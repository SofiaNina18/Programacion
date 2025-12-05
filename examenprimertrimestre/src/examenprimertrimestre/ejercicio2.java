package examenprimertrimestre;

import java.util.Random;

public class ejercicio2 {

    public static void llenarArray(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(21) - 10; 
        }
    }

    public static void mostrarArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0)   
                System.out.println();
        }
    }

    public static int numeroalto(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }

        int contador = 0;
        for (int n : arr) {
            if (n == max) contador++;
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] arr = new int[40];

        llenarArray(arr);

        System.out.println("Array generado:");
        mostrarArray(arr);

        int veces = numeroalto(arr);
        System.out.println("El número más alto aparece " + veces + " veces.");
    }
}