import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {

	public Fichero() {
		
	}
	
	public ArrayList<String> cargarPalabras(String fichero) {
		Scanner scFichero;
		ArrayList<String> palabras;
		palabras=new ArrayList<String>();
		try {
			scFichero=new Scanner(new File("./recursos/"+fichero));
			while(scFichero.hasNext()) {
				palabras.add(scFichero.nextLine());
			}
			scFichero.close();
			return palabras;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
