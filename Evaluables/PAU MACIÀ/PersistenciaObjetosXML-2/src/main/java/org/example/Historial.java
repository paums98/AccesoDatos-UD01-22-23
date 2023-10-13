package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;
@XStreamAlias("historial")
public class Historial implements Serializable {
    private String nombreInstituto;
    private int anyoAcademico;
    private List<String> asignaturas;

    public Historial(){}

    public Historial(final String nombreInstituto, final int anyoAcademico, final List<String> asignaturas) {
        this.nombreInstituto = nombreInstituto;
        this.anyoAcademico = anyoAcademico;
        this.asignaturas = asignaturas;
    }

    public String getNombreInstituto() {
        return this.nombreInstituto;
    }

    public void setNombreInstituto(final String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public int getAnyoAcademico() {
        return this.anyoAcademico;
    }

    public void setAnyoAcademico(final int anyoAcademico) {
        this.anyoAcademico = anyoAcademico;
    }

    public List<String> getAsignaturas() {
        return this.asignaturas;
    }

    public void setAsignaturas(final List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "nombreInstituto='" + nombreInstituto + '\'' +
                ", anyoAcademico=" + anyoAcademico +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
