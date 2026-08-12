package com.onda.aeroops.modules.notifications.repository;

import com.onda.aeroops.modules.notifications.model.PreferenceNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenceNotificationRepository extends JpaRepository<PreferenceNotification, Long> {
    List<PreferenceNotification> findByUtilisateurId(Long utilisateurId);
}