package com.onda.aeroops.modules.anomalies.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoriqueAnomalieDTO {
    private Long id;
    private String action;
    private String statutAvant;
    private String statutApres;
    private String utilisateurNom;
    private LocalDateTime dateHeure;
    private String commentaire;
}