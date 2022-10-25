package com.system.growth_system.service.impl;

import com.system.growth_system.persistence.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface IInventoryService {

    List<Inventory> getAll();

    Optional<Inventory> findById(Long id);

    String save(Inventory inventory);

    String delete(Inventory inventory);

}
