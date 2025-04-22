package com.tanger_med.pfe_projet.bean;

import jakarta.persistence.*;

@Entity
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String libelle;
    private String description;
    private String style;


    @ManyToOne // (fetch = FetchType.LAZY)  FetchType.LAZY signifie que les données liées à l'entité (les entités associées) ne seront chargées que lorsque vous y accédez explicitement
    @JoinColumn(name = "port_id")
    private Port port;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public String getStyle() {
        return style;
    }

    public Port getPort() {
        return port;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setPort(Port port) {
        this.port = port;
    }
}
