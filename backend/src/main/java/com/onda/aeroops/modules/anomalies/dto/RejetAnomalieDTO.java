package com.onda.aeroops.modules.anomalies.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RejetAnomalieDTO {

    @NotBlank(message = "Le motif est obligatoire")
    @Size(min = 10, message = "Le motif doit faire au moins 10 caractères")
    private String motif;
}