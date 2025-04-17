package com.tanger_med.pfe_projet.ws;

import com.tanger_med.pfe_projet.bean.PlanAmelioration;
import com.tanger_med.pfe_projet.dto.PlanAmeliorationDTO;
import com.tanger_med.pfe_projet.service.implementation.PlanAmeliorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans-amelioration")
public class PlanAmeliorationWS {
    @Autowired
    private PlanAmeliorationService planAmeliorationService;

    @PostMapping("/")
    public PlanAmelioration save(@RequestBody PlanAmeliorationDTO planAmeliorationDTO) {
        return planAmeliorationService.save(planAmeliorationDTO);
    }
    @GetMapping("/")
    public List<PlanAmelioration> findAll() {
        return planAmeliorationService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return planAmeliorationService.deleteById(id);
    }
}

