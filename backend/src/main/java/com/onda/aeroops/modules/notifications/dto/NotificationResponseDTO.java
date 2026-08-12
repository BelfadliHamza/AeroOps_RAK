package com.onda.aeroops.modules.notifications.dto;

import com.onda.aeroops.modules.notifications.model.TypeNotification;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private Long id;
    private TypeNotification type;
    private String titre;
    private String message;
    private String lien;
    private Boolean lu;
    private LocalDateTime dateCreation;
}