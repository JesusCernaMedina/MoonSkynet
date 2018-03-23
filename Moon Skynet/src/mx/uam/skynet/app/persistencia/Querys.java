package mx.uam.skynet.app.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.CORBA.Request;

public class Querys implements RequestSql {
	
	private Connection con;
	
	Querys(Connection con) {
		this.con = con;
	}

	@Override
	public int insert(String tables, String values) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement insert = con.prepareStatement("INSERT INTO " + tables + " VALUES(" + values + ")");
		return insert.executeUpdate();
	}

	@Override
	public int update(String tables, String set, String where) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement update = con.prepareStatement("UPDATE " + tables + " SET " + set + " WHERE " + where);
		return update.executeUpdate();
	}

	@Override
	public PreparedStatement select(String columns, String tables, String where) throws SQLException {
		// TODO Auto-generated method stub
		return con.prepareStatement("SELECT " + columns + " FROM " + tables + " WHERE " + where);
	}

	@Override
	public int delete(String table, String where) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement update = con.prepareStatement("DELETE FROM " + table + " WHERE " + where);
		return update.executeUpdate();
	}

}
