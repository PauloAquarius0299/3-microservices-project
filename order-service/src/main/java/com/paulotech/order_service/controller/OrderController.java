package com.paulotech.order_service.controller;

import com.paulotech.order_service.domain.dto.OrderRequestDTO;
import com.paulotech.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String Orders(@RequestBody OrderRequestDTO orderRequestDTO) {
        orderService.placeOrder(orderRequestDTO);
        return "Pedidos encaminhados com sucesso";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDTO  orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Pedido encaminhado com sucesso!";
    }
}
