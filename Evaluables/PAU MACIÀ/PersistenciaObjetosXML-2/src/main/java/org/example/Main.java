package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;

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