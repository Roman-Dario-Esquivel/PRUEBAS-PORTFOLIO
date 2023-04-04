package com.portfolio.Roman_Dario_Esquivel.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;


@Entity

public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreTitulacion;
    @NotNull
    private String institucion;
    @NotNull
    private String descripcion_edu;
    private String logoimg;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int actualmente;
    //constructores

    public Educacion() {
    }

    public Educacion(String nombre_titulacion, String institucion, String descripcion_edu, String logoimg, Date fecha_inicio, Date fecha_fin, int actualmente) {
        this.nombreTitulacion = nombre_titulacion;
        this.institucion = institucion;
        this.descripcion_edu = descripcion_edu;
        this.logoimg = logoimg;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.actualmente = actualmente;
    }

    //setters and  getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getActualmente() {
        return actualmente;
    }

    public void setActualmente(int actualmente) {
        this.actualmente = actualmente;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

}
