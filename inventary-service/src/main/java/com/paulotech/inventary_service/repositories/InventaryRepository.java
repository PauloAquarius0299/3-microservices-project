package com.paulotech.inventary_service.repositories;

import com.paulotech.inventary_service.domain.Inventary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventaryRepository extends JpaRepository<Inventary, UUID> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
