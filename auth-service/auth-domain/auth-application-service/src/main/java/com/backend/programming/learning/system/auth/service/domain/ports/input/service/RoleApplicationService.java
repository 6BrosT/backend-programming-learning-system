package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryRoleByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;

import javax.validation.Valid;

public interface RoleApplicationService {
    CreateRoleResponse createRole(@Valid CreateRoleCommand createRoleCommand);
    RoleEntityResponse findRoleById(@Valid QueryRoleByIdCommand queryRoleCommand);
    QueryAllRolesByOrganizationResponse findByOrganizationId(@Valid QueryAllRolesByOrganizationCommand queryAllRolesCommand);
    UpdateRoleResponse updateRole(@Valid CreateRoleCommand createRoleCommand);
    DeleteRoleResponse deleteRoleById(@Valid DeleteRoleCommand deleteRoleCommand);
}
