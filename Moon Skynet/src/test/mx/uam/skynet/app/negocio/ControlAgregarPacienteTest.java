package test.mx.uam.skynet.app.negocio;

import junit.framework.TestCase;
import mx.uam.skynet.app.negocio.ControlAgregarPaciente;

public class ControlAgregarPacienteTest extends TestCase {

	private ControlAgregarPaciente ctrl;
	
	protected void setUp() throws Exception {
		super.setUp();
		ctrl = new ControlAgregarPaciente();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInicia() {
		ctrl.inicia();
	}

	public void testIniciaCita() {
		ctrl.iniciaCita(2);
	}

	public void testRegPaciente() {
		ctrl.regPaciente("Jose", "Gonzalo", "12345678", "email@gmail.com", "32", "Direccion del cliente");
	}

	public void testIdUltRegistro() {
		System.out.println("Id del ultimo registro en la BD: " + ctrl.idUltRegistro());
	}

}
