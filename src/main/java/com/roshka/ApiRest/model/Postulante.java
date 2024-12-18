package com.roshka.ApiRest.model;

import jakarta.persistence.*;

@Entity
public class Postulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer nroCedula;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean experienciaLaboral;
    private Boolean estudioUniversitario;
    private Boolean notebook;
    private Boolean aceptado;

    @Column(name = "bootcamp_id", nullable = true)
    private Integer bootcampId;

    public Postulante(){
    }

    public Postulante(Long id, Integer ci, String nombre, String apellido, Integer nroCedula, String correo, String telefono, String direccion, Boolean experienciaLaboral, Boolean estudioUniversitario, Boolean notebook, Boolean aceptado, Integer bootcampId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.experienciaLaboral = experienciaLaboral;
        this.estudioUniversitario = estudioUniversitario;
        this.notebook = notebook;
        this.aceptado = aceptado;
        this.bootcampId = bootcampId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(Integer nroCedula) {
        this.nroCedula = nroCedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Boolean experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public Boolean getEstudioUniversitario() {
        return estudioUniversitario;
    }

    public void setEstudioUniversitario(Boolean estudioUniversitario) {
        this.estudioUniversitario = estudioUniversitario;
    }

    public Boolean getNotebook() {
        return notebook;
    }

    public void setNotebook(Boolean notebook) {
        this.notebook = notebook;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Integer getBootcampId() {
        return bootcampId;
    }

    public void setBootcampId(Integer bootcampId) {
        this.bootcampId = bootcampId;
    }
}
