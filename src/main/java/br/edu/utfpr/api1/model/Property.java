package br.edu.utfpr.api1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class Property extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orchard> orchards;

    @OneToMany(mappedBy = "property", cascade = CascadeType.DETACH, orphanRemoval = true)
    private List<Employee> employees;
}