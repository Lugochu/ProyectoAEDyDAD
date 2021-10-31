/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Lugo
 */
public class Utilidades {

// <editor-fold defaultstate="collapsed" desc="Funcion para mostrar texto y pedir strings">
    public static void mostrar(String mostrar) {
        System.out.println(mostrar);
    }

    public static String introducirstring(String texto) {
        String cadena;
        mostrar(texto);
        Scanner teclado = new Scanner(System.in);
        cadena = teclado.nextLine();
        return cadena;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Funciones con sobrecargas para validar enteros">

    public static int pedirValores(String texto) {
        int x;
        Scanner teclado = new Scanner(System.in);
        mostrar(texto);
        x = teclado.nextInt();
        return x;
    }

    public static int pedirValores(String texto, int Max) {
        int x;
        Scanner teclado = new Scanner(System.in);
        do {
            mostrar(texto);
            x = teclado.nextInt();
        } while (x > Max);
        return x;
    }

    public static int pedirValores(int Min, String texto) {
        int x;
        Scanner teclado = new Scanner(System.in);
        do {
            mostrar(texto);
            x = teclado.nextInt();
        } while (x < Min);
        return x;
    }

    public static int pedirValores(String texto, int Min, int Max) {
        int x;
        Scanner teclado = new Scanner(System.in);
        do {
            mostrar(texto);
            x = teclado.nextInt();
        } while (x < Min || x > Max);
        return x;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Funcion para devolver numeros primos">

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="fileToArray">

    public static String[] fileToArray(String filepath) {
        int numeroLineas = numeroLineas(filepath);
        String[] arrayArchivo = new String[numeroLineas];
        File fichero = new File(filepath);
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            for (int i = 0; i < numeroLineas; i++) {
                String linea = s.nextLine();
                arrayArchivo[i] = linea;
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return arrayArchivo;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="arrayToFile">
    static private Formatter output;

    public static boolean arrayToFile(String[] miarray, String filepath) {
        boolean boleano = false;
        Scanner s = null;
        try {
            File fichero = new File(filepath);
            s = new Scanner(fichero);
            output = new Formatter(fichero);
            for (int i = 0; i < miarray.length; i++) {
                output.format("%s\n", miarray[i]);
            }

            if (output != null) {
                output.close();
            }
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return boleano;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="NumeroDeLineas">
    public static int numeroLineas(String filepath) {
        int lineas = 0;
        File fichero = new File(filepath);
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                lineas++;
            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return lineas;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="leerFichero">
    public static void leerFichero(String filepath) {
        Scanner s = null;
        try {
            File fichero = new File(filepath);
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);
            while (s.hasNextLine()) {
                String linea = s.nextLine(); 	// Guardamos la linea en un String
                System.out.println(linea);		// Imprimimos la linea
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }

// </editor-fold>

}
