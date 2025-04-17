package com.tanger_med.pfe_projet.ws;

import com.tanger_med.pfe_projet.bean.NatureIncident;
import com.tanger_med.pfe_projet.service.implementation.NatureIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nature-incidents")
public class NatureIncidentWS {
    @Autowired
    private NatureIncidentService natureIncidentService;

    @PostMapping("/")
    public NatureIncident save(@RequestBody NatureIncident natureIncident) {
        return natureIncidentService.save(natureIncident);
    }

    @GetMapping("/")
    public List<NatureIncident> findAll() {
        return natureIncidentService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return natureIncidentService.deleteById(id);
    }
}
