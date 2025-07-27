package com.sharvan.OrderService.OrderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity extends BaseEntity{

    private Long userId;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    List<OrderItemsEntity> list;
}
