/*(Una mezcla entre int y double)
 * LEER UN NUMERO POR TECLADO Y MUESTRE POR PANTALLA EL RESULTADO DE SU FACTORIAL.
 * EJEMPLO:
 * 6! = 6*5*4*3*2*1
 * 0! = 1 
 * 13! = 13*12*11*10*9*8*7*6*5*4*3*2*1 > 2.100.000.000
 * -4! = El factorial no existe
 */

import java.util.Scanner;

public class Ejercicio012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VARIABLES
		int num;
		double fact;
		String respuesta;
		
		//INSTANCIAR
		Scanner sc = new Scanner(System.in);
		//PEDIR NUMERO POR TECLADO
		do {
		System.out.print("Introduce un numero: ");
		num= sc.nextInt();
		
		// SI EL NUMERO ES MENOR QUE 0; EL FACTORIAL NO EXISTE
		if (num < 0) {
			System.out.println("El factorial no existe."); } 
		// SI EL NUMERO ES 0 --> EL RESULTADO ES 1
		else if (num == 0) {
			System.out.println("El factorial de 0 es 1"); }
	    // SI EL NUMERO ES MAYOR QUE 0 --> CALCULAR EL RESULTADO HACIENDO VARIAS MULTIPLICACIONES.
		else {
			fact = 1;
			for (int cont = num ; cont >= 1; cont--) {
				//System.out.println(fact + "x" + cont + "=" + (fact * cont));    
				fact = fact * cont;}
				System.out.println("El factorial de " + num + "! es " + fact); }
		
		System.out.print("Quieres calcular otro factorial? (S/N): ");
		respuesta = sc.next();
		} while (respuesta.equalsIgnoreCase("S"));
	}

}

