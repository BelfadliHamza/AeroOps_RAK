package com.onda.aeroops.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compagnie")
@Data
public class Compagnie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, unique = true, length = 10)
    private String code;
}