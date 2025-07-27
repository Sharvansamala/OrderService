package com.sharvan.OrderService.OrderService.mapper;

import com.sharvan.OrderService.OrderService.dto.CreateOrderResponseDTO;
import com.sharvan.OrderService.OrderService.dto.OrderItemRequestDTO;
import com.sharvan.OrderService.OrderService.dto.OrderRequestDTO;
import com.sharvan.OrderService.OrderService.entity.OrderEntity;
import com.sharvan.OrderService.OrderService.entity.OrderItemsEntity;
import com.sharvan.OrderService.OrderService.enums.OrderStatus;

public class OrderMapper {

    public static OrderEntity toEntity(OrderRequestDTO orderRequestDTO) {

        return OrderEntity.builder()
                .userId(orderRequestDTO.getUserId())
                .orderStatus(OrderStatus.PENDING)
//                .list(orderRequestDTO.getItems().stream()
//                        .map(item -> OrderMapper.toEntity(item)))
//                        .toList())
                .build();
    }


    public static OrderItemsEntity toEntity(OrderItemRequestDTO itemDTO, OrderEntity order, double pricePerUnit, double totalPrice) {
        return OrderItemsEntity.builder()
                .productId(itemDTO.getProductId())
                .quantity(itemDTO.getQuantity())
                .order(order)
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(OrderEntity createdOrder) {
        return CreateOrderResponseDTO.builder()
                .orderId(createdOrder.getId())
                .status(createdOrder.getOrderStatus())
                .build();
    }
}
