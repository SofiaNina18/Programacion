import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public JTextField[] arrayTxt = new JTextField[8];
	public JCheckBox[] arrayChk = new JCheckBox[8];
	public JTextField txtNombreNuevo;
	public JButton btnAnadir, btnGuardar, btnSalir;
	public JTextArea txtMensaje;
	public JCheckBox chkTodos;
	public JList<String> lstNombres;
	public DefaultListModel<String> modeloLista;

	public VentanaPrincipal() {
		setTitle("Prueba de MisSMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		modeloLista = new DefaultListModel<String>();
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(36, 43, 233, 259);
		contentPane.add(scrollLista);
		lstNombres = new JList<String>(modeloLista);
		scrollLista.setViewportView(lstNombres);

		for (int i = 0; i < 8; i++) {
			arrayTxt[i] = new JTextField();
			arrayTxt[i].setEditable(false);
			arrayTxt[i].setBounds(279, 43 + (i * 30), 86, 20);
			contentPane.add(arrayTxt[i]);

			arrayChk[i] = new JCheckBox("");
			arrayChk[i].setBounds(388, 42 + (i * 30), 28, 25);
			contentPane.add(arrayChk[i]);
			
			arrayChk[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarChecks();
				}
			});
		}

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 317, 150, 20);
		contentPane.add(lblNombre);

		txtNombreNuevo = new JTextField();
		txtNombreNuevo.setBounds(30, 348, 180, 25);
		contentPane.add(txtNombreNuevo);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setEnabled(false); 
		btnAnadir.setBounds(61, 397, 100, 25);
		contentPane.add(btnAnadir);

		JLabel lblTexto = new JLabel("Texto del mensaje:");
		lblTexto.setBounds(490, 55, 150, 20);
		contentPane.add(lblTexto);

		txtMensaje = new JTextArea();
		JScrollPane scrollMensaje = new JScrollPane(txtMensaje);
		scrollMensaje.setBounds(490, 86, 290, 174);
		contentPane.add(scrollMensaje);

		chkTodos = new JCheckBox("Todos");
		chkTodos.setBounds(388, 329, 100, 25);
		contentPane.add(chkTodos);

		btnGuardar = new JButton("Guardar Fichero");
		//btnGuardar.setEnabled(false); 
		btnGuardar.setBounds(534, 273, 180, 35);
		contentPane.add(btnGuardar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(534, 387, 180, 35);
		contentPane.add(btnSalir);

		registrarEventos();
		setVisible(true);
	}

	private void registrarEventos() {
		
		txtNombreNuevo.addCaretListener(e -> {
			btnAnadir.setEnabled(!txtNombreNuevo.getText().trim().isEmpty());
		});

		btnAnadir.addActionListener(e -> {
			if (modeloLista.size() >= 8) {
				JOptionPane.showMessageDialog(null, "Máximo 8 nombres");
				return;
			}
			String nombre = txtNombreNuevo.getText().trim();
			modeloLista.addElement(nombre);
			int pos = modeloLista.size() - 1;
			arrayTxt[pos].setText(nombre);
			txtNombreNuevo.setText("");
			btnGuardar.setEnabled(true);
		});

		lstNombres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccionar = lstNombres.getSelectedIndex();
				if (seleccionar != -1 && e.getClickCount() == 2) { 
					arrayChk[seleccionar].setSelected(!arrayChk[seleccionar]
							.isSelected());
					comprobarChecks();
				}
			}
		});

		lstNombres.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int color = lstNombres.getSelectedIndex();
				for(JTextField blanco : arrayTxt) blanco.
				setBackground(Color.WHITE); 
				if (color != -1) {
					arrayTxt[color].setBackground(Color.CYAN); 
				}
			}
		});

		
		chkTodos.addActionListener(e -> {
			boolean estado = chkTodos.isSelected();
			for (int i = 0; i < 8; i++) {
				if (!arrayTxt[i].getText().isEmpty()) {
					arrayChk[i].setSelected(estado);
				} else {
					arrayChk[i].setSelected(false);
				}
			}
		});

		btnGuardar.addActionListener(e -> {
			String mensaje = txtMensaje.getText().trim();
			if (mensaje.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Escriba el mensaje");
				return;
			}
			
			for (int i = 0; i < 8; i++) {
				if (arrayChk[i].isSelected() && !arrayTxt[i]
						.getText().isEmpty()) {
					System.out.println("Para: " + arrayTxt[i].getText());
					System.out.println("Mensaje: " + mensaje);
				}
			}
		});

		btnSalir.addActionListener(e -> System.exit(0));
	}

	
	private void comprobarChecks() {
		boolean seleccionados = true;
		int contadorNombres = 0;
		
		for (int i = 0; i < 8; i++) {
			if (!arrayTxt[i].getText().isEmpty()) {
				contadorNombres++;
				if (!arrayChk[i].isSelected()) {
					seleccionados = false;
				}
			}
		}
		
		if (contadorNombres == 0) seleccionados = false;
		chkTodos.setSelected(seleccionados);
	}

	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
	
	//GETTERS Y SETTERS

	public JTextField[] getArrayTxt() {
		return arrayTxt;
	}

	public void setArrayTxt(JTextField[] arrayTxt) {
		this.arrayTxt = arrayTxt;
	}

	public JCheckBox[] getArrayChk() {
		return arrayChk;
	}

	public void setArrayChk(JCheckBox[] arrayChk) {
		this.arrayChk = arrayChk;
	}

	public JTextField getTxtNombreNuevo() {
		return txtNombreNuevo;
	}

	public void setTxtNombreNuevo(JTextField txtNombreNuevo) {
		this.txtNombreNuevo = txtNombreNuevo;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JTextArea getTxtMensaje() {
		return txtMensaje;
	}

	public void setTxtMensaje(JTextArea txtMensaje) {
		this.txtMensaje = txtMensaje;
	}

	public JCheckBox getChkTodos() {
		return chkTodos;
	}

	public void setChkTodos(JCheckBox chkTodos) {
		this.chkTodos = chkTodos;
	}

	public JList<String> getLstNombres() {
		return lstNombres;
	}

	public void setLstNombres(JList<String> lstNombres) {
		this.lstNombres = lstNombres;
	}

	public DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public void setModeloLista(DefaultListModel<String> modeloLista) {
		this.modeloLista = modeloLista;
	}
	
	
}