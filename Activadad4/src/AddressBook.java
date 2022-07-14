import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] arg) {

        // Realizamos la operacion para leer el archvio y para pasar los datos a un array mediante Hashmap
        HashMap<String, String> agenda = new HashMap<String, String>();
        String[] arrayadd;
        //Load
        String inputArchivo = "D:\\Documentos\\Escuela\\Taller_de_java\\Tarea_4\\Directorio.csv";

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputArchivo));


            String leer;
            while ((leer = bufferedReader.readLine()) != null) {
                //System.out.println(leer;
                arrayadd = leer.split(",");
                agenda.put(arrayadd[0], arrayadd[1]);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }   // Asignamos atributos
        int opcion = 0;
        String Numero;
        String Nombre;
        //Se muestra en pantalla la opcion al usuario a elegir
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce una opcion:");
        System.out.println("1 Mostrar contactos");
        System.out.println("2 Agregar Contacto");
        System.out.println("3 Salir");
        opcion = in.nextInt();

        // Se asigna la operaciom a realizar segun lo que elija el usuario con "if"
        if (opcion == 1) {
            for (Map.Entry<String, String> entry : agenda.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " : " + value);
            }
        } else if (opcion == 2) {

            // Agregamos un contacto

            Scanner on = new Scanner(System.in);
            System.out.println("2 introduce el nuemero ");
            Numero = on.nextLine();
            System.out.println("2 introduce el nuemero ");
            Nombre = on.nextLine();
            agenda.put(Numero,Nombre);
        } else {

            System.out.println("Adios");
        }
        //Guardamos los cambios "Save"
        String inputModificado = "D:\\Documentos\\Escuela\\Taller_de_java\\Tarea_4\\Directorio.csv";

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(inputModificado));

            String Line;
            for (Map.Entry<String, String> entry : agenda.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Line= key + "," + value;
                bufferedWriter.write(Line+ "\n");
            }
        } catch (IOException b) {
            System.out.println("Error al leer el archivo " + b.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }


    }
    }



