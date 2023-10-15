package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula implements Serializable {
    String titulo;
    String[] actores;
    String[] directores;
    LocalDate fechaSalida;
    String formato;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }

    public String[] getDirectores() {
        return directores;
    }

    public void setDirectores(String[] directores) {
        this.directores = directores;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Pelicula(String titulo, String[] actores, String[] directores, LocalDate fechaSalida, String formato){
        this.titulo = titulo;
        this.actores = actores;
        this.directores = directores;
        this.fechaSalida = fechaSalida;
        this.formato = formato;
    }

    public String visualizar(){
        StringBuilder infoPelicula = new StringBuilder();

        infoPelicula.append("Título: ").append(titulo).append("\n");

        infoPelicula.append("Actores: ");
        for (String actor : actores) {
            infoPelicula.append(actor).append(", ");
        }
        // Eliminar la coma y el espacio final
        if (actores.length > 0) {
            infoPelicula.delete(infoPelicula.length() - 2, infoPelicula.length());
        }
        infoPelicula.append("\n");

        infoPelicula.append("Directores: ");
        for (String director : directores) {
            infoPelicula.append(director).append(", ");
        }
        // Eliminar la coma y el espacio final
        if (directores.length > 0) {
            infoPelicula.delete(infoPelicula.length() - 2, infoPelicula.length());
        }
        infoPelicula.append("\n");

        infoPelicula.append("Fecha de Salida: ").append(fechaSalida.toString()).append("\n");
        infoPelicula.append("Formato: ").append(formato).append("\n");

        return infoPelicula.toString();
    }

}

