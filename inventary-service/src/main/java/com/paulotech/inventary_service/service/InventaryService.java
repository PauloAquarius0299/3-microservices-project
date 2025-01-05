package com.paulotech.inventary_service.service;

import com.paulotech.inventary_service.repositories.InventaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventaryService {
    private final InventaryRepository inventaryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventaryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual( skuCode, quantity);
    }
}
