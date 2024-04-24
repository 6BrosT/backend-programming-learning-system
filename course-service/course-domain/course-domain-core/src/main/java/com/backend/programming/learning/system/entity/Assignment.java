package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.Type;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Assignment extends AggregateRoot<AssignmentId> {
    private CourseId courseId;
    private String title;
    private String intro;
    private Float scores;

    private Float maxScores;
    private final ZonedDateTime time_open;
    private ZonedDateTime time_close;
    private ZonedDateTime time_limit;
    private Type type;
    private Boolean visible;

    private Assignment(Builder builder) {
        super.setId(builder.assignmentId);
        courseId = builder.courseId;
        title = builder.title;
        intro = builder.intro;
        scores = builder.scores;
        maxScores = builder.maxScores;
        time_open = builder.time_open;
        time_close = builder.time_close;
        time_limit = builder.time_limit;
        type = builder.type;
        visible = builder.visible;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public Float getScores() {
        return scores;
    }

    public Float getMaxScores() {
        return maxScores;
    }

    public ZonedDateTime getTime_open() {
        return time_open;
    }

    public ZonedDateTime getTime_close() {
        return time_close;
    }

    public ZonedDateTime getTime_limit() {
        return time_limit;
    }

    public Type getType() {
        return type;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setScores(Float scores) {
        this.scores = scores;
    }

    public void setMaxScores(Float maxScores) {
        this.maxScores = maxScores;
    }

    public void setTime_close(ZonedDateTime time_close) {
        this.time_close = time_close;
    }

    public void setTime_limit(ZonedDateTime time_limit) {
        this.time_limit = time_limit;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void initializeAssignment() {
        super.setId(new AssignmentId(UUID.randomUUID()));
    }



    public static final class Builder {
        private AssignmentId assignmentId;
        private CourseId courseId;
        private String title;
        private String intro;
        private Float scores;
        private Float maxScores;
        private ZonedDateTime time_open;
        private ZonedDateTime time_close;
        private ZonedDateTime time_limit;
        private Type type;
        private Boolean visible;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder courseId(CourseId val) {
            courseId = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder intro(String val) {
            intro = val;
            return this;
        }

        public Builder scores(Float val) {
            scores = val;
            return this;
        }

        public Builder maxScores(Float val) {
            maxScores = val;
            return this;
        }

        public Builder time_open(ZonedDateTime val) {
            time_open = val;
            return this;
        }

        public Builder time_close(ZonedDateTime val) {
            time_close = val;
            return this;
        }

        public Builder time_limit(ZonedDateTime val) {
            time_limit = val;
            return this;
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Builder visible(Boolean val) {
            visible = val;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }
}
