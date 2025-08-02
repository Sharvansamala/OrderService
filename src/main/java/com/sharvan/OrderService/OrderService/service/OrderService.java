package com.sharvan.OrderService.OrderService.service;

import com.sharvan.OrderService.OrderService.clients.ProductServiceClient;
import com.sharvan.OrderService.OrderService.dto.CreateOrderResponseDTO;
import com.sharvan.OrderService.OrderService.dto.OrderItemRequestDTO;
import com.sharvan.OrderService.OrderService.dto.OrderRequestDTO;
import com.sharvan.OrderService.OrderService.dto.ProductDTO;
import com.sharvan.OrderService.OrderService.entity.OrderEntity;
import com.sharvan.OrderService.OrderService.entity.OrderItemsEntity;
import com.sharvan.OrderService.OrderService.exception.ResourceNotFoundException;
import com.sharvan.OrderService.OrderService.mapper.OrderMapper;
import com.sharvan.OrderService.OrderService.repository.OrderRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final OrderRespository orderRespository;
    private final ProductServiceClient productClient;

    public OrderService(OrderRespository orderRespository,ProductServiceClient productServiceClient) {
        this.orderRespository = orderRespository;
        this.productClient = productServiceClient;
    }


    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO orderDTO) {

        OrderEntity order = OrderMapper.toEntity(orderDTO);


        List<OrderItemsEntity> list = new ArrayList<>();

        for (OrderItemRequestDTO itemDTO : orderDTO.getItems()){

            ProductDTO productDTO = productClient.getProductByID(itemDTO.getProductId());
            double pricePerUnit = productDTO.getPrice();
            double totalPrice = pricePerUnit*itemDTO.getQuantity();

            OrderItemsEntity orderItemsEntity = OrderMapper.toEntity(itemDTO,order,pricePerUnit,totalPrice);
            list.add(orderItemsEntity);
        }
        order.setItems(list);
        OrderEntity createdOrder = orderRespository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);

    }

    @Override
    public CreateOrderResponseDTO getOrderById(Long id) {
        OrderEntity order = orderRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Order not found with id: " + id));
        return OrderMapper.toCreateOrderResponseDTO(order);
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return productClient.getProductByID(productId);
    }
}
