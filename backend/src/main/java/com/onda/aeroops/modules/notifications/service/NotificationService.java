package com.onda.aeroops.modules.notifications.service;

import com.onda.aeroops.modules.notifications.dto.NotificationRequestDTO;
import com.onda.aeroops.modules.notifications.dto.NotificationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public Page<NotificationResponseDTO> findByUtilisateur(Boolean lu, Pageable pageable) {
        // TODO: Implémenter
        return Page.empty();
    }

    public long countNonLues(Long utilisateurId) {
        // TODO: Implémenter
        return 0;
    }

    public void marquerLue(Long id) {
        // TODO: Implémenter
    }

    public void marquerToutLues(Long utilisateurId) {
        // TODO: Implémenter
    }

    public void creerNotification(NotificationRequestDTO dto) {
        // TODO: Implémenter
        // Appelé par AnomalieService quand une anomalie est créée/assignée/validée/clôturée
    }

    public void diffuserGlobale(NotificationRequestDTO dto) {
        // TODO: Implémenter (Admin uniquement)
    }
}