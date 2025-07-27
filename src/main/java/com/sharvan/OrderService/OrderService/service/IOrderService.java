package com.sharvan.OrderService.OrderService.service;

import com.sharvan.OrderService.OrderService.dto.CreateOrderResponseDTO;
import com.sharvan.OrderService.OrderService.dto.OrderRequestDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO orderDTO);

    CreateOrderResponseDTO getOrderById(Long id);
}
