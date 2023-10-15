package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.time.LocalDate;
import java.util.List;

@XStreamAlias("profesor")
public class Profesor extends Persona {
    private String fechaIncorporacion;
    @XStreamImplicit(itemFieldName = "historial")
    private List<Historial> historial;
    @XStreamImplicit(itemFieldName = "falta")
    private List<Falta> faltas;

    public Profesor(){

    }

    public Profesor(final String fechaIncorporacion, final List<Historial> historial, final List<Falta> faltas) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.faltas = faltas;
    }

    public String getFechaIncorporacion() {
        return this.fechaIncorporacion;
    }

    public void setFechaIncorporacion(final String fechaIncorporacion) {
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
