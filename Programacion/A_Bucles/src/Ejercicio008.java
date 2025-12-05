import java.util.Scanner;

public class Ejercicio008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("INTRODUCE UN NUMERO: ");
		int num = sc.nextInt(); 

		System.out.print("Los múltiplos de 3 desde el 1 al 41 " + num + " son: ");

		//Opcion 1
		//cont=3;
		//while(cont<=num) {
		//	if(cont%3==0) {
		//		System.out.println(cont + " "); }
		// cont+=3;}

		//for (cont=3; cont<=num; cont+=3) {
		// System.out.println(cont+ " "); 

		for (int i = 1; i <= num; i++) { 
			if (i % 3 == 0) { 
				System.out.print(i + " ");
			}
		}

		System.out.println(); 
	}
}