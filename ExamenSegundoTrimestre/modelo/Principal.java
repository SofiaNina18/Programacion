public class Principal {
	public static void main(String[] args) {
		VentanaPrincipal vista = new VentanaPrincipal();
		new Eventos(vista);
		vista.setVisible(true);
	}
}