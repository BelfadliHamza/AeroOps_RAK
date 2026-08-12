package com.onda.aeroops.modules.anomalies.repository;

import com.onda.aeroops.modules.anomalies.model.HistoriqueAnomalie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueAnomalieRepository extends JpaRepository<HistoriqueAnomalie, Long> {
    List<HistoriqueAnomalie> findByAnomalieIdOrderByDateHeureDesc(Long anomalieId);
}