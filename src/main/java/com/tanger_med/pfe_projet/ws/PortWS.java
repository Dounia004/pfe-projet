package com.tanger_med.pfe_projet.ws;

import com.tanger_med.pfe_projet.bean.Port;
import com.tanger_med.pfe_projet.service.implementation.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortWS {
    @Autowired
    private PortService portService;

    @PostMapping("/")
    public Port save(@RequestBody Port port) {
        return portService.save(port);
    }

    @GetMapping("/")
    public List<Port> findAll() {
        return portService.findAll();
    }

    @GetMapping("/code/{code}")
    public Port findByCode(@PathVariable String code) {
        return portService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return portService.deleteByCode(code);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return portService.deleteById(id);
    }
}

