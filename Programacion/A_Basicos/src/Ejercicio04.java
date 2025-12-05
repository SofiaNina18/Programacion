import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
	//programa que lea dos numeros por teclado 
	//	Y muestre por pantalla en ORDEN ASCENDENTE
	
	//DECLARACIÓN DE VARIABLES
	Scanner sc;
	int num1, num2;
	
	//INSTANCIAR
	sc=new Scanner(System.in);
	
	//PEDIR NUMEROS POR TECLADO
	System.out.print("Introduce primer numero: ");
	num1=sc.nextInt(); 
	
	System.out.print("Introduce segundo numero: ");
	num2=sc.nextInt();
	
	if (num1<num2)
	{
		System.out.println("El orden ascendente empieza con: " + num1);
			
		System.out.println("El orden termina con: " + num2);
	}
	else if (num2>num1)
	{ 
		System.out.println("El orden ascendente empieza con: " + num2);
		
		System.out.println("El orden termina con: " + num1);
	}
	else
	{
		System.out.println("Los dos numeros son iguales" );
	
	}
	
	//Se puede hacer con if en tres condiciones
	//if (num1<mu2)
	//if (num2>mun1)
	//if (num1==num2)
	
	
	//MOSTRARLOS ORDENADOS
	}

}
