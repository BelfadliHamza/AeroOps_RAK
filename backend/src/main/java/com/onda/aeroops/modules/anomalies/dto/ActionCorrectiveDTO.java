package com.onda.aeroops.modules.anomalies.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActionCorrectiveDTO {

    @NotBlank(message = "La description est obligatoire")
    private String description;

    private LocalDateTime echeance;
}