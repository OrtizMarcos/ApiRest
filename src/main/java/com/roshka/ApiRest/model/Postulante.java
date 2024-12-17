package com.roshka.ApiRest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Postulante") // Especifica explícitamente el nombre de la tabla
public class Postulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // No debe ser nulo
    private String nombre;

    @Column(nullable = false) // No debe ser nulo
    private String apellido;

    @Column(name = "nroCedula", nullable = false, unique = true) // Clave única y no nula
    private String nroCedula;

    @Column(nullable = false) // No debe ser nulo
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(name = "experiencia_laboral", nullable = false)
    private Boolean experienciaLaboral;

    @Column(name = "estudio_universitario", nullable = false)
    private Boolean estudioUniversitario;

    @Column(nullable = false)
    private Boolean notebook;

    @Column(nullable = false)
    private Boolean aceptado;

    @Column(name = "bootcamp_id", nullable = true) // Puede ser nulo
    private Integer bootcampId;

    // Constructor vacío requerido por JPA
    public Postulante() {
    }

    // Getters y setters
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

    public String getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(String nroCedula) {
        this.nroCedula = this.nroCedula;
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
