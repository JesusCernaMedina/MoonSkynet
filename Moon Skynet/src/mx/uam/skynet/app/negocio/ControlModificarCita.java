package mx.uam.skynet.app.negocio;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOCitas;
import mx.uam.skynet.app.persistencia.Querys;
import mx.uam.skynet.app.presentacion.VentanaHistorialClinico;
import mx.uam.skynet.app.presentacion.VentanaModificarCita;

public class ControlModificarCita {
	
	private int fol_paciente;
	private DAOCitas daocita;
	
	public ControlModificarCita(int fol) {
		fol_paciente = fol;
		daocita = new DAOCitas(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaModificarCita WindowsPostpone = new VentanaModificarCita(this);
		WindowsPostpone.setVisible(true);
		WindowsPostpone.setTitle("Modificar Cita");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screen.height;
		int width = screen.width;
		WindowsPostpone.setLocation(width/4, height/5);
		WindowsPostpone.setSize(width/2, (height/2)+50);
		WindowsPostpone.setResizable(false);
	}
	
	public boolean cancelarCita(String num_cita) {
		int delete = daocita.eliminarCita(num_cita, fol_paciente);
		if (delete == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean modificarCita(String num_cita, String fh_nueva_cita) {
		int update = daocita.actualizaCita(num_cita, fh_nueva_cita, fol_paciente);
		if (update ==1) {
			return true;
		} else {
			return false;
		}
	}

}
