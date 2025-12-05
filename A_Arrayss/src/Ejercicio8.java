/*
 * CREAR UN ARRAY PARA GESTIONAR UN TABLERO DE AJEDREZ
 * LLENARLO CON LAS PIEZAS EN SU POSICION INICIAL
 * MOSTRARLO POR PANTALLA
 * 
 * 
 * 
 * Ejemplo:
 * BLANCAS
 * 	T C A R Q A C T 
 * 	P P P P P P P P
 * 	. . . . . . . .
 *  . . . . . . . .
 *  . . . . . . . .
 *  . . . . . . . .
 *  P P P P P P P P
 *  T C A Q K A C T
 *NEGRAS      
 */
import java.util.Scanner;
public class Ejercicio8 {
	public static final int TAM = 8;

	public static void main(String[] args) {
		
		char[][] tablero = new char[TAM][TAM];
		Scanner sc;
		sc=new Scanner(System.in);
		
		tablero = new char[8][8];
		for (int i=0; i<TAM; i++) {
			for (int j=0; j<TAM;j++){
				tablero[i][j] = '.';
				tablero[6][j] = 'P';
				tablero[1][j] = 'P';
			}
			tablero[0][0] = 'T'; 
			tablero[0][1] = 'C'; 
			tablero[0][2] = 'A';
			tablero[0][3] = 'K'; 
			tablero[0][4] = 'Q'; 
			tablero[0][5] = 'A';
			tablero[0][6] = 'C';
			tablero[0][7] = 'T'; 
			
			tablero[7][0] = 'T'; 
			tablero[7][1] = 'C'; 
			tablero[7][2] = 'A';
			tablero[7][3] = 'K';
			tablero[7][4] = 'Q'; 
			tablero[7][5] = 'A'; 
			tablero[7][6] = 'C'; 
			tablero[7][7] = 'T'; 
		}
		
		
		System.out.println("BLANCAS");
		System.out.println("    1 2 3 4 5 6 7 8");
		for (int i=0; i<TAM; i++) {
			System.out.print((1+i) + " | ");
				for (int j=0; j<TAM;j++){
					
					System.out.print(tablero[i][j] + " ");
				}
				System.out.println();
				
		}
		System.out.println("NEGRAS");
		System.out.println();
		System.out.println("NEGRAS");
		
		for (int i=TAM-1; i>-1; i--) {
			System.out.print((1+i) + " | "); //Es lo que hace la barrita al lado
			for (int j=TAM-1; j>-1;j--){
				
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();}

		System.out.println("    8 7 6 5 4 3 2 1");
        System.out.println("BLANCAS");
		//PEDIR QUE INSERTE UNA JUGADA:
    //    Origen: Fila y columna: debe estar entre 1 y 8 y además debe ser una ficha.
        // Destino: Fila y columna: debe estar entre 1 y 8
        //Ejemplo:
        //Introduce casilla ORIGEN:
        //Introduce fila(1-8):9
        //Introduce columna (1-8):2
        //Introduce numeros entre 1 y 8.
      //Introduce casilla Destino:
        //Introduce fila(1-8):3
        //Introduce columna (1-8):5
        //MOSTARLO POR PANTALLA y en moviento que se quede en blanco se quede un . que no se quede vacio
        int fila1, colm1, fila2, colm2;
      
        System.out.println("Introduce casilla de Origen");
        do {
        		System.out.println("Introduce fila (1-8): ");
            	fila1=sc.nextInt();
            		
            	System.out.println("Introduce Columna (1-8): ");
            	colm1=sc.nextInt();
        	} while ( fila1 < 1 || fila1>8 || colm1 <1 || colm1>8 || tablero [fila1-1][colm1-1]=='.');
        
        System.out.println("Introduce casilla de Destino");
        
        do {
    		System.out.println("Introduce fila (1-8): ");
        	fila2=sc.nextInt();
        		
        	System.out.println("Introduce Columna (1-8): ");
        	colm2=sc.nextInt();
    	} while ( fila1 < 1 || fila1>8 || colm1 <1 || colm1>8 || tablero [fila1-1][colm1-1]=='.');
        
        
        //MOVER LA PIEZA
        tablero [fila2-1][colm2-1]=tablero[fila1-1][colm1-1];
        tablero [fila1-1][colm1-1]='.';
        
        System.out.println("BLANCAS");
		System.out.println("    1 2 3 4 5 6 7 8");
		for (int i=0; i<TAM; i++) {
			System.out.print((1+i) + " | ");
				for (int j=0; j<TAM;j++){
					
					System.out.print(tablero[i][j] + " ");
				}
				System.out.println();
				
		}
		System.out.println("NEGRAS");
        
	}//FIN DEL MAIN
	
} 