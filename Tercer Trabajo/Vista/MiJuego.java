import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        pantallaMenu.setLayout(null);

        // Configuración de imágenes para el efecto Zoom
        ImageIcon iconoNormal = new ImageIcon("imagenes/botonJugar.png");
        Image imgNormal = iconoNormal.getImage().getScaledInstance(237, 214, Image.SCALE_SMOOTH);
        Image imgZoom = iconoNormal.getImage().getScaledInstance(260, 235, Image.SCALE_SMOOTH);
        
        ImageIcon iconoBotonNormal = new ImageIcon(imgNormal);
        ImageIcon iconoBotonZoom = new ImageIcon(imgZoom);

        JButton botonJugar = new JButton(iconoBotonNormal);
        botonJugar.setBounds(437, 214, 255, 200);
        botonJugar.setBorderPainted(false);   
        botonJugar.setContentAreaFilled(false); 
        botonJugar.setFocusPainted(false);    
        botonJugar.setOpaque(false);           

        // Efecto Zoom al pasar el ratón (Animación de interfaz)
        botonJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonJugar.setIcon(iconoBotonZoom);
                botonJugar.setBounds(425, 200, 280, 225); // Se mueve un poco para compensar el tamaño
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonJugar.setIcon(iconoBotonNormal);
                botonJugar.setBounds(437, 214, 255, 200); // Vuelve a su sitio
            }
        });

        botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarPartida();
            }
        });
        
        pantallaMenu.add(botonJugar);

        ImageIcon iconoFondo = new ImageIcon("imagenes/FondoJuego.png");
        Image imgFondo = iconoFondo.getImage().getScaledInstance(784, 561, Image.SCALE_SMOOTH);
        JLabel etiquetaFondo = new JLabel(new ImageIcon(imgFondo));
        etiquetaFondo.setBounds(0, 0, 784, 561);
        pantallaMenu.add(etiquetaFondo);
    }

    private void crearPantallaFinal() {
        pantallaFinal = new JPanel(new BorderLayout());
        pantallaFinal.setBackground(Color.WHITE);

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout(null);
        
        etiquetaResultado = new JLabel("Resultado", JLabel.CENTER);
        etiquetaResultado.setBounds(102, 67, 592, 120);
        etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 40));
        
        etiquetaPuntosFinal = new JLabel("Puntuacion", JLabel.CENTER);
        etiquetaPuntosFinal.setBounds(230, 323, 314, 59);
        etiquetaPuntosFinal.setFont(new Font("Calibri", Font.BOLD, 30));

        JLabel placeholderImagen = new JLabel("POU", JLabel.CENTER);
        placeholderImagen.setFont(new Font("Tahoma", Font.BOLD, 26));
        placeholderImagen.setBounds(291, 198, 186, 88);
        
        panelInfo.add(etiquetaResultado);
        panelInfo.add(placeholderImagen);
        panelInfo.add(etiquetaPuntosFinal);

        JButton botonVolver = new JButton("Volver a jugar");
        botonVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
        botonVolver.setBounds(207, 426, 159, 53);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarPartida();
            }
        });
        panelInfo.add(botonVolver);
                
        JButton botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
        botonSalir.setBounds(454, 426, 125, 53);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelInfo.add(botonSalir);

        pantallaFinal.add(panelInfo, BorderLayout.CENTER);
    }

    private void iniciarPartida() {
        controlador.inicializarJuego();
        gestorPantallas.show(panelPrincipal, "JUEGO");
        pantallaJuego.requestFocusInWindow();
        controlador.empezar();
    }

    public void mostrarPantallaFinal(boolean victoria, int puntos) {
        if (victoria) {
            etiquetaResultado.setText("¡HAS GANADO!");
            etiquetaResultado.setForeground(new Color(34, 139, 34));
        } else {
            etiquetaResultado.setText("¡HAS PERDIDO!");
            etiquetaResultado.setForeground(Color.RED);
        }
        etiquetaPuntosFinal.setText("Puntos conseguidos: " + puntos);
        gestorPantallas.show(panelPrincipal, "FINAL");
    }

    public AreaJuego getAreaJuego() { return pantallaJuego; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiJuego().setVisible(true);
            }
        });
    }
}