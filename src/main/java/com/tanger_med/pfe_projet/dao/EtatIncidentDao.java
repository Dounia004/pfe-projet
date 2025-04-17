package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.EtatIncident;
import com.tanger_med.pfe_projet.bean.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatIncidentDao extends JpaRepository<EtatIncident,Long> {
    EtatIncident findByLibelle(String code);
    EtatIncident findByCode(String code);
}
