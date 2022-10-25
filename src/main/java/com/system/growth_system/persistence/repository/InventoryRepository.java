package com.system.growth_system.persistence.repository;

import com.system.growth_system.persistence.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query(value = "SELECT * FROM Inventories u WHERE u.status = 'ACTIVE'", nativeQuery = true)
    List<Inventory> findAllActive();

    @Query(value = "SELECT * FROM Inventories u WHERE u.id = ?1 AND u.status = 'ACTIVE'", nativeQuery = true)
    Optional<Inventory> findById(Long id);
}
