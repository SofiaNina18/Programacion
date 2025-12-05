import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		//DECLARACION
		Scanner scTeclado, scFich;
		String strLinea, strFichero;
		
		scTeclado=new Scanner(System.in);
		//PEDIR NOMBRE DEL FICHERO POR TECLADO
		System.out.print("Introduce el nombre del fichero que quieres mostrar: ");
		strFichero=scTeclado.nextLine();
				
		//ABRIR PARA LEER EL FICHERO CUYO NOMBRE HA INTRODUCIDO EL USUARIO
		try {
			scFich=new Scanner(new File(strFichero));
			//TODO VA BIEN: LEEMOS EL FICHERO Y LO MOSTRAMOS POR PANTALLA
			while(scFich.hasNext()) {
				//leer linea del fichero
				strLinea=scFich.nextLine();
				//mostrarla por pantalla
				System.out.println(strLinea);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No se ha encontrado el fichero");
		}
		
	}

}









