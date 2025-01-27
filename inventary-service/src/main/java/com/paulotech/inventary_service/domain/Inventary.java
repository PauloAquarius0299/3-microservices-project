package com.paulotech.inventary_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "inventary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventary {

    @Id
    @GeneratedValue
    private UUID id;

    private String skuCode;
    private Integer quantity;

}
