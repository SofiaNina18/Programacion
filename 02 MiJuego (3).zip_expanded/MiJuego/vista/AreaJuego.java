import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AreaJuego extends JPanel {
	public static final int ANCHO_FONDO=2000;
	public static final int JUEGO=1;
	public static final int TRANSICION=2;
	//DATOS
	private int puntuación;
	private Image []fondos;
	private int nivel;
	private Caballo caballo;
	private EventosAreaJuego eventosAreaJuego;
	private int posXfondo;
	private int modo;
	private ArrayList<Jinete> arrayJinetes;
	
	public AreaJuego() {
		//setBackground(Color.yellow);
		//CARGAR FONDOS Y DIBUJAR UNO
		nivel=0;
		posXfondo=0;
		modo=JUEGO;
		fondos=new Image[3];
		for(int i=0;i<fondos.length;i++) {
			fondos[i]=new ImageIcon(getClass().getResource("mount"+(i+1)+".jpg")).getImage();
		}
		caballo=new Caballo(this);
		arrayJinetes=new ArrayList<Jinete>();
		eventosAreaJuego=new EventosAreaJuego(this);
		
	}//FIN DEL CONSTRUCTOR
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//OPCION 1: DIBUJAR LOS 3 FONDOS CONSECUTIVOS. AL PASAR DE PANTALLA SE VEN DE FORMA SIMULTANEA LOS DOS FONDOS DE FORMA PARCIAL
		/*g.drawImage(fondos[0], posXfondo, 0, ANCHO_FONDO, getHeight(), null);
		g.drawImage(fondos[1], posXfondo+ANCHO_FONDO, 0, ANCHO_FONDO, getHeight(), null);
		g.drawImage(fondos[2], posXfondo+ANCHO_FONDO*2, 0, ANCHO_FONDO, getHeight(), null);
		*/
		//OPCION 2: CON TRANSICIÓN DE FONDOS
		if(modo==TRANSICION) {
			//dibujar fondo de nivel actual desde posXfondo
			//dibujar fondo de nivel siguiente desde posXfondo+ANCHO_FONDO
			g.drawImage(fondos[nivel], posXfondo, 0, ANCHO_FONDO, getHeight(), null);
			g.drawImage(fondos[(nivel+1)%3], posXfondo+ANCHO_FONDO, 0, ANCHO_FONDO, getHeight(), null);
			//caballo.dibujar(g);
		}
		
		if(modo==JUEGO) {
			g.drawImage(fondos[nivel], posXfondo, 0, ANCHO_FONDO, getHeight(), null);	
		}
		
		caballo.dibujar(g);
		for (Jinete jinete : arrayJinetes) {
			jinete.dibujar(g);
		}
	}

	public int getPuntuación() {
		return puntuación;
	}

	public void setPuntuación(int puntuación) {
		this.puntuación = puntuación;
	}

	public Image[] getFondos() {
		return fondos;
	}

	public void setFondos(Image[] fondos) {
		this.fondos = fondos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Caballo getCaballo() {
		return caballo;
	}

	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}

	public EventosAreaJuego getEventosAreaJuego() {
		return eventosAreaJuego;
	}

	public void setEventosAreaJuego(EventosAreaJuego eventosAreaJuego) {
		this.eventosAreaJuego = eventosAreaJuego;
	}

	public int getPosXfondo() {
		return posXfondo;
	}

	public void setPosXfondo(int posXfondo) {
		this.posXfondo = posXfondo;
	}

	public int getModo() {
		return modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public ArrayList<Jinete> getArrayJinetes() {
		return arrayJinetes;
	}

	public void setArrayJinetes(ArrayList<Jinete> arrayJinetes) {
		this.arrayJinetes = arrayJinetes;
	}
	
	
}
