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
	public void buscaClienteEspecifico(String folio) throws SQLException {
		System.out.println("Hola1");
		ResultSet resultApellido = consult("SELECT apellidos FROM pacientes WHERE fol_paciente = '"+folio + "'").executeQuery();
		if (resultApellido.next()) {
			apellido = resultApellido.getString(1);
	        Desconectar();
		} else {
			System.out.println("No se encontro nada. 1");
	        Desconectar();
		}
		    
		    ResultSet resultNombre = consult("SELECT nombre FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
		    if (resultNombre.next()) {
		    	nombre = resultNombre.getString(1);
			    Desconectar();
			} else {
				System.out.println("No se encontro nada. 2");
			    Desconectar();
			}
		    
		    
		    ResultSet resultTelefono = consult("SELECT telefono FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
		    if (resultTelefono.next()) {
		    	telefono = resultTelefono.getString(1);
			    Desconectar();
			} else {
				System.out.println("No se encontro nada. 3");
			    Desconectar();
			}
		    
		    
		    ResultSet resultCorreo = consult("SELECT correo FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
		    if (resultCorreo.next()) {
		    	correo =  resultCorreo.getString(1);
			    Desconectar();
			} else {
				System.out.println("No se encontro nada. 4");
			    Desconectar();
			}
		    
		    
		    ResultSet resultFH_nacimiento = consult("SELECT fh_nacimiento FROM pacientes WHERE fol_paciente = '"+folio+ "'").executeQuery();
		    if (resultFH_nacimiento.next()) {
		    	fh_nacimento = resultFH_nacimiento.getInt(1);
			    Desconectar();
			} else {
				System.out.println("No se encontro nada. 5");
			    Desconectar();
			}
         
	}
//////////////////Fin busqueda cliente especifico ////////////////////////@author Gabriel Lopez Hernandez
	
	public static PreparedStatement consult(String sql) throws SQLException {
		PreparedStatement consultar = ConnectDB.Conectar().prepareStatement(sql);
		return consultar;
	}
	

	private static Connection expediente;
	public static  Statement stm;
	
    public static Connection Conectar() {
        try {
            expediente = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/moonskynet"
             ,"id3287223_artperform","098mklas");
            
//            stm = expediente.createStatement();

            if(expediente!=null){
                System.out.println("Conecxion lista..");
                
            }else if(expediente==null){
                throw new SQLException();
            }
		    
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la conexion"+" a la base de datos"+error);
        }
        return expediente;
        
        
    }
    
    
    public static Connection Desconectar(){
        expediente=null;
        return expediente;
    }

}
