package mx.uam.skynet.app.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAOCitas extends Querys {
	
	public DAOCitas(Connection con) {
		super(con);
	}

	public DefaultTableModel buscarCitasProximas(String fechaHoy) {
		DefaultTableModel modelo = new DefaultTableModel();
		try {
			ResultSet rsCitas = selectWhere("cita_fol_paciente, fh_prox_cita, descripcion, tratamiento, pago", 
													"citas", "fh_prox_cita >= '"+fechaHoy+"'").executeQuery();
			ResultSetMetaData rsMD = rsCitas.getMetaData();
			int cantidadColumnas = rsMD.getColumnCount();
			for (int i = 1; i <= cantidadColumnas; i++) {
				modelo.addColumn(rsMD.getColumnLabel(i));
			}
			while (rsCitas.next()) {
				Object[] fila = new Object[cantidadColumnas];
				for (int i = 0; i < cantidadColumnas; i++) {
					fila[i] = rsCitas.getObject(i+1);
				}
				modelo.addRow(fila);
			}
			rsCitas.close();
			ConnectDB.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}
	
	public int insertarCita(int id_paciente, String txt_fh_cita, String txt_prox_cita, String txt_desc, 
								String txt_tratamiento, int txt_pago) {
		int insert = 0;
		try {
			insert = insert("citas", "'"+id_paciente+"', DEFAULT,'"+txt_fh_cita+
            		"','"+txt_prox_cita+"','"+txt_desc+"','"+txt_tratamiento+"','"+txt_pago+"'");                   
        } catch(SQLException err) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la tabla" + err);
        }
		return insert;
	}
	
	public DefaultTableModel buscarCitas(int fol) {
		DefaultTableModel dfm = new DefaultTableModel();
		try {
			ResultSet rs = selectWhere("cita_fol_paciente, num_cita, fh_ult_cita, descripcion, tratamiento, fh_prox_cita", 
	 				"citas", "cita_fol_paciente = '"+fol+"'").executeQuery();
			dfm.setColumnIdentifiers(new Object[]{"Folio de cita","Numero de cita","Ultima cita","Descripci\u00f3n","Tratamiento","Pr\u00f3xima cita"});
	 		while(rs.next()) {
	 			dfm.addRow(new Object[]{rs.getInt("cita_fol_paciente"),rs.getInt("num_cita"),rs.getString("fh_ult_cita"),rs.getString("descripcion"), rs.getString("tratamiento"), rs.getString("fh_prox_cita")});
	 		}
	 		ConnectDB.Desconectar();
	 	}
	 	catch(Exception e){
	 		e.printStackTrace();
	 	}
		return dfm;
	}
	
	public int eliminarCita(String num_cita, int folio) {
		int delete = 0;
		try {
			delete = update("citas", "fh_prox_cita = null", "cita_fol_paciente='"+folio+"' AND num_cita='"+num_cita+"'");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return delete;
	}
	
	public int actualizaCita(String num_cita, String fh_nueva_cita, int folio) {
		int update = 0;
		try {
			update = update("citas", "fh_prox_cita = '"+fh_nueva_cita+"'", "cita_fol_paciente='"+folio+"' AND num_cita='"+num_cita+"'");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return update;
	}
}
