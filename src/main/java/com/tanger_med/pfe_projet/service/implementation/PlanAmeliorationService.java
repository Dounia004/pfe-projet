package com.tanger_med.pfe_projet.service.implementation;


import com.tanger_med.pfe_projet.bean.Colaborator;
import com.tanger_med.pfe_projet.bean.Incident;
import com.tanger_med.pfe_projet.bean.PlanAmelioration;
import com.tanger_med.pfe_projet.dao.ColaboratorDao;
import com.tanger_med.pfe_projet.dao.IncidentDao;
import com.tanger_med.pfe_projet.dao.PlanAmeliorationDao;
import com.tanger_med.pfe_projet.dto.PlanAmeliorationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlanAmeliorationService {
    @Autowired
    private PlanAmeliorationDao planAmeliorationDao;

    @Autowired
    private IncidentDao incidentDao;

    @Autowired
    private ColaboratorDao colaboratorDao;
    public PlanAmelioration save(PlanAmeliorationDTO dto) {
        PlanAmelioration plan = new PlanAmelioration();
        // Remplir champs simples
        plan.setLibelle(dto.getLibelle());
        plan.setDescriptionAction(dto.getDescriptionAction());
        plan.setDateCreation(LocalDateTime.parse(dto.getDateCreation()));
        plan.setDateResolutionPrevue(LocalDateTime.parse(dto.getDateResolutionPrevue()));
        // Trouver l'incident par ID
        Long incidentId = dto.getIncident().getId();
        Incident incident = incidentDao.findById(incidentId)
                .orElseThrow(() -> new RuntimeException("Incident avec l'id " + incidentId + " non trouvé."));
        plan.setIncident(incident);
        // Trouver le collaborateur par son ID
        Long colaboratorId = dto.getColaboratorPlan().getId();
        Colaborator colaborator = colaboratorDao.findById(colaboratorId)
                .orElseThrow(() -> new RuntimeException("Collaborateur avec l'id " + colaboratorId + " non trouvé."));
        plan.setColaboratorPlan(colaborator);
        // Sauvgarder plan
        return planAmeliorationDao.save(plan);
    }




    public List<PlanAmelioration> findAll() {
        return planAmeliorationDao.findAll();
    }
    public int deleteById(Long id) {
        if (planAmeliorationDao.existsById(id)) { planAmeliorationDao.deleteById(id); return 1; }
        return -1;
    }
}
