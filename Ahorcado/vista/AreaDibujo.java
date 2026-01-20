import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class AreaDibujo extends Canvas {
	private Ahorcado ahorcado;
	private EventosAreaDibujo eventosAreaDibujo;
	private int desplazamiento;
	//para crear el doble buffer
	private Image imagen;
	private Graphics pantVirtual;
	

	public AreaDibujo(Ahorcado ahorcado) {
		this.ahorcado=ahorcado;
		this.setBackground(Color.CYAN);
		eventosAreaDibujo=new EventosAreaDibujo(this);
		desplazamiento=0;
	
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g); 
		//dibujarAhorcado(g);
		//imagenAhorcado=g.get
		//DIBUJA TOOOOOOOODOS LOS ELEMENSTOS QUE FORMAN PARTE DEL JUEGO
	    
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		imagen=createImage(this.getWidth(), this.getHeight()); 
		pantVirtual=imagen.getGraphics();
		paint(pantVirtual);
		g.drawImage(imagen, 0, 0, null); //el tamaño de la imagen es el mismo que el del canvas
	}
	
	
	private void dibujarAhorcado(Graphics g) {
		//g.setColor(Color.BLACK);
		g.drawLine(45, 270, 45, 320); //sirve para pintar
		g.drawLine(45, 270, 95, 270); 
		if(ahorcado.getNumFallos()<7) { //<=6
			g.drawLine(95, 270, 195, 270); //PALO hORIZONTAL
		}else {
			g.drawLine(95, 270, 95, 320); //PALO VERTICAL
			g.drawLine(195, 270, 195, 320);
		}
		g.drawLine(195, 270, 245, 270); 
		g.drawLine(245, 320, 245, 50); 
		g.drawLine(245, 50, 145, 50); //CUERDA
		
		
		switch(ahorcado.getNumFallos()) {
			case 7:
				desplazamiento+=5;
				g.drawLine(145, 50, 145, 50+desplazamiento); //CUERDA CAIDA
				//escribir la palabra correcta
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.BOLD, 24));
				
				g.drawString(ahorcado.getTeclado().getPalabra(), 100, 378);
				
				g.setColor(Color.BLACK);
				
				if(desplazamiento>=80) {
					
					eventosAreaDibujo.getReloj().stop();
				}
				//g.drawLine(145, 210, 145, 270); //CUERPO CAIDO
			case 6:
				g.drawLine(145, 160+desplazamiento, 185, 210+desplazamiento); //BRAZO IZQUIERDO
				
			case 5:
				g.drawLine(145, 160+desplazamiento, 105, 210+desplazamiento); //BRAZO IZQUIERDO
				
			case 4:
				g.drawLine(145, 110+desplazamiento, 185, 160+desplazamiento); //PIERNA DERECHA
				
			case 3:
				g.drawLine(145, 110+desplazamiento, 105, 160+desplazamiento); //PIERNA IZQUIERDA
				
			case 2:
				g.drawLine(145, 100+desplazamiento, 145, 160+desplazamiento); //CUERPO
				
			case 1:
				g.drawOval(120, 50+desplazamiento, 50, 50); //CABEZA
				
			
		}
	}

	public final EventosAreaDibujo getEventosAreaDibujo() {
		return eventosAreaDibujo;
	}

	public final void setEventosAreaDibujo(EventosAreaDibujo eventosAreaDibujo) {
		this.eventosAreaDibujo = eventosAreaDibujo;
	}

	public final int getDesplazamiento() {
		return desplazamiento;
	}

	public final void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
}
