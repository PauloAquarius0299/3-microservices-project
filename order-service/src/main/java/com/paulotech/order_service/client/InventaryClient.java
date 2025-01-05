package com.paulotech.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "inventary", url = "http://localhost:8082")
public interface InventaryClient {

    @GetMapping("/api/inventary")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}