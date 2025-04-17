package com.tanger_med.pfe_projet.service.implementation;


import com.tanger_med.pfe_projet.bean.EtatIncident;
import com.tanger_med.pfe_projet.dao.EtatIncidentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatIncidentService {

    @Autowired
    private EtatIncidentDao etatIncidentDao;

    public int save(EtatIncident etatIncident) {
        EtatIncident existing = etatIncidentDao.findByLibelle(etatIncident.getLibelle());
        if (existing != null) {
            //throw new RuntimeException("EtatIncident avec le libellé '" + etatIncident.getLibelle() + "' existe déjà.");
            return -1;
        }
        etatIncidentDao.save(etatIncident);
        return 1;

    }


    public Optional<EtatIncident> findById(Long id) {
        return etatIncidentDao.findById(id);
    }

    public EtatIncident findByLibelle(String libelle) {
        return etatIncidentDao.findByLibelle(libelle);
    }

    public int deleteById(Long id) {
        if(etatIncidentDao.existsById(id)){
            etatIncidentDao.deleteById(id);
            return 1;
        }
        return -1;
    }

    public List<EtatIncident> findAll() {
        return etatIncidentDao.findAll();
    }


}



