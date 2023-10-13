package org.example;



import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Al principio funcionaba, aunque poniendo las etapas como null, al tratar de corregirlo da error
        List<Viaje> viajes = new ArrayList<>();

        leerFichero(viajes);

        crearXML(viajes);

    }

    public static void leerFichero(List<Viaje> viajes){
        try{
            FileInputStream fileInputStream = new FileInputStream("viajes.dat");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);

                try{
                    while (true){
                        Viaje viaje = (Viaje) ois.readObject();
                        viajes.add(viaje);
                        System.out.println(viaje);
                    }
                }catch (EOFException eof){

                }


        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void crearXML(List<Viaje> viajes) throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(Viaje.class);
        xStream.processAnnotations(Lugar.class);
        xStream.processAnnotations(Hotel.class);
        xStream.processAnnotations(Etapa.class);



        xStream.toXML(viajes, new FileOutputStream("src/main/resources/viajes.xml"));
    }
}