import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class AreaDibujo extends JPanel {
    private ArrayList<String> lineasADibujar;

    public AreaDibujo() {
        setBackground(new Color(251, 233, 252));
        setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lineasADibujar = new ArrayList<>();
    }

    public void setLineasADibujar(ArrayList<String> lineas) {
        this.lineasADibujar = lineas;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int pos = 15;
        for (String linea:lineasADibujar) {
            g.drawString(linea, 3, pos);
            
            pos += 17.5;
        }
    }
}