package com.onda.aeroops.modules.anomalies.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PieceJointeDTO {
    private Long id;
    private String nomFichier;
    private String url;
    private String type;
    private Long taille;
    private LocalDateTime dateAjout;
}