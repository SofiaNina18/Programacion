import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class AreaDibujo extends Canvas {
	private Ahorcado ahorcado;

	public AreaDibujo(Ahorcado ahorcado) {
		this.ahorcado=ahorcado;
		this.setBackground(Color.CYAN);
	
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		//DIBUJA TOOOOOOOODOS LOS ELEMENSTOS QUE FORMAN PARTE DEL JUEGO
	    
	}
}
