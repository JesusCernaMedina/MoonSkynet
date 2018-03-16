package mx.uam.skynet.app.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import mx.uam.skynet.app.negocio.*;

public class Principal {
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Modific Clase principal 2
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			final int x = screen.width;
			final int y = screen.height;
			
			final int windowx = x-100;
			final int windowy = y-100;
			
			Busca_pacientes_simple ventana = new Busca_pacientes_simple();
			ventana.setBounds(50, 50, windowx, windowy);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setResizable(false);
			ventana.setTitle("Busca Paciente");
			ventana.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
