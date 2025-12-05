import java.util.Scanner;

public class Ejercicio0004 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int órdenes, resultado, primero;

		System.out.println("Soy la calculasumas mágica, si quieres sumar pares impares o todos los números que quieras, avísame");

		do{

			System.out.println("Escribe 1 para sumar los pares");

		

		System.out.println("Escribe 2 para sumar los impares");

		System.out.println("Escribe 3 para sumar todos los números");

		System.out.println("Escribe cualquier otra cosa para terminar el programa");

		órdenes = teclado.nextInt();

		if (órdenes == 1) {

			System.out.println("Dame el primer número par que quieras sumar: ");

			primero = teclado.nextInt();

			resultado = pares(primero);

			System.out.println("Toda la suma da: " + resultado);

		} else if (órdenes == 2) {

			System.out.println("Dame el primer número impar que quieras sumar: ");

			primero = teclado.nextInt();

			resultado = impares(primero);

			System.out.println("Toda la suma da: " + resultado);

		}else if (órdenes == 3) {

			System.out.println("Dame el primer número que quieras sumar: ");

			primero = teclado.nextInt();

			resultado = todos(primero);

			System.out.println("Toda la suma da: " + resultado);

		}

		}while (órdenes == 1 || órdenes ==2 || órdenes ==3);

	}

	public static int pares(int a) {

		Scanner teclado = new Scanner(System.in);

		int resultado = 0;

		if (a%2 == 0) {

			resultado += a;

		}

		do {

			System.out.println("Dime otro número par para que se lo sume y si quieres parar ya pon 0");

			a = teclado.nextInt();

			if (a%2 == 0) {

				resultado += a;

			}

		}while (a !=0);

		return resultado;

		

	}

	public static int impares(int a) {

		Scanner teclado = new Scanner(System.in);

		int resultado = 0;

		if (a%2 == 1) {

			resultado += a;

		}

		do {

			System.out.println("Dime otro número impar para que se lo sume y si quieres parar ya pon 0");

			a = teclado.nextInt();

			if (a%2 == 1) {

				resultado += a;

			}

		}while (a !=0);

		return resultado;

		

	}

	public static int todos(int a) {

		Scanner teclado = new Scanner(System.in);

		int resultado = a;

		do {

			System.out.println("Dime otro número para que se lo sume y si quieres parar ya pon 0");

			a = teclado.nextInt();

				resultado += a;

		}while (a !=0);

		return resultado;

		

	
	

	}

}
