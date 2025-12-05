import java.util.Scanner;

//LEER POR TECLADO LA BASE Y LA ALTURA DE UN TRIANGULO Y MUESTRE POR PANTALLA SU ÁREA.
//Y MUESTRE POR PANTALLA SU ÁREA
//CONTROLAR QUE LA BASE Y LA ALTURA NO SEAN NEGATIVAS
//AL USUARIO INDICANDO QUE NO PUEDE SER NEGATIVO
public class Ejercicio02 {

	public static void main(String[] args) {
		//ENTRADA DE DATOS POR TECLADO EN MODO CONSOLA
		Scanner sc;
		int base, altura;
		float area;
		
		//los objetos se declaran, inicializar, realizan
		//INSTANCIA EL SCANNER
		sc=new Scanner(System.in);
		
		//LEER DATOS POR TECLADO
		
		System.out.print("Introduce la base:");
		base=sc.nextInt(); //para responder
		if(base<=0) {
			System.out.println("La base no puede ser negativa");
			return;}
			
		System.out.print("Introduce la altura:");
		altura=sc.nextInt();
		
		if(altura<=0) {
			System.out.println("La altura no puede ser negativa");
			return;}
		
		//REALIZAR CALCULOS
		area=(float)base*altura/2;
		
		//MOSTRAR RESULTADOS (OPCION 1)
		if (base<=0) {
			System.out.println("La base no puede ser 0 o negativa");}
		else if (altura<=0) {
			System.out.println("La altura no puede ser 0 o negativa");
		}
		else
			{System.out.println("Area: " + area);}
		
		//MOSTRAR RESULTADOS (OPCION 2)
		if (area>0 && altura>0 && base>0) {
			System.out.println("Area: " + area); }
		
	//	if (area>0) {
	//		if (altura>0)
	//			if (base>0)
	//		System.out.println("Area: " + area);
		
	
		else
		{
			System.out.println ("No puede ser negativo");
		}
	
		
	//Syso
	}

}
