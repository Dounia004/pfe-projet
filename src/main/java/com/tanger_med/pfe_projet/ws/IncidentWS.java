package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.Incident;
import com.tanger_med.pfe_projet.dto.IncidentDTO;
import com.tanger_med.pfe_projet.service.implementation.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incidents")
public class IncidentWS {
    @Autowired
    private IncidentService incidentService;
    //creation incident
    @PostMapping("/")
    public Incident save(@RequestBody IncidentDTO dto){

        return incidentService.save(dto);
    }


    @GetMapping("/type-incident/code/{code}")
    public List<Incident> findByTypeIncidentCode(@PathVariable String code) {
        return incidentService.findByTypeIncidentCode(code);
    }

    //recuperer incident
    @GetMapping("/id/{id}")
    public Optional<Incident> findById(@PathVariable Long id){
        return incidentService.findById(id);
    }

    //supprimer incident par id
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        incidentService.deleteById(id);
        return 1;
    }

    //recuperer incident entre 2 dates
    //@RequestParam: récupérer des paramètres de requête dans l'URL.
    @GetMapping("/date")
    public ResponseEntity<?> findByDateBetween(@PathVariable("start") String start,
                                            @PathVariable("end") String end){
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
       //si la date n'est pas valide
        if (startDate.isAfter(endDate)) {
            return ResponseEntity.badRequest().body("La date de début doit être avant la date de fin");
        }
        //si la date est valide alors recupere liste incident between ces 2 dates
            List<Incident> incidents = incidentService.findByDateBetween(startDate,endDate);
        return ResponseEntity.ok(incidents);
    }

    // Valider un incident
    @PutMapping("/valider/{id}")
    public Incident validerIncident(@PathVariable Long id) {
        return incidentService.validerIncident(id);
    }

    // Rejeter un incident avec commentaire
    //si on veut utiliser pathvariable pour commentaire aussi il faut quand lajoute dans le chemin de mappin : @PutMapping("/rejeter/{id}/{commentaire}")
    @PutMapping("/rejeter/{id}")
    public Incident rejeterIncident(@PathVariable Long id,
                                    @RequestParam("commentaire") String commentaire) {
        return incidentService.rejeterIncident(id, commentaire);
    }

    // Récupérer les incidents par etatIncident.code
    @GetMapping("/etat-incident/code/{code}")
    public List<Incident> findByEtatIncidentCode(@PathVariable String code) {
        return incidentService.findByEtatIncidentCode(code);
    }

}
