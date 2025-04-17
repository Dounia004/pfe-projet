package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.EtatIncident;
import com.tanger_med.pfe_projet.bean.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IncidentDao extends JpaRepository<Incident,Long> {
    List<Incident> findByTypeIncidentCode(String code);
    List<Incident> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Incident> findByEtatIncidentCode(String code);



}
