package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("instituto")
public class Instituto implements Serializable {

    private String nombre;
    @XStreamImplicit(itemFieldName = "persona")
    private List<Persona> personas;

    public Instituto() {

    }

    public Instituto(final String nombre, final List<Persona> personas) {
        this.nombre = nombre;
        this.personas = personas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(final List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", personas=" + personas +
                '}';
    }
}
