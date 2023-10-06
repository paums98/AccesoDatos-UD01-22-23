package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@XStreamAlias("viaje")
public class Viaje implements Serializable {
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    @XStreamImplicit(itemFieldName = "etapas")
    private List<Etapa> etapas;
    private Lugar salida;

    private static final long serialVersionUID = 8860155335702972022L;

    public Viaje(){

    }

    public Viaje(LocalDate fechaSalida, LocalDate fechaLlegada, List<Etapa> etapas, Lugar salida) {
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.etapas = etapas;
        this.salida = salida;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public Lugar getSalida() {
        return salida;
    }

    public void setSalida(Lugar salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "fechaSalida=" + fechaSalida +
                ", fechaLlegada=" + fechaLlegada +
                ", etapas=" + etapas +
                ", salida=" + salida +
                '}';
    }
}
