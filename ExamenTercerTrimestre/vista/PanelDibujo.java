import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {
    private ArrayList<String> lineasADibujar;

    public PanelDibujo() {
        setBackground(Color.WHITE);
        lineasADibujar = new ArrayList<>();
    }

    public void setLineasADibujar(ArrayList<String> lineas) {
        this.lineasADibujar = lineas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int posicionY = 20;
        for (String linea : lineasADibujar) {
            g.drawString(linea, 10, posicionY);
            posicionY += 20;
        }
    }
}