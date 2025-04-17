package com.tanger_med.pfe_projet.ws;


import com.tanger_med.pfe_projet.bean.TypeColaborator;
import com.tanger_med.pfe_projet.service.implementation.TypeColaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-colaborators")
public class TypeColaboratorWS {

    @Autowired
    private TypeColaboratorService typeColaboratorService;

    @PostMapping("/")
    public TypeColaborator save(@RequestBody TypeColaborator typeColaborator){
        return typeColaboratorService.save(typeColaborator);
    }

    @GetMapping("/")
    public List<TypeColaborator> findAll() {
        return typeColaboratorService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeColaboratorService.deleteById(id);
    }

}
