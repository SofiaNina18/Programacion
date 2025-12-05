//PROGRAMA QUE LEA UNA PALABRA POR TECLADO.
//A CONTINUACION PEDIR UN NUMERO ENTERO POR TECLADO, SEGUIR PIDIENDO NUMEROS HASTA 
//QUE EL USUARIO INTRODUZCA UNO > 0
//MOSTRAR POR PANTALLA LA PALABRA LEIDA TANTAS VECES COMO INDICA EL NUMERO
//	EJEMPLO
//		Introduce una palabra: PROGRAMACION
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -9
//		Introduce un numero positivo: -6
// 1.PROGRAMACION
// 2.PROGRAMACION
// 3.PROGRAMACION
// 4.PROGRAMACION
// 5.PROGRAMACION
// 6.PROGRAMACION

import java.util.Scanner;

public class Ejercicio010 {

    public static void main(String[] args) {

        String palabra;
		Scanner sc;
		int num;
		
		sc=new Scanner(System.in);

        //LEER UNA PALABRA
		System.out.print("Introduce una palabra:");
        palabra = sc.next();

      
        do {
            System.out.print("Introduce un número positivo:");
            num = sc.nextInt();
        } while (num <= 0);

       
        for (int i = 1; i <= num; i++) {
            System.out.println(i + ". " + palabra);
        }

       
    }
}