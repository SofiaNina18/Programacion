import java.util.Scanner;

public class practica {
	public static final int TAM = 20;

	public static void main (String [] args) {
		// Inicializa Scanner
		Scanner sc = new Scanner(System.in); 
		
		/*
		 * UTILIZANDO FUNCIONES:
		 * LLENAR UN ARRAY CON 20 NUMEROS ALEATORIOS ENTRE 1 Y 100.
		 * MOSTRARLO PARA PODER COMPORBAR
		 * PEDIR POR TECLADO DOS VALORES NUMERICOS.
		 * MEDIANTE UNA LLAMADA A LA FUNCION MOSTRAR UN MENSAJE POR PANTALLA INDICANDO
		 * SI LOS DOS NUMEROS ESTAN EN EL ARRAY O NO.
		 */
		int [] numeros = new int[TAM];
		int num1, num2;
		
		
		llenar(numeros); // Llenar el array
		System.out.println("Array generado (para comprobar): ");
		mostrar(numeros); // Mostrar el array

		System.out.print("\nIntroduce el primer número a buscar: ");
		num1 = sc.nextInt();
		
		System.out.print("Introduce el segundo número a buscar: ");
		num2 = sc.nextInt();
		
		// Llama a la función para verificar si ambos números están en el array
		boolean ambosPresentes = contieneAmbos(numeros, num1, num2);
		
		// Muestra el mensaje final indicando si ambos están o no
		if (ambosPresentes) {
			System.out.println("\n✅ SÍ: Los dos números (" + num1 + " y " + num2 + ") ESTÁN en el array.");
		} else {
			// Este mensaje cubre el caso de que falte uno o ambos.
			System.out.println("\n❌ NO: Al menos uno de los números (" + num1 + " o " + num2 + ") NO ESTÁ en el array.");
		}
		
		sc.close(); // Cerrar el Scanner
	} 
	
	//-------------------------------------------------------------------------
	
	/**
	 * FUNCIÓN QUE RECIBA COMO PARÁMETROS UN ARRAY DE NÚMEROS ENTEROS Y DOS NÚMEROS Y DEVUELVA
	 * EL VALOR VERDADERO SOLO SI LOS DOS NÚMEROS ESTÁN EN EL ARRAY. FALSO EN CASO CONTRARIO.
	 * @param array El array donde buscar.
	 * @param n1 El primer número a buscar.
	 * @param n2 El segundo número a buscar.
	 * @return true si n1 Y n2 están ambos presentes; false en caso contrario.
	 */
	public static boolean contieneAmbos(int[] array, int n1, int n2) {
		boolean encontradoN1 = false;
		boolean encontradoN2 = false;
		
		// Recorre el array buscando ambos números
		for (int num : array) {
			if (num == n1) {
				encontradoN1 = true;
			}
			if (num == n2) {
				encontradoN2 = true;
			}
			
			// Optimización: si ambos son encontrados, podemos salir del bucle
			if (encontradoN1 && encontradoN2) {
				return true;
			}
		}
		
		// Devuelve true solo si AMBAS variables son true
		return encontradoN1 && encontradoN2;
	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * Función para llenar un array de enteros con números aleatorios entre 1 y 100.
	 * @param numeros El array de enteros a llenar.
	 */
	public static void llenar (int [] numeros) {
		for (int i=0; i<numeros.length; i++) {
			// Genera número aleatorio entre 1 y 100, ambos inclusive
			numeros [i]=(int)(Math.random()*100+1);
		}  
	} 
	
	//-------------------------------------------------------------------------
	
	/**
	 * Función para mostrar por consola el contenido de un array de enteros.
	 * @param numeros El array de enteros a mostrar.
	 */
	public static void mostrar(int[] numeros) {
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea
	}

}