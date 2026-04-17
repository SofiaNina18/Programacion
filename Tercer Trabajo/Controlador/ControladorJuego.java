import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class ControladorJuego {
    
    private Pou personaje;
    private ArrayList<Objeto> listaObjetos;
    private MiJuego ventanaPrincipal;

    
    private int puntos;
    private int fallos;
    private final int MAX_FALLOS = 8;
    private final int PUNTOS_VICTORIA = 50;
    
   
    private Timer temporizadorLógica; 
    private Timer temporizadorDificultad; 
    private int velocidadCaida = 3;
    private int contadorTiempo = 0;
    private Random aleatorio;

    public ControladorJuego(MiJuego ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        aleatorio = new Random();
        inicializarJuego();
    }

    // Prepara todo para una nueva partida
    public void inicializarJuego() {
        puntos = 0;
        fallos = 0;
        velocidadCaida = 3;
        contadorTiempo = 0;
        
        
        personaje = new Pou(360, 480); 
        listaObjetos = new ArrayList<>();

       
        temporizadorLógica = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bucleJuego();
            }
        });

      
        temporizadorDificultad = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDificultad();
            }
        });
    }

   
    public void empezar() {
        temporizadorLógica.start();
        temporizadorDificultad.start();
    }

    
    public void parar() {
        temporizadorLógica.stop();
        temporizadorDificultad.stop();
    }

   
    private void bucleJuego() {
       
        if (aleatorio.nextInt(100) < 3) { 
            crearObjetoAleatorio();
        }

       
        for (int i = listaObjetos.size() - 1; i >= 0; i--) {
            Objeto obj = listaObjetos.get(i);
            obj.actualizar(velocidadCaida); 

           
            if (obj.getBorde().intersects(personaje.getBorde())) {
                gestionarColision(obj, i);
                continue; 
            }

            
            if (obj.getY() > 600) {
                if (obj.getTipo() == Objeto.TIPO_COMIDA) {
                    fallos++;
                    if (fallos >= MAX_FALLOS) {
                        finalizarJuego(false); 
                    }
                }
                listaObjetos.remove(i);
            }
        }

      
        ventanaPrincipal.getAreaJuego().repaint();
    }

    private void crearObjetoAleatorio() {
        int xObj = aleatorio.nextInt(750); 
        int tipo = (aleatorio.nextInt(10) < 2) ? Objeto.TIPO_MALO : Objeto.TIPO_COMIDA; 
        int tam = aleatorio.nextInt(21) + 30; 
        listaObjetos.add(new Objeto(xObj, -50, tam, tam, tipo));
    }

    private void gestionarColision(Objeto obj, int indice) {
        if (obj.getTipo() == Objeto.TIPO_COMIDA) {
            puntos++;
            personaje.setEstado(Pou.ESTADO_COMIENDO); 
           
            Timer tAnim = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    personaje.setEstado(Pou.ESTADO_NORMAL);
                }
            });
            tAnim.setRepeats(false);
            tAnim.start();

            if (puntos >= PUNTOS_VICTORIA) {
                finalizarJuego(true); 
            }
        } else {
           
            finalizarJuego(false);
        }
        listaObjetos.remove(indice);
    }

    private void actualizarDificultad() {
        contadorTiempo++;
        
        if (contadorTiempo % 20 == 0 && velocidadCaida < 10) {
            velocidadCaida++;
        }
    }

    private void finalizarJuego(boolean victoria) {
        parar();
        if (victoria) {
            personaje.setEstado(Pou.ESTADO_FELIZ);
        } else {
            personaje.setEstado(Pou.ESTADO_TRISTE);
        }
        
        ventanaPrincipal.mostrarPantallaFinal(victoria, puntos);
    }

   
    public KeyAdapter getControladorTeclado() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
               
                int velPou = 15; 

                if (tecla == KeyEvent.VK_A || tecla == KeyEvent.VK_LEFT) {
                    if (personaje.getX() > 0) personaje.mover(-velPou, 0);
                }
                if (tecla == KeyEvent.VK_D || tecla == KeyEvent.VK_RIGHT) {
                    if (personaje.getX() < 800 - personaje.getAncho()) personaje.mover(velPou, 0);
                }
            }
        };
    }

   
    public Pou getPersonaje() { 
    	return personaje; 
    	}
    public ArrayList<Objeto> getListaObjetos() { 
    	return listaObjetos; 
    	}
    public int getPuntos() { 
    	return puntos; 
    	}
    public int getFallos() { 
    	return fallos; 
    	}
    public int getMAX_FALLOS() { 
    	return MAX_FALLOS; 
    	}
}