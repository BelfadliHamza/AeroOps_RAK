package com.onda.aeroops.controller;

import com.onda.aeroops.dto.*;
import com.onda.aeroops.entity.Utilisateur;
import com.onda.aeroops.repository.UtilisateurRepository;
import com.onda.aeroops.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(@Valid @RequestBody RefreshRequest request) {
        return ResponseEntity.ok(authService.refresh(request.getRefreshToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@Valid @RequestBody RefreshRequest request) {
        authService.logout(request.getRefreshToken());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<ProfileResponse> me(Authentication authentication) {
        Utilisateur u = utilisateurRepository.findByEmail(authentication.getName())
                .orElseThrow();
        return ResponseEntity.ok(new ProfileResponse(
                u.getId(), u.getNom(), u.getPrenom(), u.getEmail(),
                u.getRole().name(), u.getStatut().name()));
    }
}