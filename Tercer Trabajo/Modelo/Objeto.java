public class Objeto extends Elemento {
    public static final int TIPO_COMIDA = 0;
    public static final int TIPO_MALO = 1;

    private int tipo;
    private double anguloGiro;

    public Objeto(int x, int y, int ancho, int alto, int tipo) {
        super(x, y, ancho, alto);
        this.tipo = tipo;
        this.anguloGiro = 0;
    }

    public void actualizar(int velocidadCaida) {
        this.y += velocidadCaida;
        this.anguloGiro += 5;
        if (anguloGiro >= 360) anguloGiro = 0;
    }

    public int getTipo() { return tipo; }
    public double getAnguloGiro() { return anguloGiro; }
}