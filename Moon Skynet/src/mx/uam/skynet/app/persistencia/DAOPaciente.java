package mx.uam.skynet.app.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import mx.uam.skynet.app.modelo.Paciente;

public class DAOPaciente extends Querys {
	
	public DAOPaciente(Connection con) {
		super(con);
	}

	public int agregaPaciente(Paciente paciente) {
		int insert = 0;
		try {
			insert = insert("pacientes", "DEFAULT,'"+paciente.getNombre()+"','"+paciente.getApellidos()+
					"','"+paciente.getTelefono()+"','"+paciente.getCorreo()+"','"+paciente.getFh_nacimiento()+
					"','"+paciente.getDireccion()+"'");
        } catch(SQLException err) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la tabla" + err);
        }
		return insert;
	}
	
	public int consultaUltimoPaciente() {
		int id_paciente = 0;
		try {
			PreparedStatement buscar = select("MAX(fol_paciente)", "pacientes");
	        ResultSet select = buscar.executeQuery();
	        
	        while(select.next()) {
	        	id_paciente = select.getInt(1);
	        }
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return id_paciente;
	}
	
	public Paciente buscaPaciente(String folio) {
		String nombre, apellidos, telefono, correo, direccion;
		int fh_nacimiento;
		Paciente paciente;
		try {
			ResultSet result = selectWhere("nombre, apellidos, telefono, correo, fh_nacimiento, direccion", "pacientes", "fol_paciente = '"+ folio + "'").executeQuery();
			if (result.next()) {
				nombre = result.getString(1);
				apellidos = result.getString(2);
				telefono = result.getString(3);
				correo =  result.getString(4);
				fh_nacimiento = result.getInt(5);
				direccion = result.getString(6);
				paciente = new Paciente(nombre, apellidos, telefono, correo, fh_nacimiento, direccion);
				ConnectDB.Desconectar();
			} else {
				System.out.println("No se encontro nada.");
				paciente = null;
				ConnectDB.Desconectar();
			}
		} catch (Exception e) {
			paciente = null;
			e.printStackTrace();
		}
		return paciente;
	}
	
	public int actualizaDatosPaciente(Paciente paciente, String folio) {
		int update = 0;
		try {
			update = update("pacientes", "nombre='"+paciente.getNombre()+"',apellidos='"+paciente.getApellidos()+
					"',telefono='"+paciente.getTelefono()+"',correo='"+paciente.getCorreo()+
					"',fh_nacimiento='"+paciente.getFh_nacimiento()+"', direccion='"+paciente.getDireccion()+
					"'", "fol_paciente ="+folio);
		} catch(SQLException err) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la tabla" + err);
		}
		return update;
	}
	
	public Paciente buscaNombreCompleto(int fol) {
		System.out.println("Entre al metodo: buscaNombreCompleto");
		Paciente paciente = new Paciente();
		try{
	 		ResultSet rs = selectWhere("nombre, apellidos", 
	 				"pacientes", "fol_paciente = '"+fol+"'").executeQuery();
	 		while(rs.next()) {
	 			paciente.setNombre(rs.getString("nombre"));
	 			paciente.setApellidos(rs.getString("apellidos"));
	 		}
	 	}
	 	catch(Exception e){
	 		e.printStackTrace();
	 	}
		System.out.println("Estoy saliendo del metodo: buscaNombreCompleto");
		return paciente;
	}
}
