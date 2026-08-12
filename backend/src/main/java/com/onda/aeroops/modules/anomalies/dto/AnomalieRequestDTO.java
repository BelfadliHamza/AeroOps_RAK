package com.onda.aeroops.modules.anomalies.dto;

import com.onda.aeroops.modules.anomalies.model.CriticiteAnomalie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AnomalieRequestDTO {

    @NotNull(message = "Le service est obligatoire")
    private Long serviceId;

    @NotNull(message = "La catégorie est obligatoire")
    private Long categorieId;

    private String lieu;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @NotNull(message = "La criticité est obligatoire")
    private CriticiteAnomalie criticite;

    private LocalDateTime echeance;

    private List<PieceJointeDTO> piecesJointes;
}