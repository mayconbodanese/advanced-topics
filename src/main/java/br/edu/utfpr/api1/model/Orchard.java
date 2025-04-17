package br.edu.utfpr.api1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orchard")
public class Orchard extends BaseEntity {
    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
