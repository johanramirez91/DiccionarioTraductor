package com.sofka.johanramirez;

import java.io.*;

public class Diccionario {

    private final String rutaArchivo = "src//main//resources//Diccionario.txt";
    private String registro = "";

    protected void agregarRegistro(String palabraEspanol, String palabraIngles) {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter escritura = new FileWriter(archivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritura);
            registro = registro + "" + palabraEspanol.toLowerCase() + " => " + palabraIngles.toLowerCase() + "\n";
            bufferEscritura.write(registro);
            bufferEscritura.close();
            System.out.println("Añadiste un nuevo registro al diccionario!");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo...");
        }

    }

    public void leerDiccionario() {
        try {
            FileReader lecturaArchivo = new FileReader(rutaArchivo);
            BufferedReader bufferLectura = new BufferedReader(lecturaArchivo);
            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }
            bufferLectura.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void obtenerPalabraEspanol(String palabraEspanol) {
        try {
            FileReader lectura = new FileReader(rutaArchivo);
            BufferedReader bufferLectura = new BufferedReader(lectura);
            String linea;
            int match;
            String palabraTraducida;
            String[] traduccion;
            while ((linea = bufferLectura.readLine()) != null) {
                traduccion = linea.split(" => ");
                palabraTraducida = traduccion[0];
                match = palabraTraducida.compareTo(palabraEspanol.toLowerCase());
                if (match == 0) {
                    System.out.println("La traducción de " + palabraEspanol + " es: " + traduccion[1]);
                    break;
                } else {
                    System.out.println("Intenta nuevamente");
                }
            }
        } catch (Exception e) {
            System.out.println("Intenta nuevamente");
        }
    }

    public void obtenerPalabraIngles(String palabraIngles) {
        try {
            FileReader lectura = new FileReader(rutaArchivo);
            BufferedReader bufferLectura = new BufferedReader(lectura);
            String linea;
            int match;
            String palabraTraducida;
            String[] traduccion;
            while ((linea = bufferLectura.readLine()) != null) {
                traduccion = linea.split(" => ");
                palabraTraducida = traduccion[1];
                match = palabraTraducida.compareTo(palabraIngles.toLowerCase());
                if (match == 0) {
                    System.out.println("La traducción de " + palabraIngles + " es: " + traduccion[0]);
                    break;
                } else {
                    System.out.println("Intenta nuevamente");
                }
            }
        } catch (Exception e) {
            System.out.println("Intenta nuevamente");
        }
    }

    public void cargaArchivo() {
        try {
            FileReader lectura = new FileReader(rutaArchivo);
            BufferedReader bufferLectura = new BufferedReader(lectura);
            String linea = "";
            while (linea != null) {
                linea = bufferLectura.readLine();
                if (linea == null) {
                    break;
                }
                registro = "" + registro + linea + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
