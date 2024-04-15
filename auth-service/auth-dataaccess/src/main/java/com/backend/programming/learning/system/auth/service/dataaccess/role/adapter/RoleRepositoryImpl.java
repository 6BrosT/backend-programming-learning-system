package com.backend.programming.learning.system.auth.service.dataaccess.role.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.role.mapper.RoleDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.role.repository.RoleJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleDataAccessMapper roleDataAccessMapper;
    private final RoleJpaRepository roleJpaRepository;

    public RoleRepositoryImpl(RoleDataAccessMapper roleDataAccessMapper, RoleJpaRepository roleJpaRepository) {
        this.roleDataAccessMapper = roleDataAccessMapper;
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public Role save(Role role) {
        return roleDataAccessMapper
                .roleEntityToRole(roleJpaRepository
                        .save(roleDataAccessMapper.roleToRoleEntity(role)));
    }

    @Override
    public Optional<Role> findById(RoleId roleId) {
        return roleJpaRepository.findById(roleId.getValue())
                .map(roleDataAccessMapper::roleEntityToRole);
    }

    @Override
    public void deleteById(RoleId roleId) {
        roleJpaRepository.deleteById(roleId.getValue());
    }

    @Override
    public List<Role> findByOrganizationId(OrganizationId organizationId) {
        return roleJpaRepository.findByOrganizationId(organizationId.getValue())
                .stream()
                .map(roleDataAccessMapper::roleEntityToRole)
                .toList();
    }
}