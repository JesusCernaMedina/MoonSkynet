package mx.uam.skynet.app.presentacion;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class VentanaBuscar extends JFrame {

	/**
	 * 
	 */
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
	
	public String folioDB;
	
	private String apellido;
	private String nombre;
	private String telefono;
	private String correo;
	private int fh_nacimento;
	private String direccion;

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
	
	public void buscaClienteEspecifico(String folio) throws SQLException {
		Querys query = new Querys(ConnectDB.Conectar());
		
		ResultSet resultApellido = query.selectWhere("apellidos", "pacientes", "fol_paciente = '"+folio + "'").executeQuery();
		if (resultApellido.next()) {
			apellido = resultApellido.getString(1);
			ConnectDB.Desconectar();
		} else {
//			System.out.println("No se encontro nada. 1");
			ConnectDB.Desconectar();
		}
		
		ResultSet resultNombre = query.selectWhere("nombre", "pacientes", "fol_paciente = '"+folio+ "'").executeQuery();
		if (resultNombre.next()) {
			nombre = resultNombre.getString(1);
			ConnectDB.Desconectar();
		} else {
//			System.out.println("No se encontro nada. 2");
			ConnectDB.Desconectar();
		}


		ResultSet resultTelefono = query.selectWhere("telefono", "pacientes", "fol_paciente = '"+folio+ "'").executeQuery();
		if (resultTelefono.next()) {
			telefono = resultTelefono.getString(1);
			ConnectDB.Desconectar();
		} else {
//			System.out.println("No se encontro nada. 3");
			ConnectDB.Desconectar();
		}

		ResultSet resultCorreo = query.selectWhere("correo", "pacientes", "fol_paciente = '"+folio+ "'").executeQuery();
		if (resultCorreo.next()) {
			correo =  resultCorreo.getString(1);
			ConnectDB.Desconectar();
		} else {
			
			ConnectDB.Desconectar();
		}


		ResultSet resultFH_nacimiento = query.selectWhere("fh_nacimiento", "pacientes", "fol_paciente = '"+folio+ "'").executeQuery();
		if (resultFH_nacimiento.next()) {
			fh_nacimento = resultFH_nacimiento.getInt(1);
			ConnectDB.Desconectar();
		} else {
			
			ConnectDB.Desconectar();
		}
		

		ResultSet resultDireccion = query.selectWhere("direccion", "pacientes", "fol_paciente = '"+folio+ "'").executeQuery();
		if (resultDireccion.next()) {
			direccion = resultDireccion.getString(1);
			ConnectDB.Desconectar();
		} else {
			ConnectDB.Desconectar();
		}
	}

	/**
	 * Create the frame.
	 */
	public VentanaBuscar() {
		setTitle("Búsqueda de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			
		JLabel lblFolio = new JLabel("Folio:");
		folioTF = new JTextField();
		folioTF.setColumns(10);
		folioTF.setEnabled(true);
		folioTF.setEditable(true);
		
		lblNombre = new JLabel("Nombre:");
		nombreTF = new JTextField();
		nombreTF.setEditable(true);
		nombreTF.setEnabled(true);
		nombreTF.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		apellidoTF = new JTextField();
		apellidoTF.setEditable(true);
		apellidoTF.setEnabled(true);
		apellidoTF.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Edad");
		fnacimientoTF = new JTextField();
		fnacimientoTF.setEnabled(true);
		fnacimientoTF.setEditable(true);
		fnacimientoTF.setColumns(10);
		
		lblCorreo = new JLabel("E-mail:");
		emailTF = new JTextField();
		emailTF.setEditable(true);
		emailTF.setEnabled(true);
		emailTF.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		direccionTF = new JTextField();
		direccionTF.setEditable(true);
		direccionTF.setEnabled(true);
		direccionTF.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		telefonoTF = new JTextField();
		telefonoTF.setEditable(true);
		telefonoTF.setEnabled(true);
		telefonoTF.setColumns(10);
		
	JButton button= new JButton("Historial Clinico");
	JButton botonBuscaCliente = new JButton("Buscar");
		
		botonBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						buscaClienteEspecifico(folioTF.getText());
						nombreTF.setText(nombre);
						System.out.println(nombre);
						apellidoTF.setText(apellido);
						fnacimientoTF.setText("" + fh_nacimento);
						direccionTF.setText(direccion);
						emailTF.setText(correo);
						telefonoTF.setText(telefono);
						
						if(telefono != null){
							button.setEnabled(true);	
						} else {
							button.setEnabled(false);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		});
		
			
		JButton btnEditar = new JButton("Editar");
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
						try{
							Querys query = new Querys(ConnectDB.Conectar());
//				            PreparedStatement guardar = ConnectDB.Conectar().
//				                    prepareStatement("UPDATE pacientes set nombre='"+nombreTF.getText()+"',apellidos='"+apellidoTF.getText()+
//				                    		"',telefono='"+telefonoTF.getText()+"',correo='"+emailTF.getText()+"',fh_nacimiento='"+Integer.parseInt(fnacimientoTF.getText())+
//				                    		"', direccion='"+direccionTF.getText()+ "'where fol_paciente ="+Integer.parseInt(folioTF.getText()));                                 
				             
		
				            int update = query.update("pacientes", "nombre='"+nombreTF.getText()+"',apellidos='"+apellidoTF.getText()+"',telefono='"+telefonoTF.getText()+
									"',correo='"+emailTF.getText()+"',fh_nacimiento='"+Integer.parseInt(fnacimientoTF.getText())+
									"', direccion='"+direccionTF.getText() +"'", "fol_paciente ="+Integer.parseInt(folioTF.getText()));
				            if(update==1){
				                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
				         
				           
				            }else {
				                JOptionPane.showMessageDialog(null, "Datos NO guardados");
				            }
				                                 
				        } catch(SQLException err) {
				            JOptionPane.showMessageDialog(null, "Hubo un error en la tabla" + err);
				        }
					}
				});
	
		
		JButton botonCancelar= new JButton("Cancelar");
		
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			HistorialClinico newwindows;
			
			try { 
				newwindows= new HistorialClinico(folioTF.getText());
				newwindows.setVisible(true);
				newwindows.setTitle("Historial Clínico");
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				int height = screen.height;
				int width =screen.width;
				newwindows.setLocation(50,50);
				newwindows.setSize(width-100,height-100);
				newwindows.setResizable(false);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	
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
									.addContainerGap()
									.addComponent(nombreTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(fnacimientoTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(90)
									.addComponent(lblFechaDeNacimiento))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(85)
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
							.addGap(89)
							.addComponent(lblCorreo)
							.addGap(168)
							.addComponent(lblTelefono))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(botonBuscaCliente, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(lblFolio)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFolio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(folioTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonBuscaCliente, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
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
					.addContainerGap(82, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}