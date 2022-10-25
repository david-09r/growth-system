package com.system.growth_system.persistence.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")

@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "telephone", nullable = false)
    private Long telephone;

    @Column(name = "document_number", nullable = false)
    private Long documentNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "document_type", nullable = false)
    private DocumentType documentType;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User() {
    }

    public User(Long id, String name, String lastName, String email,
                Long telephone, Long documentNumber, String password,
                String status, DocumentType documentType, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.documentNumber = documentNumber;
        this.password = password;
        this.status = status;
        this.documentType = documentType;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(telephone, user.telephone) && Objects.equals(documentNumber, user.documentNumber) && Objects.equals(password, user.password) && Objects.equals(status, user.status) && Objects.equals(documentType, user.documentType) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, telephone, documentNumber, password, status, documentType, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", documentNumber=" + documentNumber +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", documentType=" + documentType +
                ", role=" + role +
                '}';
    }
}
