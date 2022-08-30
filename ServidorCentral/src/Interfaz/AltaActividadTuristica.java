package Interfaz;
import Logica.Turistico.*;
import Logica.Usuario.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class AltaActividadTuristica extends JInternalFrame {
	
	private IControladorTuristico controlTur;
	private IControladorUsuario controlUser;
	private JTextField TxtNombre;
	private JTextField txtDuracion;
	private JTextField txtCiudad;
	private JTextField txtDescripcion;
	private JTextField txtcosto;
	private JComboBox<String> comboBoxDepto;
	private JComboBox<String> comboBoxProveedores;
	private JDateChooser dateChooser; 
    
	public AltaActividadTuristica(IControladorTuristico ict, IControladorUsuario icu) {

		
			controlTur = ict;
			controlUser = icu;
	        setResizable(true);
	        setIconifiable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Alta Actividad turistica");
	        setBounds(30, 30, 490, 439);

	        getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Listado de proveedores");
	        lblNewLabel.setBounds(186, 11, 147, 14);
	        getContentPane().add(lblNewLabel);
	        
	        comboBoxProveedores = new JComboBox();
	      //obtengo la lista de los proveedores del sistema 
	      	Set<DTProveedor> prov = icu.listarProveedores();
	        for(DTProveedor p : prov){
	        	comboBoxProveedores.addItem(p.getNickname());
	        }
	        comboBoxProveedores.setBounds(97, 36, 281, 22);
	        getContentPane().add(comboBoxProveedores);
	        
	        JLabel lblNewLabel_1 = new JLabel("Departamentos");
	        lblNewLabel_1.setBounds(203, 69, 118, 14);
	        getContentPane().add(lblNewLabel_1);
	        
	        comboBoxDepto = new JComboBox();
			//obtengo la lista de departamentos del sistema
			Set<String> deptos = ict.listarDepartamentos();
	        comboBoxDepto.setBounds(97, 90, 281, 22);
	        if(deptos != null) {
				for(String d : deptos){
					comboBoxDepto.addItem(d);
		        }
	        }

	        getContentPane().add(comboBoxDepto);
	        
	        JLabel lblNewLabel_2 = new JLabel("Nombre:");
	        lblNewLabel_2.setBounds(39, 135, 53, 14);
	        getContentPane().add(lblNewLabel_2);
	        
	        TxtNombre = new JTextField();
	        TxtNombre.setBounds(97, 132, 281, 20);
	        getContentPane().add(TxtNombre);
	        TxtNombre.setColumns(10);
	        
	        JLabel lblNewLabel_3 = new JLabel("Duracion:");
	        lblNewLabel_3.setBounds(39, 208, 70, 14);
	        getContentPane().add(lblNewLabel_3);
	        
	        txtDuracion = new JTextField();
	        txtDuracion.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {

	        		char c = e.getKeyChar();
	        		if (!(Character.isDigit(c) ||
	        		(c == KeyEvent.VK_BACK_SPACE) ||
	        		(c == KeyEvent.VK_DELETE))) {
	        		getToolkit().beep();
	        		e.consume();
	        		}
	        	}
	        });
	        txtDuracion.setBounds(97, 205, 118, 20);
	        getContentPane().add(txtDuracion);
	        txtDuracion.setColumns(10);
	        
	        JLabel lblNewLabel_4 = new JLabel("Ciudad:");
	        lblNewLabel_4.setBounds(39, 173, 46, 14);
	        getContentPane().add(lblNewLabel_4);
	        
	        txtCiudad = new JTextField();
	        txtCiudad.setBounds(97, 170, 281, 20);
	        getContentPane().add(txtCiudad);
	        txtCiudad.setColumns(10);
	        
	        JLabel lblNewLabel_5 = new JLabel("Fecha:");
	        lblNewLabel_5.setBounds(39, 236, 46, 14);
	        getContentPane().add(lblNewLabel_5);
	        
	        txtDescripcion = new JTextField();
	        txtDescripcion.setBounds(97, 282, 281, 61);
	        getContentPane().add(txtDescripcion);
	        txtDescripcion.setColumns(10);
	        
	        JLabel lblNewLabel_6 = new JLabel("Descripcion:");
	        lblNewLabel_6.setBounds(203, 268, 105, 14);
	        getContentPane().add(lblNewLabel_6);
	        
	        JButton btnConfirmar = new JButton("Confirmar");
	        btnConfirmar.setBounds(97, 354, 105, 23);
	        btnConfirmar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	if(checkFormularioActividad()) {
	                   cmdRegistroActividadActionPerformed(arg0);
	            	}
	            }
	        });
	        getContentPane().add(btnConfirmar);
	        
	        JButton btnCancelar = new JButton("Cancelar");
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                limpiarFormulario();
	                setVisible(false);
	            }
	        });
	        btnCancelar.setBounds(273, 354, 105, 23);
	        getContentPane().add(btnCancelar);
	        
	        JLabel lblNewLabel_7 = new JLabel("Costo:");
	        lblNewLabel_7.setBounds(225, 208, 46, 14);
	        getContentPane().add(lblNewLabel_7);
	        
	        txtcosto = new JTextField();
	        txtcosto.setColumns(10);
	        txtcosto.setBounds(284, 205, 94, 20);
	        getContentPane().add(txtcosto);
	        
	        dateChooser = new JDateChooser();
	        dateChooser.setBounds(97, 233, 118, 20);
	        getContentPane().add(dateChooser);
	       

	    }
		
		private boolean checkFormularioActividad() {
	        String nombreA = this.TxtNombre.getText();
	        String duracionA = this.txtDuracion.getText();
	        String ciudadA = this.txtCiudad.getText();
	        String descrA = this.txtDescripcion.getText();
	        String costoA = this.txtcosto.getText();

	        if (nombreA.isEmpty() || duracionA.isEmpty() || ciudadA.isEmpty() || descrA.isEmpty() || costoA.isEmpty() ) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac�os", "Alta Actividad",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }else {
	        	return true;
	        }
	        
	   }
		
	    protected void cmdRegistroActividadActionPerformed(ActionEvent arg0) {
	        // TODO Auto-generated method stub

	        // Obtengo datos de los controles Swing
	        String nombreA = this.TxtNombre.getText();
	        String duracionA = this.txtDuracion.getText();
	        int dur = Integer.parseInt(duracionA);
	        String ciudadA = this.txtCiudad.getText();
	        String descrA = this.txtDescripcion.getText();
	        String costoA = this.txtcosto.getText();
	        float costo = Float.parseFloat(costoA);
	        String depto = comboBoxDepto.getSelectedItem().toString();
	        String prove = comboBoxProveedores.getSelectedItem().toString();
	        Date fechaAlta = this.dateChooser.getDate();
	        

	        if (checkFormularioActividad()) {
	      	            controlTur.ingresarDatosBasicos(prove, depto, nombreA, descrA, dur, costo, ciudadA, fechaAlta);
						// Muestro éxito de la operación
						JOptionPane.showMessageDialog(this, "La actividad se ha registrado con exito", "Alta Actividad Turistica",
						        JOptionPane.INFORMATION_MESSAGE);

	      	            // Limpio el internal frame antes de cerrar la ventana
	      	            limpiarFormulario();
	      	            setVisible(false);
	      	        }
	    }
	    
	    private void limpiarFormulario() {
	    	TxtNombre.setText("");
	    	txtDuracion.setText("");
	    	txtCiudad.setText("");
	    	txtDescripcion.setText("");
	    	txtcosto.setText("");
	    }
   }
 
