package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.PlanAmelioration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PlanAmeliorationDao extends JpaRepository<PlanAmelioration, Long> {

}
