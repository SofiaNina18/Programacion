import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Teclado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton[] arrayTeclado;
	private String letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	private EventosTeclado eventosTeclado;
	

	/**
	 * Create the panel.
	 */
	public Teclado() {
		setLayout(new GridLayout(7, 4, 0, 0));

		crearTeclado(); //AÑADIR LAS LETRAS DEL ALFABETO
		//
		
		eventosTeclado=new EventosTeclado(this);
	}//FIN CONSTRUCTOR
	
	private void crearTeclado() {
		//INSTANCIAR EL ARRAY DE BOTONES
		arrayTeclado=new JButton[27];
		//AÑADIR LAS 27 TECLAS AL ARRAY Y AL PANEL
		for(int cont=0; cont<arrayTeclado.length; cont++) {
			arrayTeclado[cont]=new JButton();
			arrayTeclado[cont].setText(letras.charAt(cont)+"");
			this.add(arrayTeclado[cont]);
		}

	}

	public JButton[] getArrayTeclado() {
		return arrayTeclado;
	}

	public void setArrayTeclado(JButton[] arrayTeclado) {
		this.arrayTeclado = arrayTeclado;
	}

}
