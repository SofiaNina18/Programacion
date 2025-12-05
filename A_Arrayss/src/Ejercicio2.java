/*
 * PROGRAMA QUE LLENE UN ARRAY DE 30 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS
 * ENTRE 1 Y 100 AMBOS INCLUIDOS.
 * 
 * Generar números aleatorios:
 * 		int num;
 * 		num= (int) (Math.random()*100+1);
 */

public class Ejercicio2 {
	//CONSTANTE PARA EL TAMAÑO DEL ARRAY
	public static final int TAM = 30;
	public static void main(String[] args) {
		int [] num;
		num = new int[TAM];
		
	//DECLARAR VARIABLES: ARRAY
		System.out.println("Generando números aleatorios (1-100) entre " + TAM + " Arrays: ");
		
		
		
	//INSTANCIAR EL ARRAY (DIMENSIONARLO)
		for (int pos = 0; pos < TAM; pos++) {
			num[pos] = (int) (Math.random() * 100 + 1); }
		
	//BUCLE PARA LLENAR EL ARRAY CON NUMEROS ALEATORIOS
		System.out.println("Array generado:");
		int cont=0;
        
		for (int pos = 0; pos < num.length; pos++) {
        	System.out.print(num[pos] + " ");
        	cont++;
        	if (cont==6){
              System.out.println();
              cont=0;}
		}
           /*
            *    
        	if(pos%6==0) {
            	System.out.println(); }
            */
        	//MOSTRAR EL CONTENIDO DEL ARRAY EN ORDEN INVERSO:6 POR LINEA pero ahora del reve
        System.out.println("Ahora los mostramos al reves: ");   
        for (int pos=TAM; pos > 0; pos--) {
            System.out.print(num[pos-1] + " ");
            cont++;
            if (cont==6){
            	System.out.println();
                  cont=0;}
    /*  for (int pos=TAM-1; pos >=0; pos--}) {
    	  System.out.println(num[pos]+"");
    	  if (pos%6==0) {
    		  System.out.println();
    	  }
   */
		}
	}
}


