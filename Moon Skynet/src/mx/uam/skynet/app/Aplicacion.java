package mx.uam.skynet.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import mx.uam.skynet.app.negocio.ControlAgregarPaciente;
import mx.uam.skynet.app.negocio.ControlBuscarCliente;
import mx.uam.skynet.app.negocio.ControlVentanaPrincipal;
import mx.uam.skynet.app.presentacion.VentanaAgregarPaciente;
import mx.uam.skynet.app.presentacion.Inventario;
import mx.uam.skynet.app.presentacion.VentanaBuscarCliente;
import mx.uam.skynet.app.presentacion.VentanaPagos;
import mx.uam.skynet.app.presentacion.VentanaPrincipal;
import mx.uam.skynet.app.presentacion.VentanaRec;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aplicacion app = new Aplicacion();
		app.iniApp();
	}
	
	public void iniApp() {
		ControlVentanaPrincipal ctrlMain = new ControlVentanaPrincipal(this);
		ctrlMain.inicia();
	}
	
	public void agregarCliente() {
		ControlAgregarPaciente ctrl = new ControlAgregarPaciente();
		ctrl.inicia();
	}
	
	public void buscarCliente() {
		ControlBuscarCliente ctrl = new ControlBuscarCliente();
		ctrl.inicia();
	}
	
	public void inventario() {
		Inventario ventanaInventario;
		
		try {
			ventanaInventario = new Inventario();
			ventanaInventario.setVisible(true);
			ventanaInventario.setTitle("Inventario");
			Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
			int height = screen.height;
			int width =screen.width;
			ventanaInventario.setLocation(50,50);
			ventanaInventario.setSize(width-100,height-100);
			ventanaInventario.setResizable(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void notificaciones() {
		VentanaRec window = new VentanaRec();
		window.setVisible(true);
	}
	
	public void historialPago() {
		VentanaPagos window = new VentanaPagos();
		window.setVisible(true);
	}
	
	public void guiaUsuario() {
		try {
		     Runtime.getRuntime().exec("cmd /c start " + "C:\\Users\\Jesus\\Documents\\Guiadeu.pdf"); 
		     System.out.println(System.getProperty("user.name"));
		}catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "Checa los detalles del archivo");
		}
	}
}
