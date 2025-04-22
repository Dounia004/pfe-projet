package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortDao extends JpaRepository<Port,Long> {
    Port findByCode(String code);

}
