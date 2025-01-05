package com.paulotech.order_service.service;

import com.paulotech.order_service.client.InventaryClient;
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
    private final InventaryClient inventaryClient;

    public void placeOrder(OrderRequestDTO orderRequest) {
        var isProductInStock = inventaryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock){
        Order order = new Order();
        order.setOrderName(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }else {
            throw new IllegalArgumentException("Produto" + orderRequest.skuCode() + "não está em estoque, por favor, " +
                    "tente novamente mais tarde");
        }

    }
}
