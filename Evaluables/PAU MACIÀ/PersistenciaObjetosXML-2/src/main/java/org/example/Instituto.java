package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("instituto")
public class Instituto implements Serializable {

    private String nombre;
    private Persona persona;

    public Instituto() {

    }

    public Instituto(final String nombre, final Persona persona) {
        this.nombre = nombre;
        this.persona = persona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(final Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", persona=" + persona +
                '}';
    }
}
