import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HolaMundo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTexto;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JButton btnSalir;
	private JButton btnMostrarTexto;
	private JButton btnSumar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HolaMundo frame = new HolaMundo(); //
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
	public HolaMundo() {
		setTitle("HolaMundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // que se cierre la pantalla
		setBounds(100, 100, 1031, 711); //Parametros de 2 en dos son la XY de la horiazontal y (ancho y alto)
		contentPane = new JPanel(); //
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Texto: ");
		lblNewLabel.setBounds(58, 74, 35, 14);
		contentPane.add(lblNewLabel);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(116, 71, 170, 20);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Número 1:");
		lblNewLabel_1.setBounds(58, 121, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número 2:");
		lblNewLabel_2.setBounds(58, 166, 58, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNum1 = new JTextField();
		txtNum1.setColumns(10);
		txtNum1.setBounds(116, 118, 170, 20);
		contentPane.add(txtNum1);
		
		txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		txtNum2.setBounds(116, 163, 170, 20);
		contentPane.add(txtNum2);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(152, 212, 89, 23);
		contentPane.add(btnSalir);
		
		btnMostrarTexto = new JButton("Mostrar");
		btnMostrarTexto.setBounds(296, 70, 89, 23);
		contentPane.add(btnMostrarTexto);
		
		btnSumar = new JButton("Sumar");
		btnSumar.setBounds(296, 117, 89, 23);
		contentPane.add(btnSumar);
		
		registrarEventos();

	}//FIN DEL CONSTRUCTOR
	
	public void registrarEventos() {
		//REGRISTAR EVENTO DEL BOTÓN SALIR
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(HolaMundo.this, "¿Estas seguro que quieres salir?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					
				System.exit(0);
				}
			}
			
		});
		//REGRISTAR EVENTO DEL BOTÓN MOSTRAR
		btnMostrarTexto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTexto.setText("Hola Mundo");
			}
		});
		//REGRISTAR EVENTO DEL BOTÓN SUMAR
		btnSumar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//OBTENER LOS DOS NUMEROS, SUMARLOS Y MOSTRAR EL RESULTADO EL JTextField SUPERIOR
				try {
					String textoNum1 = txtNum1.getText();
					String textoNum2 = txtNum2.getText();
					
					
					int num1 = Integer.parseInt(textoNum1);
					int num2 = Integer.parseInt(textoNum2);
					
					int resultado = num1 + num2;
					
					
					txtTexto.setText(String.valueOf(resultado)); 
					//txtTexto.setText(resultado +""); (otra forma)
					
				} catch (NumberFormatException ex) {
					
					txtTexto.setText("Introduce números válidos");
					JOptionPane.showMessageDialog(HolaMundo.this, "Tienes que introducir numeros enteros");
				}
			}
		});
		
		
	}
}
