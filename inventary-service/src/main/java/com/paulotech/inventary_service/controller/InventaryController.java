package com.paulotech.inventary_service.controller;

import com.paulotech.inventary_service.service.InventaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventary")
@RequiredArgsConstructor
public class InventaryController {

    private final InventaryService inventaryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventaryService.isInStock(skuCode, quantity);
    }
}
