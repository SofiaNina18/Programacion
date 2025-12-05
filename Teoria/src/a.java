import java.util.Scanner;
//Pedir por taclado el nombre y mostrarlo por pantalla ademas luego decir Hola + nombre

public class a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre);
		sc.close();
		
	}

}
