package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.LocalDate;

@XStreamAlias("administrativo")
public class Administrativo extends Persona{

    private int tiempoContrato;

    public Administrativo(){}

    public Administrativo(final int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public Administrativo(final String dni, final String nombre, final String apellido1, final String apellido2, final String fechaNacimiento, final double sueldoBruto, final int tiempoContrato) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.tiempoContrato = tiempoContrato;
    }

    public int getTiempoContrato() {
        return this.tiempoContrato;
    }

    public void setTiempoContrato(final int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "tiempoContrato=" + tiempoContrato +
                '}';
    }
}
