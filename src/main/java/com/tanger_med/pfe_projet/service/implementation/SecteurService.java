package com.tanger_med.pfe_projet.service.implementation;

import com.tanger_med.pfe_projet.bean.Port;
import com.tanger_med.pfe_projet.bean.Secteur;
import com.tanger_med.pfe_projet.dao.PortDao;
import com.tanger_med.pfe_projet.dao.SecteurDao;
import com.tanger_med.pfe_projet.dto.SecteurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {

    @Autowired
    private SecteurDao secteurDao;

    @Autowired
    private PortDao portDao;

    public Secteur save(SecteurDTO dto) {
        // verifier validite du dto cad bien rempli le champ du port dans le JSON de secteur.
        if (dto.getPort() == null||dto.getPort().getCode() == null) {
            throw new IllegalArgumentException("Le code du port est requis.");
        }

        Port port = portDao.findByCode(dto.getPort().getCode());
        if (port == null) {
            throw new IllegalArgumentException("Port avec le code " + dto.getPort().getCode() + " n'existe pas");
        }

        Secteur secteur = new Secteur();
        secteur.setCode(dto.getCode());
        secteur.setLibelle(dto.getLibelle());
        secteur.setDescription(dto.getDescription());
        secteur.setStyle(dto.getStyle());
        secteur.setPort(port);

        return secteurDao.save(secteur);
    }

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    public Secteur findByCode(String code) {
        return secteurDao.findByCode(code);
    }


    public int deleteById(Long id) {
        if (secteurDao.existsById(id)) {
            secteurDao.deleteById(id);
            return 1;
        }
        return -1;
    }
}

