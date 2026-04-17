public class Pou extends Elemento {
    public static final int ESTADO_NORMAL = 0;
    public static final int ESTADO_COMIENDO = 1;
    public static final int ESTADO_TRISTE = 2;
    public static final int ESTADO_FELIZ = 3;

    private int estadoActual;

    public Pou(int x, int y) {
        super(x, y, 80, 80); 
        this.estadoActual = ESTADO_NORMAL;
    }

    public int getEstado() { 
    	return estadoActual; 
    	}
    public void setEstado(int estado) { 
    	this.estadoActual = estado; 
    	}
}