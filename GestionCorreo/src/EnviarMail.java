import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnviarMail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPara;
	private JTextField txtCC;
	private JTextField txtAsunto;
	private JTextArea txtMensaje;
	private JButton btnEnviar;
	private JList<String> lstMails;
	private JButton btnVolver;
	private JButton btnResize;
	private DefaultListModel<String> modeloMails;
	private Timer reloj;

	private GestionCorreo gestionCorreo;
	
	/**
	 * Create the frame.
	 */
	public EnviarMail(GestionCorreo gestionCorreo) {
		setResizable(false);
		this.gestionCorreo=gestionCorreo;
		
		setTitle("EnviarMail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Para:");
		lblNewLabel.setBounds(42, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtPara = new JTextField();
		txtPara.setEditable(false);
		txtPara.setBounds(104, 25, 342, 20);
		contentPane.add(txtPara);
		txtPara.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CC:");
		lblNewLabel_1.setBounds(42, 65, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCC = new JTextField();
		txtCC.setEditable(false);
		txtCC.setBounds(104, 62, 424, 20);
		contentPane.add(txtCC);
		txtCC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Asunto:");
		lblNewLabel_2.setBounds(42, 96, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(104, 93, 424, 20);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mensaje:");
		lblNewLabel_3.setBounds(42, 151, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtMensaje = new JTextArea();
		txtMensaje.setLineWrap(true);
		txtMensaje.setBounds(104, 146, 424, 242);
		contentPane.add(txtMensaje);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(538, 211, 89, 23);
		contentPane.add(btnEnviar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(538, 263, 89, 23);
		contentPane.add(btnVolver);
		
		btnResize = new JButton(">");
		btnResize.setBounds(545, 24, 68, 55);
		contentPane.add(btnResize);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(652, 28, 190, 269);
		contentPane.add(scrollPane);
		
		lstMails = new JList<String>();
		lstMails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(lstMails);
		modeloMails = new DefaultListModel<String>();
		lstMails.setModel(modeloMails);
		
		registrarEventos();
		
		

	}//FIN DEL CONSTRUCTOR
	
	public void recibirDatos() {
		if(gestionCorreo.getLstCorreos().getSelectedIndex()!=-1) {
			txtPara.setText(gestionCorreo.getLstCorreos().getSelectedValue());
			
		}
		for (int i = 0; i < gestionCorreo.getLstCorreos().getModel().getSize(); i++) {
			modeloMails.addElement(gestionCorreo.getLstCorreos().getModel().getElementAt(i));
		}
	}


	private void registrarEventos() {
		
		
		lstMails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount()==2) {
					String emailSeleccionado = lstMails.getSelectedValue();
					txtPara.setText(emailSeleccionado);
				}
			}
		});
		
		reloj = new Timer(25, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
				if(btnResize.getText().equals(">")) {
					setSize(getWidth()+5, getHeight());
					if(getWidth()>=900) {
						reloj.stop();
						btnResize.setText("<");
					}
					}else {
						setSize(getWidth()-5, getHeight());
						if(getWidth()<=650) {
							reloj.stop();
							btnResize.setText(">");
						
					}
				}
				}
			});
		btnResize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloj.start();
			}
		});
		
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gestionCorreo.setVisible(true);
				EnviarMail.this.dispose();
				
			}
		});
	}
}







