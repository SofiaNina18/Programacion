import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;

public class ControladorEventos implements ActionListener {
    private VistaPeliculas vista;
    private ModeloDatos modelo;

    public ControladorEventos(VistaPeliculas vista, ModeloDatos modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        
        if (origen == vista.getBotonTodos()) {
            cargarPeliculasPorLetra(""); 
        } 
        
        else if (origen == vista.getBotonA() || origen == vista.getBotonE() || 
                 origen == vista.getBotonI() || origen == vista.getBotonO() || origen == vista.getBotonU()) {
            JButton botonPulsado = (JButton) origen;
            cargarPeliculasPorLetra(botonPulsado.getText());
        }
       
        else if (origen == vista.getBotonMoverDerecha()) {
            moverPeliculaADerecha();
        }
        
        else if (origen == vista.getBotonDibujar()) {
            dibujarEnCanvas();
        }
        
        else if (origen == vista.getBotonGuardar()) {
            guardarArchivo();
        }
        
        else if (origen == vista.getBotonSalir()) {
            System.exit(0);
        }
    }

   

    private void cargarPeliculasPorLetra(String letra) {
        vista.getModeloListaIzquierda().clear();
        for (Pelicula p : modelo.getListaPeliculas()) {
            if (letra.isEmpty() || p.getTitulo().toUpperCase().startsWith(letra.toUpperCase())) {
                vista.getModeloListaIzquierda().addElement(p.getTitulo());
            }
        }
    }

    private void moverPeliculaADerecha() {
        String seleccion = vista.getListaIzquierda().getSelectedValue();
        if (seleccion != null) {
            String anioSeleccionado = (String) vista.getComboAnios().getSelectedItem();
            String prefijo = anioSeleccionado.equals("Desconocido") ? "????" : anioSeleccionado;
            
            vista.getModeloListaDerecha().addElement(prefijo + " - " + seleccion);
        }
    }

    private void dibujarEnCanvas() {
        ArrayList<String> lineas = new ArrayList<>();
        for (int i = 0; i < vista.getModeloListaDerecha().getSize(); i++) {
            lineas.add(vista.getModeloListaDerecha().getElementAt(i));
        }
        vista.getPanelDibujo().setLineasADibujar(lineas);
        vista.getPanelDibujo().repaint();
    }

   
 
    private void guardarArchivo() {
        try {
           
            PrintWriter escritor = new PrintWriter("recursos/peliculas2.txt"); 
            escritor.println("Listado de peliculas posteriores a 2009:");
            
            int contador = 1; 
            
           
            for (int i = 0; i < vista.getModeloListaDerecha().getSize(); i++) {
                String linea = vista.getModeloListaDerecha().getElementAt(i);
                
               
                String[] partes = linea.split(" - ", 2);
                
              
                if (partes.length == 2 && !partes[0].equals("????")) {
                    int anio = Integer.parseInt(partes[0]);
                    
                    
                    if (anio > 2009) {
                        escritor.println(contador + ".- " + partes[1]);
                        contador++;
                    }
                }
            }
            escritor.close(); 
            
            
            vista.getModeloListaDerecha().clear(); 
            
        } catch (Exception ex) {
            System.out.println("Error al guardar: " + ex.getMessage());
        }
    }
}