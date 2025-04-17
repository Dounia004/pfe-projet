package com.tanger_med.pfe_projet.service.implementation;


import com.tanger_med.pfe_projet.bean.Colaborator;
import com.tanger_med.pfe_projet.bean.TypeColaborator;
import com.tanger_med.pfe_projet.dao.ColaboratorDao;
import com.tanger_med.pfe_projet.dao.TypeColaboratorDao;
import com.tanger_med.pfe_projet.dto.ColaboratorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboratorService {
    @Autowired
    private ColaboratorDao colaboratorDao;

    @Autowired
    private TypeColaboratorDao typeColaboratorDao;

    /*
    public Colaborator save(Colaborator colaborator){
       // il faut que le type colaborator deja existe
        TypeColaborator type=typeColaboratorDao.findByCode(colaborator.getTypeColaborator().getCode());
        if(type==null){
            throw new IllegalArgumentException("type colaborator avec le code"+ colaborator.getTypeColaborator().getCode()+"nexiste pas");
        }
        colaborator.setTypeColaborator(type);
        return colaboratorDao.save(colaborator);
    }
     */

    public Colaborator save(ColaboratorDTO dto){
        TypeColaborator type = typeColaboratorDao.findByCode(dto.getTypeColaboratorCode());
        if (type == null) {
            throw new IllegalArgumentException("TypeColaborator avec le code " + dto.getTypeColaboratorCode() + " n'existe pas");
        }
        Colaborator colaborator = new Colaborator();
        colaborator.setTypeColaborator(type);

        return colaboratorDao.save(colaborator);
    }

    public List<Colaborator> findAll(){
        return colaboratorDao.findAll();
    }

    public int deleteById(Long id){
        if(colaboratorDao.findById(id).isPresent()){
            colaboratorDao.deleteById(id);
            return 1;
        }
        return -1;
    }

    public List<Colaborator> findByTypeColaboratorCode(String code){
        return colaboratorDao.findByTypeColaboratorCode(code);
    }

    public long countByTypeColaboratorCode(String code){
        return colaboratorDao.countByTypeColaboratorCode(code);
    }




}

