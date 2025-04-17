package com.tanger_med.pfe_projet.bean;

import jakarta.persistence.*;

@Entity
public class Colaborator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TypeColaborator typeColaborator;

    public Long getId() {
        return id;
    }

    public TypeColaborator getTypeColaborator() {
        return typeColaborator;
    }

    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeColaborator(TypeColaborator typeColaborator) {
        this.typeColaborator = typeColaborator;
    }
}
