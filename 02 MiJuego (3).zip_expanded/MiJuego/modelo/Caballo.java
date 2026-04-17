import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Caballo {
	public static final int QUIETO=0;
	public static final int CORRIENDO=1;
	public static final int SALTANDO=2;
	//DATOS
	private Image[] arrayImagenesIzq;
	private Image[] arrayImagenesDcha;
	private int velocidad;
	private int posX, posY;
	private int ancho, alto;
	private int dirH, dirV;
	private int estado;
	private int imgActual;
	private int contAnimaciones;
	private int impulso, estadoAnterior;
	
	private AreaJuego areaJuego;
	
	public Caballo(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		velocidad=10;
		estado=QUIETO;
		estadoAnterior=QUIETO;
		impulso=80;
		posX=500;
		posY=560;
		dirH=1;
		dirV=0;
		ancho=120;
		alto=80;
		imgActual=7;
		contAnimaciones=0;
		cargarImagenes();
	}

	public void cargarImagenes() {
		arrayImagenesDcha=new Image[8];
		arrayImagenesIzq=new Image[8];
		/*for(int i=0;i<arrayImagenesDcha.length;i++) {
			arrayImagenesDcha[i]=new ImageIcon(getClass().getResource("CaballoD"+(i+1)+".png")).getImage();
			arrayImagenesIzq[i]=new ImageIcon(getClass().getResource("CaballoI"+(i+1)+".png")).getImage();
		}
		*/
		
			try {
				for(int i=0;i<arrayImagenesDcha.length;i++) {
					arrayImagenesDcha[i]=ImageIO.read(new File("./img/CaballoD"+(i+1)+".png"));
					arrayImagenesIzq[i]=ImageIO.read(new File("./img/CaballoI"+(i+1)+".png"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //.getImage();
			
	}

	public void dibujar(Graphics g) {
		if(estado==QUIETO) {
			imgActual=7;
		}
		if(dirH==1) {
			g.drawImage(arrayImagenesDcha[imgActual], posX, posY, ancho, alto, areaJuego);
		}else {
			g.drawImage(arrayImagenesIzq[imgActual], posX, posY, ancho, alto, areaJuego);
		}
	}
	
	public void saltar() {
		//SI EL CABALLO ESTÁ EN ESTADO DE SALTO, SE MOVERÁ HACIA 
			//ARRIBA o ABAJO --> SI ESTABA QUIETO
			//ARRIBA Y DERECHA o ABAJO Y DERECHA --> SI EL CABALLO ESTABA CORRIENDO Y dirH==1  -PATAS ESTIRADAS
			//ARRIBA Y IZQUIERDA o ABAJO Y IZQUIERDA --> SI EL CABBALO ESTABA CORRIENDO Y dirH==1
		if(estado==SALTANDO) {
			if(estadoAnterior==QUIETO) {
				if(impulso>0) {
					posY-=10;
					impulso-=10;
				}else {
					posY+=10;
					impulso-=10;
					if(impulso<=-80) {
						impulso=80;
						//estadoAnterior=estado;
						imgActual=7;
						estado=QUIETO;
					}
				}
			}else {//ESTADO ANTERIOR ES CORRIENDO
				imgActual=5;
				if(impulso>0) {
					posY-=10;
					if(posX>0 && dirH==-1 || posX+ancho<areaJuego.getWidth() && dirH==1) {
						posX=posX+velocidad*dirH;
					}

					impulso-=10;
				}else {
					posY+=10;
					if(posX>0 && dirH==-1 || posX+ancho<areaJuego.getWidth() && dirH==1) {
						posX=posX+velocidad*dirH;
					}

					impulso-=10;
					if(impulso<=-80) {
						impulso=80;
						//estadoAnterior=estado;
						estado=CORRIENDO;
					}
				}
			}
		}
	}
	
	public void mover() {
		//LIMITAR POR LA IZQUIERDA
		if(estado==QUIETO || estado==SALTANDO) {
			return;
		}
		if(posX>0 && dirH==-1 || posX+ancho<areaJuego.getWidth() && dirH==1) {
			posX=posX+velocidad*dirH;
		}else if(posX+ancho>=areaJuego.getWidth() && dirH==1){ //está en el borde derecho de la pantalla
			areaJuego.setPosXfondo(areaJuego.getPosXfondo()-10);
			if(AreaJuego.ANCHO_FONDO+areaJuego.getPosXfondo()<=areaJuego.getWidth()) {
				areaJuego.getEventosAreaJuego().getReloj().stop();
				areaJuego.getEventosAreaJuego().getRelojTransicion().start();
				areaJuego.setModo(AreaJuego.TRANSICION);
			}
		}
		//ANIMACION
		contAnimaciones++;
		if(contAnimaciones==4) {
			imgActual++;
			if(imgActual==8) {
				imgActual=0;
			}
			contAnimaciones=0;
		}

	}
	
	//GETTERS Y SETTERS
	public Rectangle getRect() {
		/*Rectangle rect;
		rect=new Rectangle(posX+10, posY+20, ancho-20, alto-20);
		return rect;*/
		
		return (new Rectangle(posX+10, posY+20, ancho-20, alto-20));
	}
	
	public Image[] getArrayImagenesIzq() {
		return arrayImagenesIzq;
	}

	public void setArrayImagenesIzq(Image[] arrayImagenesIzq) {
		this.arrayImagenesIzq = arrayImagenesIzq;
	}

	public Image[] getArrayImagenesDcha() {
		return arrayImagenesDcha;
	}

	public void setArrayImagenesDcha(Image[] arrayImagenesDcha) {
		this.arrayImagenesDcha = arrayImagenesDcha;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getImgActual() {
		return imgActual;
	}

	public void setImgActual(int imgActual) {
		this.imgActual = imgActual;
	}

	public AreaJuego getAreaJuego() {
		return areaJuego;
	}

	public void setAreaJuego(AreaJuego areaJuego) {
		this.areaJuego = areaJuego;
	}

	public int getDirH() {
		return dirH;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public int getDirV() {
		return dirV;
	}

	public void setDirV(int dirV) {
		this.dirV = dirV;
	}

	public int getImpulso() {
		return impulso;
	}

	public void setImpulso(int impulso) {
		this.impulso = impulso;
	}

	public int getEstadoanterior() {
		return estadoAnterior;
	}

	public void setEstadoanterior(int estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}
	
	
}





