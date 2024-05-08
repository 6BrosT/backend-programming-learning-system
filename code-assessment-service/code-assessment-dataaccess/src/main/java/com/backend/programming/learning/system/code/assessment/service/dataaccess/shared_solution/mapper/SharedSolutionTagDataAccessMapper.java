package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import org.springframework.stereotype.Component;

@Component
public class SharedSolutionTagDataAccessMapper {
    public Tag sharedSolutionTagEntityToTag(SharedSolutionTagEntity entity){
        return Tag.builder()
                .name(entity.getTag().getName())
                .id(new TagId(entity.getTag().getId()))
                .build();
    }
}
