package luish.generadornumerospseudoaleatorios;

import java.util.Scanner;

/**
 * Generador de números pseudoaleatorios por diferentes algoritmos
 *
 * @author Luis H
 */
public class Generador {

    int contador = 10;

    public void algoritmoCuadradosMedios(int valor) {
        int semilla = valor;
        int cantidad = contador;
        for (int i = 0; i < cantidad; i++) {
            int y = semilla * semilla;
            String cadenaY = String.valueOf(y);
            if (String.valueOf(y).length() % 2 != 0) {
                cadenaY = "0" + cadenaY;
            }
            int digitosQuitar = (cadenaY.length() - String.valueOf(semilla).length()) / 2;
            int digitosFinal = cadenaY.length() - digitosQuitar;
            String nuevoY = cadenaY.substring(digitosQuitar, digitosFinal);
            semilla = Integer.parseInt(nuevoY);
            System.out.println("Y" + i + "-> " + cadenaY);
            System.out.println("X" + (i + 1) + "-> " + nuevoY);
            System.out.println("R" + (i + 1) + "-> " + "0." + nuevoY + "\n"
            );
        }
    }

    public void algoritmoProductosMedios(int valor) {
        int semilla1 = valor;
        int semilla2 = 5734;
        int cantidad = contador;
        for (int i = 0; i < cantidad; i++) {
            int y = semilla1 * semilla2;
            String cadenaY = String.valueOf(y);
            if (String.valueOf(y).length() % 2 != 0) {
                cadenaY = "0" + cadenaY;
            }
            int digitosQuitar = (cadenaY.length() - String.valueOf(semilla1).length()) / 2;
            int digitosFinal = cadenaY.length() - digitosQuitar;
            String nuevoY = cadenaY.substring(digitosQuitar, digitosFinal);
            semilla1 = semilla2;
            semilla2 = Integer.parseInt(nuevoY);
            System.out.println("Y" + i + "-> " + cadenaY);
            System.out.println("X" + (i + 2) + "-> " + nuevoY);
            System.out.println("R" + (i + 1) + "-> " + "0." + nuevoY + "\n");
        }
    }

    public void algoritmoMultiplicadorConstante(int valor) {
        int semilla = valor;
        int constante = 6965;
        int cantidad = contador;
        for (int i = 0; i < cantidad; i++) {
            int y = constante * semilla;
            String cadenaY = String.valueOf(y);
            if (String.valueOf(y).length() % 2 != 0) {
                cadenaY = "0" + cadenaY;
            }
            int digitosQuitar = (cadenaY.length() - String.valueOf(semilla).length()) / 2;
            int digitosFinal = cadenaY.length() - digitosQuitar;
            String nuevoY = cadenaY.substring(digitosQuitar, digitosFinal);
            semilla = Integer.parseInt(nuevoY);
            System.out.println("Y" + (i + 1) + "-> " + cadenaY);
            System.out.println("X" + (i + 1) + "-> " + nuevoY);
            System.out.println("R" + (i + 1) + "-> " + "0." + nuevoY + "\n");
        }
    }

    public void algoritmoLineal(int valor) {
        int semilla = valor;
        int consAdd = 19;
        int consMult = 33;
        int mod = 100;
        int cantidad = contador;
        for (int i = 0; i < cantidad; i++) {
            semilla = (consAdd * semilla + consMult) % mod;
            float r = (float) semilla / (mod - 1);
            System.out.println("X" + i + "-> " + semilla);
            System.out.println("R" + i + "->" + r + "\n");
        }
    }

    public void algoritmoCongruencialMultiplicativo(int valor) {
        int semilla = valor;
        int k = 2;
        int g = 5;
        int cantidad = contador;
        int mod = k;
        int a = 5 + 8 * k;
        for (int i = 1; i < g; i++) {
            mod = 2 * mod;
        }
        for (int i = 0; i < cantidad + 1; i++) {
            System.out.println("X" + i + "-> " + semilla);
            semilla = (a * semilla) % mod;
            float r = (float) semilla / (mod - 1);
            System.out.println("R" + (i + 1) + "->" + r + "\n");
        }
    }

    public void algoritmoCongruencialAditivo(int[] valores, int tamaño) {
        int semilla = valores[tamaño - 1];
        int mod = 100;
        int[] secuencia = new int[contador];
        int[] segundaMitad = new int[contador];
        for (int i = 0; i < valores.length; i++) {
            secuencia[i] = valores[i];
        }
        for (int i = 0; i < valores.length; i++) {
            semilla = (semilla + valores[i]) % mod;
            segundaMitad[i] = semilla;
        }
        for (int i = secuencia.length / 2; i < secuencia.length; i++) {
            secuencia[i] = segundaMitad[i - secuencia.length / 2];
        }
        semilla = valores[tamaño - 1];
        float r = 0;
        for (int i = 0; i < secuencia.length; i++) {
            semilla = (semilla + secuencia[i]) % mod;
            r = (float) semilla / (mod - 1);
            System.out.println("X" + (i + 1) + "-> " + semilla);
            System.out.println("R" + (i + 1) + "-> " + r + "\n");
        }

    }

    public void algoritmoCongruencialCuadratico(int valor) {
        int semilla = valor;
        int m = 8;
        int a = 26;
        int b = 27;
        int c = 27;
        int cantidad = contador;
        for (int i = 0; i < cantidad; i++) {
            semilla = (a * (semilla * semilla) + b * semilla + c) % m;
            System.out.println("X" + (i + 1) + "-> " + semilla);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Generador objGenera = new Generador();
        int valor1, tamanioSecuencia;
        boolean ciclo = true;
        int repetir = 1;

        while (ciclo && repetir == 1) {
            try {
                System.out.println("*** GENERADOR DE NÚMEROS PSEUDOALEATORIOS ***\n");
                System.out.println("* Defina el valor a usar en los algoritmos *");
                System.out.print("-> Ingrese un valor: ");
                valor1 = sc.nextInt();
                System.out.println("\n* Para el algoritmo Congruencial Aditivo necesita definir una secuencia de números *");
                System.out.print("-> Ingrese la cantidad de números de la secuencia: ");
                tamanioSecuencia = sc.nextInt();
                int[] secuenciaNumeros = new int[tamanioSecuencia];
                for (int i = 0; i < secuenciaNumeros.length; i++) {
                    System.out.print("-> Ingrese el valor " + (i + 1) + ": ");
                    secuenciaNumeros[i] = sc.nextInt();
                }

                System.out.println("*** Algoritmo Cuadrados Medios ***");
                objGenera.algoritmoCuadradosMedios(valor1);

                System.out.println("*** Algoritmo Productos Medios ***");
                objGenera.algoritmoProductosMedios(valor1);

                System.out.println("*** Algoritmo Multiplicador Constante ***");
                objGenera.algoritmoMultiplicadorConstante(9803);

                System.out.println("*** Algoritmo Lineal ***");
                objGenera.algoritmoLineal(valor1);

                System.out.println("*** Algoritmo Congruencial Aditivo ***");
                objGenera.algoritmoCongruencialAditivo(secuenciaNumeros, tamanioSecuencia);

                System.out.println("*** Algoritmo Congruencial Multiplicativo ***");
                objGenera.algoritmoCongruencialMultiplicativo(valor1);

                System.out.println("*** Algoritmo Congruencial Cuadratico ***");
                objGenera.algoritmoCongruencialCuadratico(valor1);

                System.out.println("");
                System.out.print("-> Pulse 1 y ENTER para repetir u otro número y ENTER para salir: ");
                repetir = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nError: ingrese un número entero\n");
                sc.nextLine();
            }
        }
    }
}
