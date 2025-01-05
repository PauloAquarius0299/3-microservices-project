package com.paulotech.order_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventaryClientStub {

    public static void stubInventaryCall(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}
