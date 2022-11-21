package com.example.pmdmejercicioexamenedu02.modelos;

import java.io.Serializable;

public class ContactoMatricula implements Serializable {

    private String nombre;
    private String ciclo;
    private String telefono;

    public ContactoMatricula(String nombre, String ciclo, String telefono) {
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.telefono = telefono;
    }

    public ContactoMatricula() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ContactoMatricula{" +
                "nombre='" + nombre + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
