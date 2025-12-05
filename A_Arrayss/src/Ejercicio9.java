/*
 * TENEMOS UN ARRAY DE NUMEROS ENTEROS DE 5 FILAS Y 10 COLUMNAS
 * LLENARNO CON NUMEROS ALEATORIOS DE DOS DIGITOS
 * MOSTRARLO POR PANTALLA CON LAS FILAS NUMERADAS
 * PEDIR POR TECLADO DOS NUMEROS DE FILA E INTERCAMBIAR SUS CONTENIDOS (LOS DE LA FILA COMPLETA)
 * VOLVER A MOSTRAR EL ARRAY
 * 
 * Ejemplo:
 * 	fila 1: 12 15 16 18 17 18 19 35 35 
 * 	fila 2: 14 25 98 78 45 25 35 36 25
 * 	..................................
 * 	fila 5: 95 94 23 65 98 87 45 21 54
 * 
 * Introduce las filas a intercambiar:
 * 	fila:2
 * 	fila:5
 * El array queda asi:
 * 	fila 1: 12 15 16 18 17 18 19 35 35
 * 	fila 2: 95 94 23 65 98 87 45 21 54
 * .................................
 *  fila 5: 14 25 98 78 45 25 35 36 25
 */
import java.util.Scanner;
public class Ejercicio9 {
	//CONSTANTE PARA EL TAMAÑO DEL ARRAY
	public static final int FILAS = 5;
	public static final int COLUMNAS = 10;
	public static void main(String[] args) {
		int [][] num;
		num = new int[FILAS][COLUMNAS];
		Scanner sc = new Scanner(System.in);
		
	//DECLARAR VARIABLES: ARRAY
		System.out.println("Filas y columnas " + FILAS + " y " + COLUMNAS + " Arrays: ");
		
		
		
	//INSTANCIAR EL ARRAY (DIMENSIONARLO)
		for (int fila = 0; fila < FILAS; fila++) {
			for (int columna = 0; columna < COLUMNAS; columna++)
			num[fila][columna] = (int) (Math.random() * 90+10); }
		
	//BUCLE PARA LLENAR EL ARRAY CON NUMEROS ALEATORIOS
		System.out.println("Array generado:");
		
        
		for (int fila = 0; fila < num.length; fila++) {
			System.out.print("Fila " + (fila+1) + ": ");
			for (int columna = 0; columna < COLUMNAS; columna++) {
        	System.out.print(num[fila][columna] + " ");}
		
		System.out.println();
		}
		//PEDIR POR TECLADO
		int fila1, fila2;
		System.out.println("Introduce las filas a intercambiar (entre 1 y " + FILAS + "):");
            System.out.print("Número de la PRIMERA fila: ");
            fila1 = sc.nextInt();
            System.out.print("Número de la SEGUNDA fila: ");
            fila2 = sc.nextInt();
		
        //Intercambiar la fila
        int aux;
    
        for (int cambiar=0; cambiar<10;cambiar++) {
        	aux = num[fila1-1][cambiar];
        	num[fila1-1][cambiar] = num[fila2-1][cambiar];
        	num[fila2-1][cambiar] = aux;
        }
        for (int fila = 0; fila < num.length; fila++) {
			System.out.print("Fila " + (fila+1) + ": ");
			for (int columna = 0; columna < COLUMNAS; columna++) {
        	System.out.print(num[fila][columna] + " ");}
		
		System.out.println();
		}
	}
}