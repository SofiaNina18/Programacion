import java.util.Scanner;

public class Ejercicio0002 {

	public static void main(String[] args) {
		// PROGRAMA QUE CALCULE UN FACTORIAL DE LOS NUMEROS INTRODUCIDOS POR TECLADO. 
		//EL PROGRAMA TERMINARA CUANDO TECLEEMOS EL NUMERO -99
		//
		Scanner sc = new Scanner(System.in);
		int []numeros;
		int num;
		double result;
		
		numeros=new int[10];
		do {
			System.out.print("Introduce un numero para calcular su factorial (-99 para terminar): ");
			num=sc.nextInt();
			if (num>=0) {
				result=factorial(num);
				System.out.println("El factorial de "+ num + " es: " + result);
			}else {
				System.out.println("No esxiste el factorial de numeros negativos...");
			}
			
			//System.out.println("El factorial de "+ num + " es: " + factorial(num));
		}while(num!=-99);
		
		//A CONTINUACION, LLENAR UN ARRAY DE 10 ELEMENTOS CON LOS 10 PRIMEROS NUMEROS POSITIVOS (FUNCION) y mostrarlos (funcion)
		llenar(numeros);
		mostrar (numeros);
		
	}	//FINAL DEL MAIN
			
	/*
	 * FUNCION QUE CALCULE EL FACTORIAL DE UN NUMERO RECIBIDO COMO PARAMETRO Y DEVUELVA SU RESULTADO.
	 * NUMERO RECIBIDO CON PARAMETRO: int
	 * RESULTADO: double
	 */
	public static double factorial(int num) {
		double resultado;
		resultado=1;
		for (int i=num; i>=1; i--) {
			resultado=resultado*i;
		}
		return resultado;
	
	}
	//FUNCION QUE LLENE UN ARRAY CON LOS 10 PRIMEROS NUMEROS ENTEROS IMPARES POSITIVOS 
	public static void llenar (int numeros[]) {
		int aux=1;
		for (int pos=0;pos<numeros.length;pos++) {
			numeros[pos]=aux;
			aux=aux+2;
		}
		//Otra forma
		for (int pos=0;pos<numeros.length;pos++) {
			numeros[pos]=pos*2+1;
			}
	
	}
	public static void mostrar (int [] numeros) {
		for (int pos=0;pos<numeros.length;pos++) {
			System.out.println(numeros [pos]+ " ");}
	}
}
