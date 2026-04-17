import java.awt.Image;
import java.awt.Rectangle;

public class Elemento {
    protected int x, y, ancho, alto;
    
    public Elemento(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public Rectangle getBorde() {
        return new Rectangle(x, y, ancho, alto);
    }

    public int getX() { 
    	return x; 
    	}
    public void setX(int x) { 
    	this.x = x; 
    	}
    public int getY() { 
    	return y; 
    	}
    public void setY(int y) { 
    	this.y = y; 
    	}
    public int getAncho() { 
    	return ancho; 
    	}
    public int getAlto() { 
    	return alto; 
    	}
}