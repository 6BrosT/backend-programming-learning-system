package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ReviewUpdateHelper {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CertificateCourseRepository certificateCourseRepository;
    private final CertificateCourseUserRepository certificateCourseUserRepository;

    public ReviewUpdateHelper(ReviewRepository reviewRepository,
                              UserRepository userRepository,
                              CertificateCourseRepository certificateCourseRepository,
                              CertificateCourseUserRepository certificateCourseUserRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.certificateCourseRepository = certificateCourseRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
    }

    @Transactional
    public void persistReview(UpdateReviewCommand updateReviewCommand) {
        checkUser(updateReviewCommand.getUpdatedBy());
        Review review = getReview(updateReviewCommand.getReviewId());

        checkUserIsAllowedToUpdateReview(updateReviewCommand, review);

        review.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));

        if (updateReviewCommand.getRating() != null) {
            review.setRating(updateReviewCommand.getRating());
        }

        if (updateReviewCommand.getContent() != null) {
            review.setContent(updateReviewCommand.getContent());
        }

        updateReview(review);
        log.info("Review updated with id: {}", review.getId().getValue());

        Float avgRating = getAvgRatingOfAllReviewsByCertificateCourseId(
                review.getCertificateCourseId().getValue());

        int updatedRows = certificateCourseRepository.updateAvgRating(
                review.getCertificateCourseId(), avgRating);
        if (updatedRows == 0) {
            log.error("Could not update avg rating for certificate course with id: {}",
                    review.getCertificateCourseId());
            throw new CoreDomainException("Could not update avg rating for certificate course with id: " +
                    review.getCertificateCourseId());
        }
        log.info("Avg rating updated for certificate course with id: {}", review.getCertificateCourseId());
    }

    private void checkUserIsAllowedToUpdateReview(
            UpdateReviewCommand updateReviewCommand, Review review) {
        // Check if user is a creator of the review
        checkUserOwnsReview(review, updateReviewCommand.getUpdatedBy());

        // Check if user registered for the certificate course
        checkCertificateCourseUserByCertificateCourseIdAndUserId(
                review.getCertificateCourseId().getValue(), updateReviewCommand.getUpdatedBy());
    }

    private void checkUserOwnsReview(Review review, UUID userId) {
        if (!review.getCreatedBy().getId().getValue().equals(userId)) {
            log.error("User with id: {} is not allowed to update review with id: {}",
                    userId, review.getId().getValue());
            throw new CoreDomainException("User with id: " + userId +
                    " is not allowed to update review with id: " + review.getId().getValue());
        }
    }

    private void checkCertificateCourseUserByCertificateCourseIdAndUserId(
            UUID certificateCourseId, UUID userId) {
        Optional<CertificateCourseUser> certificateCourseUser = certificateCourseUserRepository
                .findByCertificateCourseIdAndUserId(certificateCourseId, userId);
        if (certificateCourseUser.isEmpty()) {
            log.error("User with id: {} is not registered for certificate course with id: {}",
                    userId, certificateCourseId);
            throw new CoreDomainException("User with id: " + userId +
                    " is not registered for certificate course with id: " + certificateCourseId);
        }
    }

    private Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId) {
        return reviewRepository.getAvgRatingOfAllReviewsByCertificateCourseId(certificateCourseId);
    }

    private Review getReview(UUID reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isEmpty()) {
            log.warn("Review with id: {} not found", reviewId);
            throw new ReviewNotFoundException("Could not find review with id: " + reviewId);
        }
        return review.get();
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private void updateReview(Review review) {
        int updatedRows = reviewRepository.updateReview(review);

        if (updatedRows == 0) {
            log.error("Could not update review with id: {}", review.getId().getValue());

            throw new CoreDomainException("Could not update review with id: " + review.getId().getValue());
        }
        log.info("Review updated with id: {}", review.getId().getValue());
    }
}




















