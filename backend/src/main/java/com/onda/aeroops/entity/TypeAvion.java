package com.onda.aeroops.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "type_avion")
@Data
public class TypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String modele;

    private Integer capacite;
}