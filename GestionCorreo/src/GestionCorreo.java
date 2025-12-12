import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GestionCorreo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtWeb;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnADD;
	private JCheckBox chckbxNewCheckBox;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JLabel lblEdad;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_1_1;
	private JList lstNombres;
	private JLabel txtNombres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCorreo frame = new GestionCorreo();
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
	public GestionCorreo() {
		setTitle("GestionCorreosAlmi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(65, 95, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(65, 123, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("Web:");
		lblNewLabel_1_1.setBounds(65, 151, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(134, 92, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(134, 120, 174, 20);
		contentPane.add(txtCorreo);
		
		txtWeb = new JTextField();
		txtWeb.setColumns(10);
		txtWeb.setBounds(134, 148, 86, 20);
		contentPane.add(txtWeb);
		
		btnADD = new JButton("Añadir");
		btnADD.setBounds(376, 147, 89, 23);
		contentPane.add(btnADD);
		
		chckbxNewCheckBox = new JCheckBox("Empleado");
		chckbxNewCheckBox.setBounds(368, 91, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBounds(527, 87, 316, 94);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 11, 46, 14);
		panelEmpleado.add(lblEdad);
		
		lblNewLabel_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_2.setBounds(10, 39, 68, 14);
		panelEmpleado.add(lblNewLabel_1_2);
		
		lblNewLabel_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_1_1_1.setBounds(10, 67, 46, 14);
		panelEmpleado.add(lblNewLabel_1_1_1);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(66, 11, 86, 20);
		panelEmpleado.add(txtEdad);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(66, 39, 174, 20);
		panelEmpleado.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(66, 67, 86, 20);
		panelEmpleado.add(txtTelefono);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 249, 156, 309);
		contentPane.add(scrollPane);
		
		lstNombres = new JList();
		scrollPane.setViewportView(lstNombres);
		
		txtNombres = new JLabel("Nombres:");
		txtNombres.setBounds(86, 225, 46, 14);
		contentPane.add(txtNombres);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(368, 249, 156, 309);
		contentPane.add(scrollPane_1);
		
		JList lstCorreos = new JList();
		scrollPane_1.setViewportView(lstCorreos);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(652, 249, 156, 309);
		contentPane.add(scrollPane_2);
		
		JList listWebs = new JList();
		scrollPane_2.setViewportView(listWebs);
		
		JLabel txtCorreos = new JLabel("Correos:");
		txtCorreos.setBounds(368, 225, 46, 14);
		contentPane.add(txtCorreos);
		
		JLabel txtWebs = new JLabel("Webs:");
		txtWebs.setBounds(652, 225, 46, 14);
		contentPane.add(txtWebs);

		registrarEventos();
		
	}//FIN DEL CONSTRUCTOR
	
	private void registrarEventos() {
		
		
		
	}
}
