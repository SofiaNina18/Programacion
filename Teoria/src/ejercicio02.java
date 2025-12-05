import java.util.Random;
import java.util.Arrays;

public class ejercicio02 {

    // --- 1. Función Principal: Encontrar Máximo y Frecuencia ---
    // Recibe un array (int[]), devuelve un array con [máximo, frecuencia]
    public static int[] encontrarMaximoYFrecuencia(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{0, 0}; // Retorna [0, 0] para array vacío o nulo
        }

        // 1. Encontrar el número más alto
        int maximo = arr[0];
        for (int num : arr) {
            if (num > maximo) {
                maximo = num;
            }
        }

        // 2. Contar la frecuencia de ese número más alto
        int frecuencia = 0;
        for (int num : arr) {
            if (num == maximo) {
                frecuencia++;
            }
        }

        return new int[]{maximo, frecuencia}; // Devuelve el resultado como un array [max, freq]
    }

    // --- 2. Función auxiliar: Llenar array aleatorio entre 10 y 20 ---
    public static int[] llenarArrayAleatorio10_20(int tamano) {
        Random rand = new Random();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            // nextInt(11) genera números de 0 a 10. Al sumar 10, va de 10 a 20.
            arr[i] = rand.nextInt(11) + 10; 
        }
        return arr;
    }

    // --- 3. Función auxiliar: Mostrar array por línea ---
    public static void mostrarArrayPorLinea(int[] arr) {
        if (arr == null) {
            System.out.println("El array es nulo.");
            return;
        }
        for (int elemento : arr) {
            System.out.println(elemento);
        }
    }

    // --- 4. Programa Principal (main) ---
    public static void main(String[] args) {
        final int TAMANO = 40;
        Random rand = new Random();

        // A. Llenar un array de 40 números enteros aleatorios entre -10 y 10
        int[] arrayNumeros = new int[TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            // nextInt(21) genera números de 0 a 20. Al restar 10, va de -10 a 10.
            arrayNumeros[i] = rand.nextInt(21) - 10; 
        }

        System.out.println("--- 📋 Array Generado ---");
        System.out.println("El array contiene 40 números aleatorios entre -10 y 10:");
        // Para mostrar el array en una sola línea (más legible que por línea para 40 elementos)
        System.out.println(Arrays.toString(arrayNumeros)); 

        // B. Utilizar la función principal para obtener el resultado
        int[] resultado = encontrarMaximoYFrecuencia(arrayNumeros);
        int maximo = resultado[0];
        int frecuencia = resultado[1];

        // C. Mostrar el mensaje por pantalla
        System.out.println("\n--- 🔍 Análisis del Array ---");
        System.out.println("El **número más alto** del array es: **" + maximo + "**");
        System.out.println("Se repite **" + frecuencia + "** veces.");
    }}