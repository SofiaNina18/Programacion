//Programa que lea dos números por teclado y muestre por pantalla todos los números
//que hay entre ambos, empezando por el menor hasta llegar al mayor.
import java.util.Scanner;

public class Ejercicio007 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.print("Introduce primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce segundo número: ");
        num2 = sc.nextInt();

        // Si num1 es mayor que num2, los intercambiamos
        if (num1 > num2) {
            int aux = num1;
            num1 = num2;
            num2 = aux;
        }

        for (int num = num1; num <= num2; num++) {
            System.out.print(num + ", ");
        }
    }
}