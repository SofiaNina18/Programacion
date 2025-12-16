import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
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
	private JButton btnAdd;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JCheckBox chkEmpleado;
	private JList<String> lstNombres;
	private JList<String> lstCorreos;
	private JList<String> listWebs;

	private DefaultListModel<String> modeloNombres, modeloCorreos, modeloWebs;
	private JPanel panelEmpleado;
	private ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();

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
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(65, 95, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(65, 123, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Web:");
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
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(376, 147, 89, 23);
		contentPane.add(btnAdd);
		
		chkEmpleado = new JCheckBox("Empleado");
		chkEmpleado.setSelected(true);
		chkEmpleado.setBounds(368, 91, 97, 23);
		contentPane.add(chkEmpleado);
		
		panelEmpleado = new JPanel();
		panelEmpleado.setBounds(527, 87, 316, 94);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 11, 56, 14);
		panelEmpleado.add(lblEdad);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_2.setBounds(10, 39, 86, 14);
		panelEmpleado.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_1_1_1.setBounds(10, 67, 72, 14);
		panelEmpleado.add(lblNewLabel_1_1_1);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(74, 11, 86, 20);
		panelEmpleado.add(txtEdad);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(74, 39, 174, 20);
		panelEmpleado.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(74, 67, 86, 20);
		panelEmpleado.add(txtTelefono);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 249, 156, 309);
		contentPane.add(scrollPane);
		
		lstNombres = new JList<String>();
		scrollPane.setViewportView(lstNombres);
		//INSTANCIAR EL MODELO
		modeloNombres = new DefaultListModel<String>();
		//ASOCIAR EL MODELO CON EL JLIST CORRESPONDIENTE
		lstNombres.setModel(modeloNombres);
		
		JLabel txtNombres = new JLabel("Nombres:");
		txtNombres.setBounds(86, 225, 86, 14);
		contentPane.add(txtNombres);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(368, 249, 156, 309);
		contentPane.add(scrollPane_1);
		
		lstCorreos = new JList<String>();
		scrollPane_1.setViewportView(lstCorreos);
		modeloCorreos = new DefaultListModel<String>();
		lstCorreos.setModel(modeloCorreos);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(652, 249, 156, 309);
		contentPane.add(scrollPane_2);
		
		listWebs = new JList<String>();
		scrollPane_2.setViewportView(listWebs);
		modeloWebs = new DefaultListModel<String>();
		listWebs.setModel(modeloWebs);
		
		JLabel txtCorreos = new JLabel("Correos:");
		txtCorreos.setBounds(368, 225, 97, 14);
		contentPane.add(txtCorreos);
		
		JLabel txtWebs = new JLabel("Webs:");
		txtWebs.setBounds(652, 225, 86, 14);
		contentPane.add(txtWebs);

		registrarEventos();
		arrayPersonas = new ArrayList<Persona>();
		
		
	}//FIN DEL CONSTRUCTOR
	
	private void registrarEventos() {
		chkEmpleado.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				panelEmpleado.setVisible(chkEmpleado.isSelected());
				
				/*if(chkEmpleado.isSelected()) {
					panelEmpleado.setVisible(true);
				}else {
					panelEmpleado.setVisible(false);
				}*/
				/*si está marcado
					pongo visible el panel
				sino 
					pongo invisible el panel*/
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			Persona per;
			Empleado emp;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//EL NOMBRE ES OBLIGATORIO
				if(txtNombre.getText().trim().equals("")) {
					txtNombre.requestFocus();
					return; 
				}
				//CREAR UN OBJETO DE CLASE PERSONA CON LOS DATOS DE LOS JTextField Y AÑADIRLO AL ARRAYLIST
					per = new Persona( txtNombre.getText().trim(),
									   txtCorreo.getText().trim(),
									   txtWeb.getText().trim() );
					if(chkEmpleado.isSelected()) {	
						try {
							emp = new Empleado( per,
												Integer.parseInt( txtEdad.getText().trim() ),
												txtDireccion.getText().trim(),
												txtTelefono.getText().trim() );
							arrayPersonas.add(emp);
						}catch(NumberFormatException nfe) {
							txtEdad.requestFocus();
							txtEdad.selectAll();
							return;
						}
					}else {//Que es una persona normal
						arrayPersonas.add(per); 
					}
				
				
				//AÑADIR LOS DATOS DE LOS JTEXTFIELD (O DEL OBJETO PERSONA) AL JList
				modeloNombres.addElement( per.getNombre() );
				if (per.getCorreo().equals("")) {
					modeloCorreos.addElement(" ");
				} else {
					modeloCorreos.addElement( per.getCorreo() );
				}
				if (per.getWeb().equals("")) {
					modeloWebs.addElement(" ");
				} else {
					modeloWebs.addElement( per.getWeb() );}
				txtNombre.setText("");
				txtCorreo.setText("");
				txtWeb.setText("");
				txtEdad.setText("");
				txtDireccion.setText("");
				txtTelefono.setText("");
				txtNombre.requestFocus();
				
			
				
				
			}
		});
			
			
				
	}
		
	
}
