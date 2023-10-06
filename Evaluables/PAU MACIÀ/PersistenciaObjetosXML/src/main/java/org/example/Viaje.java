package org.example;

import java.time.LocalDate;
import java.util.List;

public class Viaje {
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private List<Etapa> etapas;
    private Lugar salida;

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
