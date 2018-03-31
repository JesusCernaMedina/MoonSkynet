package mx.uam.skynet.app.presentacion;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Citas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_fh_cita;
	private JTextField txt_prox_cita;
	private JTextField txt_desc;
	private JTextField txt_tratamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Citas dialog = new Citas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int id_cita;
	private JTextField txt_pago;
	private JButton btn_Save = new JButton("Guardar avance");
	private JLabel lblPago = new JLabel("Pago:");
	private JLabel lblTratamiento = new JLabel("Tratamiento:");
	private JLabel lblDescripcion = new JLabel("Descripcion:");
	private JLabel lblProximaCita = new JLabel("Proxima cita:");
	private JLabel lblFechaCita = new JLabel("Fecha cita:");
	private JLabel lblNuevaCita = new JLabel("Nueva Cita");
	
	public Citas(int id) {
		id_cita = id;
		initComponents();
		
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Querys query = new Querys(ConnectDB.Conectar());
					int update = query.insert("citas", "'"+id_cita+"', DEFAULT,'"+txt_fh_cita.getText()+
                    		"','"+txt_prox_cita.getText()+"','"+txt_desc.getText()+"','"+txt_tratamiento.getText()+
                    		"','"+Integer.parseInt(txt_pago.getText())+"'");
		            if(update == 1){
		                JOptionPane.showMessageDialog(null, "Avance guardado con exito");
		            } else {
		                JOptionPane.showMessageDialog(null, "Avance NO guardado");
		            }                   
		        } catch(SQLException err) {
		            JOptionPane.showMessageDialog(null, "Hubo un error en la tabla" + err);
		        }
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	public Citas() {
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Nueva cita");
		setBounds(100, 100, 333, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNuevaCita.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNuevaCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCita.setBounds(10, 11, 297, 32);
		contentPanel.add(lblNuevaCita);
		
		lblFechaCita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblFechaCita.setBounds(20, 54, 66, 17);
		contentPanel.add(lblFechaCita);
		
		lblProximaCita.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblProximaCita.setBounds(20, 82, 81, 17);
		contentPanel.add(lblProximaCita);
		
		lblDescripcion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblDescripcion.setBounds(20, 110, 73, 17);
		contentPanel.add(lblDescripcion);
		
		lblTratamiento.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblTratamiento.setBounds(20, 138, 81, 17);
		contentPanel.add(lblTratamiento);
		
		lblPago.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPago.setBounds(20, 166, 35, 17);
		contentPanel.add(lblPago);
		
		btn_Save.setBounds(104, 212, 129, 23);
		contentPanel.add(btn_Save);
		
		txt_fh_cita = new JTextField();
		txt_fh_cita.setBounds(96, 53, 200, 20);
		contentPanel.add(txt_fh_cita);
		txt_fh_cita.setColumns(10);
		
		txt_prox_cita = new JTextField();
		txt_prox_cita.setBounds(111, 81, 185, 20);
		contentPanel.add(txt_prox_cita);
		txt_prox_cita.setColumns(10);
		
		txt_desc = new JTextField();
		txt_desc.setBounds(96, 107, 200, 20);
		contentPanel.add(txt_desc);
		txt_desc.setColumns(10);
		
		txt_tratamiento = new JTextField();
		txt_tratamiento.setBounds(106, 137, 190, 20);
		contentPanel.add(txt_tratamiento);
		txt_tratamiento.setColumns(10);
		
		txt_pago = new JTextField();
		txt_pago.setBounds(65, 166, 86, 20);
		contentPanel.add(txt_pago);
		txt_pago.setColumns(10);
	}
}
