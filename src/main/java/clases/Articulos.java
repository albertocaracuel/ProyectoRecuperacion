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
    private String peso;
    private LocalDate fechaDeCreacion;

    public Articulos(String peso, LocalDate fechaDeCreacion, String referencia, String cantidad, String nombre, String precio) {
        super(referencia, cantidad, nombre, precio);
        this.peso = peso;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Articulos() {
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.peso);
        hash = 97 * hash + Objects.hashCode(this.fechaDeCreacion);
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
         String arti;
        arti=super.toString();
        return arti + "," + peso + "," + fechaDeCreacion ;
    }

    
  
    
}
