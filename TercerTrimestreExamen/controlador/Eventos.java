import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;

public class Eventos implements ActionListener {
    private Peliculas peliculas;
    private Datos datos;

    public Eventos(Peliculas peliculas, Datos datos) {
        this.peliculas = peliculas;
        this.datos = datos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        if (origen == peliculas.getBotonTodos()) {
            cargarPeliculasPorLetra(""); 
        } 
        else if (origen == peliculas.getBotonA() || origen == peliculas.getBotonE() || 
                 origen == peliculas.getBotonI() || origen == peliculas.getBotonO() || 
                 origen == peliculas.getBotonU()) {
            JButton botonPulsado = (JButton) origen;
            cargarPeliculasPorLetra(botonPulsado.getText());
        }
        else if (origen == peliculas.getBotonMoverDerecha()) {
            moverPeliculaADerecha();
        }
        else if (origen == peliculas.getBotonDibujar()) {
            dibujarEnCanvas();
        }
        else if (origen == peliculas.getBotonGuardar()) {
            guardarArchivo();
        }
        else if (origen == peliculas.getBotonSalir()) {
            System.exit(0);
        }
    }

    private void cargarPeliculasPorLetra(String letra) {
        peliculas.getModeloListaIzquierda().clear();
        for (Pelicula peli : datos.getListaPeliculas()) {
            if (letra.isEmpty() || peli.getTitulo().toUpperCase().startsWith(letra.toUpperCase())) {
                peliculas.getModeloListaIzquierda().addElement(peli.getTitulo());
            }
        }
    }

    private void moverPeliculaADerecha() {
        String seleccion = peliculas.getListaIzquierda().getSelectedValue();
        if (seleccion != null) {
            String anioSeleccionado = (String) peliculas.getComboAnios().getSelectedItem();
            String mover = anioSeleccionado.equals("Desconocido") ? "????" : anioSeleccionado;
            peliculas.getModeloListaDerecha().addElement(mover + " - " + seleccion);
        }}

    private void dibujarEnCanvas() {
        ArrayList<String> lineas = new ArrayList<>();
        for (int i = 0; i < peliculas.getModeloListaDerecha().getSize(); i++) {
            lineas.add(peliculas.getModeloListaDerecha().getElementAt(i));
        }
        peliculas.getAreaDibujo().setLineasADibujar(lineas);
        peliculas.getAreaDibujo().repaint();
    }

    private void guardarArchivo() {
        try {
            PrintWriter escribir = new PrintWriter("recursos/peliculas2.txt"); 
            escribir.println("Listado de peliculas posteriores a 2009:");
            int cont = 1; 
            
           for (int i = 0; i < peliculas.getModeloListaDerecha().getSize(); i++) {
                String linea = peliculas.getModeloListaDerecha().getElementAt(i);
                String[] partes = linea.split(" - ", 2);
                if (partes.length == 2 && !partes[0].equals("????")) {
                    int anio = Integer.parseInt(partes[0]);
                    if (anio > 2009) {
                        escribir.println(cont + ".- " + partes[1]);
                        cont++;
            }}} escribir.close(); 
            peliculas.getModeloListaDerecha().clear(); 
            
        } catch (Exception ex) {
            System.out.println("Error al guardar" + ex.getMessage());
        }}
}