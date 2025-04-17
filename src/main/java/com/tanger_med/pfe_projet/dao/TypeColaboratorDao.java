package com.tanger_med.pfe_projet.dao;

import com.tanger_med.pfe_projet.bean.TypeColaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeColaboratorDao extends JpaRepository<TypeColaborator,Long> {
 TypeColaborator findByCode(String code);

}
