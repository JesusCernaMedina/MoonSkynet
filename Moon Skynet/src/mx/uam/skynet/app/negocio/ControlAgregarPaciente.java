package mx.uam.skynet.app.negocio;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOPaciente;
import mx.uam.skynet.app.presentacion.VentanaAgregarPaciente;

public class ControlAgregarPaciente {
	
	private DAOPaciente daopaciente;
	private Paciente paciente;
	
	public ControlAgregarPaciente() {
		daopaciente = new DAOPaciente(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaAgregarPaciente window = new VentanaAgregarPaciente(this);
		window.setVisible(true);
	}
	
	public void iniciaCita(int id_paciente) {
		ControlAgregarCita ctrl = new ControlAgregarCita(id_paciente);
		ctrl.inicia();
	}
	
	public int regPaciente(String name, String last_name, String phone, String email, String age, String address) {
		paciente = new Paciente(name, last_name, phone, email, Integer.parseInt(age), address);
		int insert = daopaciente.agregaPaciente(paciente);
		return insert;
	}
	
	public int idUltRegistro() {
		int id = daopaciente.consultaUltimoPaciente();
		return id;
	}

}
