package mx.uam.skynet.app.negocio;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOCitas;
import mx.uam.skynet.app.persistencia.DAOPaciente;
import mx.uam.skynet.app.presentacion.VentanaModificarCita;
import mx.uam.skynet.app.presentacion.VentanaAgregarCitas;
import mx.uam.skynet.app.presentacion.VentanaHistorialClinico;

public class ControlHistorialClinico {
	
	private int folio_paciente;
	private DAOCitas daocitas;
	
	public ControlHistorialClinico(String folio) {
		folio_paciente = Integer.parseInt(folio);
		daocitas = new DAOCitas(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaHistorialClinico window = new VentanaHistorialClinico(this);
		window.setVisible(true);
		window.setTitle("Historial Clínico2");
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		int height = screen.height;
		int width = screen.width;
		window.setLocation(50,50);
		window.setSize(width-100,height-100);
		window.setResizable(false);
	}
	
	public void iniciaControlGeneraReceta() {
		ControlGeneraReceta ctrl = new ControlGeneraReceta(folio_paciente);
		ctrl.inicia();
	}
	
	public void iniciaControlAgregarCita() {
		ControlAgregarCita ctrl = new ControlAgregarCita(folio_paciente);
		ctrl.inicia();
	}
	
	public void iniciaControlModificarCita() {
		ControlModificarCita ctrl = new ControlModificarCita(folio_paciente);
		ctrl.inicia();
	}
	
	public DefaultTableModel verCitas() {
		return daocitas.buscarCitas(folio_paciente);
	}
	
	public Paciente verNombreCompleto () {
		ControlBuscarCliente ctrl = new ControlBuscarCliente();
		return ctrl.buscarPaciente(folio_paciente);
	}

}
