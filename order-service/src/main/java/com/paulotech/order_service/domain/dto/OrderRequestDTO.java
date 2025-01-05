package com.paulotech.order_service.domain.dto;

public record OrderRequestDTO(Long id, String orderName, String skuCode, Integer price, Integer quantity) {
}
