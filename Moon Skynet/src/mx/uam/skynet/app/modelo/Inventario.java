package mx.uam.skynet.app.modelo;

public class Inventario {
	
	private int fol_inventario;
	private int cantidad;
	private String nombre_material;
	
	public Inventario(int fol_inventario, int cantidad, String nombre_material) {
		this.fol_inventario = fol_inventario;
		this.cantidad = cantidad;
		this.nombre_material = nombre_material;
	}
	
	public Inventario() {}
	
	public int getFol_inventario() {
		return fol_inventario;
	}
	public void setFol_inventario(int fol_inventario) {
		this.fol_inventario = fol_inventario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre_material() {
		return nombre_material;
	}
	public void setNombre_material(String nombre_material) {
		this.nombre_material = nombre_material;
	}
	
	

}
