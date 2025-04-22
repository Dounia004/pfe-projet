package com.tanger_med.pfe_projet.service.implementation;

import com.tanger_med.pfe_projet.bean.Colaborator;
import com.tanger_med.pfe_projet.bean.EtatIncident;
import com.tanger_med.pfe_projet.bean.Incident;
import com.tanger_med.pfe_projet.dao.*;
import com.tanger_med.pfe_projet.dto.IncidentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentDao incidentDao;
    @Autowired
    private EtatIncidentDao etatIncidentDao;
    @Autowired
    private TypeIncidentDao typeIncidentDao;
    @Autowired
    private NatureIncidentDao natureIncidentDao;
    @Autowired
    private SecteurDao secteurDao;
    @Autowired
    private PortDao portDao;
    @Autowired
    private ColaboratorDao colaboratorDao;

    public Incident save(IncidentDTO dto) {
        Incident incident = mapDtoToEntity(dto);
        return incidentDao.save(incident);
    }

    //methode de mapp
    private Incident mapDtoToEntity(IncidentDTO dto) {
        Incident incident = new Incident();

        incident.setLibelle(dto.getLibelle());
        incident.setDescriptionIncident(dto.getDescriptionIncident());
        incident.setFichierAttachement(dto.getFichierAttachement());
        incident.setCommentaire(dto.getCommentaire());
        incident.setRecommendation(dto.getRecommendation());
        incident.setFondee(dto.isFondee());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        if (dto.getDate() != null) {
            incident.setDate(LocalDateTime.parse(dto.getDate(), formatter));
        }
        if (dto.getDateSoumission() != null) {
            incident.setDateSoumission(LocalDateTime.parse(dto.getDateSoumission(), formatter));
        }
        if (dto.getDateValidation() != null) {
            incident.setDateValidation(LocalDateTime.parse(dto.getDateValidation(), formatter));
        }
        //Associations avec d'autres entités
        if (dto.getTypeIncident() != null && dto.getTypeIncident().getCode() != null) {
            incident.setTypeIncident(typeIncidentDao.findByCode(dto.getTypeIncident().getCode()));
        }
        if (dto.getEtatIncident() != null && dto.getEtatIncident().getCode() != null) {
            incident.setEtatIncident(etatIncidentDao.findByCode(dto.getEtatIncident().getCode()));
        }
        if (dto.getNatureIncident() != null && dto.getNatureIncident().getCode() != null) {
            incident.setNatureIncident(natureIncidentDao.findByCode(dto.getNatureIncident().getCode()));
        }
        if (dto.getSecteur() != null && dto.getSecteur().getCode() != null) {
            incident.setSecteur(secteurDao.findByCode(dto.getSecteur().getCode()));
        }
        if (dto.getPort() != null && dto.getPort().getCode() != null) {
            incident.setPort(portDao.findByCode(dto.getPort().getCode()));
        }
        //recuperer liste de Colaborator correspondant au type.
        if (dto.getColaborator() != null && dto.getColaborator().getTypeColaboratorCode() != null) {
            List<Colaborator> cols = colaboratorDao.findByTypeColaboratorCode(dto.getColaborator().getTypeColaboratorCode());
            if (!cols.isEmpty()) {
                incident.setColaborator(cols.get(0)); // ou choisir selon une logique métier
            }
        }

        return incident;
    }



    public List<Incident> findAll(){

        return incidentDao.findAll();
    }

    //Optional : car Un incident avec l'ID demandé peut ne pas exister en base de données.
    public Optional<Incident> findById(Long id){
        return incidentDao.findById(id);
    }

    public int deleteById(Long id){
        if(incidentDao.existsById(id)){
            incidentDao.deleteById(id);
            return 1;
        }
        return -1;
    }

    public List<Incident> findByTypeIncidentCode(String code) {
        return incidentDao.findByTypeIncidentCode(code);
    }

    public List<Incident> findByDateBetween(LocalDateTime start, LocalDateTime end) {
        return incidentDao.findByDateBetween(start, end);
    }

    //Valider un incident
    @Transactional
    public Incident validerIncident(Long id) {
        Optional<Incident> optionalIncident = incidentDao.findById(id);

        if (!optionalIncident.isPresent()) {
            throw new RuntimeException("Incident non trouvé avec l'ID : " + id);
        }
        Incident incident = optionalIncident.get();

        EtatIncident etat = etatIncidentDao.findByLibelle("Valide");
        if (etat == null) {
            throw new RuntimeException("État 'Valide' introuvable dans la base de données");
        }

        incident.setEtatIncident(etat);
        incident.setDateValidation(LocalDateTime.now());
        return incident;
    }

    //Rejeter un incident

    @Transactional
    public Incident rejeterIncident(Long id, String commentaire) {
        // Vérifier incident
        Optional<Incident> optionalIncident = incidentDao.findById(id);
        if (!optionalIncident.isPresent()) {
            throw new RuntimeException("Aucun incident trouvé avec l'ID: " + id);
        }
        Incident incident = optionalIncident.get();
        // Vérification de l'état "Rejeté"
        EtatIncident etat = etatIncidentDao.findByLibelle("rejete");
        if (etat == null) {
            throw new RuntimeException("L'état 'Rejete' n'est pas configuré dans le système");
        }
        // Valider commentaire
        if (commentaire == null || commentaire.isBlank()) {
            throw new RuntimeException("Un commentaire est obligatoire pour rejeter un incident");
        }
        // Mise à jour
        incident.setEtatIncident(etat);
        incident.setCommentaire(commentaire.trim());
        incident.setDateValidation(LocalDateTime.now()); // Ajout recommandé

        return incident;
    }

      // incidents par état
    public List<Incident> findByEtatIncidentCode(String code) {
        return incidentDao.findByEtatIncidentCode(code);
    }

}
