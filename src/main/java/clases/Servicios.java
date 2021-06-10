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
public class Servicios extends Producto{

    private double horas;
    private LocalDate fechaComienzo;
    private LocalDate fechaDeFin;

    public Servicios(double horas, LocalDate fechaComienzo, LocalDate fechaDeFin, String referencia, String cantidad, String nombre, String precio) {
        super(referencia, cantidad, nombre, precio);
        this.horas = horas;
        this.fechaComienzo = fechaComienzo;
        this.fechaDeFin = fechaDeFin;
    }

    Servicios() {
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public LocalDate getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDate fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public LocalDate getFechaDeFin() {
        return fechaDeFin;
    }

    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.horas) ^ (Double.doubleToLongBits(this.horas) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.fechaComienzo);
        hash = 53 * hash + Objects.hashCode(this.fechaDeFin);
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
        final Servicios other = (Servicios) obj;
        if (Double.doubleToLongBits(this.horas) != Double.doubleToLongBits(other.horas)) {
            return false;
        }
        if (!Objects.equals(this.fechaComienzo, other.fechaComienzo)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeFin, other.fechaDeFin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicios{" + "horas=" + horas + ", fechaComienzo=" + fechaComienzo + ", fechaDeFin=" + fechaDeFin + '}';
    }

   
}
