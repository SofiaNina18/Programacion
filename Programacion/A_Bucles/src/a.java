
import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		
		// 1. Configuración e Inicialización
		final int MAX_INTENTOS = 10;
		final int MIN_VALOR = 1;
		final int MAX_VALOR = 1000;
		
		Scanner scanner = new Scanner(System.in);
		
		// GENERACIÓN DEL NÚMERO SECRETO SIN java.util.Random
		// Fórmula: (int) (Math.random() * (MAX_VALOR - MIN_VALOR + 1)) + MIN_VALOR
		int numeroSecreto = (int) (Math.random() * (MAX_VALOR - MIN_VALOR + 1)) + MIN_VALOR; 
		
		int intentosRestantes = MAX_INTENTOS;
		int intentoUsuario;
		boolean adivinado = false;
		
		// --- PRUEBAS: Mostrar el número secreto (Opcional, para testing) ---
		// System.out.println("DEBUG: El número secreto es: " + numeroSecreto); 
		// -------------------------------------------------------------------
		
		System.out.println("¡Adivina el número entre " + MIN_VALOR + " y " + MAX_VALOR + "!");
		
		
		// 2. Bucle Principal del Juego
		while (intentosRestantes > 0 && !adivinado) {
			
			System.out.println("\nTe quedan " + intentosRestantes + " intentos.");
			System.out.print("Introduce tu número: ");
			
			// Validar si la entrada es un número
			if (!scanner.hasNextInt()) {
				System.out.println("Entrada inválida. Introduce un número entero.");
				scanner.next(); // Consumir la entrada no válida
				continue;
			}
			
			intentoUsuario = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea
			
			// 3. Comprobar el intento
			if (intentoUsuario == numeroSecreto) {
				adivinado = true;
			} else {
				intentosRestantes--; // Restar intento si es incorrecto
				
				// Dar pista
				if (intentoUsuario < numeroSecreto) {
					System.out.println("El número secreto es MAYOR que " + intentoUsuario + ".");
				} else { // intentoUsuario > numeroSecreto
					System.out.println("El número secreto es MENOR que " + intentoUsuario + ".");
				}
			}
		} 

		
		// 4. Resultados
		System.out.println("\n--- FIN DEL JUEGO ---");
		if (adivinado) {
			int intentosUsados = MAX_INTENTOS - intentosRestantes; 
			System.out.println("¡Felicidades! Era el número **" + numeroSecreto + "**.");
			System.out.println("Lo adivinaste en " + intentosUsados + " intentos.");
		} else {
			System.out.println("¡Se te acabaron los intentos!");
			System.out.println("El número secreto era el **" + numeroSecreto + "**.");
		}
		
	
	}
}