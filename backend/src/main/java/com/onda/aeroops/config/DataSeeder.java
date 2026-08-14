package com.onda.aeroops.config;

import com.onda.aeroops.entity.Utilisateur;
import com.onda.aeroops.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (utilisateurRepository.count() == 0) {
            Utilisateur admin = new Utilisateur();
            admin.setNom("Admin");
            admin.setPrenom("Test");
            admin.setEmail("admin@aeroops.ma");
            admin.setMotDePasseHash(passwordEncoder.encode("Admin123!"));
            admin.setRole(Utilisateur.Role.ADMIN);
            utilisateurRepository.save(admin);
            System.out.println(">>> Utilisateur admin créé : admin@aeroops.ma / Admin123!");
        }
    }
}