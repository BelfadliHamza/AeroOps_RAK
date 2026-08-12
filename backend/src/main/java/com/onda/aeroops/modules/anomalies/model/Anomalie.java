package com.onda.aeroops.modules.anomalies.model;

import com.onda.aeroops.modules.auth.model.Utilisateur;
import com.onda.aeroops.modules.referentiels.model.CategorieAnomalie;
import com.onda.aeroops.modules.referentiels.model.Service;
import com.onda.aeroops.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "anomalies")
@Getter
@Setter
public class Anomalie extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "declarant_id")
    private Utilisateur declarant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private CategorieAnomalie categorie;

    private String lieu;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CriticiteAnomalie criticite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsable_id")
    private Utilisateur responsable;

    private LocalDateTime echeance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutAnomalie statut = StatutAnomalie.OUVERTE;

    @Column(name = "date_cloture")
    private LocalDateTime dateCloture;

    @Column(name = "motif_rejet", columnDefinition = "TEXT")
    private String motifRejet;

    @OneToMany(mappedBy = "anomalie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PieceJointe> piecesJointes = new ArrayList<>();

    @OneToMany(mappedBy = "anomalie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriqueAnomalie> historiques = new ArrayList<>();
}