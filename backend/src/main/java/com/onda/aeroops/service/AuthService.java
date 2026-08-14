package com.onda.aeroops.service;

import com.onda.aeroops.dto.LoginRequest;
import com.onda.aeroops.dto.LoginResponse;
import com.onda.aeroops.entity.RefreshToken;
import com.onda.aeroops.entity.Utilisateur;
import com.onda.aeroops.repository.RefreshTokenRepository;
import com.onda.aeroops.repository.UtilisateurRepository;
import com.onda.aeroops.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UtilisateurRepository utilisateurRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMotDePasse()));

        Utilisateur u = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Identifiants invalides"));

        String accessToken = jwtService.generateAccessToken(u.getEmail());
        String refreshTokenStr = jwtService.generateRefreshToken(u.getEmail());

        saveRefreshToken(u, refreshTokenStr);

        return new LoginResponse(accessToken, refreshTokenStr, u.getEmail(), u.getRole().name());
    }

    public LoginResponse refresh(String refreshTokenStr) {
        RefreshToken stored = refreshTokenRepository.findByToken(refreshTokenStr)
                .orElseThrow(() -> new BadCredentialsException("Refresh token invalide"));

        if (stored.isRevoque() || stored.getDateExpiration().isBefore(LocalDateTime.now())) {
            throw new BadCredentialsException("Refresh token expiré ou révoqué");
        }

        Utilisateur u = stored.getUtilisateur();
        String newAccessToken = jwtService.generateAccessToken(u.getEmail());

        return new LoginResponse(newAccessToken, refreshTokenStr, u.getEmail(), u.getRole().name());
    }

    public void logout(String refreshTokenStr) {
        refreshTokenRepository.findByToken(refreshTokenStr).ifPresent(token -> {
            token.setRevoque(true);
            refreshTokenRepository.save(token);
        });
    }

    private void saveRefreshToken(Utilisateur u, String token) {
        RefreshToken rt = new RefreshToken();
        rt.setUtilisateur(u);
        rt.setToken(token);
        rt.setDateExpiration(LocalDateTime.now().plusDays(7));
        refreshTokenRepository.save(rt);
    }
}