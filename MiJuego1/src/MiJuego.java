import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiJuego extends JFrame {
    private CardLayout gestorPantallas;
    private JPanel panelPrincipal;
    
    private JPanel pantallaMenu;
    private AreaJuego pantallaJuego;
    private JPanel pantallaFinal;

    private ControladorJuego controlador;

    private JLabel etiquetaResultado;
    private JLabel etiquetaPuntosFinal;

    public MiJuego() {
        setTitle("Pou: El Atrapacomidas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        gestorPantallas = new CardLayout();
        panelPrincipal = new JPanel(gestorPantallas);
        
        controlador = new ControladorJuego(this);

        crearPantallaMenu();
        panelPrincipal.add(pantallaMenu, "MENU");
        
                JButton botonJugar = new JButton("JUGAR");
                botonJugar.setBounds(323, 323, 143, 39);
                pantallaMenu.add(botonJugar);
                botonJugar.setFont(new Font("Arial", Font.BOLD, 25));
                botonJugar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        iniciarPartida();
                    }
                });

        pantallaJuego = new AreaJuego(controlador);
        pantallaJuego.addKeyListener(controlador.getControladorTeclado());
        panelPrincipal.add(pantallaJuego, "JUEGO");

        crearPantallaFinal();
        panelPrincipal.add(pantallaFinal, "FINAL");

        getContentPane().add(panelPrincipal);
        
        gestorPantallas.show(panelPrincipal, "MENU");
    }

    private void crearPantallaMenu() {
        pantallaMenu = new JPanel();
        pantallaMenu.setBackground(new Color(245, 245, 220));
        pantallaMenu.setLayout(null);

        JLabel titulo = new JLabel("POU: ATRAPA LA COMIDA", JLabel.CENTER);
        titulo.setBounds(0, 89, 784, 312);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(139, 69, 19));
        pantallaMenu.add(titulo);
    }

    private void crearPantallaFinal() {
        pantallaFinal = new JPanel(new BorderLayout());
        pantallaFinal.setBackground(Color.WHITE);

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.WHITE);
        
        etiquetaResultado = new JLabel("Resultado", JLabel.CENTER);
        etiquetaResultado.setBackground(Color.DARK_GRAY);
        etiquetaResultado.setBounds(102, 67, 592, 120);
        etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 40));
        
        etiquetaPuntosFinal = new JLabel("Puntuacion", JLabel.CENTER);
        etiquetaPuntosFinal.setBounds(230, 323, 314, 59);
        etiquetaPuntosFinal.setFont(new Font("Calibri", Font.BOLD, 30));

        JLabel placeholderImagen = new JLabel("POU", JLabel.CENTER);
        placeholderImagen.setFont(new Font("Tahoma", Font.BOLD, 26));
        placeholderImagen.setBounds(291, 198, 186, 88);
        panelInfo.setLayout(null);
        
        panelInfo.add(etiquetaResultado);
        panelInfo.add(placeholderImagen);
        panelInfo.add(etiquetaPuntosFinal);
        pantallaFinal.add(panelInfo, BorderLayout.CENTER);
        
                JButton botonVolver = new JButton("Volver a jugar");
                botonVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
                botonVolver.setBounds(207, 426, 159, 53);
                panelInfo.add(botonVolver);
                
                        JButton botonSalir = new JButton("Salir");
                        botonSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
                        botonSalir.setBounds(454, 426, 125, 53);
                        panelInfo.add(botonSalir);
                        botonSalir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                botonVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        iniciarPartida();
                    }
                });
    }

    private void iniciarPartida() {
        controlador.inicializarJuego();
        gestorPantallas.show(panelPrincipal, "JUEGO");
        pantallaJuego.requestFocusInWindow();
        controlador.empezar();
    }

    public void mostrarPantallaFinal(boolean victoria, int puntos) {
        if (victoria) {
            etiquetaResultado.setText("¡FELICIDADES, HAS GANADO!");
            etiquetaResultado.setForeground(new Color(34, 139, 34));
        } else {
            etiquetaResultado.setText("¡OH NO, HAS PERDIDO!");
            etiquetaResultado.setForeground(Color.RED);
        }
        
        etiquetaPuntosFinal.setText("Puntos conseguidos: " + puntos);
        
        gestorPantallas.show(panelPrincipal, "FINAL");
    }

    public AreaJuego getAreaJuego() { return pantallaJuego; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MiJuego juego = new MiJuego();
                juego.setVisible(true);
            }
        });
    }
}