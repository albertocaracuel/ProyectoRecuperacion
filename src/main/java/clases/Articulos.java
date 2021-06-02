/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author alberto
 */
public class Articulos extends Producto{
    private String nombre;
    private String peso;
    private LocalDate fechaDeCreacion;

    public Articulos(String nombre, String peso, LocalDate fechaDeCreacion, String referencia, String cantidad) {
        super(referencia, cantidad);
        this.nombre = nombre;
        this.peso = peso;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.peso);
        hash = 17 * hash + Objects.hashCode(this.fechaDeCreacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulos other = (Articulos) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeCreacion, other.fechaDeCreacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulos{" + "nombre=" + nombre + ", peso=" + peso + ", fechaDeCreacion=" + fechaDeCreacion + '}';
    }
    
    
}
