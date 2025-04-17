package com.tanger_med.pfe_projet.bean;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class   PlanAmelioration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //FetchType.LAZY signifie que les données liées à l'entité (les entités associées) ne seront chargées que lorsque vous y accédez explicitement
    @JoinColumn(name = "incident_id")
    private Incident incident;

    @ManyToOne
    private Colaborator colaboratorPlan;

    @Lob
    private String descriptionAction;

    private String libelle;
    private LocalDateTime dateCreation;
    private LocalDateTime dateResolutionPrevue;

    public Long getId() {
        return id;
    }

    public Incident getIncident() {
        return incident;
    }

    public Colaborator getColaboratorPlan() {
        return colaboratorPlan;
    }

    public String getDescriptionAction() {
        return descriptionAction;
    }

    public String getLibelle() {
        return libelle;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateResolutionPrevue() {
        return dateResolutionPrevue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public void setColaboratorPlan(Colaborator colaboratorPlan) {
        this.colaboratorPlan= colaboratorPlan;
    }

    public void setDescriptionAction(String descriptionAction) {
        this.descriptionAction = descriptionAction;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateResolutionPrevue(LocalDateTime dateResolutionPrevue) {
        this.dateResolutionPrevue = dateResolutionPrevue;
    }
}
