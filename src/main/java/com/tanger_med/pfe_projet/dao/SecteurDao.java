package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Long> {
    Secteur findByCode(String code);

}
