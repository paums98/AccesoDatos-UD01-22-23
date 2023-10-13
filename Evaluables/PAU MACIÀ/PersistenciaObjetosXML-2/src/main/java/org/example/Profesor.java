package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.LocalDate;
import java.util.List;

@XStreamAlias("profesor")
public class Profesor extends Persona {
    private LocalDate fechaIncorporacion;
    private List<Historial> historial;
    private List<Falta> faltas;

    public Profesor(){

    }

    public Profesor(final LocalDate fechaIncorporacion, final List<Historial> historial, final List<Falta> faltas) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.faltas = faltas;
    }

    public LocalDate getFechaIncorporacion() {
        return this.fechaIncorporacion;
    }

    public void setFechaIncorporacion(final LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public List<Historial> getHistorial() {
        return this.historial;
    }

    public void setHistorial(final List<Historial> historial) {
        this.historial = historial;
    }

    public List<Falta> getFaltas() {
        return this.faltas;
    }

    public void setFaltas(final List<Falta> faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "fechaIncorporacion=" + fechaIncorporacion +
                ", historial=" + historial +
                ", faltas=" + faltas +
                '}';
    }
}
