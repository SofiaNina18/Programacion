import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class EnviarMail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPara;
	private JLabel j;
	private JTextField txtCC;
	private JTextField txtAsunto;
	private JTextArea txtMensaje;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnVolver;
	private JList list;
	
	private GestionCorreo gestionCorreo;

	
	public EnviarMail(GestionCorreo gestionCorreo) {
		this.gestionCorreo = gestionCorreo;
		
		setTitle("EnviarMail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPara = new JTextField();
		txtPara.setBounds(135, 29, 445, 20);
		contentPane.add(txtPara);
		txtPara.setColumns(10);
		
		j = new JLabel("Para: ");
		j.setBounds(41, 32, 67, 14);
		contentPane.add(j);
		
		JLabel lblCc = new JLabel("CC: ");
		lblCc.setBounds(41, 73, 67, 14);
		contentPane.add(lblCc);
		
		JLabel lblAsunto = new JLabel("Asunto: ");
		lblAsunto.setBounds(41, 122, 67, 14);
		contentPane.add(lblAsunto);
		
		txtCC = new JTextField();
		txtCC.setColumns(10);
		txtCC.setBounds(135, 70, 445, 20);
		contentPane.add(txtCC);
		
		txtAsunto = new JTextField();
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(135, 119, 445, 20);
		contentPane.add(txtAsunto);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(41, 165, 67, 14);
		contentPane.add(lblMensaje);
		
		txtMensaje = new JTextArea();
		txtMensaje.setBounds(135, 165, 445, 292);
		contentPane.add(txtMensaje);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(666, 192, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBounds(603, 28, 89, 59);
		contentPane.add(btnNewButton_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(666, 244, 89, 23);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(785, 29, 184, 362);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		registrarEventos();

	}//FIN DEL CONSTRUCTOR
	private void registrarEventos() {
		// TODO Auto-generated method stub
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
