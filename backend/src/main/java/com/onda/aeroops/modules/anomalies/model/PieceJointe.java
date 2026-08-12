package com.onda.aeroops.modules.anomalies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pieces_jointes")
@Getter
@Setter
public class PieceJointe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anomalie_id", nullable = false)
    private Anomalie anomalie;

    @Column(name = "nom_fichier", nullable = false)
    private String nomFichier;

    @Column(nullable = false)
    private String url;

    private String type;

    private Long taille;

    @Column(name = "date_ajout", updatable = false)
    private LocalDateTime dateAjout = LocalDateTime.now();
}