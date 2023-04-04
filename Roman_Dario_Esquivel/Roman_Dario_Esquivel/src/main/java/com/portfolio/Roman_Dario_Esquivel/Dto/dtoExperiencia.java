package com.portfolio.Roman_Dario_Esquivel.Dto;


import jakarta.validation.constraints.NotBlank;


public class dtoExperiencia {
   
    @NotBlank
    private String Empresa;
    
    @NotBlank
    private String puesto;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String logo;
   
    @NotBlank
    private String fecha_inicio;
    
    private String actualmente;
    
    private String fecha_fin;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String Empresa, String puesto, String descripcion, String logo, String fecha_inicio, String actualmente, String fecha_fin) {
        this.Empresa = Empresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.logo = logo;
        this.fecha_inicio = fecha_inicio;
        this.actualmente = actualmente;
        this.fecha_fin = fecha_fin;
    }
    
    // setters and getters

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
