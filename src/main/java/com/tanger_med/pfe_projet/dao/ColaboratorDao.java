package com.tanger_med.pfe_projet.dao;


import com.tanger_med.pfe_projet.bean.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboratorDao extends JpaRepository<Colaborator,Long> {

    List<Colaborator> findByTypeColaboratorCode(String code);
    long countByTypeColaboratorCode(String code);
    List<Colaborator> findByTypeColaboratorId(Long id);


}
