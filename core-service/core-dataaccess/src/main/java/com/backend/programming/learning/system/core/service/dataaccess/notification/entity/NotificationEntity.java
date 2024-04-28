package com.backend.programming.learning.system.core.service.dataaccess.notification.entity;

import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification", schema = "public")
@Entity
public class NotificationEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id_from", referencedColumnName = "id")
    private UserEntity userFrom;

    @ManyToOne
    @JoinColumn(name = "user_id_to", referencedColumnName = "id")
    private UserEntity userTo;

    private String subject;
    private String fullMessage;
    private String smallMessage;
    private String component;
    
    @Enumerated(EnumType.STRING)
    private NotificationEventType eventType;

    private String contextUrl;
    private String contextUrlName;
    private Boolean isRead;
    private ZonedDateTime timeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}