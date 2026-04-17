import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField[] arrayTxt = new JTextField[8];
	private JCheckBox[] arrayChk = new JCheckBox[8];
	private JTextField txtNombreNuevo;
	private JButton btnAnadir, btnGuardar, btnSalir;
	private JTextArea txtMensaje;
	private JCheckBox chkTodos;
	private JList<String> lstNombres;
	private DefaultListModel<String> modeloLista;
	private JLabel lblNombre;
	private JLabel lblTexto;

	public VentanaPrincipal() {
		setTitle("MisSMS");
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
		}

		txtNombreNuevo = new JTextField();
		txtNombreNuevo.setBounds(30, 348, 180, 25);
		contentPane.add(txtNombreNuevo);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setEnabled(false);
		btnAnadir.setBounds(61, 397, 100, 25);
		contentPane.add(btnAnadir);

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
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 317, 150, 20);
		contentPane.add(lblNombre);
		
		lblTexto = new JLabel("Texto del mensaje:");
		lblTexto.setBounds(490, 55, 150, 20);
		contentPane.add(lblTexto);
	}
	
	//GETTERS

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField[] getArrayTxt() {
		return arrayTxt;
	}

	public JCheckBox[] getArrayChk() {
		return arrayChk;
	}

	public JTextField getTxtNombreNuevo() {
		return txtNombreNuevo;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JTextArea getTxtMensaje() {
		return txtMensaje;
	}

	public JCheckBox getChkTodos() {
		return chkTodos;
	}

	public JList<String> getLstNombres() {
		return lstNombres;
	}

	public DefaultListModel<String> getModeloLista() {
		return modeloLista;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public JLabel getLblTexto() {
		return lblTexto;
	}


	
}