package mx.uam.skynet.app.presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.negocio.ControlBuscarCliente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaBuscarCliente extends JFrame {

	private static final long serialVersionUID = 3250008474179648164L;
	private JPanel contentPane;
	private JTextField folioTF;
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

	public VentanaBuscarCliente(ControlBuscarCliente ctrl) {
		setTitle("Búsqueda de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			
		JLabel lblFolio = new JLabel("Folio:");
		lblFolio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		folioTF = new JTextField();
		folioTF.setColumns(10);
		folioTF.setEnabled(true);
		folioTF.setEditable(true);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nombreTF = new JTextField();
		nombreTF.setEditable(true);
		nombreTF.setEnabled(true);
		nombreTF.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		apellidoTF = new JTextField();
		apellidoTF.setEditable(true);
		apellidoTF.setEnabled(true);
		apellidoTF.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Edad");
		lblFechaDeNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		fnacimientoTF = new JTextField();
		fnacimientoTF.setEnabled(true);
		fnacimientoTF.setEditable(true);
		fnacimientoTF.setColumns(10);
		
		lblCorreo = new JLabel("E-mail:");
		lblCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		emailTF = new JTextField();
		emailTF.setEditable(true);
		emailTF.setEnabled(true);
		emailTF.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		direccionTF = new JTextField();
		direccionTF.setEditable(true);
		direccionTF.setEnabled(true);
		direccionTF.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		telefonoTF = new JTextField();
		telefonoTF.setEditable(true);
		telefonoTF.setEnabled(true);
		telefonoTF.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int update = ctrl.editarPaciente(nombreTF.getText(), apellidoTF.getText(), telefonoTF.getText(), 
						emailTF.getText(), fnacimientoTF.getText(), direccionTF.getText(), folioTF.getText());
				if(update == 1) {
					JOptionPane.showMessageDialog(null, "Datos actualizados con exito.");
				}else {
					JOptionPane.showMessageDialog(null, "Datos NO actualizados");
				}
			}
		});
		
		JButton button = new JButton("Historial Clinico");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.iniciaHistorialClinico(folioTF.getText());
			}
		});
		
		JButton botonBuscaCliente = new JButton("Buscar");
		botonBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Paciente paciente = ctrl.buscarClienteFolio(folioTF.getText());
				nombreTF.setText(paciente.getNombre());
				apellidoTF.setText(paciente.getApellidos());
				fnacimientoTF.setText("" + paciente.getFh_nacimiento());
				direccionTF.setText(paciente.getDireccion());
				emailTF.setText(paciente.getCorreo());
				telefonoTF.setText(paciente.getTelefono());
					
				if(paciente.getTelefono() != null){
					button.setEnabled(true);	
				} else {
					button.setEnabled(false);
				}
			}
		});
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(nombreTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addComponent(fnacimientoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(80)
										.addComponent(lblFechaDeNacimiento))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(75)
										.addComponent(lblNombre)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(direccionTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(button, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(apellidoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(telefonoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(botonCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(87)
										.addComponent(lblDireccion))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(81)
										.addComponent(lblApellidos))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(79)
								.addComponent(lblCorreo)
								.addGap(168)
								.addComponent(lblTelefono))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(botonBuscaCliente, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(lblFolio)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblFolio)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botonBuscaCliente, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombreTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(apellidoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDireccion)
								.addComponent(lblFechaDeNacimiento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(fnacimientoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(direccionTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCorreo)
								.addComponent(lblTelefono)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(telefonoTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCancelar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}