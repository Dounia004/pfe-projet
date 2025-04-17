package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.TypeIncident;
import com.tanger_med.pfe_projet.service.implementation.TypeIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-incidents")

public class TypeIncidentWS {
    @Autowired
    private TypeIncidentService typeIncidentService;

    // Ajouter un nouveau type d'incident
    @PostMapping("/")
    public int save(@RequestBody TypeIncident typeIncident) {
        return typeIncidentService.save(typeIncident);
    }

    // Récupérer tous les types
    @GetMapping("/")
    public List<TypeIncident> findAll() {
        return typeIncidentService.findAll();
    }

    // Récupérer un type par ID
    @GetMapping("/id/{id}")
    public Optional<TypeIncident> findById(@PathVariable Long id) {
        return typeIncidentService.findById(id);
    }

    //Récupérer un type par code
    @GetMapping("/code/{code}")
    public TypeIncident findByCode(@PathVariable String code) {
        return typeIncidentService.findByCode(code);
    }

    //Supprimer un type par ID
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        typeIncidentService.deleteById(id);
        return 1;
    }

    //Supprimer par style
    @DeleteMapping("/style/{style}")
    public int deleteByStyle(@PathVariable String style) {
        return typeIncidentService.deleteByStyle(style);
    }

    // Récupérer les types critiques (style = "danger")
    @GetMapping("/style/critical")
    public List<TypeIncident> findCriticalTypes() {
        return typeIncidentService.findCriticalTypes();
    }

    @GetMapping("/style/success")
    public List<TypeIncident> findSuccessfulTypes() {
        return typeIncidentService.findSuccessfulTypes();
    }

    //Mise à jour du libellé à partir du code
    @PutMapping("/libelle")
    public void updateLibelle(@RequestParam String code, @RequestParam String newLibelle) {
        typeIncidentService.updateLibelle(code, newLibelle);
    }





}
