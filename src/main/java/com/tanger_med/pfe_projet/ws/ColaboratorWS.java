package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.Colaborator;
import com.tanger_med.pfe_projet.dto.ColaboratorDTO;
import com.tanger_med.pfe_projet.service.implementation.ColaboratorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaborators")
public class ColaboratorWS {

    @Autowired
    private ColaboratorService colaboratorService;

    /*@PostMapping("/")
    public Colaborator save(@RequestBody Colaborator colaborator){
        return colaboratorService.save(colaborator);
    }
     */

    @PostMapping("/")
    public Colaborator save(@RequestBody ColaboratorDTO colaboratorDTO) {
        return colaboratorService.save(colaboratorDTO);
    }

    @GetMapping("/")
    public List<Colaborator> findAll() {
        return colaboratorService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return colaboratorService.deleteById(id);
    }

    @GetMapping("/typeColaborator/code/{code}")
    public List<Colaborator> findByTypeColaboratorCode(@PathVariable String code){
        return colaboratorService.findByTypeColaboratorCode(code);
    }

    @GetMapping("/count/typeColaborator/code/{code}")
    public long countByTypeColaboratorCode(@PathVariable String code) {
        return colaboratorService.countByTypeColaboratorCode(code);
    }
}
