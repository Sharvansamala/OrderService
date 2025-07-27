package com.sharvan.OrderService.OrderService.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void createdAt(){
        Instant now = Instant.now();
        this.createdAt= now;
        this.updatedAt=now;
    }

    @PreUpdate
    public void updatedAt(){
        this.updatedAt = Instant.now();
    }
}
