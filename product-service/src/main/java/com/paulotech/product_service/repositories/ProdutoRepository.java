package com.paulotech.product_service.repositories;

import com.paulotech.product_service.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Product, String> {
}
