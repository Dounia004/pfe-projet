package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.TypeIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeIncidentDao extends JpaRepository<TypeIncident,Long> {

TypeIncident findByCode(String code);
int deleteByStyle(String style);
List<TypeIncident> findByStyle(String style);

}
