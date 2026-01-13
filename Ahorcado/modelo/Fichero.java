import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
			e.printStackTrace();
			
		}
		return null;
		
		
	}
}
