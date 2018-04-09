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
}

