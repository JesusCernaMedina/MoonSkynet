package mx.uam.skynet.app.negocio;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOPaciente;
import mx.uam.skynet.app.presentacion.VentanaGenerarReceta;

public class ControlGeneraReceta {
	
	private int folio;
	private DAOPaciente daopaciente;
	
	public ControlGeneraReceta(int folio) {
		this.folio = folio;
		daopaciente = new DAOPaciente(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaGenerarReceta window = new VentanaGenerarReceta(this);
		window.setVisible(true);
		window.setTitle("Generar Receta");
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int height = screen.height;
		int width =screen.width;
		window.setLocation(50,50);
		window.setSize(width-100,height-100);
		window.setResizable(false);
	}
	
	public Paciente buscarNombrePaciente() {
		return daopaciente.buscaNombreCompleto(folio);
	}
	
	public int getFolio() {
		return this.folio;
	}
}
