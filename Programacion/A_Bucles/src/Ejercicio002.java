//for(var=1; var<=100; var++) {
	//sentencias;
//Programa que muestre los números del 1 al 100 (20 números por línea)

public class Ejercicio002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int num, cont;
			num=1;
			cont=0;
					
			//DECLARAR VARIABLES
			while (num<=100)
			{
				System.out.print (num + " "); 
				//Opcion 1
				//if (num==20 || num==40 || num==60 || num=80) 
				
				//Opcion 2 // R
				if (num % 20 == 0) {
					System.out.println();
				}
				//OPcion 3
				cont ++;
				if (cont==20 ) {
					System.out.println();
					cont=0;
				
				}
			num++;
	            
			}
	}

}
