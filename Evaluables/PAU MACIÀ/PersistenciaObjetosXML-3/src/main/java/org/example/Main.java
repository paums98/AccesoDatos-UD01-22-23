package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ListaInstitutos lista = leerXML();
        for (Instituto insti:
             lista.getLista()) {
            System.out.println(insti);
        }
        escribirBinario(lista);

    }

    public static void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("1. Convertir XML a DAT.");
        System.out.println("2. Convertir DAT a XML");
        System.out.println("3. Mostrar XML");
        System.out.println("4. Mostrar DAT");
        System.out.println("5. Salir");

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

    }

    private static void mostrarDAT() {
    }

    private static void mostrarXML() {
    }

    private static void leerBinario() {
    }

    public static ListaInstitutos leerXML() throws FileNotFoundException {
        XStream xstream = new XStream();

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
        ListaInstitutos lista = (ListaInstitutos) xstream.fromXML(new FileInputStream("instituto.xml"));
        return lista;

    }
    public static void escribirBinario(ListaInstitutos lista){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("institutos.dat"))){
            oos.writeObject(lista);
        }catch (IOException e){
            e.getMessage();
        }
    }
}