package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RoleDataMapper {
    private final UserDataMapper userDataMapper;

    public RoleDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public Role createRoleCommandToRole(CreateRoleCommand createRoleCommand) {
        return Role.builder()
                .name(createRoleCommand.getName())
                .description(createRoleCommand.getDescription())
                .build();
    }

    public CreateRoleResponse roleToCreateRoleResponse(Role role, String message) {
        return CreateRoleResponse.builder()
                .roleId(role.getId().getValue())
                .name(role.getName())
                .message(message)
                .build();
    }

    public RoleEntityResponse roleToRoleResponse(Role role) {
        UserEntityResponse createdBy = userDataMapper.userToUserResponse(role.getCreatedBy());
        UserEntityResponse updatedBy = userDataMapper.userToUserResponse(role.getUpdatedBy());

        return RoleEntityResponse.builder()
                .roleId(role.getId().getValue())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .description(role.getDescription())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }

    public UpdateRoleResponse roleToUpdateRoleResponse(Role roleUpdated, String message) {
        return UpdateRoleResponse.builder()
                .roleId(roleUpdated.getId().getValue())
                .message(message)
                .build();
    }

    public DeleteRoleResponse roleToDeleteRoleResponse(UUID roleId, String message) {
        return DeleteRoleResponse.builder()
                .roleId(roleId)
                .message(message)
                .build();
    }
}
