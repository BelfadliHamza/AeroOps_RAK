package com.onda.aeroops.modules.anomalies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignerResponsableDTO {

    @NotNull(message = "Le responsable est obligatoire")
    private Long responsableId;

    private LocalDateTime echeance;
}