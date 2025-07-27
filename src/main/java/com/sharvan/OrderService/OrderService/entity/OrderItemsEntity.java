package com.sharvan.OrderService.OrderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsEntity extends BaseEntity {
    private Long productId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private OrderEntity order;
}
