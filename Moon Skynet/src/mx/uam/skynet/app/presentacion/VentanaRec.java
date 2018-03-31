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
import mx.uam.skynet.app.persistencia.Querys;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static java.util.Calendar.DATE;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Jesus Cerna Medina
 *
 */
public class VentanaRec extends JFrame {

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
					VentanaRec frame = new VentanaRec();
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
	public VentanaRec() {
		setTitle("Citas de Ma\u00F1ana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		///////////////////////////////citas de hoy////////////////////////////////////////@gabriel
        
       
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		
		////////////fecha mañana/////////////////////////////
		
		Calendar calendario = Calendar.getInstance();
		
		
		
		
		calendario.add(DATE,1);
		
		int año = calendario.get(Calendar.YEAR);
		int mes = (calendario.get(Calendar.MONTH)+1);
		int mañana = calendario.get(Calendar.DAY_OF_MONTH);
		
		String fechaManana = String.format("%d-%02d-%02d",año,mes,mañana);
		
		
		
		
		
		
		
		
		////////////////fin fecha mañana///////////////////////////
		
		try {
			Querys query = new Querys(ConnectDB.Conectar());			
			ResultSet rsCitas = query.selectWhere("nombre,apellidos,descripcion,pago", "pacientes,citas", "fh_prox_cita LIKE '"+fechaManana+"%' and fol_paciente = cita_fol_paciente").executeQuery();
			
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
