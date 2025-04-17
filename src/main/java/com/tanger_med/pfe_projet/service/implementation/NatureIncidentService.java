package com.tanger_med.pfe_projet.service.implementation;

import com.tanger_med.pfe_projet.bean.NatureIncident;
import com.tanger_med.pfe_projet.dao.NatureIncidentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureIncidentService {
    @Autowired
    private NatureIncidentDao dao;

    public NatureIncident save(NatureIncident obj) { return dao.save(obj); }
    public List<NatureIncident> findAll() { return dao.findAll(); }
    public int deleteById(Long id) {
        if (dao.existsById(id)) { dao.deleteById(id); return 1; }
        return -1;
    }
}
