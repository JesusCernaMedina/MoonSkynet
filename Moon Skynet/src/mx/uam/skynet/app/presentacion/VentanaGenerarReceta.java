package mx.uam.skynet.app.presentacion;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mx.uam.skynet.app.modelo.Paciente;
import mx.uam.skynet.app.negocio.ControlGeneraReceta;
import mx.uam.skynet.app.persistencia.ConnectDB;
 
public class VentanaGenerarReceta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title = new JLabel();
	private ControlGeneraReceta ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ControlGeneraReceta ctrl = new ControlGeneraReceta(2);
			VentanaGenerarReceta dialog = new VentanaGenerarReceta(ctrl);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates new form Historial_clinico
	 * @throws SQLException 
	 */
	public VentanaGenerarReceta(ControlGeneraReceta ctrl) {
		this.ctrl = ctrl;
		initComponents();
	}


	private void initComponents() {

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = screen.width;
		final int y = screen.height;
		int windowx = ((x-100));
		int windowy = (y-100);
//		System.out.println(windowx+" "+windowy);

		panel1 = new JPanel();
		lblpaciente = new JLabel();
		lblquery = new JLabel();
		lblFecha =  new JLabel();
		lblDescripcion = new JLabel();
		lblTratamiento = new JLabel();
		txtFecha = new JTextField();
		txtDescripcion = new JTextField();
		txtTratamiento = new JTextField();
		btngenerarPDF = new JButton();
		chooser = new JFileChooser();
		
		Paciente paciente = ctrl.buscarNombrePaciente();

		setBackground(new java.awt.Color(255, 255, 255));
		getContentPane().setLayout(null);

		panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		panel1.setLayout(null);

		title.setAlignmentX(java.awt.Label.CENTER);
		title.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		title.setText("Generar receta");
		panel1.add(title);
		title.setBounds((windowx/2)-245, 0, 345, 92);

		lblpaciente.setBackground(new java.awt.Color(204, 204, 204));
		lblpaciente.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
		lblpaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblpaciente.setText("Paciente:");
		panel1.add(lblpaciente);
		lblpaciente.setBounds(40, 100, 250, 30);

		lblquery.setFont(new Font("Times New Roman", 1, 36)); // NOI18N
		lblquery.setHorizontalAlignment(JTextField.CENTER);
		lblquery.setText(paciente.getNombre()+" "+ paciente.getApellidos());
		panel1.add(lblquery);
		lblquery.setBounds(145, 100, 550, 30);

		lblFecha.setFont(new Font("Times New Roman", 0,30));
		lblFecha.setHorizontalAlignment(JTextField.CENTER);
		lblFecha.setText("Fecha:");
		panel1.add(lblFecha);
		lblFecha.setBounds((windowx/2)-300, 175, 100, 30);

		txtFecha.setBounds((windowx/2)-200, 175, 200, 30);
		txtFecha.setText("DIA de MES de AÑO ");
		txtFecha.setHorizontalAlignment(JTextField.CENTER);
		txtFecha.setForeground(new Color(204, 204, 204));
		txtFecha.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				txtFecha.setText("");
				txtFecha.setForeground(Color.BLACK);
			}
		});
		panel1.add(txtFecha);

		lblDescripcion.setFont(new Font("Times New Roman",0,30));
		lblDescripcion.setHorizontalAlignment(JTextField.CENTER);
		lblDescripcion.setText("Descripci\u00f3n:");
		panel1.add(lblDescripcion);
		lblDescripcion.setBounds((windowx/4)-150, 200, 150, 100);

		txtDescripcion.setBounds(30, 275, windowx/3, (windowy/4)+100);
		txtDescripcion.setForeground(new Color(204, 204, 204));
		panel1.add(txtDescripcion);

		lblTratamiento.setFont(new Font("Times New Roman",0,30));
		lblTratamiento.setHorizontalAlignment(JTextField.CENTER);
		lblTratamiento.setText("Tratamiento:");
		panel1.add(lblTratamiento);
		lblTratamiento.setBounds((windowx/2), 200, 150, 100);

		txtTratamiento.setBounds((windowx/2)-135, 275, windowx/3, (windowy/4)+100);
		txtTratamiento.setForeground(new Color(204, 204, 204));
		panel1.add(txtTratamiento);


		//        ADD ACTIONLISTENER BUTTON GENERATE

		btngenerarPDF.setText("GENERAR RECETA");
		btngenerarPDF.setBounds((windowx/2)-220,windowy-100 , 140, 30);
		btngenerarPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int opcion=chooser.showSaveDialog(null);
				if(opcion==JFileChooser.APPROVE_OPTION){
					try {
						OutputStream output = new FileOutputStream(chooser.getSelectedFile()+".pdf");
						Document pdf = new Document();
						PdfWriter writer = PdfWriter.getInstance(pdf, output);
						
						Image membreto = Image.getInstance("C:\\Users\\Jesus\\Documents\\liberable3\\MoonSkynet\\receta.png");
						membreto.scaleToFit(500f, 500f);
						membreto.setAlignment(Element.ALIGN_CENTER);
						
						Paragraph title = new Paragraph();
						title.add("\n "+"\n"+" RECETA INDIVIDUAL");
						title.setAlignment(Element.ALIGN_CENTER);
						
						Paragraph fecha= new Paragraph();
						fecha.add("\n"+""+"\n"+""+"\n"+""+"\n"+"Fecha de expedición: "+txtFecha.getText());
						fecha.setAlignment(Element.ALIGN_LEFT);
						
						Paragraph folio = new Paragraph();
						folio.add("Folio de cita: "+ ctrl.getFolio());
						folio.setAlignment(Element.ALIGN_RIGHT);
						
						Paragraph nombre = new Paragraph();
						nombre.add(""+"\n"+""+"\n"+""+"\n"+"Nombre de paciente: "+ paciente.getNombre() +" "+paciente.getApellidos());
						nombre.setAlignment(Element.ALIGN_LEFT);
						
						Paragraph descripcion = new Paragraph(); 
						descripcion.add(""+"\n"+""+"\n"+""+"\n"+"Descripcion de tratamiento: "+txtDescripcion.getText());
						descripcion.setAlignment(Element.ALIGN_JUSTIFIED);
						
						Paragraph tratamiento = new Paragraph();
						tratamiento.add(""+"\n"+""+"\n"+"Tratamiento prescripto por el doctor: "+ txtTratamiento.getText());
						tratamiento.setAlignment(Element.ALIGN_JUSTIFIED);
						
						Paragraph lblNomDoc = new Paragraph();
						lblNomDoc.add("\n"+""+"\n"+""+"\n"+""+"\n"+""+"\n"+"Nombre y firma del Médico");
						lblNomDoc.setAlignment(Element.ALIGN_RIGHT);
						
						Paragraph nomDoc = new Paragraph();
						nomDoc.add("\n"+"Carmen Chavarría Luna");
						nomDoc.setAlignment(Element.ALIGN_RIGHT);
						
						Paragraph lblCedula = new Paragraph();
						lblCedula.add("\n"+"Cédula Profesional");
						lblCedula.setAlignment(Element.ALIGN_RIGHT);
						
						Paragraph cedula = new Paragraph();
						cedula.add("\n"+"1234567");
						cedula.setAlignment(Element.ALIGN_RIGHT);
						
						
						
						Paragraph frase = new Paragraph(""+"\n"+""+"\n"+"Si luces una sonrisa, tendrás amigos."+
							"\n"+" En cambio, si andas con el ceño fruncido, no tendrás más que arrugas. "+
								"\n"+"¿Para qué estamos si no para hacerles la vida más llevadera a nuestros semejantes?"+
									"\n"+"(George Elioy).");
						frase.setAlignment(Element.ALIGN_CENTER);
						
						pdf.open();
						
						pdf.add(membreto);
						pdf.add(title);
						pdf.add(fecha);
						pdf.add(folio);
						pdf.add(nombre);
						pdf.add(descripcion);
						pdf.add(tratamiento);
						pdf.add(lblNomDoc);
						pdf.add(nomDoc);
						pdf.add(lblCedula);
						pdf.add(cedula);
						pdf.add(frase);
								
					
//						AGREGAR ELEMENTOS DEL PDF
						pdf.close();
						output.close();
					} 
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		panel1.add(btngenerarPDF);
		
		getContentPane().add(panel1);
		panel1.setBounds(0, 0, x, y);

		pack();
	}// </editor-fold>//GEN-END:initComponents


	// Variables declaration - do not modify//GEN-BEGIN:variables


	private JButton btngenerarPDF;

	private JLabel lblquery;
	private JLabel lblpaciente;
	private JLabel lblDescripcion;
	private JLabel lblTratamiento;
	private JLabel lblFecha;
	private JTextField txtDescripcion;
	private JTextField  txtTratamiento;
	private JTextField txtFecha;
	private JFileChooser chooser;

	private JPanel panel1;


	// End of variables declaration//GEN-END:variables
}
