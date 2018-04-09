package mx.uam.skynet.app.negocio;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOPaciente;
import mx.uam.skynet.app.presentacion.VentanaBuscarCliente;

public class ControlBuscarCliente {
	
	private DAOPaciente daopaciente;
	
	public ControlBuscarCliente() {
		daopaciente = new DAOPaciente(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaBuscarCliente window = new VentanaBuscarCliente(this);
		window.setVisible(true);
	}
	
	public void iniciaHistorialClinico(String folio) {
		ControlHistorialClinico ctrl = new ControlHistorialClinico(folio);
		ctrl.inicia();
	}
	
	public Paciente buscarClienteFolio(String folio) {
		return daopaciente.buscaPaciente(folio);
	}
	
	public int editarPaciente(String nombre, String apellidos, String telefono, String correo, String fh_nacimiento, 
			String direccion, String folio) {
		Paciente paciente = new Paciente(nombre, apellidos, telefono, correo, Integer.parseInt(fh_nacimiento), direccion);
		return daopaciente.actualizaDatosPaciente(paciente, folio);
	}
	
	public Paciente buscarPaciente(int folio_paciente) {
		return daopaciente.buscaNombreCompleto(folio_paciente);
	}

}
