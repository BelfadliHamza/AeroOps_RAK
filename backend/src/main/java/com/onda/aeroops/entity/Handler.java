package com.onda.aeroops.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "handler")
@Data
public class Handler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 150)
    private String contact;
}