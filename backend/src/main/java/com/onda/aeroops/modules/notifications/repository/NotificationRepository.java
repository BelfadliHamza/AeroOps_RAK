package com.onda.aeroops.modules.notifications.repository;

import com.onda.aeroops.modules.notifications.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Page<Notification> findByUtilisateurIdOrderByDateCreationDesc(Long utilisateurId, Pageable pageable);

    Page<Notification> findByUtilisateurIdAndLuOrderByDateCreationDesc(Long utilisateurId, Boolean lu, Pageable pageable);

    long countByUtilisateurIdAndLu(Long utilisateurId, Boolean lu);
}