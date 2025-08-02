package com.sharvan.OrderService.OrderService.controller;

import com.sharvan.OrderService.OrderService.dto.CreateOrderResponseDTO;
import com.sharvan.OrderService.OrderService.dto.OrderRequestDTO;
import com.sharvan.OrderService.OrderService.dto.ProductDTO;
import com.sharvan.OrderService.OrderService.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderDTO) {
        CreateOrderResponseDTO response = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateOrderResponseDTO> getOrderById(@PathVariable Long id) {
        CreateOrderResponseDTO response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO response = orderService.getProductById(productId);
        return ResponseEntity.ok(response);
    }
}
