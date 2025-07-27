package com.sharvan.OrderService.OrderService.repository;

import com.sharvan.OrderService.OrderService.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespository extends JpaRepository<OrderEntity,Long> {
}
