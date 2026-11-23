package com.example.ecomorderservice.client;

import com.example.ecomorderservice.client.config.InventoryFeignClientConfig;
import com.example.ecomorderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Inventory-service"
        ,url = "http://localhost:8081"
         ,configuration = InventoryFeignClientConfig.class)
public interface InventoryClient {

    @GetMapping("/Inventory/{productId}")
    InventoryResponse getInventory(@PathVariable Long productId);

    @PostMapping("/Inventory")
    String updateInventory(@RequestBody InventoryResponse inventoryResponse);
}
