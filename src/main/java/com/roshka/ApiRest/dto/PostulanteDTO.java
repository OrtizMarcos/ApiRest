package com.roshka.ApiRest.dto;

public class PostulanteDTO {
    private String nro_Cedula;
    private String nombre;

    // Constructor
    public PostulanteDTO(String nroCedula, String nombre) {
        this.nro_Cedula = nroCedula;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNroCedula() {
        return nro_Cedula;
    }

    public void setNroCedula(String nroCedula) {
        this.nro_Cedula = nroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

