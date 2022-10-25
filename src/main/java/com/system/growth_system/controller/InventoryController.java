package com.system.growth_system.controller;

import com.system.growth_system.persistence.entity.Inventory;
import com.system.growth_system.service.InventoryServiceImpl;
import com.system.growth_system.util.enums.TextResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/inventory")
public class InventoryController {
    private final InventoryServiceImpl inventoryService;

    public InventoryController(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllInventory() {
        try {
            List<Inventory> inventories = this.inventoryService.getAll();
            return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.OK, inventories);
        }catch (Exception e) {
            return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findInventoryForId(@PathVariable Long id){
        try {
            Optional<Inventory> inventory = this.inventoryService.findById(id);
            return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.OK, inventory);
        }catch (Exception e){
            return ResponseHandler.generateResponse(TextResponse.ERROR_STATUS.getValue(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
