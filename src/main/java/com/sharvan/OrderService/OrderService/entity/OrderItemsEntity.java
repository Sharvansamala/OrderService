package com.sharvan.OrderService.OrderService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderItemsEntity extends BaseEntity {
    private Long productId;
    private int quantity;

    private double pricePerUnit;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private OrderEntity order;
}
