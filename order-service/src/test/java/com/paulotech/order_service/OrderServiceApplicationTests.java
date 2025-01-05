package com.paulotech.order_service;

import com.paulotech.order_service.stubs.InventaryClientStub;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(TestcontainersConfiguration.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static PostgreSQLContainer mysqlContainer = new PostgreSQLContainer("postgres:15.3");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static{
		mysqlContainer.start();
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJson = """
				{
				    "skuCode": "iphone_13_red",
				    "price": 2000,
				    "quantity": 100
				}
				""";
		InventaryClientStub.stubInventaryCall("iphone_13_red", "100");

		var responseBodyString = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(submitOrderJson)
				.when()
				.post("/api/order")
				.then()
				.extract().response().asString();
	}

}
