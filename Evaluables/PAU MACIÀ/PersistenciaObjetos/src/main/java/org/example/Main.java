package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;


public class Main {
    //Array estático para almacenar las películas
    static List<Pelicula> pelisFichero = new ArrayList<>();
    //
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int eleccion = 0;
        Pelicula pelicula;
        establecerLista();

        System.out.println("Mi videoclub");
        System.out.println("------------");
        do {
            /* USABA ESTE FOR PARA COMPROBAR QUE SE INTRODUJESEN TODOS LOS DATOS NUEVOS AL ARRAY ESTÁTICO
            for(Pelicula p : pelisFichero){
                System.out.println("ARRAY");
                System.out.println(p);
            }*/
            //MENÚ
            System.out.println("");
            System.out.println("Menú: ");
            System.out.println("1. Insertar Película");
            System.out.println("2. Modificar Película");
            System.out.println("3. Eliminar Película");
            System.out.println("4. Visualizar Película");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.println("Escoja una opción: ");
            eleccion = sc.nextInt();
            sc.nextLine();
            switch (eleccion) {
                case 1:
                    pelicula = leerDatos();
                    InsertarObjeto(pelicula);
                    break;
                case 2:
                    modificarPelicula();
                    break;
                case 3:
                    eliminarPelicula();
                    break;
                case 4:
                    leerPeliculasFichero();


                    break;
                case 5:
                    System.out.println("Finalizando el programa...");
                    break;
            }
        } while (eleccion != 5);


    }

    //Método para eliminar película, elimina y vuelve a introducir los objetos menos el que le indiquemos
    public static void eliminarPelicula() {

        String titulo;
        pelisFichero.clear();
        System.out.println("Indica el título de la película a eliminar");
        titulo = sc.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/peliculas.dat"))) {

            while (true) {
                try {
                    Pelicula pelicula = (Pelicula) ois.readObject();
                    if (!pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                        pelisFichero.add(pelicula);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (IOException ioException) {
            System.out.println("Error al leer el archivo de películas: " + ioException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error al deserializar la película: " + classNotFoundException.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/peliculas.dat"))) {
            for (Pelicula peli : pelisFichero) {
                oos.writeObject(peli);
            }
        } catch (IOException ioException) {
            System.out.println("Error al escribir en el archivo de películas: " + ioException.getMessage());
        }
        System.out.println();
        System.out.println("Película "+titulo +" eliminada exitosamente.");
    }

    //Método para modificar, extraemos y añadimos de nuevo con el formato cambiado
    public static void modificarPelicula() {
        pelisFichero.clear();
        String titulo, nuevoFormato;
        System.out.println("Indica el título de la película a modificar: ");
        titulo = sc.nextLine();
        System.out.println("Indica el nuevo formato para esta película: ");
        nuevoFormato = sc.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/peliculas.dat"))) {

            while (true) {
                try {
                    Pelicula pelicula = (Pelicula) ois.readObject();
                    if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                        pelicula.setFormato(nuevoFormato);
                    }
                    pelisFichero.add(pelicula);
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (IOException ioException) {
            System.out.println("Error al leer el archivo de películas: " + ioException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error al deserializar la película: " + classNotFoundException.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/peliculas.dat"))) {
            for (Pelicula peli : pelisFichero) {
                oos.writeObject(peli);
            }
        } catch (IOException ioException) {
            System.out.println("Error al escribir en el archivo de películas: " + ioException.getMessage());
        }

        System.out.println("Formato modificado exitosamente.");

    }

    //Método para que el usuario introduzca los datos, devuelve el objeto ya construído
    public static Pelicula leerDatos() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Pelicula pelicula;
        String titulo;
        String formato;
        List<String> actores;
        List<String> directores;
        LocalDate fechaSalida;

        System.out.println("Introduce el titulo: ");
        titulo = sc.nextLine();
        System.out.println("Introduce los actores entre punto y coma: ");
        actores = Arrays.asList(sc.nextLine().split(";"));
        System.out.println("Introduce los directores entre punto y coma: ");
        directores = Arrays.asList(sc.nextLine().split(";"));
        System.out.println("Introduce la fecha de salida: ");
        fechaSalida = LocalDate.parse(sc.nextLine(), formater);
        System.out.println("Introduce el formato: ");
        formato = sc.nextLine();

        pelicula = new Pelicula(titulo, actores, directores, fechaSalida, formato);
        return pelicula;
    }

    //Inserta el objeto que le pasamos al fichero y a la lista
    public static void InsertarObjeto(Pelicula pelicula) {
        try {
            File archivo = new File("src/main/resources/peliculas.dat");

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            pelisFichero.add(pelicula);

            for (Pelicula peli:pelisFichero) {
                oos.writeObject(peli);
            }
            oos.close();
        } catch (IOException io) {
            System.out.println("Error al leer el archivo de películas: " + io.getMessage());
        } catch (Exception e) {
            System.out.println("Hubo algún problema.");
        }
    }

    //Lee el objeto que le indiquemos
    public static void leerPeliculasFichero() {
        String titulo;
        System.out.println("Indica el título de la película a visualizar");
        titulo = sc.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/peliculas.dat"))) {
            boolean encontrado = false;
            while (true) {
                try {
                    Pelicula pelicula = (Pelicula) ois.readObject();
                    if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                        System.out.println(pelicula);
                        encontrado = true;
                    }
                } catch (EOFException eof) {
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Película no encontrada.");
            }
        } catch (IOException io) {
            System.out.println("Error al leer el archivo de películas: " + io.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error al deserializar la película: " + classNotFoundException.getMessage());
        }
    }

    //Inicializa la lista con los objetos del fichero, método indispensable
    public static void establecerLista(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/peliculas.dat"))){
            while (true) {
                try{
                    Pelicula pelicula = (Pelicula) ois.readObject();
                    pelisFichero.add(pelicula);
                }catch (EOFException eof){
                    break;
                }
            }
        }catch (IOException io){
            System.out.println("Error al leer el archivo de películas: " + io.getMessage());
        }catch (ClassNotFoundException classNotFoundException){
            System.out.println("Error al deserializar la película: " + classNotFoundException.getMessage());
        }
    }
}