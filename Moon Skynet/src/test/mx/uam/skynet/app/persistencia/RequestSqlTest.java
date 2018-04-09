package test.mx.uam.skynet.app.persistencia;

import junit.framework.TestCase;
import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.persistencia.ConnectDB;
import mx.uam.skynet.app.persistencia.DAOPaciente;

public class RequestSqlTest extends TestCase {

	private DAOPaciente daopaciente;
	
	protected void setUp() throws Exception {
		super.setUp();
		daopaciente = new DAOPaciente(ConnectDB.Conectar());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		ConnectDB.Desconectar();
	}

	public void testInsert() {
		
	}

	public void testUpdate() {
	}

	public void testSelectWhere() {
		daopaciente.buscaNombreCompleto(2);
	}

	public void testSelect() {
	}

	public void testDelete() {
	}

}