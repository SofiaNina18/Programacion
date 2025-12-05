		
/*
 * PROGRAMA QUE PIDA POR TECLADO LA BASE Y EL EXPONENTE Y, MEDIANTE UNA LLAMADA A LA FUNCION POTENCIA,
 * CALCULE LA POTENCIA DEL PRIMERO ELEVADO AL SEGUNDO.
 * Ejemplo:
 * 2^3= 2 x 2 x 2 = 8
 * 3^5= 3 x 3 x 3 x 3 x 3 = 243
 */
import java.util.Scanner;
public class Ejercicio0003 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 int base, exponente;
		 
		 
		 System.out.print("Introduce la base (número entero): ");
		 base = sc.nextInt();
	        
	        
        System.out.print("Introduce el exponente (número entero): ");
        exponente = sc.nextInt();
        
        double resultado = potencia(base, exponente);
        
        
        System.out.println("El resultado de " + base + " elevado a " + exponente + " es: " + resultado);
	}
	public static double potencia (int base, int exponente){
		if (exponente == 0) {
			return 1;
		}
		double resultado = 1;
		
	/*
	 * HAZ UNA FUNCION QUYE RECIBA COMO PARAMETROS DOS NUMEROS ENTEROS Y DEVULVA EL RESULTADO DE
	 * LA POTENCIA DEL PRIMERO ELEVADO AL SEGUNDO (no vale utilizar la funcion pow)
	 */
	
		if (exponente > 0) {
         
			for (int i = 0; i < exponente; i++) {
				resultado *= base; 
			}
		} 
        
        else { 
            
            for (int i = exponente; i < 0; i++) {
                resultado *= base;
            }
           
            resultado = 1 / resultado;
        }
		
		return resultado;
	}
}