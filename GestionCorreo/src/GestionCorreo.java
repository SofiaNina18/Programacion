import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private JList<String> lstWebs;
	private DefaultListModel<String> modeloNombres, modeloCorreos, modeloWebs;
	private JPanel panelEmpleado;
	private ArrayList<Persona> arrayPersonas;
	

	private JButton btnCargarBD;
	private JButton btnGuardarBD;

	private BaseDatos bd;
	private JButton btnEnviarMail;
	private EnviarMail enviarMail;

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
		setTitle("GestionCorreoALMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(44, 41, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(44, 71, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Web:");
		lblNewLabel_2.setBounds(44, 96, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtNombre = new JTextField();
		txtNombre.setBounds(100, 38, 111, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(100, 68, 198, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		txtWeb = new JTextField();
		txtWeb.setBounds(100, 93, 115, 20);
		contentPane.add(txtWeb);
		txtWeb.setColumns(10);

		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(335, 92, 89, 23);
		contentPane.add(btnAdd);

		chkEmpleado = new JCheckBox("Empleado");
		chkEmpleado.setSelected(true);
		chkEmpleado.setBounds(335, 37, 97, 23);
		contentPane.add(chkEmpleado);

		panelEmpleado = new JPanel();
		panelEmpleado.setBounds(491, 22, 297, 111);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Edad:");
		lblNewLabel_3.setBounds(22, 11, 46, 14);
		panelEmpleado.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Dirección:");
		lblNewLabel_4.setBounds(22, 45, 60, 14);
		panelEmpleado.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Teléfono:");
		lblNewLabel_5.setBounds(22, 70, 46, 14);
		panelEmpleado.add(lblNewLabel_5);

		txtEdad = new JTextField();
		txtEdad.setBounds(80, 8, 53, 20);
		panelEmpleado.add(txtEdad);
		txtEdad.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(80, 42, 165, 20);
		panelEmpleado.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(78, 73, 86, 20);
		panelEmpleado.add(txtTelefono);
		txtTelefono.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 165, 164, 258);
		contentPane.add(scrollPane);

		lstNombres = new JList<String>();
		scrollPane.setViewportView(lstNombres);
		//INSTANCIAR EL MODELO
		modeloNombres=new DefaultListModel<String>();
		//ASOCIAR EL MODELO CON EL JLIST CORRESPONDIENTE
		lstNombres.setModel(modeloNombres);

		JLabel lblNewLabel_6 = new JLabel("Nombres:");
		lblNewLabel_6.setBounds(88, 148, 46, 14);
		contentPane.add(lblNewLabel_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(303, 165, 164, 252);
		contentPane.add(scrollPane_1);

		lstCorreos = new JList<String>();
		scrollPane_1.setViewportView(lstCorreos);
		modeloCorreos=new DefaultListModel<String>();
		lstCorreos.setModel(modeloCorreos);

		JLabel lblNewLabel_7 = new JLabel("Correos:");
		lblNewLabel_7.setBounds(303, 148, 46, 14);
		contentPane.add(lblNewLabel_7);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(496, 165, 164, 252);
		contentPane.add(scrollPane_2);

		lstWebs = new JList<String>();
		scrollPane_2.setViewportView(lstWebs);
		modeloWebs=new DefaultListModel<String>();
		lstWebs.setModel(modeloWebs);

		JLabel lblNewLabel_8 = new JLabel("Webs:");
		lblNewLabel_8.setBounds(501, 148, 46, 14);
		contentPane.add(lblNewLabel_8);

		btnGuardarBD = new JButton("Guardar BD");
		btnGuardarBD.setBounds(699, 195, 105, 23);
		contentPane.add(btnGuardarBD);

		btnCargarBD = new JButton("Cargar BD");
		btnCargarBD.setBounds(699, 241, 105, 23);
		contentPane.add(btnCargarBD);
		
		btnEnviarMail = new JButton("Enviar Mail");
		btnEnviarMail.setBounds(699, 311, 105, 23);
		contentPane.add(btnEnviarMail);

		arrayPersonas=new ArrayList<Persona>();
		bd=new BaseDatos();
		registrarEventos();

	}//FIN DEL CONSTRUCTOR

	private void registrarEventos() {
		btnEnviarMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una nueva instancia de la clase EnviarMail y ponerla visible
				enviarMail=new EnviarMail(GestionCorreo.this);
				enviarMail.setVisible(true);
				GestionCorreo.this.setVisible(false);
			}
		});
		
		btnCargarBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				Persona per;
				Empleado emp;
				rs=bd.obtenerDatos();
				//MENSAJE DE AVISO Y PEDIR CONFIRMACION
				if(JOptionPane.showConfirmDialog(GestionCorreo.this, "Se van a cargar datos. Los registros no guardados se perderán",
						"Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					//vaciar las 3 listas
					modeloNombres.clear();
					modeloCorreos.clear();
					modeloWebs.clear();
					try {
						if(rs.first()) {
							do {
								per=new Persona(rs.getString("nombre"), rs.getString("correo"), rs.getString("web"));
								per.setEstado(Persona.GUARDADO);
								per.setId(rs.getInt("id"));
								if(rs.getBoolean("esEmpleado")) {
									emp=new Empleado(per, rs.getInt("edad"), rs.getString("direccion"), rs.getString("telefono"));
									emp.setEstado(Persona.GUARDADO);
									arrayPersonas.add(emp);
								}else {
									arrayPersonas.add(per);
								}
								modeloNombres.addElement(per.getNombre());
								modeloCorreos.addElement(per.getCorreo());
								modeloWebs.addElement(per.getWeb());
							}while(rs.next());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnGuardarBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// RECORRER EL ARRAYLIST Y PARA CADA OBJETO INSERTARLO EN LA BD COMO PERSONA O COMO
				//EMPLEADO, SOLO SI NO HA SIDO GUARDADO PREVIAMENTE
				for (Persona persona : arrayPersonas) {
					if(persona.getEstado()==Persona.NUEVO) {
						if(bd.insertar(persona)==1) {
							persona.setEstado(Persona.GUARDADO);
						}
					}
				}
			}
		});

		lstNombres.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				seleccionarListas(lstNombres.getSelectedIndex());
			}
		});

		lstCorreos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				seleccionarListas(lstCorreos.getSelectedIndex());
			}
		});

		lstWebs.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				seleccionarListas(lstWebs.getSelectedIndex());
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Persona per;
				Empleado emp;
				//EL NOMBRE ES OBLIGATORIO
				if(txtNombre.getText().trim().equals("")) {
					txtNombre.requestFocus();
					txtNombre.selectAll();
					return;
				}
				per=new Persona(txtNombre.getText().trim(), txtCorreo.getText().trim(), txtWeb.getText().trim());
				if(!per.esCorreoCorrecto()) {
					txtCorreo.requestFocus();
					txtCorreo.selectAll();
					return;
				}
				//CREAR UN OBJETO DE CLASE Persona o Empleado CON LOS DATOS DE LOS JTextFiled Y AÑADIRLO AL
				//ARRAYLIST
				if(chkEmpleado.isSelected()) {
					try {
						emp=new Empleado(per, Integer.parseInt(txtEdad.getText().trim()), txtDireccion.getText().trim(),
								txtTelefono.getText().trim());
						arrayPersonas.add(emp);
					} catch(NumberFormatException e1) {
						txtEdad.requestFocus();
						txtEdad.selectAll();
						return;
					}
				} else {//ES UNA PERSONA
					arrayPersonas.add(per);
				}
				//AÑADIR LOS DATOS DE LOS JTEXTFIELD (O DEL OBJETO Persona) A LOS JList
				modeloNombres.addElement(per.getNombre());
				if(per.getCorreo().trim().equals("")) {
					modeloCorreos.addElement(" ");
				}else {
					modeloCorreos.addElement(per.getCorreo());
				}
				if (per.getWeb().trim().equals("")) {
					modeloWebs.addElement(" ");
				}else { 
					modeloWebs.addElement(per.getWeb());
				}
				txtNombre.setText("");
				txtCorreo.setText("");
				txtWeb.setText("");
				txtEdad.setText("");
				txtDireccion.setText("");
				txtTelefono.setText("");
				txtNombre.requestFocus();
			}
		});


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
	}

	protected void seleccionarListas(int selectedIndex) {
		// TODO Auto-generated method stub
		lstNombres.setSelectedIndex(selectedIndex);
		lstCorreos.setSelectedIndex(selectedIndex);
		lstWebs.setSelectedIndex(selectedIndex);
	}
	
	public JList<String> getLstNombres() {
		return lstNombres;
	}

	public void setLstNombres(JList<String> lstNombres) {
		this.lstNombres = lstNombres;
	}

	public JList<String> getLstCorreos() {
		return lstCorreos;
	}

	public void setLstCorreos(JList<String> lstCorreos) {
		this.lstCorreos = lstCorreos;
	}

	public JList<String> getLstWebs() {
		return lstWebs;
	}

	public void setLstWebs(JList<String> lstWebs) {
		this.lstWebs = lstWebs;
	}

	public ArrayList<Persona> getArrayPersonas() {
		return arrayPersonas;
	}

	public void setArrayPersonas(ArrayList<Persona> arrayPersonas) {
		this.arrayPersonas = arrayPersonas;
	}
}



