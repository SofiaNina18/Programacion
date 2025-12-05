import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class MiBaseDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int NAVEGACION = 0;
	private static final int EDIT = 1;
	private static final int ADD = 2;
	private JPanel contentPane;
	private JButton btnEdit;
	private JButton btnadd;
	private JButton btneliminar;
	private JButton btnprim;
	private JButton btnAnt;
	private JButton btnSig;
	private JButton btnult;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtNumSocio;
	private JTextField txtNumReg;

	private BaseDatos baseDatos;
	private ResultSet rs;
	private int regActual;
	private JPanel panelNavegacion;
	private int modo;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiBaseDatos frame = new MiBaseDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MiBaseDatos() throws SQLException {
		setTitle("Gestión Base de Datos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Socio: ");
		lblNewLabel.setBounds(36, 80, 47, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(36, 116, 47, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setBounds(36, 155, 62, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(36, 196, 62, 14);
		contentPane.add(lblTelefono);
		
		btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}});
		btnEdit.setBounds(354, 76, 89, 23);
		contentPane.add(btnEdit);
		
		btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnadd.setBounds(354, 128, 89, 23);
		contentPane.add(btnadd);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btneliminar.setBounds(354, 180, 89, 23);
		contentPane.add(btneliminar);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(464, 115, 56, 23);
		contentPane.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(530, 115, 78, 23);
		contentPane.add(btnCancel);
		
		btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(546, 274, 62, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("SOCIOS DE ALMI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(235, 21, 176, 31);
		contentPane.add(lblNewLabel_1);
		
		txtNumSocio = new JTextField();
		txtNumSocio.setColumns(10);
		txtNumSocio.setBounds(93, 77, 67, 20);
		contentPane.add(txtNumSocio);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(93, 113, 122, 20);
		contentPane.add(txtNombre);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(93, 152, 214, 20);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(93, 193, 99, 20);
		contentPane.add(txtTelefono);
		
		panelNavegacion = new JPanel();
		panelNavegacion.setBounds(36, 240, 333, 43);
		contentPane.add(panelNavegacion);
		panelNavegacion.setLayout(null);
		
		btnprim = new JButton("<<");
		btnprim.setBounds(10, 11, 56, 23);
		panelNavegacion.add(btnprim);
		
		btnAnt = new JButton("<");
		btnAnt.setBounds(76, 11, 47, 23);
		panelNavegacion.add(btnAnt);
		
		txtNumReg = new JTextField();
		txtNumReg.setBounds(133, 12, 47, 20);
		panelNavegacion.add(txtNumReg);
		txtNumReg.setColumns(10);
		
		btnSig = new JButton(">");
		btnSig.setBounds(192, 11, 47, 23);
		panelNavegacion.add(btnSig);
		
		btnult = new JButton(">>");
		btnult.setBounds(249, 11, 56, 23);
		panelNavegacion.add(btnult);
		btnprim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		registrarEventos();
		
		baseDatos = new BaseDatos();
		if (baseDatos.getCn() == null) {
			//System.out.println("No se ha podido hacer la conexion");
			//JOptionPane INFORMANDO DE QUE NO SE HA PODIDO CONECTAR Y
			//DESACTIVAR TODOOOOOOOOOOS LOS BOTONES DEL FORMULARIO
			System.exit(1);
		}
		rs=baseDatos.obtenerTodos();
		modo=NAVEGACION;
		if(rs.first()) {
			regActual=1;
			cargarDatos();
			}
		
		
	}//Fin de constructork
	
	private void registrarEventos() {
		// TODO Auto-generated method stub
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					modo=NAVEGACION;
					modoEdicion(false);
					cargarDatos();
			}});
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				//Dependiendo del modo hacer INSERT o UPDATE
				if(modo==EDIT) {
					num=Integer.parseInt(txtNumSocio.getText().trim());
					if (baseDatos.actulizarSocio(num, txtNombre.getText().trim(), 
							txtDireccion.getText().trim(), txtTelefono.getText().trim())==0) {
						JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
						txtNombre.requestFocus();
						return;
					}
					modo=NAVEGACION;
					modoEdicion(false);
					rs=baseDatos.obtenerTodos(); //Volver a cargar el resultset desde la Base de Datos
					try {
						rs.absolute(regActual);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cargarDatos();
					
				}if(modo==ADD) {
					if (baseDatos.insertarSocio(txtNombre.getText().trim(), 
							txtDireccion.getText().trim(), txtTelefono.getText().trim())==0) {
						JOptionPane.showMessageDialog(null, "No se ha podido insertar el registro");
						txtNombre.requestFocus();
						return;
					}
					//CAMBIAR EL MODO
					modo=NAVEGACION;
					modoEdicion(false);
					//VOLVER A CARGAR EL RESULTSET
					rs=baseDatos.obtenerTodos(); //Volver a cargar el resultset desde la Base de Datos
					//CARGAR LOS DATOS DEL ULTIMO
					try {
						ResultSet rsAux=baseDatos.obtenerDatos("SELECT COUNT(*) FROM socios");
						System.out.println("Antes del first");
						if(rsAux.first()) {
							System.out.println("First");
							regActual=rsAux.getInt(1);
							rs.last();
							cargarDatos(); }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cargarDatos();
				}
				}
			});
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MiBaseDatos.this, 
						"¿Está seguro de eliminar los datos de " + txtNombre.getText().trim() + "?",
						"Eliminar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(baseDatos.eliminarSocio(Integer.parseInt(txtNumSocio.getText().trim()))==0) {
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro");
						
					}else {
						try {
							if(rs.isLast()) {
								rs=baseDatos.obtenerTodos();
								regActual--;
								rs.last();
								cargarDatos();
							}else {
								rs=baseDatos.obtenerTodos();
								cargarDatos();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.next()) {
						regActual++;
						cargarDatos();
						
						
					}if(rs.isAfterLast()) {
						rs.previous();}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.previous()) {
						regActual--;
						cargarDatos();
					}if(rs.isBeforeFirst()) {
						rs.next();}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnprim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.first()) {
						regActual=1;
						cargarDatos();}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					while(!rs.isLast()) {
						rs.next();
						regActual++;
					}
					cargarDatos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtNumReg.addActionListener(new ActionListener() { //Pulsar ENTER en el JTextField
			public void actionPerformed(ActionEvent e) {
				//COGER EL NUMERO ESCRITO (CONTROLAR ERROR SI NO ES UN NUMERO)
				int num, numReg;
				ResultSet rsAux;
				try {
					num=Integer.parseInt(txtNumReg.getText().trim());
					//comprobar que el número de registro e ir a esa posición
					
					rsAux=baseDatos.obtenerDatos("SELECT COUNT(*) FROM socios");
					rsAux.first();
					numReg=rsAux.getInt(1);
					if (num>0 && num<=numReg) {
						rs.absolute(num);
						regActual=num;
						cargarDatos();
					}else {
						cargarDatos();
					}
					
				}catch(NumberFormatException ex) {
					cargarDatos();
					txtNumReg.selectAll();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	

	
	public void modoEdicion(boolean modo) {
		//Si recibe true, activa el modo edición
			//Pone editable a true: JTextField de datos 
			//Pone enabled a true; JButton OK y Cancel
			//pone enabled a false: botones de navegación, editar, eliminar, añadir
			//controles de navegación: enabled false
		
		//si recibe false, desactiva el modo edición
		txtNombre.setEditable(modo);
		txtDireccion.setEditable(modo);
		txtTelefono.setEditable(modo);
		btnOk.setEnabled(modo);
		btnCancel.setEnabled(modo);
		btnEdit.setEnabled(!modo);
		btnadd.setEnabled(!modo);
		btneliminar.setEnabled(!modo);
		
		for(Component comp:panelNavegacion.getComponents()) {
			comp.setEnabled(!modo);
		}
		
	}

	public void cargarDatos() {
		//CARGAR LOS DATOS DE REGISTRO ACTUAL EN LOS JtextField del JFrame
		try {
			txtNumSocio.setText(rs.getInt("numSocio")+"");
			txtNombre.setText(rs.getString("nombre"));
			txtDireccion.setText(rs.getString("direccion"));
			txtTelefono.setText(rs.getString("telefono"));
			txtNumReg.setText("Reg " + regActual);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

