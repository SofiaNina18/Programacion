//programa que lea una nota numerica por teclado y muestre por pantalla esa nota en
//FORMA DE TEXTO SEGÚIN ESTA TABLA:
//0<=NOTA<3 -> MD o OG
//3<=NOTA<5 -> INS o GU
//5<=NOTA<6 -> SF o NH
//6<=NOTA<7 -> BN o ON 
//7<=NOTA<9 -> NT o OO
//9<=NOTA<=10 -> SB o BK

//EJERMPLO:
//INTRODUCE una nota (0-10): 15
//NOta no valida -> Se acaba el programa

//Ejemplo 2:
//introduce una nota (0-10): 7
//Has sacado un NT o OO

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		
		//DECLARACIÓN DE VARIABLES
		Scanner sc;
		int nota;
		
		//INSTANCIAR
		sc=new Scanner(System.in);
		
		//PEDIR NUMEROS POR TECLADO
		System.out.print("Introduce una nota (0-10): ");
		nota=sc.nextInt(); 
		
		//MOSTRAR EL VALOR DE LA NOTA EN FORMATO DE TEXTO 
		switch (nota)
		{
			case 0, 1, 2: System.out.println ("La nota es muy deficiente"); 
			break;
			
			case 3, 4: System.out.println("Insuficiente");
			break;
			
			case 5: System.out.println ("Suficiente");
			break;
			
			case 6: System.out.println ("Bien");
			
			break; 
			
			case 7, 8: System.out.println ("Notable");
			
			break; 
			
			case 9, 10:  System.out.println ("Sobresaliente");
			
			break; 
			
			default:
                System.out.println("Nota no válida");
                break;
            
                
            
                
		}
		
	}

}
