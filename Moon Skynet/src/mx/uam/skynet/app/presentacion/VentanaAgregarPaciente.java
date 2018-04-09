package mx.uam.skynet.app.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import mx.uam.skynet.app.negocio.ControlAgregarPaciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;

/**
 * 
 * @author Jesus Cerna Medina
 *
 */
public class VentanaAgregarPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField last_name;
	private JTextField email;
	private JTextField age;

	/**
	 * Create the dialog.
	 */
	public VentanaAgregarPaciente(ControlAgregarPaciente ctrl) {
		setTitle("Agregar Cliente");
		setBounds(100, 100, 365, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNuevoCliente = new JLabel("Registra un nuevo cliente");
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		name = new JTextField();
		name.setColumns(10);
		
		last_name = new JTextField();
		last_name.setColumns(10);
		
		JTextField phone = new JTextField();
		phone.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		age = new JTextField();
		age.setColumns(10);
		
		JTextArea address = new JTextArea();
		address.setLineWrap(true);
		
		JButton btnAceptar = new JButton("Siguiente");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || last_name.getText().isEmpty() || phone.getText().isEmpty() || 
						email.getText().isEmpty() || age.getText().isEmpty() || address.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos.");
				} else {
					int insert = ctrl.regPaciente(name.getText(), last_name.getText(), phone.getText(), email.getText(), 
							age.getText(), address.getText());
					if(insert == 1) {
		                JOptionPane.showMessageDialog(null, "Cliente registrado con exito.\n Agendale una cita a " + name.getText());
		                dispose();
		                ctrl.iniciaCita(ctrl.idUltRegistro());
		            } else {
		                JOptionPane.showMessageDialog(null, "Datos NO guardados. Verificar los campos");
		            }
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNuevoCliente, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblApellidos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDireccion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEdad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnAceptar)
									.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
									.addComponent(btnCancelar)
									.addGap(36))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(name, Alignment.LEADING)
									.addComponent(last_name, Alignment.LEADING, 238, 238, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(address, Alignment.LEADING)
									.addComponent(email, Alignment.LEADING, 238, 238, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevoCliente, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(last_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addGap(20))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
