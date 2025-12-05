
public class Ejercicio0005 {
/*
 * MEDIANTE A LAS LLAMADAS FUNCIONES:
 * LLENAR DOS ARRAYS DE 20 ELEMENTOS CON NUMEROS ENTEROS 
 * MOSTRAR DOS ARRAYS DE NUMEROS ENTEROS
 * ORDENAR LOS DOS ARRAYS Y MOSTRARLOS ORDENADOS
 * TENEMOS UN TERCER ARRAY DE 40 ELEMENTOS VACIO.
 * 
 */
	public static final int TAM = 20;
	public static void main(String[] args) {
		int [] array1 = new int[TAM];
		int [] array2 = new int[TAM];
		int [] array3 = new int[TAM*2];
		
		llenar(array1);
		llenar(array2);
		System.out.println("Contenido del array 1: ");
		mostrar(array1);
		System.out.println("Contenido del array 2: ");
		mostrar(array2);
		
		//ORDENARLOS Y VOLVER A MOSTRARLOS
		System.out.println("Contenido del array 1: ");
		ordenar(array1);
		System.out.println();
		System.out.println("Contenido del array 2: ");
		ordenar(array2);
		System.out.println();
		System.out.println("Array mixto y ordenado: ");
		fusionar(array1, array2, array3);
		mostrar(array3);

	}
	/*
	 * HACER LAS SIGUIENTES FUNCIONES:
	 */
	
	/*FUNCION QUE RECIBA DOS ARRAYS ORDENADOS COMO PARAMETROS Y VAYA METIENDO UN TERCER ARRAY 
	 * TAMBIEN RECIBIDO COMO PARAMETRO LOS ELEMENTOS DE LOS DOS ARRAYS ANTERIORES
	 * DE FORMA ORDENADA (NO VALE LLAMAR A LA FUNCION ORDENAR)
	 */
	public static void fusionar(int [] array1, int [] array2, int [] array3) {
        int i = 0;
        int j = 0; 
        int k = 0; 
                 
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];
                i++;
            } else {
                array3[k] = array2[j];
                j++;
            } k++;
        }while (i < array1.length) {
            array3[k] = array1[i];
            i++;
            k++;
        }while (j < array2.length) {
            array3[k] = array2[j];
            j++;
            k++;
        }
	}
	 /* FUNCION PARA LLENAR UN ARRAY RECIBIDO COMO PARAMETRO CON NUMEROS ENTEROS ALEATORIOS DE DOS DIGITOS
	 */
	public static void llenar (int [] numeros) {
		for (int i=0; i<numeros.length; i++) {
			numeros [i]=(int)(Math.random()*90+10);}}
	
	
	 /* FUNCION PARA MOSTRAR POR PANTALLA UN ARRAY RECIBIDO COMO PARAMETRO. (metodo burbuja)
	 */
	public static void mostrar(int[] numeros) {
        for (int i=0;i<numeros.length;i++) {
            System.out.print(numeros [i] + " ");}
        System.out.println(); 
    
	}public static void ordenar (int [] numeros) {
        int aux=0;
        boolean ordenado;

        
		for (int i=0;i<numeros.length;i++) {  //tantas pasadas sobre el array como elementos tiene recorrer el array comparando cada elemento con el siguiente e intercambiarlos si el actual es mayor que el siguiente.
        	ordenado=true;
			for (int j=0;j<numeros.length-i-1;j++) {
				if (numeros [j] > numeros [j+1]) {
        		aux = numeros [j];
        		numeros [j] =numeros [j+1];
        		numeros [j+1]=aux;
        		ordenado=false;
				}
			}
			if(ordenado) {
				break;
			}
		}	
	//VOLVER A MOSTRAR EL ARRAY
		for (int i = 0; i < TAM; i++) { 
        	System.out.print(numeros[i] + " ");
        	}
    }
}
