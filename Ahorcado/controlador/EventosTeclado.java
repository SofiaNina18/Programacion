import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EventosTeclado {

	public EventosTeclado(Teclado teclado) {
		JButton []array;
		array=teclado.getArrayTeclado();
		
		for (JButton btn : array) {
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					char letra;
					boolean esta;
					String palabra, palAux;
					JLabel lblPalabra;
					palabra=teclado.getPalabra();
					lblPalabra=teclado.getAhorcado().getLblPalabra();
					//COGER EL TEXTO DEL BOTON
					letra=btn.getText().charAt(0);
					palAux="";
					esta=false;
					for(int pos=0;pos<palabra.length();pos++) {
						//si coincide la letra: la concatenamos al aux
						if(letra==palabra.charAt(pos)) {
							palAux=palAux+letra+" ";
							esta=true;
						}else {
							palAux=palAux+lblPalabra.getText().substring(pos*2, pos*2+2);
						}
					}
					lblPalabra.setText(palAux);
					if(esta) {
						btn.setBackground(Color.GREEN);
						if(!lblPalabra.getText().contains("_")) {
							teclado.estadoTeclado(false);
							teclado.getAhorcado().getBtnNueva().setEnabled(true);
						}
					}else {
						btn.setBackground(Color.RED);
						teclado.getAhorcado().setNumFallos(teclado.getAhorcado().getNumFallos()+1);
						teclado.getAhorcado().getAreaDibujo().repaint();
						if(teclado.getAhorcado().getNumFallos()>=7) {
							teclado.estadoTeclado(false);
							teclado.getAhorcado().getBtnNueva().setEnabled(true);
							//INICIAMOS EL RELOJ
							teclado.getAhorcado().getAreaDibujo().getEventosAreaDibujo().getReloj().start();
							
						}
					}
					
					
					
					//SUSTITUIR LAS POSICIONES EN LAS QUE ESTÁ LA LETRA
					
					//SI LA LETRA ESTÁ:
						//-> PONER EL BOTON VERDE
						//-> COMPROBAR SI FINAL
							//SI El LABEL NO TIENE GUIONES
								//BLOQUEAR LETRAS
								//DESBLOQUEAR NUEVA PALABRA
					//SI LA LETRA NO ESTÁ 
						//-> PONER EL BOTON ROJO
						//-> INCREMENTAR FALLOS
						//-> REDIBUJAR AREADIBUJO
						//-> COMPROBAR SI FINAL
					
				}
			});
		}
		
	}//FIN DEL CONSTRUCTOR
}




