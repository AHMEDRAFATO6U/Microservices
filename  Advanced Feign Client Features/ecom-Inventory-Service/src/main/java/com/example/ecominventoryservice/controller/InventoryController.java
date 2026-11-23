package com.example.ecominventoryservice.controller;

import com.example.ecominventoryservice.model.Inventory;
import com.example.ecominventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{productId}")
    public Inventory CheckInventory(@PathVariable Long productId) throws InterruptedException {
//        Thread.sleep(15000);
        return inventoryService.CheckStock(productId);
    }

    @PostMapping
    public String addProduct(@RequestBody Inventory inventory){
        return inventoryService.addProduct(inventory);
    }


    @PutMapping
    public String updateProduct(@RequestBody Inventory inventory){
        return inventoryService.updateProduct(inventory);
    }


    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        return inventoryService.deleteProduct(productId);
    }





}
