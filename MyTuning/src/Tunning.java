import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Tunning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tunning frame = new Tunning();
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
	public Tunning() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Taller TuNing");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Enviar");
		panelSur.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		panelSur.add(btnNewButton);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		
		JPanel panelDatos = new JPanel();
		panelCentral.add(panelDatos);
		panelDatos.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_1);
		
		textField = new JTextField();
		panelDatos.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panelDatos.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Dirección:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panelDatos.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Provincia:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		panelDatos.add(comboBox);
		
		lblNewLabel_5 = new JLabel("Edad:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		panelDatos.add(comboBox_1);
		
		lblNewLabel_6 = new JLabel("Sexo:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDatos.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panelDatos.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("No especificar");
		panel.add(rdbtnNewRadioButton_2);
		
		JPanel panelPreferencias = new JPanel();
		panelCentral.add(panelPreferencias);
		panelPreferencias.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Preferencias");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPreferencias.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panelPreferencias.add(lblNewLabel_8);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Tunning");
		panelPreferencias.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Equipamiento");
		panelPreferencias.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Recambios");
		panelPreferencias.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Reparaciones");
		panelPreferencias.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Puesta a Punto");
		panelPreferencias.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Mantenimiento");
		panelPreferencias.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Competición");
		panelPreferencias.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Vehículos ocasión");
		panelPreferencias.add(chckbxNewCheckBox_7);
		
		JPanel panelComentarios = new JPanel();
		panelCentral.add(panelComentarios);
		panelComentarios.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("Comentarios");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComentarios.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		panelComentarios.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Comentarios: ");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComentarios.add(lblNewLabel_11);
		
		JTextArea textArea = new JTextArea();
		panelComentarios.add(textArea);
		
		JLabel lblNewLabel_13 = new JLabel("");
		panelComentarios.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		panelComentarios.add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("Pedidos:");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComentarios.add(lblNewLabel_12);
		
		JTextArea textArea_1 = new JTextArea();
		panelComentarios.add(textArea_1);

	}

}
