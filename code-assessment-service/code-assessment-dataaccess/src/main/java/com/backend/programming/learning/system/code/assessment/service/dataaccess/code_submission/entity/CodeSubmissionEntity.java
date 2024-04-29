package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_submission")
public class CodeSubmissionEntity {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name="code_question_id", referencedColumnName = "id")
    private CodeQuestionEntity codeQuestion;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private ProgrammingLanguageEntity programmingLanguage;

    private Double grade;
    private Double avgRuntime;
    private Double avgMemory;
    private String aiAssessment;
    private String sonaqueAssessment;
    private String sourceCode;

    @Column(name = "number_of_test_case_sent")
    private Integer numOfTestCaseSent;

    @Column(name = "number_of_test_case_graded")
    private Integer numOfTestCaseGraded;

    @Enumerated(EnumType.STRING)
    private String gradingStatus;

    @Enumerated(EnumType.STRING)
    private String copyState;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CodeSubmissionEntity that = (CodeSubmissionEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
