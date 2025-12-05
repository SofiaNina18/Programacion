
public class Ejercicio01 {

	public static void main(String[] args) {
		//DECLARACIÓN DE VARIABLES
		int num; 
		String nombre;
		
		//InNICIALIZAR LAS VARIABLES
		num=25;
		nombre="DAM1";
		
		//MOSTRAR VALORES
		//El valor del numero es: 25.
		System.out.println("El valor del numero es: "+num+".");
		//Estamos en la clase DAM1
		System.out.println("Estamos en la clase de: "+nombre);
		
		//MODIFICAR EL VALOR DEL NUMERO: SUMARLE 35
		num=num+35;
		num+=5;
		num=num+1;
		num++;
		System.out.println(num+1);
// para restar solo uno es num++, num-- (solo vale con uno)
		//VOLVER A MOSTRAR EL VALOR DEL NUMERO
		
		System.out.println("El valor del numero es: "+num);
		
		System.out.println("Hola Mundo!!!");
	}

}
