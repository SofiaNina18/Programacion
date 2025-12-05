//PROGRAMA QUE PIDA POR TECLADO EL NUMERO DE ALUMNOS MATRICULADOS (>0)
/*A CONTINUACION, PARA CADA ALUMNO PEDIR POR TECLADO COMO NUMERO ENTERO LA NOTA DE CADA ALUMNO ENTRE 0 Y 10..
 * AL FINAL MOSTRAR POR PANTALLA EL NUMERO DE APROBADOS Y LA NOTA MEDIA DE TODOS.
 * 
 * EJEMPLO:
 * 	Introduce el numero de alumnos: 6
 * 	Introduce las notas de los alumnos (0-10): 
	 * 	Alumno 1: 7
	 * 	Alumno 2: 3
	 * 	Alumno 3: 10
	 * 	Alumno 4: 8
	 * 	Alumno 5: 6
	 * 	Alumno 6: 4
 * 	El numero de aprobados es: 5
 * 	La nota media de es: 6,33
*/
 
import java.util.Scanner;

public class Ejercicio011 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numAlumnos;
		int numAprobados = 0;
		int sumaNotas = 0;
		int num;

		
		do {
			System.out.print("Introduce el numero de alumnos: ");
			numAlumnos = sc.nextInt();
			
			System.out.println("Introduce la nota del alumno (0-10): ");
			} 
		
		while (numAlumnos <= 0);
		
		for (int i = 1; i <= numAlumnos; i++) {
			int nota;
				
			do {
				
				System.out.print("Alumno " + i + ": ");
				nota = sc.nextInt();
				
				if (nota < 0 || nota > 10) {
					System.out.println("La nota debe ser 0-10");
				}
			} 
			while (nota < 0 || nota > 10);
			
			if (nota >= 5) {
				numAprobados++;
			}
			
			sumaNotas += nota;
		}
		
		double notaMedia = (double) sumaNotas / numAlumnos;

		System.out.println("El numero de aprobados es: " + numAprobados);
		
		
		notaMedia = Math.floor(notaMedia);
		System.out.println("La nota media es: " + notaMedia);
		
	}
}