package mx.uam.skynet.app.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.Querys;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeProduct extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textId1;
	private JTextField textName;
	private JTextField textId2;
	private JRadioButton rdbtnModificarCantidad;
	private JRadioButton rdbtnModificarNombre;
	private JSpinner NumCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeProduct dialog = new ChangeProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeProduct() {
		setTitle("Modificar producto");
		setBounds(100, 100, 497, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModificarUnProducto = new JLabel("Modificar un producto");
		lblModificarUnProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarUnProducto.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblModificarUnProducto.setBounds(10, 11, 461, 29);
		contentPanel.add(lblModificarUnProducto);
		
		rdbtnModificarNombre = new JRadioButton("Modificar Nombre");
		rdbtnModificarNombre.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtnModificarNombre.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textId2.setEditable(false);
				NumCant.setEnabled(false);
				textId1.setEditable(true);
				textName.setEditable(true);
				System.out.println("Nombre: " + rdbtnModificarNombre.isSelected());
			}
		});
		rdbtnModificarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnModificarNombre.setBounds(186, 47, 116, 23);
		contentPanel.add(rdbtnModificarNombre);
		
		rdbtnModificarCantidad = new JRadioButton("Modificar cantidad");
		rdbtnModificarCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtnModificarCantidad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textId1.setEditable(false);
				textName.setEditable(false);
				textId2.setEditable(true);
				NumCant.setEnabled(true);
				System.out.println("Cantidad: " + rdbtnModificarCantidad.isSelected());
			}
		});
		rdbtnModificarCantidad.setBounds(186, 119, 116, 23);
		contentPanel.add(rdbtnModificarCantidad);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnModificarCantidad);
		grupo1.add(rdbtnModificarNombre);
		
		JLabel lblFolioAModificar = new JLabel("Folio a modificar:");
		lblFolioAModificar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFolioAModificar.setBounds(33, 84, 103, 14);
		contentPanel.add(lblFolioAModificar);
		
		textId1 = new JTextField();
		textId1.setBounds(135, 82, 52, 20);
		contentPanel.add(textId1);
		textId1.setColumns(10);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo nombre:");
		lblNuevoNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNuevoNombre.setBounds(223, 84, 92, 14);
		contentPanel.add(lblNuevoNombre);
		
		textName = new JTextField();
		textName.setBounds(314, 82, 137, 20);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		JLabel label = new JLabel("Folio a modificar:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(33, 163, 103, 14);
		contentPanel.add(label);
		
		textId2 = new JTextField();
		textId2.setColumns(10);
		textId2.setBounds(135, 161, 65, 20);
		contentPanel.add(textId2);
		
		JLabel lblNuevaCantidad = new JLabel("Nueva cantidad:");
		lblNuevaCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNuevaCantidad.setBounds(237, 165, 92, 14);
		contentPanel.add(lblNuevaCantidad);
		
		NumCant = new JSpinner();
		NumCant.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		NumCant.setBounds(331, 163, 65, 20);
		contentPanel.add(NumCant);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnModificarCantidad.isSelected()) {
					Querys query = new Querys(ConnectDB.Conectar());
					try {
						int update = query.update("inventario", "cantidad = '"+ NumCant.getValue() +"'", "fol_inventario = '"+ textId2.getText() +"'");
						if (update == 1) {
							JOptionPane.showMessageDialog(null, "Cantidad actualizada con exito!");
						} else {
							JOptionPane.showMessageDialog(null, "Error al actiualizar!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if(rdbtnModificarNombre.isSelected()) {
					Querys query = new Querys(ConnectDB.Conectar());
					try {
						int update = query.update("inventario", "nombre_material = '"+ textName.getText() +"'", "fol_inventario = '"+ textId1.getText() +"'");
						if (update == 1) {
							JOptionPane.showMessageDialog(null, "Nombre actualizado con exito!");
						} else {
							JOptionPane.showMessageDialog(null, "Error al actiualizar!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona una opcion");
				}
			}
		});
		btnAceptar.setBounds(202, 216, 89, 23);
		contentPanel.add(btnAceptar);
	}
}
