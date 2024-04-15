package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    void createQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void createQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion);
    void createCertificateCourse(CertificateCourse certificateCourse);
    void createReview(Review review);
    void createTopic(Topic topic);
    void createContest(Contest contest);
}
