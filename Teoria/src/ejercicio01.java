import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class ejercicio01 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        ArrayList<Integer> ultimosCuatro = new ArrayList<>();
        
        
        int contador = 0;
        
        List<Integer> secuenciaBuscada = Arrays.asList(4, 5, 6, 7);

        System.out.println("Introduce números. Introduce 0 para finalizar.");
        
        while (true) {
            try {
                System.out.print("> ");
                
                if (scanner.hasNextInt()) {
                    int numero = scanner.nextInt();
                    
                    if (numero == 0) {
                        break;
                    }
                    
                    ultimosCuatro.add(numero);
                    
            
                    if (ultimosCuatro.size() > 4) {
                        ultimosCuatro.remove(0); 
                    }
                    
                   
                    if (ultimosCuatro.size() == 4 && ultimosCuatro.equals(secuenciaBuscada)) {
                        contador++;
                       
                    }
                    
                } else {
                   
                    String entradaNoValida = scanner.next(); 
                    System.out.println("Entrada no válida ('" + entradaNoValida + "'). Por favor, introduce un número entero.");
                }
                
            } catch (Exception e) {
               
                System.out.println("Ocurrió un error inesperado.");
                scanner.nextLine(); 
            }
        }
        
        
        scanner.close();

        System.out.println("Resultado:");
        System.out.println("La secuencia '4, 5, 6, 7' se repitió: " + contador + " veces.");
    }
}