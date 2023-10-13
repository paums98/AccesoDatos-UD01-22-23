package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.time.LocalDate;

@XStreamAlias("falta")
public class Falta implements Serializable {

    private LocalDate fecha;
    private String razon;

    public Falta(){}

    public Falta(final LocalDate fecha, final String razon) {
        this.fecha = fecha;
        this.razon = razon;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(final LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return this.razon;
    }

    public void setRazon(final String razon) {
        this.razon = razon;
    }

    @Override
    public String toString() {
        return "Falta{" +
                "fecha=" + fecha +
                ", razon='" + razon + '\'' +
                '}';
    }
}
