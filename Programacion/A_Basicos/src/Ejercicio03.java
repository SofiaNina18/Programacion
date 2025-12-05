import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		//LEER DOS NUMEROS ENTEROS POR TECLADO Y GUARDALOS EN DOS VARIALBES
		Scanner sc;
		int num1, num2, aux;
		
		//INSTANCIA EL SCANNER
		sc=new Scanner(System.in);
		
		//LEER DATOS POR TECLADO
		System.out.print("Introduce primer numero: ");
		num1=sc.nextInt(); //para responder
		
		System.out.print("Introduce segundo numero: ");
		num2=sc.nextInt();
		
		//MOSTRAR EL VALOR DE CADA VARIABLE
		
		System.out.println("El primer numero es: " + num1);
		System.out.println("El segundo numero es: " + num2);
		
		//REALIZAR EL INTERCAMBIO DE DATOS
		aux=num1;
		num1=num2;
		num2=aux;
		
		//VOLVER A MOSTRAR EL VALOR DE CADA VARIABLE
		System.out.println("El primer numero es: " + num1);
		System.out.println("El segundo numero es: " + num2);
			
	}

}
