package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeEssayQuestionId;

import java.util.UUID;

public class QtypeEssayQuestion extends BaseEntity<QtypeEssayQuestionId> {
    private final Question question;
    private final String responseFormat;
    private final Integer responseRequired;
    private final Integer responseFieldLines;
    private final Integer minWordLimit;
    private final Integer maxWordLimit;
    private final Integer attachments;
    private final Integer attachmentsRequired;
    private final String graderInfo;
    private final String graderInfoFormat;
    private final String responseTemplate;
    private final Integer maxBytes;
    private final String fileTypesList;

    public void initQtypeEssayQuestion() {
        setId(new QtypeEssayQuestionId(UUID.randomUUID()));
    }

    // Getter
    public Question getQuestion() {
        return question;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public Integer getResponseRequired() {
        return responseRequired;
    }

    public Integer getResponseFieldLines() {
        return responseFieldLines;
    }

    public Integer getMinWordLimit() {
        return minWordLimit;
    }

    public Integer getMaxWordLimit() {
        return maxWordLimit;
    }

    public Integer getAttachments() {
        return attachments;
    }

    public Integer getAttachmentsRequired() {
        return attachmentsRequired;
    }

    public String getGraderInfo() {
        return graderInfo;
    }

    public String getGraderInfoFormat() {
        return graderInfoFormat;
    }

    public String getResponseTemplate() {
        return responseTemplate;
    }

    public Integer getMaxBytes() {
        return maxBytes;
    }

    public String getFileTypesList() {
        return fileTypesList;
    }

    private QtypeEssayQuestion(Builder builder) {
        super.setId(builder.qtypeEssayQuestionId);
        question = builder.question;
        responseFormat = builder.responseFormat;
        responseRequired = builder.responseRequired;
        responseFieldLines = builder.responseFieldLines;
        minWordLimit = builder.minWordLimit;
        maxWordLimit = builder.maxWordLimit;
        attachments = builder.attachments;
        attachmentsRequired = builder.attachmentsRequired;
        graderInfo = builder.graderInfo;
        graderInfoFormat = builder.graderInfoFormat;
        responseTemplate = builder.responseTemplate;
        maxBytes = builder.maxBytes;
        fileTypesList = builder.fileTypesList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QtypeEssayQuestionId qtypeEssayQuestionId;
        private Question question;
        private String responseFormat;
        private Integer responseRequired;
        private Integer responseFieldLines;
        private Integer minWordLimit;
        private Integer maxWordLimit;
        private Integer attachments;
        private Integer attachmentsRequired;
        private String graderInfo;
        private String graderInfoFormat;
        private String responseTemplate;
        private Integer maxBytes;
        private String fileTypesList;

        private Builder() {
        }

        public Builder id(QtypeEssayQuestionId val) {
            qtypeEssayQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder responseFormat(String val) {
            responseFormat = val;
            return this;
        }

        public Builder responseRequired(Integer val) {
            responseRequired = val;
            return this;
        }

        public Builder responseFieldLines(Integer val) {
            responseFieldLines = val;
            return this;
        }

        public Builder minWordLimit(Integer val) {
            minWordLimit = val;
            return this;
        }

        public Builder maxWordLimit(Integer val) {
            maxWordLimit = val;
            return this;
        }

        public Builder attachments(Integer val) {
            attachments = val;
            return this;
        }

        public Builder attachmentsRequired(Integer val) {
            attachmentsRequired = val;
            return this;
        }

        public Builder graderInfo(String val) {
            graderInfo = val;
            return this;
        }

        public Builder graderInfoFormat(String val) {
            graderInfoFormat = val;
            return this;
        }

        public Builder responseTemplate(String val) {
            responseTemplate = val;
            return this;
        }

        public Builder maxBytes(Integer val) {
            maxBytes = val;
            return this;
        }

        public Builder fileTypesList(String val) {
            fileTypesList = val;
            return this;
        }

        public QtypeEssayQuestion build() {
            return new QtypeEssayQuestion(this);
        }
    }
}
