package mx.uam.skynet.app.persistencia;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * @author Jesus Cerna Medina
 */
public class ConnectDB {

	//////////////////inicio Datos Cliente ////////////////////////@author Gabriel Lopez Hernandez

	private static String apellido;
	private static String nombre;
	private static String telefono;
	private static String correo;
	private static int fh_nacimento;
	private static String direccion;
	private static int folio_cita;
	private int row;
	
	public static int getFolio_cita() {
		return folio_cita;
	}

	public static void setFolio_cita(int folio_cita) {
		ConnectDB.folio_cita = folio_cita;
	}

	public static String getCita_previa() {
		return cita_previa;
	}

	public static void setCita_previa(String cita_previa) {
		ConnectDB.cita_previa = cita_previa;
	}

	public static String getCita_nueva() {
		return cita_nueva;
	}

	public static void setCita_nueva(String cita_nueva) {
		ConnectDB.cita_nueva = cita_nueva;
	}

	private static String cita_previa;
	private static String cita_nueva; 
	
//	ARRAY TYPE OBJECT TO SAVE THE ALL APPOINTMENT OF THE PATIENT
	private static Object[] obj  ;



	public static Object[] getObj() {
		return obj;
	}

	public static void setObj(Object[] obj) {
		ConnectDB.obj = obj;
	}

	public static String getDireccion() {
		return direccion;
	}

	public static void setDireccion(String direccion) {
		ConnectDB.direccion = direccion;
	}

	public static String getApellido() {
		return apellido;
	}

	public static void setApellido(String apellido) {
		ConnectDB.apellido = apellido;
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		ConnectDB.nombre = nombre;
	}

	public static String getTelefono() {
		return telefono;
	}

	public static void setTelefono(String telefono) {
		ConnectDB.telefono = telefono;
	}

	public static String getCorreo() {
		return correo;
	}

	public static void setCorreo(String correo) {
		ConnectDB.correo = correo;
	}

	public static int getFh_nacimento() {
		return fh_nacimento;
	}

	public static void setFh_nacimento(int fh_nacimento) {
		ConnectDB.fh_nacimento = fh_nacimento;
	}

	//////////////////Fin de Datos Cliente ////////////////////////@author Gabriel Lopez Hernandez

	//////////////////inicio Busqueda cliente especifico ////////////////////////@author Gabriel Lopez Hernandez
//	public void buscaClienteEspecifico(String folio) throws SQLException {
//		ResultSet resultApellido = consult("SELECT apellidos FROM pacientes WHERE fol_paciente = '"+folio + "'").executeQuery();
//		if (resultApellido.next()) {
//			apellido = resultApellido.getString(1);
//			Desconectar();
//		} else {
////			System.out.println("No se encontro nada. 1");
//			Desconectar();
//		}
//		
//		ResultSet resultNombre = consult("SELECT nombre FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
//		if (resultNombre.next()) {
//			nombre = resultNombre.getString(1);
//			Desconectar();
//		} else {
////			System.out.println("No se encontro nada. 2");
//			Desconectar();
//		}
//
//
//		ResultSet resultTelefono = consult("SELECT telefono FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
//		if (resultTelefono.next()) {
//			telefono = resultTelefono.getString(1);
//			Desconectar();
//		} else {
////			System.out.println("No se encontro nada. 3");
//			Desconectar();
//		}
//
//		ResultSet resultCorreo = consult("SELECT correo FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
//		if (resultCorreo.next()) {
//			correo =  resultCorreo.getString(1);
//			Desconectar();
//		} else {
//			
//			Desconectar();
//		}
//
//
//		ResultSet resultFH_nacimiento = consult("SELECT fh_nacimiento FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
//		if (resultFH_nacimiento.next()) {
//			fh_nacimento = resultFH_nacimiento.getInt(1);
//			Desconectar();
//		} else {
//			
//			Desconectar();
//		}
//		
//
//		ResultSet resultDireccion = consult("SELECT direccion FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
//		if (resultDireccion.next()) {
//			direccion = resultDireccion.getString(1);
//			Desconectar();
//		} else {
//			
//			Desconectar();
//		}
//	}
	//////////////////Fin busqueda cliente especifico ////////////////////////@author Gabriel Lopez Hernandez


//	SEARCH APOINTMENT PATIENT
//	public ResultSet AppointmentPatient(String folio){
//		Connection cn= Conectar();
//		Statement st;
//		ResultSet rs = null;
//		try {
//			
//			st = cn.createStatement();
//			rs= st.executeQuery("SELECT cita_fol_paciente, fh_ult_cita, descripcion, tratamiento, fh_prox_cita "
//					+ "FROM citas WHERE cita_fol_paciente = '"+folio+"'");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
	
//	POSTPONE APPOINTMENT

//	public void postponeButton(String folio, int folio_cita, String fecha_nueva){
//		Connection cn= Conectar();
//		PreparedStatement pst;
//		
//		try {
//			System.out.println( fecha_nueva+" "+folio +" "+folio_cita );
//			pst= cn.prepareStatement("UPDATE citas, pacientes SET  fh_prox_cita= '"+fecha_nueva+"' WHERE fol_paciente='"+folio+"' AND cita_fol_paciente='"+folio_cita+"'");
//			row= pst.executeUpdate();
//			System.out.println(row);
//			
//			if (row>0) {
//				System.out.println("Se ha actualizado correctamente");
//				
//				Desconectar();
//			} else {
//				
//				Desconectar();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
	
	// CANCEL APPOINTMENT 
//	public void cancelButton(String folio, int folio_cita, String fecha_nueva){
//		
//		Connection cn= Conectar();
//		PreparedStatement pst;
//		
//		try {
//			System.out.println( fecha_nueva+" "+folio +" "+folio_cita );
//			pst= cn.prepareStatement("UPDATE citas, pacientes SET  fh_prox_cita= null WHERE fol_paciente='"+folio+"' AND cita_fol_paciente='"+folio_cita+"'" );
//			row= pst.executeUpdate();
//			System.out.println(row);
//			
//			if (row>0) {
//				System.out.println("Se ha actualizado correctamente");
//				
//				Desconectar();
//			} else {
//				
//				Desconectar();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public static PreparedStatement consult(String sql) throws SQLException {
		PreparedStatement consultar = ConnectDB.Conectar().prepareStatement(sql);
		return consultar;
	}

	private static Connection connection;
	public static  Statement stm;

	public static Connection Conectar() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moonskynet", 
					"id3287223_artperform","098mklas");
			if(connection != null){
				System.out.println("Conexion lista..");
			} else if(connection == null) {
				throw new SQLException();
			}
		} catch(SQLException err) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la conexion a la base de datos. " + err);
		}
		return connection;
	}

	public static Connection Desconectar(){
		connection = null;
		return connection;
	}
	
//	public ResultSet Inventario() {
//		Connection cn= Conectar();
//		Statement st;
//		ResultSet rs = null;
//		try {
//			st = cn.createStatement();
//			rs= st.executeQuery("SELECT * FROM inventario ");
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		return rs;
//	}
}
