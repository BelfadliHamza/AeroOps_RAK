package com.onda.aeroops.modules.referentiels.model;

import com.onda.aeroops.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories_anomalies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieAnomalie extends BaseEntity {

    @Column(nullable = false)
    private String libelle;
}