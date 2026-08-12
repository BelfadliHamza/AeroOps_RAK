package com.onda.aeroops.modules.notifications.dto;

import com.onda.aeroops.modules.notifications.model.TypeNotification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequestDTO {

    @NotNull(message = "L'utilisateur est obligatoire")
    private Long utilisateurId;

    @NotNull(message = "Le type est obligatoire")
    private TypeNotification type;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @NotBlank(message = "Le message est obligatoire")
    private String message;

    private String lien;
}