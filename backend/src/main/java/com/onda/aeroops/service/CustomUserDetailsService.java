package com.onda.aeroops.service;

import com.onda.aeroops.entity.Utilisateur;
import com.onda.aeroops.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur u = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + email));

        return User.builder()
                .username(u.getEmail())
                .password(u.getMotDePasseHash())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole().name())))
                .disabled(u.getStatut() == Utilisateur.Statut.SUSPENDU)
                .build();
    }
}