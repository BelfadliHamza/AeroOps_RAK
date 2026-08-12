package com.onda.aeroops.modules.anomalies.controller;

import com.onda.aeroops.modules.anomalies.dto.*;
import com.onda.aeroops.modules.anomalies.model.StatutAnomalie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anomalies")
@Tag(name = "Anomalies", description = "Gestion des anomalies opérationnelles (Module 5)")
public class AnomalieController {

    @GetMapping
    @Operation(summary = "Liste des anomalies", description = "Filtres : statut, service, catégorie, date")
    public ResponseEntity<Page<AnomalieResponseDTO>> getAll(
            @RequestParam(required = false) StatutAnomalie statut,
            @RequestParam(required = false) Long serviceId,
            @RequestParam(required = false) Long categorieId,
            Pageable pageable) {
        // TODO: Implémenter
        return ResponseEntity.ok(Page.empty());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Détail d'une anomalie")
    public ResponseEntity<AnomalieResponseDTO> getById(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PostMapping
    @Operation(summary = "Déclarer une anomalie", description = "Création par l'agent d'exploitation")
    public ResponseEntity<AnomalieResponseDTO> create(@Valid @RequestBody AnomalieRequestDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.status(HttpStatus.CREATED).body(new AnomalieResponseDTO());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une anomalie", description = "Possible uniquement si statut = OUVERTE")
    public ResponseEntity<AnomalieResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AnomalieRequestDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PutMapping("/{id}/assigner")
    @Operation(summary = "Assigner un responsable", description = "Passe le statut à EN_TRAITEMENT")
    public ResponseEntity<AnomalieResponseDTO> assigner(@PathVariable Long id, @Valid @RequestBody AssignerResponsableDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PutMapping("/{id}/actions")
    @Operation(summary = "Ajouter des actions correctives")
    public ResponseEntity<AnomalieResponseDTO> ajouterActions(@PathVariable Long id, @Valid @RequestBody ActionCorrectiveDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PatchMapping("/{id}/valider")
    @Operation(summary = "Valider le traitement", description = "Resp. QSE uniquement. Passe à VALIDEE.")
    public ResponseEntity<AnomalieResponseDTO> valider(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PatchMapping("/{id}/rejeter")
    @Operation(summary = "Rejeter le traitement", description = "Resp. QSE uniquement. Passe à REJETEE.")
    public ResponseEntity<AnomalieResponseDTO> rejeter(@PathVariable Long id, @Valid @RequestBody RejetAnomalieDTO dto) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @PatchMapping("/{id}/cloturer")
    @Operation(summary = "Clôturer l'anomalie", description = "Chef Expl. uniquement. Action finale.")
    public ResponseEntity<AnomalieResponseDTO> cloturer(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(new AnomalieResponseDTO());
    }

    @GetMapping("/{id}/historique")
    @Operation(summary = "Historique complet du workflow")
    public ResponseEntity<List<HistoriqueAnomalieDTO>> getHistorique(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/{id}/pieces-jointes")
    @Operation(summary = "Ajouter des pièces jointes")
    public ResponseEntity<List<PieceJointeDTO>> ajouterPiecesJointes(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/{id}/pieces-jointes")
    @Operation(summary = "Liste des pièces jointes")
    public ResponseEntity<List<PieceJointeDTO>> getPiecesJointes(@PathVariable Long id) {
        // TODO: Implémenter
        return ResponseEntity.ok(List.of());
    }
}