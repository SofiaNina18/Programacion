/*
 * LLENAR UN ARRAY CON 35 NUMEROS ALEATORIOS ENTEROS POSITIVOS DE DOS DIGITOS(1-100) AMBOS INCLUIDOS.
 * MOSTRARLO POR PANTALLA
 */
public class Ejercicio3 {
	public static final int TAM = 35;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num;
		num = new int[TAM];
		
	//DECLARAR VARIABLES: ARRAY
		System.out.println("Generando números aleatorios (10-99) entre " + TAM + " Arrays: ");
	
	//INSTANCIAR EL ARRAY (DIMENSIONARLO)
		for (int pos = 0; pos < TAM; pos++) {
			num[pos] = (int) (Math.random() * 90+10); }
		
	//BUCLE PARA LLENAR EL ARRAY CON NUMEROS ALEATORIOS
		System.out.println("Array generado:");
		int cont=0;
       //Opcion 1 
		for (int pos = 0; pos < TAM; pos++) {
        	System.out.print(num[pos] + " ");
        	cont++;
        	if (cont%10==0){ //if ((pos+1)%10==0)
              System.out.println();
              cont=0;} }
		System.out.println();
	
		


		//MOSTRAR POR PANTALLA, SUMAR, Y CONTAR LOS ELEMENTOS PARES DEL ARRAY.
		//Los elementos pares son:
			//52 34 68 74 92 42 84 24 14 94 92 52 .... 34
			//La suma es: 856
			//El numero de elementos pare

		System.out.println("Los elementos pares son: ");
		int Suma=0;
		int Cont=0;
		
		for (int pos =0; pos < TAM; pos++) {
		    if (num[pos]%2==0) {
		        System.out.print(num[pos] + " "); 
		        Suma += num[pos]; 
		        Cont++; }}         

		System.out.println(); 
		System.out.println("La suma es: " + Suma); 
		System.out.println("El numero de elementos pares es: " + Cont); 
	
	}

}
