package test.mx.uam.skynet.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import test.mx.uam.skynet.app.negocio.ControlAgregarPacienteTest;
import test.mx.uam.skynet.app.persistencia.RequestSqlTest;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(RequestSqlTest.class);
		suite.addTestSuite(ControlAgregarPacienteTest.class);
		//$JUnit-END$
		return suite;
	}

}
