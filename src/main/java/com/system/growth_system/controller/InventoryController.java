package com.system.growth_system.controller;

import com.system.growth_system.persistence.entity.Inventory;
import com.system.growth_system.service.InventoryServiceImpl;
import com.system.growth_system.util.enums.InventoryResponse;
import com.system.growth_system.util.enums.TextResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseHandler.generateResponse(TextResponse.ERROR_STATUS.getValue(), HttpStatus.MULTI_STATUS, e.getMessage());
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

    @PostMapping()
    public ResponseEntity<Object> store(@RequestBody Inventory inventory){
        try {
            Object response = this.inventoryService.save(inventory);
            if (response.equals(InventoryResponse.SERIAL_NUMBER_DUPLICATE.getValue())) {
                return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.OK, response);
            }
            return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.CREATED, response);
        }catch (Exception e) {
            return ResponseHandler.generateResponse(TextResponse.ERROR_STATUS.getValue(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteForId(@PathVariable Long id) {
        try {
            String response = this.inventoryService.delete(id);
            if (response.equals(InventoryResponse.NOT_FOUND.getValue())) {
                return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.OK, response);
            }
            return ResponseHandler.generateResponse(TextResponse.SUCCESS_STATUS.getValue(), HttpStatus.NO_CONTENT, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(TextResponse.ERROR_STATUS.getValue(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(value = "/delete-multiple")
    public ResponseEntity<Object> deleteMultipleInventories(){

    }
}
