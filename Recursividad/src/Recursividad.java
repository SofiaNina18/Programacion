import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Recursividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnFact;
	private JLabel txtNum;
	private JLabel TxtBase;
	private JLabel txtFact;
	private JTextField textField_3;
	private JTextField textField_2;
	private JButton btnPotencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recursividad frame = new Recursividad();
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
	public Recursividad() {
		setTitle("Recursividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNum = new JLabel("Numero");
		txtNum.setBounds(67, 49, 46, 14);
		contentPane.add(txtNum);
		
		textField = new JTextField();
		textField.setBounds(123, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtFact = new JLabel("Factorial");
		txtFact.setBounds(229, 49, 46, 14);
		contentPane.add(txtFact);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 46, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnFact = new JButton("Calcular Fact");
		btnFact.setBounds(402, 45, 89, 23);
		contentPane.add(btnFact);
		
		TxtBase = new JLabel("Base:");
		TxtBase.setBounds(67, 98, 46, 14);
		contentPane.add(TxtBase);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 95, 86, 20);
		contentPane.add(textField_2);
		
		JLabel TxtExponente = new JLabel("Exponente:");
		TxtExponente.setBounds(67, 144, 46, 14);
		contentPane.add(TxtExponente);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 141, 86, 20);
		contentPane.add(textField_3);
		
		JLabel TxtPotencia = new JLabel("Potencia:");
		TxtPotencia.setBounds(229, 120, 46, 14);
		contentPane.add(TxtPotencia);
		
		btnPotencia = new JButton("Calcular Potencia");
		btnPotencia.setBounds(285, 116, 149, 23);
		contentPane.add(btnPotencia);
		
		registrarEventos();
	}//FIN DEL CONSTRUCTOR
	
	public double potencia(int base, int exponente) {
		if (exponente == 0) {
			return 1;
		} 
		return base * potencia(base, exponente - 1);
	}

	private void registrarEventos() {
		btnPotencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int base, exponente;
				double resultado;
				
				//COGER EL VALOR DEL NUMERO
				try {
				
				base = Integer.parseInt(textField_2.getText().trim());
				exponente = Integer.parseInt(textField_3.getText().trim());
				
				resultado = Math.pow(base, exponente);
				
				
				
				JOptionPane.showMessageDialog(Recursividad.this, "El resultado es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
			 	
			 	}catch (NumberFormatException ex) {
 				JOptionPane.showMessageDialog(Recursividad.this, "Introduce un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
 				return;
 			}
			}
		});
		btnFact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int num;
            	double resultado;
            	
            	//COGER EL VALOR DEL NUMERO
            	try {
            	// Leer desde el campo de texto donde el usuario escribe el número
            	num = Integer.parseInt(textField.getText().trim());
            	// Comprobar que no sea negativo
            	if (num < 0) {
            		JOptionPane.showMessageDialog(Recursividad.this, "Introduce un número no negativo.", "Error", JOptionPane.ERROR_MESSAGE);
            		return;
            	}else {
					textField_1.setText(factorial(num) + "");
				}
            	
            	/*resultado = factorial(num);
            	
            	textField_1.setText(resultado + ""); */
             	
             	}catch (NumberFormatException ex) {
 				JOptionPane.showMessageDialog(Recursividad.this, "Introduce un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
 				return;
 			}
            }
		});
	}//FIN DEL METODO REGISTRAR EVENTOS
	
	public double factorial(int num) {
		double resultado;
		if (num == 0 || num == 1) {
			return 1;
		} 
		resultado = num * factorial(num - 1);
		return resultado;
			
		
	}
}