package com.onda.aeroops.modules.referentiels.model;

import com.onda.aeroops.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String nom;
}