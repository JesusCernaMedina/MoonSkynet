package mx.uam.skynet.app.persistencia;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
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
	private static String fh_nacimento;
	
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

	public static String getFh_nacimento() {
		return fh_nacimento;
	}

	public static void setFh_nacimento(String fh_nacimento) {
		ConnectDB.fh_nacimento = fh_nacimento;
	}
	
//////////////////Fin de Datos Cliente ////////////////////////@author Gabriel Lopez Hernandez
	
	
//////////////////inicio Busqueda cliente especifico ////////////////////////@author Gabriel Lopez Hernandez
	public void buscaClienteEspecifico(String folio) throws SQLException
	{
		 ResultSet resultApellido = stm.executeQuery("SELECT apellidos FROM clientes WHERE folio = "+folio);
         apellido = resultApellido.toString();
		    
		    ResultSet resultNombre = stm.executeQuery("SELECT nombre FROM clientes WHERE folio = "+folio);
		    nombre = resultNombre.toString();
		    
		    ResultSet resultTelefono = stm.executeQuery("SELECT telefono FROM clientes WHERE folio = "+folio);
		    telefono = resultTelefono.toString();
		    
		    ResultSet resultCorreo = stm.executeQuery("SELECT correo FROM clientes WHERE folio = "+folio);
		    correo =  resultCorreo.toString();
		    
		    ResultSet resultFH_nacimiento = stm.executeQuery("SELECT fh_nacimiento FROM clientes WHERE folio = "+folio);
		    fh_nacimento = resultFH_nacimiento.toString();
         
	}
//////////////////Fin busqueda cliente especifico ////////////////////////@author Gabriel Lopez Hernandez
	

	private static Connection expediente;
	public static  Statement stm;
	
    public static Connection Conectar(){
        try {
            expediente = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/moonskynet"
             ,"id3287223_artperform","098mklas");
            
            stm = expediente.createStatement();
           
            
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
