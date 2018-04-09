package mx.uam.skynet.app.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import mx.uam.skynet.app.Aplicacion;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOCitas;
import mx.uam.skynet.app.presentacion.VentanaPrincipal;

public class ControlVentanaPrincipal {
	
	private DAOCitas daocitas;
	private Aplicacion app;
	
	public ControlVentanaPrincipal(Aplicacion app) {
		this.app = app;
		daocitas = new DAOCitas(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaPrincipal window = new VentanaPrincipal(this, app);
		window.setVisible(true);
	}
	
	public DefaultTableModel citasProximas() {
		DefaultTableModel modelo = new DefaultTableModel();
		Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fechaHoy = dateFormat.format(date);
		System.out.println(fechaHoy);
		
		modelo = daocitas.buscarCitasProximas(fechaHoy);
		
		return modelo;
	}
}
