package com.onda.aeroops.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "refresh_token")
@Data
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(name = "date_expiration", nullable = false)
    private LocalDateTime dateExpiration;

    private boolean revoque = false;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation = LocalDateTime.now();
}