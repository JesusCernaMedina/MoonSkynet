package mx.uam.skynet.app.modelo;

public class Citas {
	
	private int num_cita;
	private int pago;
	private String fh_ult_cita;
	private String fh_prox_cita;
	private String descripcion;
	private String tratamiento;
	
	public Citas(int num_cita, int pago, String fh_ult_cita, String fh_prox_cita, String descripcion, String tratamiento) {
		this.num_cita = num_cita;
		this.pago = pago;
		this.fh_ult_cita = fh_ult_cita;
		this.fh_prox_cita = fh_prox_cita;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
	}
	
	public Citas() {}
	
	public int getNum_cita() {
		return num_cita;
	}
	public void setNum_cita(int num_cita) {
		this.num_cita = num_cita;
	}
	public int getPago() {
		return pago;
	}
	public void setPago(int pago) {
		this.pago = pago;
	}
	public String getFh_ult_cita() {
		return fh_ult_cita;
	}
	public void setFh_ult_cita(String fh_ult_cita) {
		this.fh_ult_cita = fh_ult_cita;
	}
	public String getFh_prox_cita() {
		return fh_prox_cita;
	}
	public void setFh_prox_cita(String fh_prox_cita) {
		this.fh_prox_cita = fh_prox_cita;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

}
