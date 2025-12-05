/*
 * LLENAR UN ARRAY DE 20 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS DE 2 DIGITOS. 
 * MOSTRARLO.
 * A CONTINACION ORDENARLO DE FORMA ASCENDENTE
 * MOSTRARLO EN PANTALLA CON EL METODO BURBUJA
 */
public class Ejercicio7 {
	public static final int TAM = 20;
	public static void main(String[] args) {
		
		
	//DECLARAR VARIABLES: ARRAY
		int [] num;
		num = new int[TAM];
		
		
		System.out.println("Generando números aleatorios (10-99) entre " + TAM + " Arrays: ");
	
	//INSTANCIAR EL ARRAY 
		for (int pos = 0; pos < TAM; pos++) {
			num[pos] = (int) (Math.random() * 90+10); }
		
		System.out.println("Array generado:");
    
		for (int pos = 0; pos < TAM; pos++) {  //muestra el array en una linea
        	System.out.print(num[pos] + " "); }
		System.out.println(); 
		
	//ORDENARLO DE MENOR A MAYOR - METODO BURBUJA
		int aux;
		for (int i = 0; i < TAM - 1; i++) { //tantas pasadas sobre el array como elementos tiene
			//recorrer el array comparando cada elemento con el siguiente
			//e intercambiando si el actual es mayor que el siguiente
			
            for (int j = 0; j < TAM - 1 - i; j++) { // Si el elemento actual es mayor que el siguiente
    
                if (num[j] > num[j + 1]) {
                    aux = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = aux;
                }
            }}
		// MOSTRAR EL ARRAY ORDENADO
        for (int pos = 0; pos < TAM; pos++) {  //muestra el array en una linea
        	System.out.print(num[pos] + " "); }
		System.out.println(); 
		
	}
}
