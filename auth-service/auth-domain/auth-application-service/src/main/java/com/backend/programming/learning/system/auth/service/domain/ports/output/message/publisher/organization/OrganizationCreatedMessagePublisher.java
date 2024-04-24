package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization;

import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationCreatedMessagePublisher extends DomainEventPublisher<OrganizationCreatedEvent> {
}
