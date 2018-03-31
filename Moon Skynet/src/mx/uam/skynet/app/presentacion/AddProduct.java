package mx.uam.skynet.app.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProduct dialog = new AddProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProduct() {
		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAgregaUnNuevo = new JLabel("Agrega un nuevo producto");
		lblAgregaUnNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregaUnNuevo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAgregaUnNuevo.setBounds(10, 11, 414, 22);
		contentPanel.add(lblAgregaUnNuevo);
		
		JLabel lblNewLabel = new JLabel("Nombre del material:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(29, 72, 100, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCantidad.setBounds(29, 111, 46, 14);
		contentPanel.add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(139, 69, 212, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(85, 108, 44, 20);
		contentPanel.add(spinner);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Querys query = new Querys(ConnectDB.Conectar());
				try {
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos.");
					} else {
						int update = query.insert("inventario", "DEFAULT, '" + textField.getText() + "','" + spinner.getValue() + "'");
						if (update == 1) {
							JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
						} else {
							JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el producto.");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(173, 152, 89, 23);
		contentPanel.add(btnAceptar);
	}
}
