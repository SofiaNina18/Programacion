import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Datos {
    private ArrayList<Pelicula> listaPeliculas;

    public Datos() {
        listaPeliculas = new ArrayList<>();
        cargarDatos();
    }

    public void cargarDatos() {
        try {
            File archivo = new File("recursos/peliculas.txt");
            if (!archivo.exists()) {
                archivo = new File("peliculas.txt"); 
            }
            
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String titulo = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    int anio = Integer.parseInt(scanner.nextLine().trim());
                    listaPeliculas.add(new Pelicula(titulo, anio));
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("No se puedo leer: " + e.getMessage());
        }}
    
    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
}