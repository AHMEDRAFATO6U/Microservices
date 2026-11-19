package com.example.ecominventoryservice.service;

import com.example.ecominventoryservice.model.Inventory;
import com.example.ecominventoryservice.repo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    public Inventory CheckStock(Long productId) {
        Optional<Inventory> inventory = inventoryRepository.findById(productId);
        return inventory.get();
    }

    public String addProduct(Inventory inventory) {
      inventoryRepository.save(inventory);
        return "PRODUCT ADDED";

    }

    public String updateProduct(Inventory inventory) {
       inventoryRepository.save(inventory);
       return "PRODUCT UPDATED";
    }

    public String deleteProduct(Long productId) {
        inventoryRepository.deleteById(productId);
        return "PRODUCT DELETED";
    }
}
