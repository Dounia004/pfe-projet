package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.Secteur;
import com.tanger_med.pfe_projet.dto.SecteurDTO;
import com.tanger_med.pfe_projet.service.implementation.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secteurs")
public class SecteurWS {
    @Autowired
    private SecteurService secteurService;

    @PostMapping("/")
    public Secteur save(@RequestBody SecteurDTO secteurDTO) {
        return secteurService.save(secteurDTO);
    }

    @GetMapping("/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }

    @GetMapping("/code/{code}")
    public Secteur findByCode(@PathVariable String code) {
        return secteurService.findByCode(code);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return secteurService.deleteById(id);
    }
}

