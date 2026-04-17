import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class EventosAreaJuego {

	private AreaJuego areaJuego;
	private int []estadoTeclas;
	private Timer reloj;
	
	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		
		
		areaJuego.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				areaJuego.getCaballo().setEstado(Caballo.QUIETO);
				areaJuego.repaint();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Hola");
				if(e.getKeyCode()==KeyEvent.VK_LEFT) { // || e.getKeyCode()==KeyEvent.VK_A) {
					if(areaJuego.getCaballo().getDirH()!=-1) {
						areaJuego.getCaballo().setDirH(-1);
					}else {
						//modificar posicion
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						areaJuego.getCaballo().mover();
					}
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) { // || e.getKeyCode()==KeyEvent.VK_D) {
					if(areaJuego.getCaballo().getDirH()!=1) {
						areaJuego.getCaballo().setDirH(1);
					}else {
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						areaJuego.getCaballo().mover();
					}
				} 
				
				areaJuego.repaint();
			}
		});
	}
}




