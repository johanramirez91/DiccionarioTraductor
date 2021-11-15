package com.sofka.johanramirez;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lecturaTecladoMenu = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        int opcion = 0;

        do {
            System.out.println("Bienvenido/a al diccionario traductor");
            System.out.println("Por favor, selecciona y digita el numero de la función que deseas realizar...");
            System.out.println("1. Registrar palabra y su traducción al ingles\n" +
                    "2. Consultar todo el diccionario\n" +
                    "3. Consultar un termino en ingles\n" +
                    "4. Consultar un termino en español\n" +
                    "5. Salir");

            try {
                opcion = lecturaTecladoMenu.nextInt();
            } catch (Exception ex) {
                System.out.println("Opción invalida, vuelve a intentar");
            }
            diccionario.cargaArchivo();
            switch (opcion) {
                case 1:
                    try {
                        Scanner lecturaTecladoOpcion = new Scanner(System.in);
                        System.out.println("Digite la palabra en español: ");
                        String palabraEnEspanol = lecturaTecladoOpcion.nextLine();
                        System.out.println("Ingresaste: " + palabraEnEspanol);
                        System.out.println("Digite la palabra en ingles: ");
                        String palabraEnIngles = lecturaTecladoOpcion.nextLine();
                        System.out.println("Ingresaste: " + palabraEnIngles);
                        diccionario.agregarRegistro(palabraEnEspanol, palabraEnIngles);
                    } catch (Exception e) {
                        System.out.println("Debes ingresar solo letras");
                    }
                    break;

                case 2:
                    diccionario.leerDiccionario();
                    break;

                case 3:
                    try {
                        Scanner lecturaTecladoOpcion = new Scanner(System.in);
                        System.out.println("Digite la palabra en español para obtener traducción: ");
                        String palabraBusqueda = lecturaTecladoOpcion.nextLine();
                        diccionario.obtenerPalabraEspanol(palabraBusqueda);
                    } catch (Exception e) {
                        System.out.println("Digite una palabra válida:");
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try {
                        Scanner lecturaTecladoOpcion = new Scanner(System.in);
                        System.out.println("Digite la palabra en ingles para obtener traducción: ");
                        String palabraBusqueda = lecturaTecladoOpcion.nextLine();
                        diccionario.obtenerPalabraIngles(palabraBusqueda);
                    } catch (Exception e) {
                        System.out.println("Digite una palabra válida:");
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Hasta pronto...");
                    break;

                default:
                    System.out.println("Debes digitar un numero entero entre 1 y 5");
            }
        } while (opcion != 5);
    }
}
