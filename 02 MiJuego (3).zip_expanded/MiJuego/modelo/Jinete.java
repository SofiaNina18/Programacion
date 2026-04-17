import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import org.w3c.dom.css.Rect;

public class Jinete {
	private int posX, posY;
	private int ancho, alto;
	private int puntos;
	private int velocidad;
	private Image imagen;
	private AreaJuego areaJuego;
	private Random r;
	
	public Jinete(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		r=new Random();
		ancho=50;
		alto=70;
		posX=r.nextInt(areaJuego.getWidth()-ancho); //ALEATORIA DENTRO DE LA PANTALLA
		posY=-alto;
		velocidad=r.nextInt(2, 11); //ALEATORIA ENTRE 2 Y 10
		imagen=new ImageIcon(getClass().getResource("Jinete.png")).getImage();
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagen, posX, posY, ancho, alto, areaJuego);
	}
	
	public void caer() {
		int num;
		//CAEN DESDE ARRIBA MOVIÉNDOSE EN VERTICAL, A LA IZQUIERDA O A LA DERECHA DE FORMA ALEATORIA
		posY+=velocidad;
		num=r.nextInt(3);
		if(num==1 && posX+ancho<areaJuego.getWidth()-velocidad) {
			posX+=velocidad;
		}else if(num==2 && posX>velocidad) {
			posX-=velocidad;
		}
	}
	
	//GETTERS Y SETTERS
	public Rectangle getRect() {
		return new Rectangle(posX, posY, ancho, alto);
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	
	
	
	
}
