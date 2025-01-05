package com.paulotech.product_service.service;

import com.paulotech.product_service.domain.Product;
import com.paulotech.product_service.domain.dto.ProductRequestDTO;
import com.paulotech.product_service.domain.dto.ProductResponseDTO;
import com.paulotech.product_service.repositories.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProdutoRepository repository;

    public ProductService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        Product product = Product.builder()
                .name(productRequestDTO.name())
                .description(productRequestDTO.description())
                .price(productRequestDTO.price())
                .build();
        repository.save(product);
        log.info("Produto criado com sucesso!");
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponseDTO> getAllProducts(){
        return repository.findAll()
                .stream()
                .map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
