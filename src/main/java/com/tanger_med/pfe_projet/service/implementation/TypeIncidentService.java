package com.tanger_med.pfe_projet.service.implementation;

import com.tanger_med.pfe_projet.bean.TypeIncident;
import com.tanger_med.pfe_projet.dao.TypeIncidentDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeIncidentService {
    @Autowired
    public TypeIncidentDao typeIncidentDao;


    public int save(TypeIncident typeIncident){
        TypeIncident existing = typeIncidentDao.findByCode(typeIncident.getCode());
        //si un type dincident avec le meme code existe deja
        if (existing != null) {
            //throw new RuntimeException("TypeIncident avec le code '" + typeIncident.getCode() + "' existe déjà.");
            return -1;
        }
        typeIncidentDao.save(typeIncident);
        return 1;
    }


    public List<TypeIncident> findAll(){
        return typeIncidentDao.findAll();
    }

    public Optional<TypeIncident> findById(Long id){
        return typeIncidentDao.findById(id);
    }

    public int deleteById(Long id){
        if(typeIncidentDao.existsById(id)){
            typeIncidentDao.deleteById(id);
            return 1;
        }
        return -1;
    }

    public TypeIncident findByCode(String code){
        return typeIncidentDao.findByCode(code);
    }

    //Supprimer tous les TypeIncident qui ont un style spécifique
    public int deleteByStyle(String style){
        return typeIncidentDao.deleteByStyle(style);
    }

    public List<TypeIncident> findCriticalTypes() {
        return typeIncidentDao.findByStyle("danger");
    }

    public List<TypeIncident> findSuccessfulTypes() {
        return typeIncidentDao.findByStyle("success");
    }
    //mise a jour libelle
    @Transactional
    public int updateLibelle(String code, String newLibelle) {
        TypeIncident type = typeIncidentDao.findByCode(code);
        if (type == null) {
            //throw new RuntimeException("TypeIncident non trouvé avec le code: " + code);
            return -1;
        }
        type.setLibelle(newLibelle);
              return 1;     // Pas besoin de save() car @Transactional
    }




}
