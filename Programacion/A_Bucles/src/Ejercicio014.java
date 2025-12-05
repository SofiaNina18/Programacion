/*
 * PROGRAMA QUE "PIENSE" UN NUMERO ALEATORIO ENTRE 1 Y 1000. (EN LA BASE DE PRUEBAS MOSTRARLO)
 * 
 *  EL USUARIO DEBE ADIVINAR EL NUMERO EN UN MAXIMO DE 10 INTENTOS.
 *  PARA ELLO EL PROGRAMA NOS IRA DIICIENDO SI ES MAYOR O MENOS. (RANGO DE VALORES ENTRE LOS QUE ESTA EL NUMERO)
 *  AL FINAL NOS DIRA SI HEMOS ACERDADO O SI SE NOS HA ACABADO LOS INTENTOS.
 *  
 *  EJEMPLO:
 *  	Ya he pensado el numero. Adivinalo:
 *  	Te queda 10 intentos. Introduce nº [1-1000]: 18
 *  	Te queda 9 intentos. Introduce nº [1-18]: 18
 *  	Te queda 8 intentos. Introduce nº [1-18]: 180
 *  	Te queda 7 intentos. Introduce nº [1-18]: 4
 *  	Felicidades era el numero 4
 *  	
 *  
 *  
 */
import java.util.Scanner;

public class Ejercicio014 {

	public static void main(String[] args) {
		
		// DECLARACION
		 int intentos = 10;
		 int min = 1;
		 int max = 1000;
		
		Scanner sc = new Scanner(System.in);
		
		// INICIALIZACION
		int numAdivinar = (int) (Math.random() * 1000+1); 
		
		int intentosRestantes = intentos;
		int intentoUsuario;
		boolean adivinado = false;
	
		System.out.println("Ya he pensado el numero. Adivinalo. ");
		
		
		
		// CUERPO DEL PROGRAMA
		while (intentosRestantes > 0 && !adivinado) {
			
			System.out.print("Te quedan " + intentosRestantes + " intentos. " + "Introduce nº [" + min + "-"+ max
					+ "]: ");
			
			
			intentoUsuario = sc.nextInt();
			sc.nextLine(); 
			
			
			if (intentoUsuario == numAdivinar) {
				adivinado = true;
			} else {
				intentosRestantes--; 
				
				
				if (intentoUsuario < numAdivinar) {
					System.out.println("El número es MAYOR que " + intentoUsuario + ".");
					if(intentoUsuario > min) {
						min = intentoUsuario;
					}
				} else { // intentoUsuario > numeroSecreto
					System.out.println("El número  es MENOR que " + intentoUsuario + ".");
					if (intentoUsuario < max) {
						max= intentoUsuario;
					}
				}
			}
		} 

		
		// RESULTADO
	
		if (adivinado) {
			int intentosUsados = intentos - intentosRestantes; 
			System.out.println("¡Felicidades! Era el número " + numAdivinar + ".");
			System.out.println("Lo adivinaste en " + intentosUsados + " intentos.");
		} else {
			System.out.println("¡Se te acabaron los intentos!");
			System.out.println("El número secreto era el " + numAdivinar + ".");
		}
		
	
	}
}