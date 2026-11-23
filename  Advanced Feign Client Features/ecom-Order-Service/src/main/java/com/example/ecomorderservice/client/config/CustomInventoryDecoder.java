package com.example.ecomorderservice.client.config;


import com.example.ecomorderservice.dto.InventoryResponse;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.DecodeException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class CustomInventoryDecoder implements Decoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException {

        if (response.body() == null) {
            return null;
        }

        try (InputStream bodyIs = response.body().asInputStream()) {

            if (type.equals(InventoryResponse.class)) {
                JsonNode rootNode = objectMapper.readTree(bodyIs);

                InventoryResponse inventory = new InventoryResponse();


                inventory.setProductId(rootNode.path("productId").asLong());
                inventory.setQuantity(rootNode.path("quantity").asInt());

                return inventory;
            }

            throw new DecodeException(response.status(), "Unsupported type: " + type, response.request());

        } catch (Exception e) {
            throw new DecodeException(response.status(), "Failed to decode response", response.request(), e);
        }
    }
}
