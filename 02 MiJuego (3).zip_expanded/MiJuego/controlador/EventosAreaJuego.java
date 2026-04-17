import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import javax.swing.Timer;

public class EventosAreaJuego {

	private AreaJuego areaJuego;
	private int []estadoTeclas;
	private Timer reloj, relojTransicion, relojJinetes;;
	
	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		estadoTeclas=new int[4];
		for (int i = 0; i < estadoTeclas.length; i++) {
			estadoTeclas[i]=0;
		}
		
		relojJinetes=new Timer(800, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				areaJuego.getArrayJinetes().add(new Jinete(areaJuego));
			}
		});
		relojJinetes.start();
		
		relojTransicion=new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//restar 100 a posXfondo y a posXcaballo
				areaJuego.setPosXfondo(areaJuego.getPosXfondo()-100);
				areaJuego.getCaballo().setPosX(areaJuego.getCaballo().getPosX()-100);
				areaJuego.repaint();
				
				//parar el reloj al finalizar la transición
				if(areaJuego.getPosXfondo()<=-AreaJuego.ANCHO_FONDO) {
					areaJuego.setPosXfondo(0);
					areaJuego.setNivel((areaJuego.getNivel()+1)%3);//0 a 1, ,1 a 2, 2 a 0
					areaJuego.setModo(AreaJuego.JUEGO);
					areaJuego.getCaballo().setPosX(0);
					relojTransicion.stop();
					reloj.start();
				}
			}
		});
		
		reloj=new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//MOVER TODOS LOS ELEMENTOS QUE FORMAN PARTE DEL JUEGO
				areaJuego.getCaballo().mover();
				areaJuego.getCaballo().saltar();
				for (Jinete jinete: areaJuego.getArrayJinetes()) {
					jinete.caer();
				}

				/*ERROR DE OPERACIONES CONCURRENTES EN UN ARRAYLIST
				 * for (Jinete jinete : areaJuego.getArrayJinetes()) {
					if(areaJuego.getCaballo().getRect().intersects(jinete.getRect())) {
						areaJuego.getArrayJinetes().remove (jinete);
					}
				}*/
				
				for(int i=areaJuego.getArrayJinetes().size()-1;i>=0;i--) {
					if(areaJuego.getCaballo().getRect().intersects(areaJuego.getArrayJinetes().get(i).getRect())) {
						areaJuego.getArrayJinetes().remove (i);
					}
				}
				
				areaJuego.repaint();
			}
		});
		
		reloj.start();
		
		areaJuego.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					estadoTeclas[0]=0;
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					estadoTeclas[1]=0;
				}
				if(estadoTeclas[0]==0 && estadoTeclas[1]==0 && areaJuego.getCaballo().getEstado()!=Caballo.SALTANDO) {
					areaJuego.getCaballo().setEstado(Caballo.QUIETO);
				}
				//REVISAR: EL CABALLO AL TERMINAR DE SALTAR NO SE QUEDA QUITO AUNQUE NO HAYA TECLAS PULSADAS
				
				areaJuego.repaint();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(areaJuego.getCaballo().getEstado()!=Caballo.SALTANDO) {
					if(e.getKeyCode()==KeyEvent.VK_LEFT) { // || e.getKeyCode()==KeyEvent.VK_A) {
						if(areaJuego.getCaballo().getDirH()!=-1) {
							areaJuego.getCaballo().setDirH(-1);
						}else {
							//modificar posicion
							areaJuego.getCaballo().setEstadoanterior(areaJuego.getCaballo().getEstado());
							areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
							//areaJuego.getCaballo().setDirH(-1);
							//areaJuego.getCaballo().mover();
							estadoTeclas[0]=1;
							estadoTeclas[1]=0;
						}
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						estadoTeclas[0]=1;
						estadoTeclas[1]=0;
					}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) { // || e.getKeyCode()==KeyEvent.VK_D) {
						if(areaJuego.getCaballo().getDirH()!=1) {
							areaJuego.getCaballo().setDirH(1);
						}else {
							areaJuego.getCaballo().setEstadoanterior(areaJuego.getCaballo().getEstado());
							areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
							//areaJuego.getCaballo().setDirH(1);
							//areaJuego.getCaballo().mover();
							estadoTeclas[0]=0;
							estadoTeclas[1]=1;
						}
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						estadoTeclas[0]=0;
						estadoTeclas[1]=1;
					} else if(e.getKeyCode()==KeyEvent.VK_UP) {
						estadoTeclas[2]=1;
						if(areaJuego.getCaballo().getEstado()!=Caballo.SALTANDO) {
							areaJuego.getCaballo().setEstadoanterior(areaJuego.getCaballo().getEstado());
						}
						areaJuego.getCaballo().setEstado(Caballo.SALTANDO);
					}
				}
				areaJuego.repaint();
			}
		});
	}

	public int[] getEstadoTeclas() {
		return estadoTeclas;
	}

	public void setEstadoTeclas(int[] estadoTeclas) {
		this.estadoTeclas = estadoTeclas;
	}

	public Timer getReloj() {
		return reloj;
	}

	public void setReloj(Timer reloj) {
		this.reloj = reloj;
	}

	public Timer getRelojTransicion() {
		return relojTransicion;
	}

	public void setRelojTransicion(Timer relojTransicion) {
		this.relojTransicion = relojTransicion;
	}
}




