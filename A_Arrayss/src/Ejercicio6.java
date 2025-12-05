/*
PROGRAMA QUE LLENE UN ARRAY DE 15 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS.
ENTRE 1 Y 100. MOSTRAR EL ARRAY EN UNA LINEA.
A CONTINUACION DESPLAZAR LOS ELEMENTOS DEL ARRAY UNA POSICION A LA DERECHA,
COLOCANDO EL ELEMENTO DE LA ULTIMA POSICION EN LA POCION 0.
VOLVER A MOSTRAR EL ARRAY EN UNA LINEA

EJEMPLO:
Array generado: 1 2 3 4 5 6 7 8 9 10
Desplazo de elementos: 10 1 2 3 4 5 6 7 8 9 
 */
public class Ejercicio6 {
	public static final int TAM = 15;
	public static void main(String[] args) {
		
		
	//DECLARAR VARIABLES: ARRAY
		int [] num;
		num = new int[TAM];
		
		System.out.println("Generando números aleatorios (1-100) entre " + TAM + " Arrays: ");
	
	//INSTANCIAR EL ARRAY 
		for (int pos = 0; pos < TAM; pos++) {
			num[pos] = (int) (Math.random() * 100+1); }
		
		System.out.println("Array generado:");
    
		for (int pos = 0; pos < TAM; pos++) {  //muestra el array en una linea
        	System.out.print(num[pos] + " "); }
		System.out.println(); 
		
	//DESPLAZAR EL CONTENIDO UN APOSICION A LA DERECHA
		int aux = num[TAM - 1]; 
		
		for (int pos = TAM - 1; pos > 0; pos--) {
            num[pos] = num[pos - 1];}
		 num[0] = aux;
		System.out.println("Array desplazado: ");
		    
		for (int pos = 0; pos < TAM; pos++) { 
        	System.out.print(num[pos] + " ");}
        System.out.println();
	}
}