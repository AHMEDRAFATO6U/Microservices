package com.example.ecomorderservice.client.config;


import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import tools.jackson.databind.ObjectMapper;
import com.example.ecomorderservice.dto.InventoryResponse;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CustomInventoryEncoder implements Encoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) {
        try {
            if (object instanceof InventoryResponse inventory) {

                Map<String, Object> data = new HashMap<>();
                data.put("productId", inventory.getProductId());
                data.put("quantity", inventory.getQuantity());

                String json = objectMapper.writeValueAsString(data);
                template.body(json);

            } else {
                throw new EncodeException("Unsupported object type: " + object.getClass().getName());
            }
        } catch (Exception e) {
            throw new EncodeException("Failed to encode request body", e);
        }
    }
}
