package com.system.growth_system.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Builder

@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "province", cascade = {CascadeType.ALL})
    private Set<City> cities;

    public Province() {
    }

    public Province(Long id, String name, String status, Set<City> cities) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(id, province.id) && Objects.equals(name, province.name) && Objects.equals(status, province.status) && Objects.equals(cities, province.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, cities);
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", cities=" + cities +
                '}';
    }
}
