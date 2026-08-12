package com.onda.aeroops.modules.anomalies.model;

import com.onda.aeroops.modules.auth.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historique_anomalies")
@Getter
@Setter
public class HistoriqueAnomalie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anomalie_id", nullable = false)
    private Anomalie anomalie;

    @Column(nullable = false)
    private String action;

    @Column(name = "statut_avant")
    private String statutAvant;

    @Column(name = "statut_apres")
    private String statutApres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_heure", nullable = false)
    private LocalDateTime dateHeure = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String commentaire;
}