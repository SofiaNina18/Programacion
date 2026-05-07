import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Peliculas extends JFrame {
    private JButton botonTodos; 
    private JButton botonA; 
    private JButton botonE; 
    private JButton botonI; 
    private JButton botonO; 
    private JButton botonU;
    private JButton botonMoverDerecha; 
    private JButton botonDibujar; 
    private JButton botonGuardar;
    private JButton botonSalir;
    private JList<String> listaIzquierda;
    private JList<String> listaDerecha;
    private DefaultListModel<String> modeloListaIzquierda;
    private DefaultListModel<String> modeloListaDerecha;
    private JComboBox<String> comboAnios;
    
    private AreaDibujo areaDibujo;
    private Eventos eventos;
    private Datos datos;

    public Peliculas() {
    	setTitle("Peliculas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 588);

        datos = new Datos();
        getContentPane().setLayout(null);

        JButton botonTodos = new JButton("Todos");
        botonTodos.setBounds(25, 48, 245, 30);
        getContentPane().add(botonTodos);
        
        JButton botonA = new JButton("A");
        botonA.setBounds(25, 81, 45, 30);
        getContentPane().add(botonA);
        
        JButton botonE = new JButton("E");
        botonE.setBounds(75, 81, 45, 30);
        getContentPane().add(botonE);
        
        JButton botonI = new JButton("I");
        botonI.setBounds(125, 81, 45, 30);
        getContentPane().add(botonI);
        
        JButton botonO = new JButton("O");
        botonO.setBounds(175, 81, 45, 30);
        getContentPane().add(botonO);
        
        JButton botonU = new JButton("U");
        botonU.setBounds(225, 81, 45, 30);
        getContentPane().add(botonU);

        modeloListaIzquierda = new DefaultListModel<>();
        modeloListaIzquierda.addElement("Inception");
        modeloListaIzquierda.addElement("Inside Out");
        modeloListaIzquierda.addElement("Iron Man 3");
        
        listaIzquierda = new JList<>(modeloListaIzquierda);
        JScrollPane scrollIzquierda = new JScrollPane(listaIzquierda);
        scrollIzquierda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scrollIzquierda.setBounds(20, 122, 250, 300);
        getContentPane().add(scrollIzquierda);

        botonMoverDerecha = new JButton(">>");
        botonMoverDerecha.setBounds(280, 252, 60, 30);
        getContentPane().add(botonMoverDerecha);

        modeloListaDerecha = new DefaultListModel<>();
        listaDerecha = new JList<>(modeloListaDerecha);
        JScrollPane scrollDerecha = new JScrollPane(listaDerecha);
        scrollDerecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scrollDerecha.setBounds(350, 122, 250, 300);
        getContentPane().add(scrollDerecha);

        botonDibujar = new JButton(">>");
        botonDibujar.setBounds(610, 252, 60, 30);
        getContentPane().add(botonDibujar);

        areaDibujo = new AreaDibujo();
        areaDibujo.setBounds(680, 122, 230, 300);
        areaDibujo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(areaDibujo);

        JLabel etiquetaAnio = new JLabel("Año:");
        etiquetaAnio.setBounds(50, 446, 40, 30);
        getContentPane().add(etiquetaAnio);

        comboAnios = new JComboBox<>();
        comboAnios.setBounds(90, 446, 130, 30);
        comboAnios.addItem("Desconocido");
        
        for (int i = 1930; i <= 2035; i++) {
            comboAnios.addItem(String.valueOf(i));}
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
        
        

        eventos = new Eventos(this, datos);
        botonTodos.addActionListener(eventos);
        botonA.addActionListener(eventos);
        botonE.addActionListener(eventos);
        botonI.addActionListener(eventos);
        botonO.addActionListener(eventos);
        botonU.addActionListener(eventos);
        botonMoverDerecha.addActionListener(eventos);
        botonDibujar.addActionListener(eventos);
        botonGuardar.addActionListener(eventos);
        botonSalir.addActionListener(eventos);
    }
    
    //GETERS AND SETTERS
  
	public JButton getBotonTodos() {
		return botonTodos;
	}

	public void setBotonTodos(JButton botonTodos) {
		this.botonTodos = botonTodos;
	}

	public JButton getBotonA() {
		return botonA;
	}

	public void setBotonA(JButton botonA) {
		this.botonA = botonA;
	}

	public JButton getBotonE() {
		return botonE;
	}

	public void setBotonE(JButton botonE) {
		this.botonE = botonE;
	}

	public JButton getBotonI() {
		return botonI;
	}

	public void setBotonI(JButton botonI) {
		this.botonI = botonI;
	}

	public JButton getBotonO() {
		return botonO;
	}

	public void setBotonO(JButton botonO) {
		this.botonO = botonO;
	}

	public JButton getBotonU() {
		return botonU;
	}

	public void setBotonU(JButton botonU) {
		this.botonU = botonU;
	}

	public JButton getBotonMoverDerecha() {
		return botonMoverDerecha;
	}

	public void setBotonMoverDerecha(JButton botonMoverDerecha) {
		this.botonMoverDerecha = botonMoverDerecha;
	}

	public JButton getBotonDibujar() {
		return botonDibujar;
	}

	public void setBotonDibujar(JButton botonDibujar) {
		this.botonDibujar = botonDibujar;
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}

	public void setBotonSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}

	public JList<String> getListaIzquierda() {
		return listaIzquierda;
	}

	public void setListaIzquierda(JList<String> listaIzquierda) {
		this.listaIzquierda = listaIzquierda;
	}

	public DefaultListModel<String> getModeloListaIzquierda() {
		return modeloListaIzquierda;
	}

	public void setModeloListaIzquierda(DefaultListModel<String> modeloListaIzquierda) {
		this.modeloListaIzquierda = modeloListaIzquierda;
	}

	public DefaultListModel<String> getModeloListaDerecha() {
		return modeloListaDerecha;
	}

	public void setModeloListaDerecha(DefaultListModel<String> modeloListaDerecha) {
		this.modeloListaDerecha = modeloListaDerecha;
	}

	public JComboBox<String> getComboAnios() {
		return comboAnios;
	}

	public void setComboAnios(JComboBox<String> comboAnios) {
		this.comboAnios = comboAnios;
	}

	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	public void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}
	
	public static void main(String[] args) {
        Peliculas ventanaJframe = new Peliculas();
        ventanaJframe.setVisible(true);
    }
}