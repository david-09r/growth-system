package com.system.growth_system.service;

import com.system.growth_system.persistence.entity.Inventory;
import com.system.growth_system.persistence.repository.InventoryRepository;
import com.system.growth_system.service.impl.IInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public String save(Inventory inventory) {
        return null;
    }

    @Override
    public String delete(Inventory inventory) {
        return null;
    }
}
