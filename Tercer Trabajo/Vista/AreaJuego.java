import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;

public class AreaJuego extends JPanel {
    private ControladorJuego controlador;
    
    // Variables para las imágenes
    private Image imagenFondo;
    private Image imgPouNormal;
    private Image imgPouComiendo;
    private Image imgComida;
    private Image imgMalo;

    public AreaJuego(ControladorJuego controlador) {
        this.controlador = controlador;
        this.setFocusable(true);

        // Cargamos el fondo específico para el juego
        imagenFondo = new ImageIcon("imagenes/fondoJuego1.png").getImage();
        
        // Cargamos el resto de imágenes que ya teníamos
        imgPouNormal = new ImageIcon("imagenes/pou_normal.png").getImage();
        imgPouComiendo = new ImageIcon("imagenes/pou_comiendo.png").getImage();
        imgComida = new ImageIcon("imagenes/comida.png").getImage();
        imgMalo = new ImageIcon("imagenes/malo.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Suavizado para que las imágenes rotadas se vean bien
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. DIBUJAR EL FONDO (Ocupa todo el panel: 800x600)
        g2d.drawImage(imagenFondo, 0, 0, 800, 600, null);

        // 2. DIBUJAR AL POU
        Pou p = controlador.getPersonaje();
        Image imgActual = (p.getEstado() == Pou.ESTADO_COMIENDO) ? imgPouComiendo : imgPouNormal;
        g2d.drawImage(imgActual, p.getX(), p.getY(), p.getAncho(), p.getAlto(), null);

        // 3. DIBUJAR OBJETOS CON GIRO (Animación)
        for (Objeto obj : controlador.getListaObjetos()) {
            AffineTransform viejo = g2d.getTransform();
            
            // Posicionamos el pincel en el centro del objeto para rotar
            g2d.translate(obj.getX() + obj.getAncho() / 2, obj.getY() + obj.getAlto() / 2);
            g2d.rotate(Math.toRadians(obj.getAnguloGiro()));
            
            // Elegimos la imagen según el tipo
            Image imgObj = (obj.getTipo() == Objeto.TIPO_COMIDA) ? imgComida : imgMalo;
            
            // Dibujamos centrado en el nuevo origen
            g2d.drawImage(imgObj, -obj.getAncho() / 2, -obj.getAlto() / 2, obj.getAncho(), obj.getAlto(), null);
            
            g2d.setTransform(viejo);
        }

        // 4. INTERFAZ (Puntos y Fallos)
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Puntos: " + controlador.getPuntos(), 20, 30);
        g2d.drawString("Fallos: " + controlador.getFallos() + "/" + controlador.getMAX_FALLOS(), 20, 60);
    }
}