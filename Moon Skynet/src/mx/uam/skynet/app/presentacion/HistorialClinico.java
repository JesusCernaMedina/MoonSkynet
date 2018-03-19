package mx.uam.skynet.app.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.persistencia.ConnectDB;


public class HistorialClinico extends JFrame {
	ResultSet rs;
	JLabel label1 = new JLabel();


	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Historial_clinico
	 * @throws SQLException 
	 */
	public HistorialClinico(String fol) throws SQLException {
		
		initComponents(fol);
	}
	String folio; 

	private void initComponents(final String fol) throws SQLException {
		folio = fol;
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

		label3.setAlignment(java.awt.Label.CENTER);
		label3.setFont(new java.awt.Font("Arabic Typesetting", 0, 48)); // NOI18N
		label3.setText("Historial Cl\u00ednico");


		setBackground(new java.awt.Color(255, 255, 255));
		getContentPane().setLayout(null);

		panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		panel1.setLayout(null);

		label1.setAlignmentX(java.awt.Label.CENTER);
		label1.setFont(new java.awt.Font("Arabic Typesetting", 0, 48)); // NOI18N
		label1.setText("Historial Cl\u00ednico");
		panel1.add(label1);
		label1.setBounds(0, 0, 1172, 92);



		jTable2.setFont(new java.awt.Font("Arabic Typesetting", 0, 20)); // NOI18N
		
		DefaultTableModel dfm = new DefaultTableModel();
		jTable2.setModel(dfm);
		dfm.setColumnIdentifiers(new Object[]{"Folio de cita","Ultima cita","Descripci\u00f3n","Tratamiento","Pr\u00f3xima cita"});
		
		ConnectDB con = new ConnectDB();
		rs= con.AppointmentPatient(fol);
		 	try{
		 		while(rs.next()){
		 			dfm.addRow(new Object[]{rs.getInt("cita_fol_paciente"),rs.getString("fh_ult_cita"),rs.getString("descripcion"), rs.getString("tratamiento"), rs.getString("fh_prox_cita")});
		 		}
		 	}
		 	catch(Exception e){
		 		e.printStackTrace();
		 	}
		
			

		jScrollPane2.setViewportView(jTable2);

		panel1.add(jScrollPane2);
		jScrollPane2.setBounds(40, 130, 1090, 350);

		jLabel2.setBackground(new java.awt.Color(204, 204, 204));
		jLabel2.setFont(new java.awt.Font("Arabic Typesetting", 0, 36)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Paciente:");
		panel1.add(jLabel2);
		jLabel2.setBounds(40, 100, 540, 30);

		label2.setAlignment(java.awt.Label.CENTER);
		label2.setFont(new java.awt.Font("Arabic Typesetting", 0, 48)); // NOI18N
		label2.setText("Historial Cl\u00ednico");
		panel1.add(label2);
		label2.setBounds(0, 0, 1172, 92);

			jLabel1.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
			jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel1.setText(ConnectDB.getNombre()+" "+ ConnectDB.getApellido() );
			panel1.add(jLabel1);
			jLabel1.setBounds(580, 100, 550, 30);
	

		ButtonAdd.setText("Agregar");
		ButtonAdd.setBounds((windowx/9),windowy-200 , 140, 30);
		panel1.add(ButtonAdd);
		ButtonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		try {
			
			Citas dialog = new Citas(Integer.parseInt(fol));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
				// TODO Auto-generated method stub

				ModificarCita WindowsPostpone= new ModificarCita(fol);

				WindowsPostpone.setVisible(true);
				WindowsPostpone.setTitle("Modificar Cita");

				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				int height = screen.height;
				int width = screen.width;
				WindowsPostpone.setLocation(width/4, height/5);
				WindowsPostpone.setSize(width/2, (height/2)+50);
				WindowsPostpone.setResizable(false);

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


		getContentPane().add(panel1);
		panel1.setBounds(0, 0, x, y);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */


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
