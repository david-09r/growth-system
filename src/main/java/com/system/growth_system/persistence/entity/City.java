package com.system.growth_system.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Builder

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    @Column(name = "status", nullable = false)
    private String status;

    public City() {
    }

    public City(Long id, String name, Province province, String status) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City name1 = (City) o;
        return Objects.equals(id, name1.id) && Objects.equals(name, name1.name) && Objects.equals(province, name1.province) && Objects.equals(status, name1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, province, status);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province=" + province +
                ", status='" + status + '\'' +
                '}';
    }
}
