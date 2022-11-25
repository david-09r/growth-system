package com.system.growth_system.service;

import com.system.growth_system.persistence.entity.Inventory;
import com.system.growth_system.persistence.repository.InventoryRepository;
import com.system.growth_system.service.impl.IInventoryService;
import com.system.growth_system.util.enums.InventoryResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements IInventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getAll() {
        return this.inventoryRepository.findAllActive();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Object save(Inventory inventory) throws Exception {
        try {
            return this.inventoryRepository.save(inventory);
        }
        catch (DataIntegrityViolationException d) {
            return InventoryResponse.SERIAL_NUMBER_DUPLICATE.getValue();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String delete(Inventory inventory) {
        return null;
    }
}
