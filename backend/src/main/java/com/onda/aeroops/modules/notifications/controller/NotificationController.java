package com.onda.aeroops.modules.notifications.controller;

import com.onda.aeroops.modules.notifications.dto.NotificationRequestDTO;
import com.onda.aeroops.modules.notifications.dto.NotificationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@Tag(name = "Notifications", description = "Gestion des notifications (Module 12)")
public class NotificationController {

    @GetMapping
    @Operation(summary = "Mes notifications")
    public ResponseEntity<Page<NotificationResponseDTO>> getAll(
            @RequestParam(required = false) Boolean lu,
            Pageable pageable) {
        // TODO: Implémenter
        return ResponseEntity.ok(Page.empty());
    }

    @GetMapping("/non-lues")
    @Operation(summary = "Nombre de notifications non lues")
    public ResponseEntity<Long> getNonLues() {
        // TODO: Implémenter
        return ResponseEntity.ok(0L);
    }

    @PatchMapping("/{id}/lire")
    @Operation(summary = "Marquer comme lue")
    public ResponseEntity<Void> marquerLue(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/tout-lire")
    @Operation(summary = "Marquer toutes comme lues")
    public ResponseEntity<Void> marquerToutLues() {
        // TODO: Implémenter
        return ResponseEntity.ok().build();
    }

    @PutMapping("/preferences")
    @Operation(summary = "Mettre à jour les préférences")
    public ResponseEntity<Void> updatePreferences() {
        // TODO: Implémenter
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/diffusion")
    @Operation(summary = "Notification globale (Admin)")
    public ResponseEntity<Void> diffuser(@Valid @RequestBody NotificationRequestDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.ok().build();
    }
}