import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class EventosAreaDibujo {
	private AreaDibujo areaDibujo;
	private Timer reloj;
	
	
	public EventosAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo=areaDibujo;
		reloj=new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaDibujo.repaint();
			}
		});
	}


	public final AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}


	public final void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}


	public final Timer getReloj() {
		return reloj;
	}


	public final void setReloj(Timer reloj) {
		this.reloj = reloj;
	}
	
}
