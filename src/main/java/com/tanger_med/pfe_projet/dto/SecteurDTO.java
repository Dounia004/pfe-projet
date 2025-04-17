package com.tanger_med.pfe_projet.dto;

public class SecteurDTO {
    private String code;
    private String libelle;
    private String description;
    private String style;
    private PortCodeDTO port;

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

    public PortCodeDTO getPort() {
        return port;
    }
    //setters


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

    public void setPort(PortCodeDTO port) {
        this.port = port;
    }


    //classe statique imbrique'
    public static class PortCodeDTO {
        private String code;

        //getter

        public String getCode() {
            return code;
        }
        //setter

        public void setCode(String code) {
            this.code = code;
        }

    }

}
