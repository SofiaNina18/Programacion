//PROGRAMA QUE LEA UN NUMERO ENTEROS POR TECLADO HASTA QUE TECLEE EL -99
//Y MUESTRE POR PANTALLA CUANTOS POSITIVOS, CUANTOS NEGATIVOS, Y CUANTOS NULOS (VALOR 0)
//SE HAN INTRODUCIDO.
//EJEMPLO:
//		Introduce un numero (-99 para terminar): 25
//		Introduce un numero (-99 para terminar): 12
//		Introduce un numero (-99 para terminar): 0
//		Introduce un numero (-99 para terminar): -23
//		Introduce un numero (-99 para terminar): 51
//		Introduce un numero (-99 para terminar): -56
//		Introduce un numero (-99 para terminar): 0
//		Introduce un numero (-99 para terminar): 2
//		Introduce un numero (-99 para terminar): 5
//		Introduce un numero (-99 para terminar): -25
//		Introduce un numero (-99 para terminar): 0
//		Introduce un numero (-99 para terminar): -99

//	Has introducido 5 positivos, 3 negativos, 3 nulos.

import java.util.Scanner;

public class Ejercicio009 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		int positivos = 0;
		int negativos = 0;
		int nulos = 0;
		
		System.out.print("Introduce un numero (-99 para terminar): ");
		num = sc.nextInt();
		
		while (num !=-99)  //while (true) (para hacer bubles)
		{
			if (num > 0) 
			{
				positivos++;
			} 
			else if (num < 0) 
			{
				negativos++;
			} 
			else 
			{
				nulos++;
			}
			
			System.out.print("Introduce un numero (-99 para terminar): ");
			num = sc.nextInt();
		}
		
		System.out.println("Has introducido " + positivos + " positivos, " + negativos + " negativos y " + nulos + " nulos.");
	}
}