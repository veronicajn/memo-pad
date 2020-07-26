package library;

import java.io.*;
import java.util.logging.*;

public class Archivo {

//Crear archivos
    public static void Crear(String ruta, String nArch) {
        File camino = new File(ruta);

        File archivo = new File(ruta + "\\" + nArch);
        try {
            camino.mkdirs();
            archivo.createNewFile();

        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear el archivo");
        }
    }

    //Leer archivos
    public static String Leer(String ruta) {
        File archivo = new File(ruta);

        String respuesta = "";

        if (!archivo.exists()) {
            System.out.println("El archivo " + archivo + " no existe");
        } else {
            try {
                try (BufferedReader dw = new BufferedReader(new FileReader(archivo))) {

                    while (dw.ready()) {
                        respuesta = respuesta + dw.readLine() + "\n";
                    }
                    dw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);

                System.out.println("Error al leer el fichero");
            }
        }

        return respuesta;
    }

    public static String Leer(File archivo) {

        String respuesta = "";

        if (!archivo.exists()) {
            System.out.println("El archivo " + archivo + " no existe");
        } else {
            try {
                try (BufferedReader dw = new BufferedReader(new FileReader(archivo))) {

                    while (dw.ready()) {
                        respuesta = respuesta + dw.readLine() + "\n";
                    }
                    dw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);

                System.out.println("Error al leer el fichero");
            }
        }

        return respuesta;
    }

    //ACUERDATE DE QUE NECESITAS IMPLEMENTAR SERIALIZABLE EN EL OBJETO QUE LE PASES.
    //Crear o editar ficheros para meter objetos dentro
    public static void EditarObj(String ruta, Object contenido) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(contenido);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }

//Leer ficheros con objetos dentro
    public static Object LeerObj(String fichero) {
        Object obj = null;
        try {

            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la lectura del objeto");
        }
        return obj;

    }

//Editar ficheros
    public static void Editar(String ruta, String contenido) {
        File archivo = new File(ruta);
        try {
            BufferedWriter bw;
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo, true));
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
            }
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero");
        }
    }


//Editar ficheros
    public static void Editar(File archivo, String contenido) {
       
        try {
            BufferedWriter bw;
            //if (archivo.exists()) {
              //  bw = new BufferedWriter(new FileWriter(archivo, true));
            //} else {
                bw = new BufferedWriter(new FileWriter(archivo));
           // }
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero");
        }
    }

}

