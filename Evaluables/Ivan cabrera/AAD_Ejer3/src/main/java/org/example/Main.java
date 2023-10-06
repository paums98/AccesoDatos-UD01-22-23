package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        boolean salir = true;
        opcion = PedirOpcion(opcion);

        while(salir){

            if(opcion < 1 || opcion > 5){
                System.out.println("Tienes que poner una opción entre el 1 y el 3");
            }

            else if(opcion == 1){
                Insertar();
                opcion = PedirOpcion(opcion);
            }

            else if(opcion == 2){
                Modificar();
                opcion = PedirOpcion(opcion);
            }

            else if(opcion == 3){
                Borrar();
                opcion = PedirOpcion(opcion);
            }

            else if(opcion == 4){
                Visualizar();
                opcion = PedirOpcion(opcion);
            }

            else{
                salir = false;
            }
        }
    }

    static int PedirOpcion(int opcion){

        Scanner sc = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("** Mi videoClub \n\n 1. Insertar Película \n 2. Modificar Película \n 3. Eliminar Película \n 4. Visualizar Película \n 5. Salir \n\n Elige una opción: ");
        opcion = sc.nextInt();

        return(opcion);
    }

    static void Insertar() throws IOException {

        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

        try{
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");
            ficherodat.createNewFile();
            // Abre el archivo en modo "lectura/escritura"
            FileInputStream filein =
                    new FileInputStream(ficherodat);

            ObjectInputStream objectin =
                    new ObjectInputStream(filein);

            Pelicula pelicula = null;


            while(true){
                pelicula = (Pelicula) objectin.readObject();
                listaPeliculas.add(pelicula);

            }
        }catch (IOException error){

        }catch (Exception ex){

        }

        File ficherodat =
                new File("src/main/resources/peliculas.dat");

        // Abre el archivo en modo "append" para añadir contenido sin borrar lo existente
        FileOutputStream aleatorio =
                new FileOutputStream(ficherodat);

        ObjectOutputStream objectout =
                new ObjectOutputStream(aleatorio);

        System.out.println(" ");

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el título: ");
        String titulo = sc.nextLine();

        System.out.println("Introduzca los actores separados por coma y un espacio: ");
        String actores = sc.nextLine();
        String[] actoresArray = actores.split(", ");

        System.out.println("Introduzca los directores separados por coma y un espacio: ");
        String directores = sc.nextLine();
        String[] directoresArray = directores.split(", ");

        System.out.println("Introduzca la fecha de salida en formato 10-10-2023: ");
        String fechaTexto = sc.nextLine();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaTexto, formatoFecha);

        System.out.println("Introduzca el formato: ");
        String formato = sc.nextLine();

        Pelicula peli = new Pelicula(titulo, actoresArray, directoresArray, fecha, formato);

        listaPeliculas.add(peli);

        for(int i = 0; i < listaPeliculas.size(); i++){
            objectout.writeObject(listaPeliculas.get(i));
        }

        aleatorio.close();
    }

    static void Modificar() throws IOException {

        Scanner sc = new Scanner(System.in);

        boolean peliencontrada = false;
        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        Pelicula peliculaModificada;


        System.out.println("Introduzca el título de la película que desea modificar: ");
        String tituloBuscar = sc.nextLine();

        try{
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");

            // Abre el archivo en modo "lectura/escritura"
            FileInputStream filein =
                    new FileInputStream(ficherodat);

            ObjectInputStream objectin =
                    new ObjectInputStream(filein);

            Pelicula pelicula = null;

            while(true){
                pelicula = (Pelicula) objectin.readObject();
                String tit = pelicula.getTitulo();
                if(tit.equals(tituloBuscar)){
                    peliencontrada = true;
                }else{
                    listaPeliculas.add(pelicula);
                }
            }
        }catch (IOException error){

        }catch (Exception ex){

        }

        if(peliencontrada){
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");

            // Abre el archivo en modo "append" para añadir contenido sin borrar lo existente
            FileOutputStream aleatorio =
                    new FileOutputStream(ficherodat);

            ObjectOutputStream objectout =
                    new ObjectOutputStream(aleatorio);

            // Solicita los nuevos datos de la película
            System.out.println("Introduzca los nuevos actores separados por coma y un espacio: ");
            String nuevosActores = sc.nextLine();
            String[] nuevosActoresArray = nuevosActores.split(", ");

            System.out.println("Introduzca los nuevos directores separados por coma y un espacio: ");
            String nuevosDirectores = sc.nextLine();
            String[] nuevosDirectoresArray = nuevosDirectores.split(", ");

            System.out.println("Introduzca la nueva fecha de salida en formato 10-10-2023: ");
            String nuevaFechaTexto = sc.nextLine();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate nuevaFecha = LocalDate.parse(nuevaFechaTexto, formatoFecha);

            System.out.println("Introduzca el nuevo formato: ");
            String nuevoFormato = sc.nextLine();

            peliculaModificada = new Pelicula(tituloBuscar, nuevosActoresArray, nuevosDirectoresArray, nuevaFecha, nuevoFormato);
            listaPeliculas.add(peliculaModificada);

            for(int i = 0; i < listaPeliculas.size(); i++){
                objectout.writeObject(listaPeliculas.get(i));
            }

            aleatorio.close();
        }
    }

    static void Borrar() throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean peliencontrada = false;
        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        Pelicula peliculaModificada;


        System.out.println("Introduzca el título de la película que desea modificar: ");
        String tituloBuscar = sc.nextLine();

        try{
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");

            // Abre el archivo en modo "lectura/escritura"
            FileInputStream filein =
                    new FileInputStream(ficherodat);

            ObjectInputStream objectin =
                    new ObjectInputStream(filein);

            Pelicula pelicula = null;

            while(true){
                pelicula = (Pelicula) objectin.readObject();
                String tit = pelicula.getTitulo();
                if(tit.equals(tituloBuscar)){
                    peliencontrada = true;
                }else{
                    listaPeliculas.add(pelicula);
                }
            }
        }catch (IOException error){

        }catch (Exception ex){

        }

        if(peliencontrada){
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");

            // Abre el archivo en modo "append" para añadir contenido sin borrar lo existente
            FileOutputStream aleatorio =
                    new FileOutputStream(ficherodat);

            ObjectOutputStream objectout =
                    new ObjectOutputStream(aleatorio);

            for(int i = 0; i < listaPeliculas.size(); i++){
                objectout.writeObject(listaPeliculas.get(i));
            }

            aleatorio.close();
        }
    }

    static void Visualizar() throws IOException {

        Scanner sc = new Scanner(System.in);

        boolean peliencontrada = false;
        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        Pelicula peliculaModificada;

        try{
            File ficherodat =
                    new File("src/main/resources/peliculas.dat");

            // Abre el archivo en modo "lectura/escritura"
            FileInputStream filein =
                    new FileInputStream(ficherodat);

            ObjectInputStream objectin =
                    new ObjectInputStream(filein);

            Pelicula pelicula = null;

            while(true){
                pelicula = (Pelicula) objectin.readObject();
                System.out.println(pelicula.visualizar());
                listaPeliculas.add(pelicula);

            }
        }catch (IOException error){

        }catch (Exception ex){

        }
    }
}