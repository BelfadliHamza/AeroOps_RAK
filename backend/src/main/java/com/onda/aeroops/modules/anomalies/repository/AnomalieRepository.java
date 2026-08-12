package com.onda.aeroops.modules.anomalies.repository;

import com.onda.aeroops.modules.anomalies.model.Anomalie;
import com.onda.aeroops.modules.anomalies.model.StatutAnomalie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnomalieRepository extends JpaRepository<Anomalie, Long> {

    Optional<Anomalie> findByNumero(String numero);

    Page<Anomalie> findByStatut(StatutAnomalie statut, Pageable pageable);

    Page<Anomalie> findByServiceId(Long serviceId, Pageable pageable);

    Page<Anomalie> findByDeclarantId(Long declarantId, Pageable pageable);

    Page<Anomalie> findByResponsableId(Long responsableId, Pageable pageable);

    long countByStatut(StatutAnomalie statut);
}