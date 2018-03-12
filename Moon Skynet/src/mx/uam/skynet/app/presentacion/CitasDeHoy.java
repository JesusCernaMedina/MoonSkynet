package mx.uam.skynet.app.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JButton;



public class CitasDeHoy extends JFrame implements ActionListener {
	
	public CitasDeHoy()
	{
		this.setTitle("Citas Programadas para hoy");                   
	    this.setSize(610, 410);                                
	    this.setLocationRelativeTo(null);                      
	    getContentPane().setLayout(null);
	    
	    JButton btnAceptar = new JButton("Aceptar");
	    btnAceptar.setBounds(475, 12, 117, 25);
	    getContentPane().add(btnAceptar);
	    
	    this.setResizable(false);                              
	}
	
	///////////////////Fecha/////////////////////////////////
    Calendar c = new GregorianCalendar();
    String dia = Integer.toString(c.get(Calendar.DATE));
    String mes = Integer.toString(c.get(Calendar.MONTH)+1);
    String anio = Integer.toString(c.get(Calendar.YEAR));
	/////////////////fin Fecha////////////////////////////////
	
    
    
    
    
    
    
    
    
	public static void main(String arg[])
	{
		CitasDeHoy citas = new CitasDeHoy();
		citas.setVisible(true);
	}
	
	/*
//////////////////inicio busqueda citas de Hoy ////////////////////////@author Gabriel Lopez Hernandez
	
public void citasDeHoy(String  dia,String mes,String anio) throws SQLException
{
ResultSet resultCitas = stm.executeQuery("SELECT name  from citas WHERE fecha="+dia );
}
//////////////////Fin busqueda citas de hoy ////////////////////////@author Gabriel Lopez Hernandez
	*/
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
