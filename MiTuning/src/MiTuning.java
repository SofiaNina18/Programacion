import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;

public class MiTuning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Campos del formulario
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JComboBox<String> cbProvincia;
	private JComboBox<String> cbEdad;
	private JRadioButton rbHombre;
	private JRadioButton rbMujer;
	private JRadioButton rbOtro;
	private JCheckBox chkTunning;
	private JCheckBox chkRecambios;
	private JCheckBox chkPuesta;
	private JCheckBox chkCompeticion;
	private JCheckBox chkEquipamiento;
	private JCheckBox chkReparaciones;
	private JCheckBox chkMantenimiento;
	private JCheckBox chkVehiculos;
	private JTextArea taComentarios;
	private JTextArea taPedidos;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MiTuning frame = new MiTuning();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MiTuning() {
		setTitle("Mi Tuning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 420);

		contentPane = new JPanel(new BorderLayout(6, 6));
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);

		// Encabezado
		JLabel lblTitulo = new JLabel("Taller TuNing", SwingConstants.CENTER);
		lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 16f));
		contentPane.add(lblTitulo, BorderLayout.NORTH);

		/*
		 Diseño vertical: vamos a usar un panel central con 3 columnas:
		 - columna izquierda: campos (label + campo) apilados verticalmente.
		 - columna central: Preferencias (checkboxes) apilados en 4x2.
		 - columna derecha: Comentarios y Pedidos (áreas de texto verticales).
		 Esto evita que los componentes queden en una sola fila horizontal.
		*/
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);

		// ----- Columna izquierda: formulario (labels + campos) -----
		JPanel formPanel = new JPanel(new GridLayout(0, 2, 6, 6)); // pares label-campo
		txtNombre = new JTextField();
		txtApellidos = new JTextField();
		txtDireccion = new JTextField();

		JLabel label = new JLabel("Nombre:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label);
		formPanel.add(txtNombre);
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label_1);
		formPanel.add(txtApellidos);
		JLabel label_2 = new JLabel("Dirección:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label_2);
		formPanel.add(txtDireccion);

		JLabel label_3 = new JLabel("Provincia:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label_3);
		String[] provincias = { "Selecciona...", "Madrid", "Barcelona", "Valencia", "Sevilla", "Alicante", "Granada" };
		cbProvincia = new JComboBox<>(provincias);
		formPanel.add(cbProvincia);

		JLabel label_4 = new JLabel("Edad:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label_4);
		cbEdad = new JComboBox<>();
		cbEdad.addItem("Selecciona...");
		for (int i = 16; i <= 90; i++) cbEdad.addItem(String.valueOf(i));
		cbEdad.setSelectedItem("18");
		formPanel.add(cbEdad);

		JLabel label_5 = new JLabel("Sexo:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		formPanel.add(label_5);
		// panel para radios (como campo en la segunda columna)
		JPanel pSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
		rbHombre = new JRadioButton("Hombre");
		rbMujer = new JRadioButton("Mujer");
		rbOtro = new JRadioButton("No especificar");
		ButtonGroup bg = new ButtonGroup();
		panelCentro.setLayout(new MigLayout("", "[472px][236px][172px]", "[402px]"));
		bg.add(rbHombre);
		bg.add(rbMujer);
		bg.add(rbOtro);
		pSexo.add(rbHombre);
		pSexo.add(rbMujer);
		pSexo.add(rbOtro);
		formPanel.add(pSexo);
		panelCentro.add(formPanel, "cell 0 0,alignx left,aligny center");

		// ----- Columna central: Preferencias (checkboxes) -----
		JPanel prefsPanel = new JPanel(new GridLayout(4, 2, 6, 6));
		prefsPanel.setBorder(BorderFactory.createTitledBorder("Preferencias"));
		chkTunning = new JCheckBox("Tunning");
		chkRecambios = new JCheckBox("Recambios");
		chkPuesta = new JCheckBox("Puesta a Punto");
		chkCompeticion = new JCheckBox("Competición");
		chkEquipamiento = new JCheckBox("Equipamiento");
		chkReparaciones = new JCheckBox("Reparaciones");
		chkMantenimiento = new JCheckBox("Mantenimiento");
		chkVehiculos = new JCheckBox("Vehículos ocasión");

		// Añadir en orden para que queden en 2 columnas verticales
		prefsPanel.add(chkTunning);
		prefsPanel.add(chkEquipamiento);
		prefsPanel.add(chkRecambios);
		prefsPanel.add(chkReparaciones);
		prefsPanel.add(chkPuesta);
		prefsPanel.add(chkMantenimiento);
		prefsPanel.add(chkCompeticion);
		prefsPanel.add(chkVehiculos);
		panelCentro.add(prefsPanel, "cell 1 0,alignx left,aligny center");

		// ----- Columna derecha: Comentarios / Pedidos -----
		JPanel rightPanel = new JPanel(new GridLayout(4, 1, 6, 6));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
		rightPanel.add(new JLabel("Comentarios:"));
		taComentarios = new JTextArea(5, 20);
		rightPanel.add(new JScrollPane(taComentarios));
		rightPanel.add(new JLabel("Pedidos:"));
		taPedidos = new JTextArea(3, 20);
		rightPanel.add(new JScrollPane(taPedidos));
		panelCentro.add(rightPanel, "cell 2 0,alignx left,aligny top");

		// Botones en el sur
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 6));
		JButton btnEnviar = new JButton("Enviar");
		JButton btnCancelar = new JButton("Cancelar");
		panelSur.add(btnEnviar);
		panelSur.add(btnCancelar);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		// Listeners
		btnEnviar.addActionListener((ActionEvent e) -> onEnviar());
		btnCancelar.addActionListener((ActionEvent e) -> clearForm());

		// Ajustes finales
		pack();
		setSize(new Dimension(700, 420));
		setLocationRelativeTo(null);
	}

	private void onEnviar() {
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellidos.getText().trim();

		if (nombre.isEmpty() || apellidos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nombre y Apellidos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String direccion = txtDireccion.getText().trim();
		String provincia = (String) cbProvincia.getSelectedItem();
		String edad = (String) cbEdad.getSelectedItem();
		String sexo = rbHombre.isSelected() ? "Hombre" : rbMujer.isSelected() ? "Mujer" : "No especificar";

		List<String> prefs = new ArrayList<>();
		if (chkTunning.isSelected()) prefs.add("Tunning");
		if (chkRecambios.isSelected()) prefs.add("Recambios");
		if (chkPuesta.isSelected()) prefs.add("Puesta a Punto");
		if (chkCompeticion.isSelected()) prefs.add("Competición");
		if (chkEquipamiento.isSelected()) prefs.add("Equipamiento");
		if (chkReparaciones.isSelected()) prefs.add("Reparaciones");
		if (chkMantenimiento.isSelected()) prefs.add("Mantenimiento");
		if (chkVehiculos.isSelected()) prefs.add("Vehículos ocasión");

		String comentarios = taComentarios.getText().trim();
		String pedidos = taPedidos.getText().trim();

		System.out.println("=== Datos formulario ===");
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellidos: " + apellidos);
		System.out.println("Dirección: " + direccion);
		System.out.println("Provincia: " + provincia);
		System.out.println("Edad: " + edad);
		System.out.println("Sexo: " + sexo);
		System.out.println("Preferencias: " + prefs);
		System.out.println("Comentarios: " + comentarios);
		System.out.println("Pedidos: " + pedidos);

		JOptionPane.showMessageDialog(this, "Formulario enviado (revisa la consola).", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}

	private void clearForm() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		cbProvincia.setSelectedIndex(0);
		cbEdad.setSelectedIndex(0);
		rbHombre.setSelected(false);
		rbMujer.setSelected(false);
		rbOtro.setSelected(false);
		chkTunning.setSelected(false);
		chkRecambios.setSelected(false);
		chkPuesta.setSelected(false);
		chkCompeticion.setSelected(false);
		chkEquipamiento.setSelected(false);
		chkReparaciones.setSelected(false);
		chkMantenimiento.setSelected(false);
		chkVehiculos.setSelected(false);
		taComentarios.setText("");
		taPedidos.setText("");
	}
}