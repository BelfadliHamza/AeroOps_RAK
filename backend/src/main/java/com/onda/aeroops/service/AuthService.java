package com.onda.aeroops.service;

import com.onda.aeroops.dto.LoginRequest;
import com.onda.aeroops.dto.LoginResponse;
import com.onda.aeroops.entity.Utilisateur;
import com.onda.aeroops.repository.UtilisateurRepository;
import com.onda.aeroops.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UtilisateurRepository utilisateurRepository;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMotDePasse()));

        Utilisateur u = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Identifiants invalides"));

        String accessToken = jwtService.generateAccessToken(u.getEmail());
        String refreshToken = jwtService.generateRefreshToken(u.getEmail());

        return new LoginResponse(accessToken, refreshToken, u.getEmail(), u.getRole().name());
    }
}