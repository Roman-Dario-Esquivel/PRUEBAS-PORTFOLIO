package com.portfolio.Roman_Dario_Esquivel.Dto;

import jakarta.validation.constraints.NotBlank;



public class dtoEducacion {
    @NotBlank
    private String nombre_institucion;
    @NotBlank
    private String nombreTitulacion;
    @NotBlank
    private String descripcion_edu;
    @NotBlank
    private String logoimg;
    @NotBlank
    private String fecha_inicio;
    private String actualmente;
    private String fecha_fin;

    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre_institucion, String nombreTitulacion, String descripcion_edu, String logoimg, String fecha_inicio, String actualmente, String fecha_fin) {
        this.nombre_institucion = nombre_institucion;
        this.nombreTitulacion = nombreTitulacion;
        this.descripcion_edu = descripcion_edu;
        this.logoimg = logoimg;
        this.fecha_inicio = fecha_inicio;
        this.actualmente = actualmente;
        this.fecha_fin = fecha_fin;
    }
    

    // Setters y getters

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public String getNombreTitulacion() {
        return nombreTitulacion;
    }

    public void setNombreTitulacion(String nombre_titulacion) {
        this.nombreTitulacion = nombre_titulacion;
    }

    public String getDescripcion_edu() {
        return descripcion_edu;
    }

    public void setDescripcion_edu(String descripcion_edu) {
        this.descripcion_edu = descripcion_edu;
    }

    public String getLogoimg() {
        return logoimg;
    }

    public void setLogoimg(String logoimg) {
        this.logoimg = logoimg;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getActualmente() {
        return actualmente;
    }

    public void setActualmente(String actualmente) {
        this.actualmente = actualmente;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    
    
    
}
