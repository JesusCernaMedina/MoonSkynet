package mx.uam.skynet.app.presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mx.uam.skynet.app.persistencia.ConnectDB;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class VentanaBuscar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250008474179648164L;
	private JPanel contentPane;
	private JTextField folioTF;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField nombreTF;
	private JTextField fnacimientoTF;
	private JTextField emailTF;
	private JTextField apellidoTF;
	private JTextField direccionTF;
	private JTextField telefonoTF;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblDireccion;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	
	
	public String folioDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscar frame = new VentanaBuscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaBuscar() {
		setTitle("Busqueda de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton botonBuscaCliente = new JButton("Buscar");
		
		botonBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 ConnectDB conexion = new ConnectDB();
					try {
						conexion.buscaClienteEspecifico(folioTF.toString());
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		});
		
		folioTF = new JTextField();
		folioTF.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblFolio = new JLabel("Folio:");
		
		nombreTF = new JTextField();
		nombreTF.setEditable(false);
		nombreTF.setEnabled(false);
		nombreTF.setColumns(10);
		
		fnacimientoTF = new JTextField();
		fnacimientoTF.setEnabled(false);
		fnacimientoTF.setEditable(false);
		fnacimientoTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setEditable(false);
		emailTF.setEnabled(false);
		emailTF.setColumns(10);
		
		apellidoTF = new JTextField();
		apellidoTF.setEditable(false);
		apellidoTF.setEnabled(false);
		apellidoTF.setColumns(10);
		
		direccionTF = new JTextField();
		direccionTF.setEditable(false);
		direccionTF.setEnabled(false);
		direccionTF.setColumns(10);
		
		telefonoTF = new JTextField();
		telefonoTF.setEditable(false);
		telefonoTF.setEnabled(false);
		telefonoTF.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		
		lblApellidos = new JLabel("Apelliods:");
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		
		lblDireccion = new JLabel("Direccion:");
		
		lblCorreo = new JLabel("E-mail:");
		
		lblTelefono = new JLabel("Telefono:");
		
		JButton botonCancelar= new JButton("Cancelar");
		
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(118)
									.addComponent(lblFolio))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(nombreTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
										.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
										.addComponent(fnacimientoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
										.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(47))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(apellidoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
										.addComponent(direccionTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
										.addComponent(telefonoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
									.addGap(49))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(botonBuscaCliente)
									.addGap(18)
									.addComponent(botonCancelar)
									.addGap(43))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(lblNombre)
							.addGap(154)
							.addComponent(lblApellidos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblFechaDeNacimiento)
							.addGap(93)
							.addComponent(lblDireccion))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(111)
							.addComponent(lblCorreo)
							.addGap(153)
							.addComponent(lblTelefono)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblFolio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(9))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonBuscaCliente, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
								.addComponent(botonCancelar, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblApellidos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nombreTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(apellidoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaDeNacimiento)
						.addComponent(lblDireccion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(fnacimientoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(direccionTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCorreo)
						.addComponent(lblTelefono))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(telefonoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
