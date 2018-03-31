package mx.uam.skynet.app.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface RequestSql {
	
	/**
	 * Metodo encargado de realizar una insercion a la base de datos.
	 * @param tables Tablas a realizar la insercion.
	 * @param values Valores a insertar.
	 * @return Retorna un entero donde 1 es exitoso y 0 es fallido.
	 * @throws SQLException
	 */
	public int insert(String tables, String values) throws SQLException;
	
	/**
	 * Metodo encargado de actualizar en la base de datos.
	 * @param tables Tablas a realizar la actualizacion.
	 * @param set Valores a modificar.
	 * @param where Condicion para actualizar.
	 * @return Retorna un entero donde 1 es exitoso y 0 es fallido.
	 * @throws SQLException
	 */
	public int update(String tables, String set, String where) throws SQLException;
	
	/**
	 * Metodo encargado de seleccionar en la base de datos.
	 * @param columns Columnas a mostrar.
	 * @param tables Tablas a seleccionar.
	 * @param where Condicion para mostrar las columnas.
	 * @return Retorna el objeto con los valores de cada columna.
	 * @throws SQLException
	 */
	public PreparedStatement selectWhere(String columns, String tables, String where) throws SQLException;
	
	/**
	 * Metodo encargado de seleccionar en la base de datos.
	 * @param columns Columnas a mostrar.
	 * @param tables Tablas a seleccionar.
	 * @return Retorna el objeto con los valores de cada columna.
	 * @throws SQLException
	 */
	public PreparedStatement select(String columns, String tables) throws SQLException;
	
	/**
	 * Metodo encargado de borrar en la base de datos.
	 * @param table Tabla donde se borraran registros.
	 * @param where Condicion para borrar registros.
	 * @return Retorna un entero donde 1 es exitoso y 0 es fallido.
	 * @throws SQLException
	 */
	public int delete(String table, String where) throws SQLException;

}
