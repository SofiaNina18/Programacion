import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Time;
import java.util.Scanner;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TresEnRaya extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int NO_FIN=0;
	public static final int TABLAS=1;
	public static final int GANADOR=2;
	
	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JButton btnNuevaPartida;
	private JButton btnSalir;
	private JButton btnBlue;
	private JButton btnRed;
	private JButton []arrayBotones;
	private boolean turnoJugador1 = true;
	private boolean juegoActivo = true;
	private int turno;
	private JColorChooser dlgColor;
	
	private Timer reloj;
	private int pos1, pos2, pos3;
	
	// Fields for blinking the winning line
	private Timer blinkTimer;
	private Color[] originalBlinkColors;
	private boolean blinkState = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya frame = new TresEnRaya();
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
	public TresEnRaya() {
		setTitle("Tres En Raya Almi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 5, 0, 0));
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn1);
		
		btn2 = new JButton("");
		contentPane.add(btn2);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn3);
		
		lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJugador1);
		
		btnRed = new JButton("Red");
		btnRed.setForeground(Color.RED);
		btnRed.setBackground(Color.RED);
		contentPane.add(btnRed);
		
		btn4 = new JButton("");
		contentPane.add(btn4);
		
		btn5 = new JButton("");
		contentPane.add(btn5);
		
		btn6 = new JButton("");
		contentPane.add(btn6);
		
		lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJugador2);
		
		btnBlue = new JButton("Blue");
		btnBlue.setForeground(new Color(0, 0, 255));
		btnBlue.setBackground(new Color(0, 0, 255));
		contentPane.add(btnBlue);
		
		btn7 = new JButton("");
		contentPane.add(btn7);
		
		btn8 = new JButton("");
		contentPane.add(btn8);
		
		btn9 = new JButton("");
		contentPane.add(btn9);
		
		btnNuevaPartida = new JButton("Nueva Partida");
		contentPane.add(btnNuevaPartida);
		
		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);
	
		arrayBotones=new JButton[9];
		turno=1;
		
		llenarArray(arrayBotones);
		registrarEventos();
		estadoBotones(false);

	}//FIN DEL CONSTRUCTOR
	
	
	public void registrarEventos() {
		reloj=new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//CÓDIGO PARA QUE PARPADEEN LAS FICHAS QUE HAN HECHO 3 EN RAYA
				
				if(turno==1) {
					if (arrayBotones[pos1].getBackground().equals(btnRed.getBackground())) {
						arrayBotones[pos1].setBackground(null);
						arrayBotones[pos2].setBackground(null);
						arrayBotones[pos3].setBackground(null);
						reloj.setDelay(1000);
						}else {
							arrayBotones[pos1].setBackground(btnRed.getBackground());
							arrayBotones[pos2].setBackground(btnRed.getBackground());
							arrayBotones[pos3].setBackground(btnRed.getBackground());
						reloj.setDelay(200);
						}
					}else {
						if (arrayBotones[pos1].getBackground().equals(btnBlue.getBackground())) {
							arrayBotones[pos1].setBackground(null);
							arrayBotones[pos2].setBackground(null);
							arrayBotones[pos3].setBackground(null);
							reloj.setDelay(1000);
							}else {
								arrayBotones[pos1].setBackground(btnBlue.getBackground());
								arrayBotones[pos2].setBackground(btnBlue.getBackground());
								arrayBotones[pos3].setBackground(btnBlue.getBackground());
							reloj.setDelay(200);
							}
				}
				
			}
		});
		
		
		
		//REGRISTAR EVENTO DEL BOTÓN SALIR
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(TresEnRaya.this, "¿Estas seguro que quieres salir?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					
				System.exit(0);
				}
			}
			
		});
		
		btnNuevaPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//habilitar los 9 botones
				estadoBotones(true);
				restaurarColor();
				//deshabilarse a si mismo
				//btnNuevaPartida.setEnabled(false);
				//desabilitar los botones de los colores
				btnRed.setEnabled(false);
				btnBlue.setEnabled(false);
				
				elegirJugadores();
			}
		});
		
		
		
		btnRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlgColor=new JColorChooser();
				Color color;
				color=dlgColor.showDialog(rootPane, "Elige Color", btnRed.getBackground());
				if(color!=null) {
					btnRed.setBackground(color);
				}
			}
		});
		
		btnBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlgColor=new JColorChooser();
				Color color;
				color=dlgColor.showDialog(rootPane, "Elige Color", btnBlue.getBackground());
				if(color!=null) {
					btnBlue.setBackground(color);
				}
			}
		});
		for (JButton boton : arrayBotones) {
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int resultado;
					// desabilitar el botón
					boton.setEnabled(false);
					//poner el color segun el turno
					if(turno==1) {
						boton.setBackground(btnRed.getBackground());
					}else {
						boton.setBackground(btnBlue.getBackground());
					}
					//comprobar fin de juego
					resultado=comprobarFin();
					if (resultado==TABLAS) {
						JOptionPane.showMessageDialog(TresEnRaya.this, "La partida ha terminado en tablas");
					}else if (resultado==GANADOR){
						reloj.start();
						btnRed.setEnabled(true);
						btnBlue.setEnabled(true);
						estadoBotones(false);
						if (turno==1) {
							JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador:" + lblJugador1.getText());
						}else {
							JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador:" + lblJugador2.getText());
						}
						btnNuevaPartida.setEnabled(true);
					}
					//cambiar el turno
					if (turno==1) {
						turno=2;
					}else {
						turno=1;
					}
				}
			});            
		}

		
		
	}//FIN DE RESGISTRAR EVENTOS
	
	public void resaltarNombre() {
		if (turno==1) {
			//RESALTAR EL NOMBRE DEL JUGADOR 
			lblJugador1.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 14));
			lblJugador1.setForeground(btnRed.getBackground());
			//quitar EL RESALTADO AL OTRO JUGADOR
			lblJugador2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblJugador2.setForeground(Color.BLACK);
		}else {
			lblJugador2.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 14));
			lblJugador2.setForeground(btnBlue.getBackground());
			//quitar EL RESALTADO AL OTRO JUGADOR
			lblJugador1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblJugador1.setForeground(Color.BLACK);
		}
	}
	
	public int comprobarFin() {
		
	//1º COMPROBAR SI HAY 3 EN RAYA
		//COMPROBAR LAS 3 FILAS
		for(int fila=0; fila<3; fila++) {
			if (arrayBotones[fila*3+0].getBackground().equals(arrayBotones[fila*3+1].getBackground())&& 
					arrayBotones[fila*3+0].getBackground().equals(arrayBotones[fila*3+2].getBackground())&&
					!arrayBotones[fila*3+0].getBackground().equals(btnSalir.getBackground())) {
				pos1=fila*3;
				pos2=fila*3+1;
				pos3=fila*3+2;
				
				return GANADOR;
				}
		}
		for(int columna=0; columna<3; columna++) {
			if (arrayBotones[columna].getBackground().equals(arrayBotones[columna+3].getBackground())&& 
					arrayBotones[columna].getBackground().equals(arrayBotones[columna+6].getBackground())&&
					!arrayBotones[columna].getBackground().equals(btnSalir.getBackground())) {
				pos1=columna;
				pos2=columna+3;
				pos3=columna+6;
				
				return GANADOR;
				}
		}
		//COMPROBAR DIAGONALES
		
			if (arrayBotones[0].getBackground().equals(arrayBotones[4].getBackground())&& 
					arrayBotones[0].getBackground().equals(arrayBotones[8].getBackground())&&
					!arrayBotones[0].getBackground().equals(btnSalir.getBackground())) {
				pos1=0;
				pos2=4;
				pos3=8;
				
				return GANADOR;
				}
			if (arrayBotones[2].getBackground().equals(arrayBotones[4].getBackground())&& 
					arrayBotones[2].getBackground().equals(arrayBotones[6].getBackground())&&
					!arrayBotones[2].getBackground().equals(btnSalir.getBackground())) {
				pos1=2;
				pos2=4;
				pos3=6;
				return GANADOR;
				}
		//COMPROBAR TABLAS
			int activadas = 0;
			for (int i=0; i<arrayBotones.length;i++ ) {
				if (arrayBotones[i].isEnabled()) {
					activadas++;
					
				}
			}
			if (activadas==0){
				return TABLAS;
			}
		return NO_FIN;
		
	}
	protected void elegirJugadores() {
		//ELEGIR DOS JUGADORES DEL FICHERO JUGADORES.TXT DE FORMA ALEATORIA Y PONER SUS
		//NOMBRES EN LOS DOS JTEXTFIELD
		Scanner sc;
		String linea, ruta;
		int numJugadores, j1, j2;
		try {
			sc=new Scanner(new File("Jugadores.txt"));
			sc.nextLine();
			numJugadores=sc.nextInt();
			sc.nextLine();
			//generar dos numeros aleatorios (sin repetir) entre 1 y numJugadores
			j1=(int)(Math.random()*numJugadores+1);
			do {
				j2=(int)(Math.random()*numJugadores+1);
			} while (j1==j2);
			for (int i = 1; i <= numJugadores; i++) {
				linea=sc.nextLine();
				if(j1==i) {
					lblJugador1.setText(linea);
				}
				if(j2==i) {
					lblJugador2.setText(linea);
				}
				
			}
			sc.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
	}

	//LLENAR EL ARRAY CON BOTONES DEL 1 AL 9 DEL TRES EN RAYA

	private void llenarArray(JButton[] arrayBotones2) {
		
		arrayBotones2[0] = btn1;
		arrayBotones2[1] = btn2;
		arrayBotones2[2] = btn3;
		arrayBotones2[3] = btn4;
		arrayBotones2[4] = btn5;
		arrayBotones2[5] = btn6;
		arrayBotones2[6] = btn7;
		arrayBotones2[7] = btn8;
		arrayBotones2[8] = btn9;
		
		
	}
	
	//FUNCION QUE HABILITE Y PARA DESABILITAR TODOS LOS BOTONES DEL JUEGO
	public void estadoBotones(boolean estado) {
		for (int i=0; i<arrayBotones.length;i++) {
			arrayBotones[i].setEnabled(estado);

		}
	}
	
	public void restaurarColor() {
		for (int i=0; i<arrayBotones.length;i++) {
			arrayBotones[i].setBackground(null);
		//	arrayBotones[i].setBackground(btnSalir.getBackground()); (para agarar el color de uno y poner en el otro)

		}
	}
	
	
	
	
	
}