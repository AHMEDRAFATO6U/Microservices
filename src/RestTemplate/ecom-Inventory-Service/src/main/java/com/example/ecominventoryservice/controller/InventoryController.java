package com.example.ecominventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inventory")
@RequiredArgsConstructor
public class InventoryController {


    @GetMapping("/{productId}")
    public  String InStock(@PathVariable String productId ){
        return productId.equals("1") ? "INSTOCK" : "OUT OF STOCK" ;
    }
}
