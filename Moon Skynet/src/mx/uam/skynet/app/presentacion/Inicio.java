package mx.uam.skynet.app.presentacion;

import java.awt.EventQueue;

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

import mx.uam.skynet.app.persistencia.ConnectDB;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Jesus Cerna Medina
 *
 */
public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250008474179648164L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Agregar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddClient cliente = new AddClient();
				cliente.setVisible(true);
			}
		});
		
		JLabel lblDoctora = new JLabel("");
		lblDoctora.setIcon(new ImageIcon(Inicio.class.getResource("/mx/uam/skynet/app/presentacion/img/doctora.png")));
		
		JButton botonBuscaCliente = new JButton("Buscar Cliente");
		
		botonBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaBuscar ventanaBuscar = new VentanaBuscar();
				ventanaBuscar.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("Inventario");
		
		
		///////////////////////////////citas de hoy////////////////////////////////////////@gabriel
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		
		System.out.println(dateFormat.format(date));
		String fechaHoy = dateFormat.format(date);
		
		try {
			ConnectDB.Conectar();
			
			ResultSet rsCitas = ConnectDB.consult("SELECT nombre,apellidos,descripcion,pago FROM pacientes,citas WHERE fh_ult_cita LIKE '"+fechaHoy+"%' and fol_paciente = cita_fol_paciente").executeQuery();
			
			
			ResultSetMetaData rsMD = rsCitas.getMetaData();
			
			int cantidadColumnas = rsMD.getColumnCount();
			
			for (int i = 1; i <= cantidadColumnas; i++) {
				  modelo.addColumn(rsMD.getColumnLabel(i));
				 }
				 
				 while (rsCitas.next()) {
				  Object[] fila = new Object[cantidadColumnas];
				  for (int i = 0; i < cantidadColumnas; i++) {
				    fila[i]=rsCitas.getObject(i+1);
				  }
				  modelo.addRow(fila);
				 }
				 rsCitas.close();
				ConnectDB.Desconectar();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		//////////////////////////////////fin citas hoy ///////////////////////////////////////
		
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JButton btnNewButton_1 = new JButton("Notificaciones");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaRec ventanarec = new VentanaRec();
				ventanarec.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Historial de Pago");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaPagos ventanaPagos = new VentanaPagos();
				ventanaPagos.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
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
							.addComponent(btnNewButton_3)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
