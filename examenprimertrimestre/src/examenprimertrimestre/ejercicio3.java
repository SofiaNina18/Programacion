package examenprimertrimestre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio3 {

    private static int precioTotal = 0; 
    
    public static void main(String[] args) {
        String nombreFichero = "juegos.txt";
        String[] listaJuegos = leerYCalcular(nombreFichero);
        if (listaJuegos == null) {  
            return;
        }
        Salida(listaJuegos, precioTotal);
    }
    private static String[] leerYCalcular(String nombreFichero) {
        int contadorJuegos = 0;
        
        try (Scanner lector = new Scanner(new File(nombreFichero))) {
            while (lector.hasNextLine()) {
                if (valido(lector.nextLine())) {
                    contadorJuegos++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo" + nombreFichero);
            return null; 
        }

        if (contadorJuegos == 0) return new String[0];
       
        String[] listaJuegos = new String[contadorJuegos];
        precioTotal = 0; 
        int indice = 0;
        
        try (Scanner lector = new Scanner(new File(nombreFichero))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();

                if (indice < contadorJuegos && !linea.isEmpty()) {
                    String[] partes = linea.split(", ");
                    
                    if (partes.length == 2) {
                        try {
                            //para validar el precio
                            int precio = Integer.parseInt(partes[1].trim());
                            
                            listaJuegos[indice] = partes[0].trim();
                            precioTotal += precio;
                            indice++;
                        } catch (NumberFormatException e) {
                           
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
        }
        return listaJuegos;
    }
    private static boolean valido(String linea) {
        linea = linea.trim();
        if (linea.isEmpty()) return false;
        
        String[] partes = linea.split(", ");
        
        if (partes.length == 2) {
            try {
                Integer.parseInt(partes[1].trim());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private static void Salida(String[] juegos, int total) {
 
        String listadoFormateado = String.join(", ", juegos);
       
        System.out.println("LISTADO DE JUEGOS COMPRADOS:");
        System.out.println(listadoFormateado);
        System.out.println("PRECIO TOTAL: " + total + " €");
    }
}