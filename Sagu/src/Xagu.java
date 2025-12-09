import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Xagu extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int FILAS = 10;
	public static final int COLS = 10;
	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnCargar;
	private JButton btnBuscarSalida;

	private JLabel[][] casillas;
	private JPanel panelLaberinto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xagu frame = new Xagu();
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
	public Xagu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.NORTH);

		btnCargar = new JButton("Cargar Mapa");
		panelBotones.add(btnCargar);

		btnBuscarSalida = new JButton("Buscar Salida");
		panelBotones.add(btnBuscarSalida);

		btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);

		panelLaberinto = new JPanel();
		contentPane.add(panelLaberinto, BorderLayout.CENTER);
		panelLaberinto.setLayout(new GridLayout(FILAS, COLS, 0, 0));

		crearLabels();
		registrarEventos();
	}// Fin del constructor

	public void registrarEventos() {
		btnCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cargarMapa();
			}
		});
	}

	protected void cargarMapa() {
		// TODO Auto-generated method stub

		Scanner scFich;
		FileDialog dlgMapa;
		String linea;
		String fich;

		dlgMapa = new FileDialog(this, "Cargar Mapa", FileDialog.LOAD);
		// Antes de mostrar el dialogo, podemos configurar algunas cosas
		// dlgMapa.setDirectory(System.getProperty("user.home")+"\\Desktop");
		// //Directorio por defecto
		dlgMapa.setDirectory(".\\img"); // Directorio por defecto,
										// se pone punto porque indica que dentro
										// de la carpeta actual entre al img
		// añadir filtros
		dlgMapa.setVisible(true);
		fich = dlgMapa.getFile();
		
		if (fich!=null) {
			try {
				scFich = new Scanner(new File(dlgMapa.getDirectory() + fich));
				scFich=new Scanner(new File("./img/mapa1.txt"));
				int fila = 0;
				while (scFich.hasNext()) {
					//LEER UNA LINEA
					linea = scFich.nextLine();
					//PROCESARLA Linea
					for (int col = 0; col < COLS; col++) {
						//Si es "0" -> quitar * (vaciar casilla)
						//si es 1 -> Cargar imagen de muro.jpg
						//si es 2 -> Cargar imagen de Xagu.jpg
						if (linea.charAt(col) == '0') {
							casillas[fila][col].setText("");
							//que el mapa solo se active en uno mapa
							
						} if (linea.charAt(col) == '1') 
							//Cargar fichero de imagen
						{
							//casillas[fila][col].setIcon(new ImageIcon("./img/muro.jpg"));
							casillas[fila][col].setIcon(new ImageIcon(getClass().getResource("muro.jpg")));
						} if (linea.charAt(col) == '2') {
							casillas[fila][col].setIcon(new ImageIcon("./img/Xagu.jpg"));
						}
					} fila++;
				}
				scFich.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

//Vamos a crear objetos en ejecusion

	public void crearLabels() {
		JLabel lblAux;
		// Vamos a hacer un array bidemensional de JLabels

		casillas = new JLabel[FILAS][COLS];
		// CREAR LOS 100 JLABELS con sus caracteristicas
		// Texto,tamaño y posicion, color, etc....
		// Añadirlo al panel
		// Añadirlo al array
		for (int fila = 0; fila < FILAS; fila++) {
			for (int col = 0; col < COLS; col++) {
				lblAux = new JLabel("*");
				lblAux.setHorizontalAlignment(JLabel.CENTER);
				lblAux.setFont(new Font("Arial", Font.BOLD, 20));
				panelLaberinto.add(lblAux);
				casillas[fila][col] = lblAux;
			}
		}

	}

}
