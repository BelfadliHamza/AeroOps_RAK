package com.onda.aeroops.modules.anomalies.dto;

import com.onda.aeroops.modules.anomalies.model.CriticiteAnomalie;
import com.onda.aeroops.modules.anomalies.model.StatutAnomalie;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AnomalieResponseDTO {

    private Long id;
    private String numero;
    private String serviceNom;
    private String declarantNom;
    private String categorieLibelle;
    private String lieu;
    private String description;
    private CriticiteAnomalie criticite;
    private String responsableNom;
    private LocalDateTime echeance;
    private StatutAnomalie statut;
    private LocalDateTime dateCloture;
    private String motifRejet;
    private LocalDateTime dateCreation;
    private List<PieceJointeDTO> piecesJointes;
    private List<HistoriqueAnomalieDTO> historiques;
}