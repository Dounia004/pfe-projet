package com.tanger_med.pfe_projet.dto;

import lombok.Data;


public class ColaboratorDTO {
    private String typeColaboratorCode;

   public String getTypeColaboratorCode() {
        return typeColaboratorCode;
    }

    public void setTypeColaboratorCode(String typeColaboratorCode) {
        this.typeColaboratorCode = typeColaboratorCode;
    }

    public static class PortCodeDTO{
       private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }


}
