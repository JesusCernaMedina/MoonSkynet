package mx.uam.skynet.app.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.negocio.ControlHistorialClinico;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;


public class VentanaHistorialClinico extends JFrame {
	
	private JLabel label1 = new JLabel();
	private ControlHistorialClinico ctrl;

	private static final long serialVersionUID = 1L;

	public VentanaHistorialClinico(ControlHistorialClinico ctrl) {
		this.ctrl = ctrl;
		initComponents();
	}

	private void initComponents() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = screen.width;
		final int y = screen.height;
		int windowx = ((x-70));
		int windowy = (y-70);

		label3 = new java.awt.Label();
		panel1 = new java.awt.Panel();

		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		label2 = new java.awt.Label();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		ButtonAdd = new javax.swing.JButton();
		ButtonPostpone = new javax.swing.JButton();
		ButtonCancel = new javax.swing.JButton();
		JButton ButtonGR = new javax.swing.JButton();

		label3.setAlignment(java.awt.Label.CENTER);
		label3.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N

		setBackground(new java.awt.Color(255, 255, 255));
		getContentPane().setLayout(null);

		panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		panel1.setLayout(null);

		label1.setAlignmentX(java.awt.Label.CENTER);
		label1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
		panel1.add(label1);
		label1.setBounds(110, 110, 1172, 92);

		jTable2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
		
		DefaultTableModel dfm = new DefaultTableModel();
		dfm = ctrl.verCitas();
		jTable2.setModel(dfm);
		 	
		jScrollPane2.setViewportView(jTable2);

		panel1.add(jScrollPane2);
		jScrollPane2.setBounds(40, 130, 1090, 350);

		jLabel2.setBackground(new java.awt.Color(204, 204, 204));
		jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Paciente:");
		panel1.add(jLabel2);
		jLabel2.setBounds(40, 100, 540, 30);

		label2.setAlignment(java.awt.Label.CENTER);
		label2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
		label2.setText("Historial Cl\u00ednico");
		panel1.add(label2);
		label2.setBounds(0, 0, 1172, 92);
		
		Paciente paciente = ctrl.verNombreCompleto();
	 	
		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText(paciente.getNombre() +" "+ paciente.getApellidos());
		panel1.add(jLabel1);
		jLabel1.setBounds(580, 100, 550, 30);
	

		ButtonAdd.setText("Agregar");
		ButtonAdd.setBounds((windowx/9),windowy-200 , 140, 30);
		panel1.add(ButtonAdd);
		ButtonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciaControlAgregarCita();
			}
		});

		//        ADD ACTIONLISTENER BUTTON ADD

		ButtonPostpone.setText("Modificar Cita");
		ButtonPostpone.setBounds((windowx/2)-80,windowy-200 , 140, 30);
		panel1.add(ButtonPostpone);

		//        ADD ACTIONLISTENER BUTTON POSTPONER

		ButtonPostpone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciaControlModificarCita();
			}
		});

		ButtonCancel.setText("Cancelar");
		ButtonCancel.setBounds((windowx-(windowx/9))-140,windowy-200 , 140, 30);
		panel1.add(ButtonCancel);

		//        ADD ACTIONLISTENER BUTTON CANCEL

		ButtonCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		ButtonGR.setText("Generar Receta");
		ButtonGR.setBounds((windowx-(windowx/9))-585,windowy-150 , 140, 30);
		panel1.add(ButtonGR);

		ButtonGR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciaControlGeneraReceta();
			}
		});

		getContentPane().add(panel1);
		panel1.setBounds(0, 0, x, y);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ControlHistorialClinico ctrl = new ControlHistorialClinico("2");
			VentanaHistorialClinico dialog = new VentanaHistorialClinico(ctrl);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton jButton1;
	private javax.swing.JButton ButtonAdd;
	private javax.swing.JButton ButtonPostpone;
	private javax.swing.JButton ButtonCancel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable2;

	private java.awt.Label label2;
	private java.awt.Label label3;
	private java.awt.Panel panel1;


	// End of variables declaration//GEN-END:variables
}
