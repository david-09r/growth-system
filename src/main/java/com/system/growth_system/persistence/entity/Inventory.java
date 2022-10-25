package com.system.growth_system.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Builder

@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, length = 255)
    private String serialNumber;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(name = "unit_price", nullable = false)
    private Long unitPrice;

    @Column(name = "quantity_stock", nullable = false)
    private Integer quantityStock;

    @Column(name = "quantity_output", nullable = false)
    private Integer quantityOutput;

    @Column(name = "status", nullable = false)
    private String status;

    public Inventory(){}

    public Inventory(Long id, String serialNumber, String name,
                     String description, Long unitPrice, Integer quantityStock,
                     Integer quantityOutput, String status) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityStock = quantityStock;
        this.quantityOutput = quantityOutput;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(serialNumber, inventory.serialNumber) && Objects.equals(name, inventory.name) && Objects.equals(description, inventory.description) && Objects.equals(unitPrice, inventory.unitPrice) && Objects.equals(quantityStock, inventory.quantityStock) && Objects.equals(quantityOutput, inventory.quantityOutput) && Objects.equals(status, inventory.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, name, description, unitPrice, quantityStock, quantityOutput, status);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantityStock=" + quantityStock +
                ", quantityOutput=" + quantityOutput +
                ", status='" + status + '\'' +
                '}';
    }
}
