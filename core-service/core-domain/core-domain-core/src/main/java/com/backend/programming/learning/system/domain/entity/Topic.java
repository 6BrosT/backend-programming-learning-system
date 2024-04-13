package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.LocalDateTime;

public class Topic extends AggregateRoot<TopicId> {
    private String name;
    private String description;
    private final UserId createdBy;
    private UserId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Topic(Builder builder) {
        super.setId(builder.topicId);
        name = builder.name;
        description = builder.description;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private TopicId topicId;
        private String name;
        private String description;
        private UserId createdBy;
        private UserId updatedBy;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder topicId(TopicId val) {
            topicId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public Topic build() {
            return new Topic(this);
        }
    }
}