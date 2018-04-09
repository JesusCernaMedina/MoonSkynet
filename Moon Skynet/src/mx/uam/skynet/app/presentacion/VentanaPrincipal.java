package mx.uam.skynet.app.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.Aplicacion;
import mx.uam.skynet.app.negocio.ControlVentanaPrincipal;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Jesus Cerna Medina
 *
 */
public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 3250008474179648164L;
	private JPanel contentPane;
	private JTable table;
	private Aplicacion app;
	private ControlVentanaPrincipal ctrl;
	
	/**
	 * Constructor encargado de instanciar clase Aplicacion y mostrar ventana principal
	 * @param app Clase principal que se encarga de ejecutar toda la aplicacion
	 */
	public VentanaPrincipal(ControlVentanaPrincipal ctrl, Aplicacion app) {
		this.app = app;
		this.ctrl = ctrl;
		init();
	}
	
	/**
	 * Metodo encargado de mostrar la ventana principal de la aplicacion
	 */
	public void init() {
		setTitle("Ventana Principal - MoonSkynet");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 170, 690, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDoctora = new JLabel("");
		lblDoctora.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/mx/uam/skynet/app/presentacion/img/doctora.png")));
		
		JButton btnNewButton = new JButton("Agregar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.agregarCliente();
			}
		});
		
		JButton botonBuscaCliente = new JButton("Buscar Cliente");
		
		botonBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.buscarCliente();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Inventario");
		btnNewButton_2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				app.inventario();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Notificaciones");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.notificaciones();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Historial de Pago");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.historialPago();
			}
		});

		JButton button = new JButton("Guía de Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.guiaUsuario();
			}
		});
		
		// Tabla de citas proximas
		DefaultTableModel modelo = new DefaultTableModel();
		modelo = ctrl.citasProximas();
		table = new JTable(modelo);
		
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(botonBuscaCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_3, Alignment.TRAILING))
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDoctora, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(43)))
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDoctora, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(botonBuscaCliente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(button)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
