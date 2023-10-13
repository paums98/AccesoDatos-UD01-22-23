package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@XStreamAlias("persona")
public class Persona implements Serializable {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private double sueldoBruto;

    public Persona(){

    }

    public Persona(final String dni, final String nombre, final String apellido1, final String apellido2, final String fechaNacimiento, final double sueldoBruto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBruto= sueldoBruto;

    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(final String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(final String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(final String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(final String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldoBruto() {
        return this.sueldoBruto;
    }

    public void setSueldoBruto(final double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldoBruto=" + sueldoBruto +
                '}';
    }
}
