package com.onda.aeroops.modules.notifications.repository;

import com.onda.aeroops.modules.notifications.model.RegleAlerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegleAlerteRepository extends JpaRepository<RegleAlerte, Long> {
    List<RegleAlerte> findByActifTrue();
}