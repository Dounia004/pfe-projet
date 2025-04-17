package com.tanger_med.pfe_projet.service.implementation;


import com.tanger_med.pfe_projet.bean.TypeColaborator;
import com.tanger_med.pfe_projet.dao.TypeColaboratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TypeColaboratorService {

    @Autowired
    private TypeColaboratorDao typeColaboratorDao;

    public TypeColaborator save(TypeColaborator typeColaborator){
        return typeColaboratorDao.save(typeColaborator);
    }

    public List<TypeColaborator> findAll(){
        return typeColaboratorDao.findAll();
    }

    public int deleteById(Long id){
        if(typeColaboratorDao.findById(id).isPresent()){
            typeColaboratorDao.deleteById(id);
            return 1;
        }
        return -1;
    }

}
