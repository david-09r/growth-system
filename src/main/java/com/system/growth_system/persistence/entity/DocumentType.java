package com.system.growth_system.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Builder

@Entity
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "documentType", cascade = {CascadeType.ALL})
    private Set<User> users;

    public DocumentType() {}

    public DocumentType(Long id, String name, String status, Set<User> users) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, users);
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                '}';
    }
}
