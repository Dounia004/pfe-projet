package com.tanger_med.pfe_projet.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private LocalDateTime date;
    private LocalDateTime dateSoumission;
    private LocalDateTime dateValidation;
    private Boolean fondee;
    @Lob
    private String descriptionIncident;
    private String fichierAttachement;

    @Lob
    private String commentaire;
    @Lob
    private String recommendation;

    @ManyToOne
    private NatureIncident natureIncident;

    @ManyToOne
    private Secteur secteur;

    @ManyToOne
    private Port port;

    @ManyToOne
    private EtatIncident etatIncident;

    @ManyToOne
    private TypeIncident typeIncident;
    @ManyToOne
    private Colaborator colaborator;


    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getDateSoumission() {
        return dateSoumission;
    }

    public LocalDateTime getDateValidation() {
        return dateValidation;
    }

    public Boolean getFondee() {
        return fondee;
    }

    // soit
    public String getDescriptionIncident() {
        return descriptionIncident;
    }



    public String getFichierAttachement() {
        return fichierAttachement;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public NatureIncident getNatureIncident() {
        return natureIncident;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public Port getPort() {
        return port;
    }

    public EtatIncident getEtatIncident() {
        return etatIncident;
    }

    public TypeIncident getTypeIncident() {
        return typeIncident;
    }

    public Colaborator getColaborator() {
        return colaborator;
    }

    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDateSoumission(LocalDateTime dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public void setDateValidation(LocalDateTime dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setFondee(Boolean fondee) {
        this.fondee = fondee;
    }


    public void setDescriptionIncident(String descriptionIncident) {
        this.descriptionIncident = descriptionIncident;
    }

    public void setFichierAttachement(String fichierAttachement) {
        this.fichierAttachement = fichierAttachement;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public void setNatureIncident(NatureIncident natureIncident) {
        this.natureIncident = natureIncident;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public void setEtatIncident(EtatIncident etatIncident) {
        this.etatIncident = etatIncident;
    }

    public void setTypeIncident(TypeIncident typeIncident) {
        this.typeIncident = typeIncident;
    }

    public void setColaborator(Colaborator colaborator) {
        this.colaborator = colaborator;
    }
}

