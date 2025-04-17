package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.EtatIncident;
import com.tanger_med.pfe_projet.service.implementation.EtatIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etat-incident")
public class EtatIncidentWS {

    @Autowired
    private EtatIncidentService etatIncidentService;

    @PostMapping("/")
    public int save(@RequestBody EtatIncident etatIncident) {
         etatIncidentService.save(etatIncident);
        return 1;
    }

    @GetMapping("/")
    public List<EtatIncident> findAll() {
        return etatIncidentService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<EtatIncident> findById(@PathVariable Long id) {
        return etatIncidentService.findById(id);
    }

    @GetMapping("/libelle/{libelle}")
    public EtatIncident findByLibelle(@PathVariable String libelle) {
        return etatIncidentService.findByLibelle(libelle);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        Optional<EtatIncident> etat = etatIncidentService.findById(id);
        if (etat.isEmpty()) {
            return -1;
        } else {
            etatIncidentService.deleteById(id);
            return 1;
        }
    }



}
