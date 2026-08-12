package com.onda.aeroops.modules.notifications.model;

import com.onda.aeroops.modules.auth.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "preference_notifications",
        uniqueConstraints = @UniqueConstraint(columnNames = {"utilisateur_id", "canal"}))
@Getter
@Setter
public class PreferenceNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CanalNotification canal;

    @Column(nullable = false)
    private Boolean active = true;
}