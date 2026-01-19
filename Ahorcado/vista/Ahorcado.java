import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

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
	
	private EventosAhorcado eventosAhorcado;
	

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
		setTitle("AlmiAhorcado");
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
		btnNueva.setEnabled(false);
		panelSur.add(btnNueva);
		
		btnSalir = new JButton("Salir");
		panelSur.add(btnSalir);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		teclado=new Teclado(this);
		panelCentro.add(teclado);
		
		areaDibujo=new AreaDibujo(this);
		panelCentro.add(areaDibujo);
		
		eventosAhorcado=new EventosAhorcado(this);
		
		fichero=new Fichero();
		arrayPalabras=fichero.cargarPalabras("palabras.txt");
		
		elegirPalabra();
	}

	public void elegirPalabra() {
		Random r;
		String palabra;
		int posicion;
		if(arrayPalabras.size()==0) {
			JOptionPane.showMessageDialog(null, "No quedan palabras");
			return;
		}
		//ELIGE UNA PALABRA AL AZAR DEL ARRAYLIST
		r=new Random();
		posicion=r.nextInt(arrayPalabras.size());
		palabra=arrayPalabras.get(posicion);
		//LA ELIMINA DEL ARRAYLIST
		arrayPalabras.remove(posicion);
		//REINICIA LOS BOTONES (COLOR Y ENABLED)
		teclado.estadoTeclado(true);
		//REINICIA EL CANVAS (REINICIAR FALLOS Y REPAINT)
		numFallos=0;
		areaDibujo.repaint();
		//PONE TANTOS GUIONES (SEGUIDOS DE UN ESPACIO) COMO LETRAS TENGA LA PALABRA
		lblPalabra.setText("");
		for(int i=0;i<palabra.length();i++) {
			lblPalabra.setText(lblPalabra.getText()+"_ ");
		}
		teclado.setPalabra(palabra);
	}
	
	
	//GETTERS / SETTERS
	public ArrayList<String> getArrayPalabras() {
		return arrayPalabras;
	}

	public void setArrayPalabras(ArrayList<String> arrayPalabras) {
		this.arrayPalabras = arrayPalabras;
	}

	public int getNumFallos() {
		return numFallos;
	}

	public void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}

	public JLabel getLblPalabra() {
		return lblPalabra;
	}

	public void setLblPalabra(JLabel lblPalabra) {
		this.lblPalabra = lblPalabra;
	}

	public JButton getBtnNueva() {
		return btnNueva;
	}

	public void setBtnNueva(JButton btnNueva) {
		this.btnNueva = btnNueva;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	public void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}

}
