package com.backend.programming.learning.system.auth.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final OrganizationJpaRepository organizationJpaRepository;

    public OrganizationRepositoryImpl(OrganizationDataAccessMapper organizationDataAccessMapper, OrganizationJpaRepository organizationJpaRepository) {
        this.organizationDataAccessMapper = organizationDataAccessMapper;
        this.organizationJpaRepository = organizationJpaRepository;
    }

    @Override
    public Organization save(Organization organization) {
        return organizationDataAccessMapper
                .organizationEntityToOrganization(organizationJpaRepository
                        .save(organizationDataAccessMapper.organizationToOrganizationEntity(organization)));
    }

    @Override
    public Optional<Organization> findById(OrganizationId organizationId) {
        return organizationJpaRepository.findById(organizationId.getValue())
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }
}
