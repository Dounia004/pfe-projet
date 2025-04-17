package com.tanger_med.pfe_projet.dto;

public class IncidentDTO {

    private String libelle;
    private String date;
    private String dateSoumission;
    private String dateValidation;
    private boolean fondee;
    private String descriptionIncident;
    private String fichierAttachement;
    private String commentaire;
    private String recommendation;

    private TypeIncidentDTO typeIncident;
    private EtatIncidentDTO etatIncident;
    private NatureIncidentDTO natureIncident;
    private PortDTO port;
    private SecteurDto secteur;
    private ColaboratorDTO colaborator;

    public static class TypeIncidentDTO {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class EtatIncidentDTO {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class NatureIncidentDTO {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class PortDTO {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class SecteurDto {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class ColaboratorDTO {
        private String typeColaboratorCode;

        public String getTypeColaboratorCode() {
            return typeColaboratorCode;
        }

        public void setTypeColaboratorCode(String typeColaboratorCode) {
            this.typeColaboratorCode = typeColaboratorCode;
        }
    }

    //getters et setters de classe mere


    public String getLibelle() {
        return libelle;
    }

    public String getDate() {
        return date;
    }

    public String getDateSoumission() {
        return dateSoumission;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public boolean isFondee() {
        return fondee;
    }

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

    public TypeIncidentDTO getTypeIncident() {
        return typeIncident;
    }

    public EtatIncidentDTO getEtatIncident() {
        return etatIncident;
    }

    public NatureIncidentDTO getNatureIncident() {
        return natureIncident;
    }

    public PortDTO getPort() {
        return port;
    }

    public SecteurDto getSecteur() {
        return secteur;
    }

    public ColaboratorDTO getColaborator() {
        return colaborator;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateSoumission(String dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setFondee(boolean fondee) {
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

    public void setTypeIncident(TypeIncidentDTO typeIncident) {
        this.typeIncident = typeIncident;
    }

    public void setEtatIncident(EtatIncidentDTO etatIncident) {
        this.etatIncident = etatIncident;
    }

    public void setNatureIncident(NatureIncidentDTO natureIncident) {
        this.natureIncident = natureIncident;
    }

    public void setPort(PortDTO port) {
        this.port = port;
    }

    public void setSecteur(SecteurDto secteur) {
        this.secteur = secteur;
    }

    public void setColaborator(ColaboratorDTO colaborator) {
        this.colaborator = colaborator;
    }
}
