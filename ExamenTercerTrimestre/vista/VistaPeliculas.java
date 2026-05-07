import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;

public class VistaPeliculas extends JFrame {
    private JButton botonTodos, botonA, botonE, botonI, botonO, botonU;
    private JButton botonMoverDerecha, botonDibujar, botonGuardar, botonSalir;
    private JList<String> listaIzquierda, listaDerecha;
    private DefaultListModel<String> modeloListaIzquierda, modeloListaDerecha;
    private JComboBox<String> comboAnios;
    private PanelDibujo panelDibujo;
    
    private ControladorEventos controlador;
    private ModeloDatos modelo;

    public VistaPeliculas() {
        setTitle("Peliculas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 588);

        
        modelo = new ModeloDatos();
        getContentPane().setLayout(null);

        
        botonTodos = new JButton("Todos");
        botonTodos.setBounds(25, 48, 245, 30);getContentPane().add(botonTodos);
        botonA = new JButton("A");
        botonA.setBounds(25, 81, 45, 30);getContentPane().add(botonA);
        botonE = new JButton("E");
        botonE.setBounds(75, 81, 45, 30);getContentPane().add(botonE);
        botonI = new JButton("I");
        botonI.setBounds(125, 81, 45, 30);getContentPane().add(botonI);
        botonO = new JButton("O");
        botonO.setBounds(175, 81, 45, 30);getContentPane().add(botonO);
        botonU = new JButton("U");
        botonU.setBounds(225, 81, 45, 30);getContentPane().add(botonU);

        
        modeloListaIzquierda = new DefaultListModel<>();
        modeloListaIzquierda.addElement("Inception");
        modeloListaIzquierda.addElement("Inside Out");
        modeloListaIzquierda.addElement("Iron Man 3");
        
        listaIzquierda = new JList<>(modeloListaIzquierda);
        JScrollPane scrollIzquierda = new JScrollPane(listaIzquierda);
        scrollIzquierda.setBounds(20, 122, 250, 300);
        getContentPane().add(scrollIzquierda);

        
        botonMoverDerecha = new JButton(">>");
        botonMoverDerecha.setBounds(280, 252, 60, 30);
        getContentPane().add(botonMoverDerecha);

        
        modeloListaDerecha = new DefaultListModel<>();
        listaDerecha = new JList<>(modeloListaDerecha);
        JScrollPane scrollDerecha = new JScrollPane(listaDerecha);
        scrollDerecha.setBounds(350, 122, 250, 300);
        getContentPane().add(scrollDerecha);

        
        botonDibujar = new JButton(">>");
        botonDibujar.setBounds(610, 252, 60, 30);
        getContentPane().add(botonDibujar);

        
        panelDibujo = new PanelDibujo();
        panelDibujo.setBounds(680, 122, 230, 300);
        panelDibujo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(panelDibujo);

        
        JLabel etiquetaAnio = new JLabel("Año:");
        etiquetaAnio.setBounds(50, 446, 40, 30);
        getContentPane().add(etiquetaAnio);

        comboAnios = new JComboBox<>();
        comboAnios.setBounds(90, 446, 130, 30);
        comboAnios.addItem("Desconocido");
        for (int i = 1930; i <= 2035; i++) {
            comboAnios.addItem(String.valueOf(i));
        }
        comboAnios.setSelectedItem("2026"); 
        getContentPane().add(comboAnios);

        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(426, 446, 100, 30);
        getContentPane().add(botonGuardar);

        botonSalir = new JButton("Salir");
        botonSalir.setBounds(240, 497, 100, 30);
        getContentPane().add(botonSalir);
        
        JLabel titulo = new JLabel("Cargar del fichero:");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
        titulo.setBounds(25, 21, 146, 14);
        getContentPane().add(titulo);
        

        
        controlador = new ControladorEventos(this, modelo);
        botonTodos.addActionListener(controlador);
        botonA.addActionListener(controlador);
        botonE.addActionListener(controlador);
        botonI.addActionListener(controlador);
        botonO.addActionListener(controlador);
        botonU.addActionListener(controlador);
        botonMoverDerecha.addActionListener(controlador);
        botonDibujar.addActionListener(controlador);
        botonGuardar.addActionListener(controlador);
        botonSalir.addActionListener(controlador);
    }

    
    public JButton getBotonTodos() { return botonTodos; }
    public JButton getBotonA() { return botonA; }
    public JButton getBotonE() { return botonE; }
    public JButton getBotonI() { return botonI; }
    public JButton getBotonO() { return botonO; }
    public JButton getBotonU() { return botonU; }
    public JButton getBotonMoverDerecha() { return botonMoverDerecha; }
    public JButton getBotonDibujar() { return botonDibujar; }
    public JButton getBotonGuardar() { return botonGuardar; }
    public JButton getBotonSalir() { return botonSalir; }
    public JList<String> getListaIzquierda() { return listaIzquierda; }
    public DefaultListModel<String> getModeloListaIzquierda() { return modeloListaIzquierda; }
    public DefaultListModel<String> getModeloListaDerecha() { return modeloListaDerecha; }
    public JComboBox<String> getComboAnios() { return comboAnios; }
    public PanelDibujo getPanelDibujo() { return panelDibujo; }

    public static void main(String[] args) {
        VistaPeliculas frame = new VistaPeliculas();
        frame.setVisible(true);
    }
}