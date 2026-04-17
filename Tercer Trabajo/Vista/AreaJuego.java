import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class AreaJuego extends JPanel {
    private ControladorJuego controlador;

    public AreaJuego(ControladorJuego controlador) {
        this.controlador = controlador;
        this.setBackground(new Color(173, 216, 230)); 
        this.setFocusable(true); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Pou p = controlador.getPersonaje();
        dibujarPou(g2d, p);

        for (Objeto obj : controlador.getListaObjetos()) {
            dibujarObjetoGirando(g2d, obj);
        }

        dibujarInterfaz(g2d);
    }

    private void dibujarPou(Graphics2D g2d, Pou p) {
        switch (p.getEstado()) {
            case Pou.ESTADO_COMIENDO:
                //g2d.setColor(Color.GREEN);
                break;
            case Pou.ESTADO_TRISTE:
                //g2d.setColor(Color.RED);
                break;
            case Pou.ESTADO_FELIZ:
                //g2d.setColor(Color.YELLOW);
                break;
            default:
                //g2d.setColor(new Color(139, 69, 19));
                break;
        }
        g2d.fillRoundRect(p.getX(), p.getY(), p.getAncho(), p.getAlto(), 20, 20);
    }

    private void dibujarObjetoGirando(Graphics2D g2d, Objeto obj) {
        AffineTransform old = g2d.getTransform();
        
        int centroX = obj.getX() + obj.getAncho() / 2;
        int centroY = obj.getY() + obj.getAlto() / 2;
        
        g2d.translate(centroX, centroY);
        g2d.rotate(Math.toRadians(obj.getAnguloGiro()));
        
        if (obj.getTipo() == Objeto.TIPO_COMIDA) {
            g2d.setColor(Color.ORANGE);
            g2d.fillOval(-obj.getAncho()/2, -obj.getAlto()/2, obj.getAncho(), obj.getAlto());
        } else {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(-obj.getAncho()/2, -obj.getAlto()/2, obj.getAncho(), obj.getAlto());
        }
        
        g2d.setTransform(old);
    }

    private void dibujarInterfaz(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        
        g2d.drawString("Puntos: " + controlador.getPuntos(), 20, 30);
        
        int fallosRestantes = controlador.getMAX_FALLOS() - controlador.getFallos();
        g2d.drawString("Fallos: " + controlador.getFallos() + "/" + controlador.getMAX_FALLOS(), 20, 60);
        
        if (fallosRestantes <= 2) {
            g2d.setColor(Color.RED);
            g2d.drawString("¡CUIDADO!", 20, 90);
        }
    }
}