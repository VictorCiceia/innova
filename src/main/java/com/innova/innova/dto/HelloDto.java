package com.innova.innova.dto;

import java.util.Date;

public class HelloDto {

    private String nombre;

    private Date fecha;

    public HelloDto(String nombre) {
        this.nombre = "Hola " + nombre;
        this.fecha = new Date();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
