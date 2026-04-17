import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class Eventos {
	private VentanaPrincipal ventana;

	public Eventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		registrarEventos();
	}

	private void registrarEventos() {
		ventana.getTxtNombreNuevo().addCaretListener(e -> {
			ventana.getBtnAnadir().setEnabled(!ventana.getTxtNombreNuevo()
					.getText().trim().isEmpty());
		});

		ventana.getBtnAnadir().addActionListener(e -> {
			if (ventana.getModeloLista().size() >= 8) {
				JOptionPane.showMessageDialog(null, "Máximo 8 nombres");
				return;
			}
			String nombre = ventana.getTxtNombreNuevo().getText().trim();
			ventana.getModeloLista().addElement(nombre);
			int pos = ventana.getModeloLista().size() - 1;
			ventana.getArrayTxt()[pos].setText(nombre);
			ventana.getTxtNombreNuevo().setText("");
			ventana.getBtnGuardar().setEnabled(true);
		});

		ventana.getChkTodos().addActionListener(e -> {
			boolean estado = ventana.getChkTodos().isSelected();
			for (int i = 0; i < 8; i++) {
				if (!ventana.getArrayTxt()[i].getText().isEmpty()) {
					ventana.getArrayChk()[i].setSelected(estado);
				} else {
					ventana.getArrayChk()[i].setSelected(false);
				}
			}
		});

		
		for (int i = 0; i < 8; i++) {
			ventana.getArrayChk()[i].addActionListener(e -> comprobarChecks());
		}

		ventana.getLstNombres().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int seleccionar = ventana.getLstNombres().getSelectedIndex();
				if (seleccionar != -1 && e.getClickCount() == 2) {
					ventana.getArrayChk()[seleccionar].setSelected(
							!ventana.getArrayChk()[seleccionar].isSelected());
					comprobarChecks();
				}
			}
		});

		ventana.getLstNombres().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int color = ventana.getLstNombres().getSelectedIndex();
				for(JTextField blanco : ventana.getArrayTxt()) 
					blanco.setBackground(Color.WHITE);
				if (color != -1) ventana.getArrayTxt()[color]
						.setBackground(Color.CYAN);
			}
		});
		
		ventana.getBtnGuardar().addActionListener(e -> {
			String mensaje = ventana.getTxtMensaje().getText().trim();
			if (mensaje.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Escriba el mensaje");
				return;
			}
			for (int i = 0; i < 8; i++) {
				if (ventana.getArrayChk()[i].isSelected() && 
						!ventana.getArrayTxt()[i].getText().isEmpty()) {
					System.out.println("Para: " + ventana.getArrayTxt()[i].getText());
					System.out.println("Mensaje: " + mensaje);
				}
			}
		});

		ventana.getBtnSalir().addActionListener(e -> System.exit(0));
	}

	private void comprobarChecks() {
		boolean seleccionados = true;
		int contadorNombres = 0;
		for (int i = 0; i < 8; i++) {
			if (!ventana.getArrayTxt()[i].getText().isEmpty()) {
				contadorNombres++;
				if (!ventana.getArrayChk()[i].isSelected()) seleccionados = false;
			}
		}
		ventana.getChkTodos().setSelected(contadorNombres > 0 && seleccionados);
	}
}