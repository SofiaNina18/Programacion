/*
 * 
 */
import java.util.Scanner;
public class Ejercicio0001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		int num1, num2, resultado;
		
		sc=new Scanner(System.in);
		
		//LEER DATOS POR TECLADO
		System.out.print("Introduce primer numero: ");
		num1=sc.nextInt(); //para responder
		
		System.out.print("Introduce segundo numero: ");
		num2=sc.nextInt();
		
		resultado=sumar(num1,num2);
		System.out.println("La suma es: " + resultado);
		}
	
	//FUNCION QUE REALICE LA SUMA DE DOS NUMEROS 
	//RECIBIDOS COMO PARÁMETROS Y DEVUELVA EL RESULTADO DE ESA SUMA
	public static int sumar (int n1, int n2) {
		int result;
		result=n1+n2;
		return result;
		
	
	
		
	}
	
	
}

		