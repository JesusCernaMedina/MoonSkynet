package mx.uam.skynet.app.modelo;

public class Paciente {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correo;
	private int fh_nacimiento;
	private String direccion;
	
	public Paciente(String nombre, String apellidos, String telefono, String correo, int fh_nacimiento, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.fh_nacimiento = fh_nacimiento;
		this.direccion = direccion;
	}
	
	public Paciente() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getFh_nacimiento() {
		return fh_nacimiento;
	}

	public void setFh_nacimiento(int fh_nacimiento) {
		this.fh_nacimiento = fh_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
