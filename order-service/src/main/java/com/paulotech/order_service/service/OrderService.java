package com.paulotech.order_service.service;

import com.paulotech.order_service.domain.Order;
import com.paulotech.order_service.domain.dto.OrderRequestDTO;
import com.paulotech.order_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequestDTO orderRequest) {
        Order order = new Order();
        order.setOrderName(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }
}
