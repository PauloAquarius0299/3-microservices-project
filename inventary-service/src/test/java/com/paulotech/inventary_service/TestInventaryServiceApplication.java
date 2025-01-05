package com.paulotech.inventary_service;

import org.springframework.boot.SpringApplication;

public class TestInventaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventaryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
