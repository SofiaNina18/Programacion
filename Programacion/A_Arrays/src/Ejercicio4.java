/* PROGRAMA QUE PIDA POR TECLADO EL NUMERO DE PERSONAS QUE QUIERO GESTIONAR EN  MI PROGRAMA.
 * CREAR DOS ARRAYS PARA GUARDAR LOS NOMBRES Y LAS EDADES DE TANTAS PERSONAS COMO HAYA INDICADO EL USUARIO.
 * PEDIR POR TECLADO LOS NOMBRES Y LAS EDADES Y GUARDARLAS.
 * MOSTRAR POR PANTALLA NOMBRE Y EDAD DE LOS MAYORES DE 18 AÑOS,
 * 
 * EJEMPLO:
 * 	¿Cúantas personas quieres?:  4
 * 	Nombre 1: Jokin
 * 	Edad 1: 21
 * 	Nombre 2: Yossif
 * 	Edad 2: 20
 * 	Nombre 3: Alex
 * 	Edad 3: 20
 * 	Nombre 4: Lander
 * 	Edad 4: 20
 * 
 * Los mayores de 18 años son: 
 * Jokin con 21, Yossif con 20, Alex con 20 y Lander con 20
 */
import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		//DECLARACION
		int numPersonas;
		int [] edades;
		String [] nombres;
		Scanner sc; sc=new Scanner(System.in);
		//PEDIR POR TECLADO EL NUMERO DE PERSONAS
		
		System.out.print("¿Cúantas personas quieres?: ");
		numPersonas=sc.nextInt(); 
		//INSTANCIAR ARRAYS: Crearlos con un tamaño
		nombres = new String [numPersonas]; //Para escribir con letras
		edades = new int [numPersonas];  //Solo admite numeros
		
		for (int pos=0; pos < numPersonas; pos++){
			System.out.print("Nombre " + (pos + 1) + ": ");
			nombres[pos] = sc.next();
			System.out.print("Edad " + (pos + 1)+ ": ");
			edades[pos] = sc.nextInt(); 
		}
		//BUSCAR Y MOSTRAR LOS MAYORES DE EDAD
		System.out.println();
		System.out.println("Los mayores de 18 años son: ");
		for (int pos=0; pos < numPersonas; pos++) {
			if (edades [pos] >= 18) {
				System.out.println("Nombre " + (pos+1) + ": " + nombres [pos]);
				System.out.println("Edad " + (pos+1) + ": " + edades[pos]); }}
	}
}
