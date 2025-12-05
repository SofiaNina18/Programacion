import java.util.Scanner;

public class Ejercicio0006 {
	public static final int TAM = 20;
	public static void main (String [] args) {
		Scanner sc;
		sc=new Scanner(System.in);
		
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
		
		llenar(numeros);
		System.out.print("Array generado: ");
		mostrar(numeros);
			

		System.out.print("Introduce un numero dentro del array: ");
		num1=sc.nextInt();
		
		System.out.print("Introduce un numero dentro del array: ");
		num2=sc.nextInt();
		
		boolean ambosPresentes = contieneAmbos(numeros, num1, num2);
		
	
		if (ambosPresentes) {
			System.out.println("Ambos números se encuentran en el array");
		} else {
			System.out.println("Uno o los dos no se encuentran en el array.");
		} 
		
		
	} 
	/*
	 * FUNCION QUE RECIBA COMO PARAMETROS UN ARRAY DE NUMEROS ENTEROS Y DOS NUMEROS Y DEVUELVA
	 * EL VALOR VERDADERO SOLO SI LOS DOS NUMEROS ESTAN EN EL ARRAY. FALSO EN CASO CONTRARIO.
	 */
	
	public static void llenar (int [] numeros) {
		for (int i=0; i<numeros.length; i++) {
			numeros [i]=(int)(Math.random()*100+1);}  
		
	} public static void mostrar(int[] numeros) {
        for (int i=0;i<numeros.length;i++) {
            System.out.print(numeros [i] + " ");}
        System.out.println(); 
        
	} public static boolean contieneAmbos(int[] numeros, int n1, int n2) { // CORREGIDO: solo 2 números
		boolean num1Encontrado = false;
		boolean num2Encontrado = false;
		
		for (int i=0; i<numeros.length;i++) {
			if (i == n1) {
				num1Encontrado = true;
			}
			if (i == n2) {
				num2Encontrado = true;
			}
			
			// Optimizacion: si ambos ya se encontraron, podemos salir del bucle
			if (num1Encontrado && num2Encontrado) {
				return true;
			
			} else {
				return false;
			}
		}
		
		// Devolvemos el resultado final
		return num1Encontrado && num2Encontrado;
	}

}