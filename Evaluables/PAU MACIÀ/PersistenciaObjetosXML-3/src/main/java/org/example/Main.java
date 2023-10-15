package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }

    public static void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("1. Convertir XML a DAT.");
            System.out.println("2. Convertir DAT a XML");
            System.out.println("3. Mostrar XML");
            System.out.println("4. Mostrar DAT");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.println("Selecciona una opción: ");

            opcion = sc.nextInt();

            switch (opcion){
                case 1: leerXML();

                    break;
                case 2: leerBinario();

                    break;
                case 3: mostrarXML();
                    break;
                case 4: mostrarDAT();
                    break;
                case 5:
                    System.out.println("Finalizando programa...");
            }
        }while (opcion!=5);

    }

    private static void mostrarDAT() {
        Scanner sc = new Scanner(System.in);
        String fichero;
        System.out.println("Introduce el nombre del fichero sin la extensión: ");
        fichero = sc.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero + ".dat"))) {
            ListaInstitutos lista = (ListaInstitutos) ois.readObject();
            System.out.println("Contenido del archivo " + fichero + ".dat:");
            for (Instituto instituto : lista.getLista()) {
                System.out.println(instituto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarXML() {
        Scanner sc = new Scanner(System.in);
        String fichero;
        System.out.println("Introduce el nombre del fichero sin la extensión: ");
        fichero = sc.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichero + ".xml"));
            String linea;
            System.out.println("Contenido del archivo " + fichero + ".xml:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void leerBinario() {
        Scanner sc = new Scanner(System.in);
        String fichero;

        System.out.println("Introduce el nombre del fichero sin la extensión: ");
        fichero = sc.nextLine();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero + ".dat"))){

            ListaInstitutos lista = (ListaInstitutos) ois.readObject();
            escribirXML(lista, fichero);

        }catch (IOException ex){
            System.out.println("Problema de entrada y salida.");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }



    }

    public static void escribirXML(ListaInstitutos lista, String fichero) throws IOException {
        File ficheroXML = new File(fichero+".xml");
        if (!ficheroXML.exists()){
            ficheroXML.createNewFile();
        }
        XStream xstream = new XStream();

        xstream.processAnnotations(Instituto.class);
        xstream.processAnnotations(ListaInstitutos.class);
        xstream.processAnnotations(Persona.class);
        xstream.processAnnotations(Historial.class);
        xstream.processAnnotations(Profesor.class);
        xstream.processAnnotations(Administrativo.class);
        xstream.processAnnotations(Falta.class);


        xstream.toXML(lista, new FileOutputStream(ficheroXML));
        System.out.println("Conversión realizada con éxito.");
    }

    public static void leerXML() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String fichero;

        System.out.println("Introduce el nombre del fichero sin la extensión: ");
        fichero = sc.nextLine();
        XStream xstream = new XStream();

        try{
            xstream.processAnnotations(Instituto.class);
            xstream.processAnnotations(ListaInstitutos.class);
            xstream.processAnnotations(Persona.class);
            xstream.processAnnotations(Historial.class);
            xstream.processAnnotations(Profesor.class);
            xstream.processAnnotations(Administrativo.class);
            xstream.processAnnotations(Falta.class);

            xstream.addImplicitCollection(ListaInstitutos.class,"lista");
            xstream.allowTypes(new Class[]{
                    org.example.Instituto.class,
                    org.example.ListaInstitutos.class,
                    org.example.Persona.class,
                    org.example.Historial.class,
                    org.example.Profesor.class,
                    org.example.Administrativo.class,
                    org.example.Falta.class
            });
            ListaInstitutos lista = (ListaInstitutos) xstream.fromXML(new FileInputStream(fichero+".xml"));
            escribirBinario(lista, fichero);
        }catch (IOException ex){
            System.out.println("Archivo no encontrado. ");
        }



    }
    public static void escribirBinario(ListaInstitutos lista, String fichero) throws IOException {
        File ficheroDAT = new File(fichero+".dat");
        if (!ficheroDAT.exists()){
            ficheroDAT.createNewFile();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+".dat"))){
            oos.writeObject(lista);
        }catch (IOException e){
            e.getMessage();
        }
        System.out.println("Conversión realizada con éxito.");
    }

}