package com.tanger_med.pfe_projet.dto;

public class PlanAmeliorationDTO {
    private String libelle;
    private String descriptionAction;
    private String dateCreation;
    private String dateResolutionPrevue;
    private IncidentIdDTO incident;
    private ColaboratorTypeIdDTO colaboratorPlan;


//premiere classe imbriquer
    public static class IncidentIdDTO {
        private Long id; // Utilisation de l'ID

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    //deuxieme classe imbrique
    public static class ColaboratorTypeIdDTO {
        private Long id; // ID du TypeColaborator

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    //getters et setters de classe mere

    public String getLibelle() {
        return libelle;
    }

    public String getDescriptionAction() {
        return descriptionAction;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateResolutionPrevue() {
        return dateResolutionPrevue;
    }

    public IncidentIdDTO getIncident() {
        return incident;
    }

    public ColaboratorTypeIdDTO getColaboratorPlan() {
        return colaboratorPlan;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescriptionAction(String descriptionAction) {
        this.descriptionAction = descriptionAction;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateResolutionPrevue(String dateResolutionPrevue) {
        this.dateResolutionPrevue = dateResolutionPrevue;
    }

    public void setIncident(IncidentIdDTO incident) {
        this.incident = incident;
    }

    public void setColaboratorPlan(ColaboratorTypeIdDTO colaboratorPlan) {
        this.colaboratorPlan = colaboratorPlan;
    }

}
