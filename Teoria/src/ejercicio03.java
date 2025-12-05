import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio03 {

    public static void main(String[] args) {
        String nombreFichero = "juegos.txt";
        
        // Variables para almacenar los resultados
        int precioTotal = 0;
        List<String> listaJuegos = new ArrayList<>();

        try {
            // 1. Inicializa el Scanner para leer el archivo
            File archivo = new File(nombreFichero);
            Scanner lector = new Scanner(archivo);
            
            // 2. Itera sobre cada línea del archivo
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                // Elimina espacios en blanco al principio y al final
                linea = linea.trim();

                // Solo procesa si la línea no está vacía
                if (!linea.isEmpty()) {
                    // Divide la línea por la coma seguida de un espacio (", ")
                    String[] partes = linea.split(", ");
                    
                    // Verifica que la línea tiene las dos partes esperadas (Nombre y Precio)
                    if (partes.length == 2) {
                        String nombreJuego = partes[0].trim();
                        String precioStr = partes[1].trim();

                        try {
                            // Intenta convertir el precio a entero
                            int precio = Integer.parseInt(precioStr);
                            
                            // Añade a las listas si la conversión es exitosa
                            listaJuegos.add(nombreJuego);
                            precioTotal += precio;

                        } catch (NumberFormatException e) {
                            // Maneja el error si el precio no es un número válido
                            System.out.println("⚠️ Error de formato de número: El precio '" + precioStr + 
                                               "' en la línea de '" + nombreJuego + "' no es un entero válido y se omitirá.");
                        }
                    } else {
                        // Maneja el error si la línea no tiene el formato "Nombre, Precio"
                        System.out.println("⚠️ Error de formato de línea: La línea '" + linea + 
                                           "' no tiene el formato esperado y se omitirá.");
                    }
                }
            }
            // Cierra el Scanner al terminar
            lector.close();

            // 3. Imprime la salida solicitada
            imprimirSalida(listaJuegos, precioTotal);

        } catch (FileNotFoundException e) {
            // Maneja el error si el archivo no se encuentra
            System.err.println("❌ Error: No se encontró el archivo '" + nombreFichero + 
                               "'. Asegúrate de que esté en la ruta correcta.");
        }
    }

    /**
     * Formatea e imprime los resultados en la consola.
     */
    private static void imprimirSalida(List<String> juegos, int total) {
        // Usa String.join para formatear la lista de juegos separada por ", "
        String listadoFormateado = String.join(", ", juegos);

        System.out.println("\n--- Salida por pantalla ---");
        System.out.println("LISTADO DE JUEGOS COMPRADOS:");
        System.out.println(listadoFormateado);
        System.out.println("\nPRECIO TOTAL: " + total + " €");
    }
}