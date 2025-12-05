/*
LLENAR UN ARRAY DE 20 ELEMENTOS CON NUMEROS ENTEROS POSITIVOS ENTRE 1 Y 50.
MOSTRARLO POR PANTALLA.
BUSCAR EL MAYOR DENTRO DEL ARRAY Y MOSTRARLO POR PANTALLA.
 */
public class Ejercicio5 {
	//CONSTANTE PARA EL TAMAÑO DEL ARRAY
	public static final int TAM = 20;
	public static void main(String[] args) {
		
		
	//DECLARAR VARIABLES: ARRAY
		int [] num;
		num = new int[TAM];
		int comparador;
		System.out.println("Generando números aleatorios (1-50) entre " + TAM + " Arrays: ");
		
		
		
	//INSTANCIAR EL ARRAY (DIMENSIONARLO)
		for (int pos = 0; pos < TAM; pos++) {
			num[pos] = (int) (Math.random() * 50+1); }
		
	//BUSCAR EL MAYOR Y MOSTRARLO POR PANTALLA
		System.out.println("Array generado:");
        comparador=num[0];
        int intercambio=0;
        
		for (int pos = 0; pos < TAM; pos++) {  //BUSCA EL MAYOR
        	System.out.print(num[pos] + " ");
        	if (num [pos] > comparador) {
        		comparador = num [pos];
        		intercambio = pos;
				}}
		System.out.println();
		System.out.println("El numero mayor es: " + comparador);
	//INTERCAMBIAR EL MAYOR CON EL DE LA ULTIMA POSICION
		num [intercambio] = num [19];
		num [19] = comparador;
	//VOLVER A MOSTRAR EL ARRAY
		for (int pos = 0; pos < TAM; pos++) { 
        	System.out.print(num[pos] + " ");
        	}
	
	        
		
		
		
		
	}

}
