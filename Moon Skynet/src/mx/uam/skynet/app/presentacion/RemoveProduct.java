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
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveProduct extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFolio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RemoveProduct dialog = new RemoveProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RemoveProduct() {
		setTitle("Eliminar producto");
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEliminarProducto = new JLabel("Eliminar producto");
			lblEliminarProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblEliminarProducto.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblEliminarProducto.setBounds(10, 11, 414, 24);
			contentPanel.add(lblEliminarProducto);
		}
		{
			JLabel lblFolioDelProducto = new JLabel("Folio del producto:");
			lblFolioDelProducto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblFolioDelProducto.setBounds(98, 64, 115, 14);
			contentPanel.add(lblFolioDelProducto);
		}
		{
			textFolio = new JTextField();
			textFolio.setBounds(223, 63, 86, 20);
			contentPanel.add(textFolio);
			textFolio.setColumns(10);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Querys query = new Querys(ConnectDB.Conectar());
					try {
						int update = query.delete("inventario", "fol_inventario = '"+ textFolio.getText() +"'");
						if (update == 1) {
							JOptionPane.showMessageDialog(null, "Fila borrada con exito!");
						} else {
							JOptionPane.showMessageDialog(null, "El folio seleccionado no existe.");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnAceptar.setBounds(124, 105, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			JButton btnNewButton = new JButton("Cancelar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(220, 105, 89, 23);
			contentPanel.add(btnNewButton);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 46, 404, 1);
		contentPanel.add(separator);
	}
}
