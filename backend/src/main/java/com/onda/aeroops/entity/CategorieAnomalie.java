package com.onda.aeroops.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorie_anomalie")
@Data
public class CategorieAnomalie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String libelle;
}