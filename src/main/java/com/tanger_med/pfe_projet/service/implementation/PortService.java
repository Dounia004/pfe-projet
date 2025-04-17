package com.tanger_med.pfe_projet.service.implementation;


import com.tanger_med.pfe_projet.bean.Port;
import com.tanger_med.pfe_projet.dao.PortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortService {
    @Autowired
    private PortDao dao;

    public Port save(Port port) { return dao.save(port); }
    public List<Port> findAll() { return dao.findAll(); }
    public int deleteById(Long id) {
        if (dao.existsById(id)) { dao.deleteById(id); return 1; }
        return -1;
    }
}
