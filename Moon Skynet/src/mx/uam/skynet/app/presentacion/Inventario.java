package mx.uam.skynet.app.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.negocio.Modificar_cita;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;

public class Inventario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResultSet rs;
	JLabel label1 = new JLabel();
	private JButton jButton1;
	private JButton ButtonAdd;
	private JButton ButtonChange;
	private JButton ButtonRemove;
	
	private JScrollPane ScrollPane;
	private JTable datos;

	private Label label2;	
	private Panel panel1;
	
	public Inventario() throws SQLException {
		initComponents();
	}
	
	private void initComponents() throws SQLException {
		// TODO Auto-generated method stub
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = screen.width;
		final int y = screen.height;
		int windowx = ((x-100));
		int windowy = (y-100);
		
		panel1 = new java.awt.Panel();

		ScrollPane = new javax.swing.JScrollPane();
		datos = new javax.swing.JTable();
		label2 = new Label();
		jButton1 = new javax.swing.JButton();
		ButtonAdd = new javax.swing.JButton();
		ButtonChange = new javax.swing.JButton();
		ButtonRemove = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));
		getContentPane().setLayout(null);

		panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		panel1.setLayout(null);


		label2.setAlignment(java.awt.Label.CENTER);
		label2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
		label2.setText("Inventario");
		panel1.add(label2);
		label2.setBounds(0, 0, 1172, 92);

		datos.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
		
		DefaultTableModel dfm = new DefaultTableModel();
		datos.setModel(dfm);
		dfm.setColumnIdentifiers(new Object[]{"Folio de Inventario","Nombre de material","Cantidad"});

		Querys query = new Querys(ConnectDB.Conectar());
		rs = query.select("*", "inventario").executeQuery();
		 	try{
		 		while(rs.next()){
		 			dfm.addRow(new Object[]{rs.getInt("fol_inventario"),rs.getString("nombre_material"),rs.getInt("cantidad")});
		 			datos.setEnabled(false);
		 			datos.setForeground(Color.BLACK);
		 		}
		 	}
		 	catch(Exception e){
		 		e.printStackTrace();
		 	}
		
		ScrollPane.setViewportView(datos);

		panel1.add(ScrollPane);
		ScrollPane.setBounds(40, 130, 1090, 350);

			jButton1.setText("VOLVER");
			panel1.add(jButton1);

		//       BACK TO WINDOW "VentanaBuscar.java" WHERE CLEAN THE SEARCH

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});


		jButton1.setBounds((windowx/2)-80 ,windowy-100 , 140, 30);


		ButtonAdd.setText("AGREGAR");
		ButtonAdd.setBounds((windowx/9),windowy-200 , 140, 30);
		panel1.add(ButtonAdd);


		//        ADD ACTIONLISTENER BUTTON ADD
		ButtonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola add");
				AddProduct add = new AddProduct();
				add.setVisible(true);
			}
		});

		ButtonChange.setText("CAMBIAR");
		ButtonChange.setBounds((windowx/2)-80,windowy-200 , 140, 30);
		panel1.add(ButtonChange);

		//        ADD ACTIONLISTENER BUTTON POSTPONER

		ButtonChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola change");
				ChangeProduct change = new ChangeProduct();
				change.setVisible(true);
			}
		});

		ButtonRemove.setText("REMOVER");
		ButtonRemove.setBounds((windowx-(windowx/9))-140,windowy-200 , 140, 30);
		panel1.add(ButtonRemove);

		//        ADD ACTIONLISTENER BUTTON CANCEL

		ButtonRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola remove");
				RemoveProduct remove = new RemoveProduct();
				remove.setVisible(true);
			}
		});

		getContentPane().add(panel1);
		panel1.setBounds(0, 0, x, y);

		pack();
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inventario dialog = new Inventario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
