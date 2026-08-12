package com.onda.aeroops.modules.notifications.model;

import com.onda.aeroops.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "regles_alerte")
@Getter
@Setter
public class RegleAlerte extends BaseEntity {

    @Column(nullable = false)
    private String evenement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CanalNotification canal;

    @Column(name = "role_cible", nullable = false)
    private String roleCible;

    @Column(nullable = false)
    private Boolean actif = true;
}