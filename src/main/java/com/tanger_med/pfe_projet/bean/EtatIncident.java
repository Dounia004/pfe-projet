package com.tanger_med.pfe_projet.bean;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EtatIncident {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    private String style;
    private String decriptionEtat;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getStyle() {
        return style;
    }

    public String getDecriptionEtat() {
        return decriptionEtat;
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

    public void setStyle(String style) {
        this.style = style;
    }

    public void setDecriptionEtat(String decriptionEtat) {
        this.decriptionEtat = decriptionEtat;
    }

}