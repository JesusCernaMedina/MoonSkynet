package mx.uam.skynet.app.negocio;

import javax.swing.JOptionPane;

import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOCitas;
import mx.uam.skynet.app.presentacion.VentanaAgregarCitas;

public class ControlAgregarCita {
	
	private int id_paciente;
	private DAOCitas daocitas;
	
	public ControlAgregarCita(int id_paciente) {
		this.id_paciente = id_paciente;
		daocitas = new DAOCitas(ConnectDB.Conectar());
	}
	
	public void inicia() {
		VentanaAgregarCitas cita = new VentanaAgregarCitas(this);
        cita.setVisible(true);
	}
	
	public void agendarCita(String txt_fh_cita, String txt_prox_cita, String txt_desc, String txt_tratamiento, String txt_pago) {
		int insert = daocitas.insertarCita(id_paciente, txt_fh_cita, txt_prox_cita, txt_desc, txt_tratamiento, Integer.parseInt(txt_pago));
		if(insert == 1){
            JOptionPane.showMessageDialog(null, "Cita guardada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Cita NO guardada.\nVerifique que los datos ean correctos.");
        }
	}

}
