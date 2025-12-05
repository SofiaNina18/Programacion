/*
 * PROGRAMA QUE HAGA LO SIGUIENTE:
 * 1. LLENAR UN ARRAY CON 10 MUNEROS ENTEROS LEIDOS POR TECLADO. AL PEDIR LOS NUMEROS INDICAR POR CUAL VAMOS:
 * EJEMPLO:
 * 	Introduce 10 numeros:
 * 	Numero 1: 1
 * 	Numero 2: 2
 * 	Numero 3: 3
 * .........:
 * 	Numero 10: 10
 * 
 * Los numeros guardados son: 
 * 1, 2, 3, 4, 5, 
 * 6, 7, 8, 9, 10
 */

import java.util.Scanner;

public class Ejercicio1 {
	
	public static final int TAM=10; //Es una constante
	public static void main(String[] args) {
		//DECLARACION
		Scanner sc;
		int num;
		int [] numeros;
		
		//INSTANCIAR
		sc=new Scanner(System.in);
		numeros= new int [TAM];
		//LLENAR EL ARRAY
		for (int pos=0; pos<TAM; pos++)
		{
			System.out.print("Numero " + (pos+1) + ": ");
			numeros [pos] = sc.nextInt();
		}
		//MOSTRAR LOS NUMEROS GUARDADOS EN EL ARRAY. MOSTRAR 5 EN CADA FILA SEPARADOS POR UN ESPACIO.
		System.out.println("Los numeros guardados son: ");
		
		for (int pos=0; pos<TAM; pos++) { 
			System.out.print(numeros [pos] + " ");
			if (pos==4) {
				System.out.println();	
			}
		}
		
		
		
	}

}
