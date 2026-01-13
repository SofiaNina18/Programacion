import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Ahorcado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPalabra;
	private JButton btnNueva;
	private JButton btnSalir;
	private ArrayList<String> arrayPalabras;
	private int numFallos;
	private Fichero fichero;
	
	
	private Teclado teclado;
	private AreaDibujo areaDibujo;
	private JPanel panelCentro;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado frame = new Ahorcado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ahorcado() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblPalabra = new JLabel("_ _ _ _ _ _ _ _ _ _ _");
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabra.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblPalabra, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva Palabra");
		panelSur.add(btnNueva);
		
		btnSalir = new JButton("Salir");
		panelSur.add(btnSalir);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		teclado = new Teclado();
		panelCentro.add(teclado);
		
		areaDibujo = new AreaDibujo();
		panelCentro.add(areaDibujo);
		
		fichero=new Fichero();
		arrayPalabras=fichero.cargarPalabras("palabras.txt");
		
		for (String string : arrayPalabras) {
			System.out.println(string);
		}
	}//FIN CONSTRUCTOR

	public final ArrayList<String> getArrayPalabras() {
		return arrayPalabras;
	}

	public final void setArrayPalabras(ArrayList<String> arrayPalabras) {
		this.arrayPalabras = arrayPalabras;
	}

	public final int getNumFallos() {
		return numFallos;
	}

	public final void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}

}
