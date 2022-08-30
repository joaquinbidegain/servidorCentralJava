package Interfaz;

import Logica.Turistico.*;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Set;

import javax.swing.SwingConstants;
import com.toedter.components.JSpinField;

public class AltaSalidaTuristica  extends JInternalFrame  {
	private JTextField nombreSal;
	private JTextField lugarSalida;
	private JComboBox comboDep;
	private JComboBox comboAct;
	private JDateChooser fechaSal;
	private JDateChooser fechaAlta;
 	private JSpinField spinField;
 	private JTextField cantTuristas;
 	private JButton btnNewButton;
 	private JButton btnCancelar;
		
	 
	public AltaSalidaTuristica(IControladorTuristico ict) {
		getContentPane().setBackground(new Color(240, 255, 255));
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Salida Turistica");
        setBounds(30, 30, 544, 407);
        getContentPane().setLayout(null);
        
        JLabel departamentos = new JLabel("Nombre Actividad");
        departamentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        departamentos.setBounds(188, 75, 141, 21);
        getContentPane().add(departamentos);
        
        
        
        comboDep = new JComboBox();
        comboDep.setBounds(78, 44, 362, 21);
        comboDep.setVisible(true);
        Set<String> deps = ict.listarDepartamentos();
        if(deps != null) {
        	for(String dp : deps){
        		comboDep.addItem(dp);
        	}
        }
        getContentPane().add(comboDep);
        
        
        
        comboAct = new JComboBox();
        comboAct.setBounds(78, 106, 362, 21);
        getContentPane().add(comboAct);
        
        JLabel lblNewLabel = new JLabel("Agregar Datos Salida");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(188, 137, 141, 21);
        getContentPane().add(lblNewLabel);
        
        nombreSal = new JTextField();
        nombreSal.setBounds(78, 191, 121, 19);
        getContentPane().add(nombreSal);
        nombreSal.setColumns(10);
        
        lugarSalida = new JTextField();
        lugarSalida.setColumns(10);
        lugarSalida.setBounds(188, 220, 252, 19);
        getContentPane().add(lugarSalida);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre Salida");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(78, 168, 121, 13);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Lugar de Salida");
        lblNewLabel_1_1.setBounds(78, 223, 121, 13);
        getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Hora Salida");
        lblNewLabel_1_1_1.setBounds(239, 168, 75, 13);
        getContentPane().add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Cantidad Turistas");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1.setBounds(319, 168, 121, 13);
        getContentPane().add(lblNewLabel_1_1_1_1);
        
        btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkFormularioSalida()) {
        			//OPERACION
        			cmdRegistroUsuarioActionPerformed(ict);        		
        		}
        	}
        });
        btnNewButton.setBounds(78, 301, 141, 21);
        getContentPane().add(btnNewButton);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(299, 301, 141, 21);
        getContentPane().add(btnCancelar);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(78, 156, 362, 2);
        getContentPane().add(separator);
        
        JLabel departamentos_1 = new JLabel("Departamentos");
        departamentos_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        departamentos_1.setBounds(198, 10, 141, 21);
        getContentPane().add(departamentos_1);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(78, 94, 362, 2);
        getContentPane().add(separator_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(78, 32, 362, 2);
        getContentPane().add(separator_2);
        
        fechaAlta = new JDateChooser();
        fechaAlta.setBounds(299, 272, 141, 19);
        getContentPane().add(fechaAlta);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Fecha Salida");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setBounds(78, 260, 141, 13);
        getContentPane().add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("Fecha de Alta Salida");
        lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2_1.setBounds(299, 260, 141, 13);
        getContentPane().add(lblNewLabel_1_1_2_1);
        
        fechaSal = new JDateChooser();
        fechaSal.setBounds(78, 272, 141, 19);
        getContentPane().add(fechaSal);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(78, 247, 362, 2);
        getContentPane().add(separator_3);
        
        spinField = new JSpinField();
        spinField.setBounds(249, 191, 30, 19);
        spinField.setValue(99);
        spinField.setMaximum(23);
        spinField.setMinimum(00);
        getContentPane().add(spinField);
        
        cantTuristas = new JTextField();
        cantTuristas.addKeyListener(new KeyAdapter() {
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
        cantTuristas.setColumns(10);
        cantTuristas.setBounds(319, 191, 121, 19);
        getContentPane().add(cantTuristas);
        
        
        comboDep.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource()==comboDep) {
					//ACA TENGO QUE UTILIZAR SELECCIONADO PARA HACER UNA BUSQUEDA EN BACK Y OBTENER TODOS LOS DATOS BASICOS DEL USUARIO
					  	comboAct.removeAllItems();
			            String deptoSelec=(String)comboDep.getSelectedItem();
			            Set<String> act_depto = ict.obtenerActividadesDepartamento(deptoSelec);
			            if(act_depto != null) {
			    	        for(String ad : act_depto){
			    	        	comboAct.addItem(ad);
			    	        }
			            }
				  }
        	}
        });
	}

	private boolean checkFormularioSalida() {
	    String nombreSal = this.nombreSal.getText();
	    String lugarSal = this.lugarSalida.getText();
	    int horaSalida = this.spinField.getValue();
	    String cantTuristas = this.cantTuristas.getText();
	    String comboBox = this.comboDep.getSelectedItem().toString();
	    String comboBox_1 = this.comboAct.getSelectedItem().toString();	        
	    
	 
	
	
	    if (nombreSal.isEmpty() || lugarSal.isEmpty() ||  cantTuristas.isEmpty() || comboBox.isEmpty() || comboBox_1.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Salida Turistica",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }else if (horaSalida == 99){
	    	JOptionPane.showMessageDialog(this, "Debe ingresar una hora valida (00hs - 23hs)", "Alta Salida Turistica",
	                JOptionPane.ERROR_MESSAGE);;
	        return false;
	    }else {
	    	return true;
	    }
	    
	}
	
	protected void cmdRegistroUsuarioActionPerformed(IControladorTuristico ict) {
	
	 String nombreSal = this.nombreSal.getText();
	 String lugarSal = this.lugarSalida.getText();
	 int horaSalida = this.spinField.getValue();
	 String cantTuristas = this.cantTuristas.getText();
	 String nombreAct = this.comboAct.getSelectedItem().toString();
	 String departamento = this.comboDep.getSelectedItem().toString();
	 Date fechaAlta = this.fechaAlta.getDate();
	 Date fechaSal = this.fechaSal.getDate();
	 int cant = Integer.parseInt(cantTuristas);
	 
	    if (checkFormularioSalida()) {
	    		int i = ict.ingresarSalidaTuristica(nombreSal,fechaSal, lugarSal, cant,fechaAlta, nombreAct, departamento);
		     	if(i==2) {
				// Muestro Ã©xito de la operaciÃ³n
				JOptionPane.showMessageDialog(this, "La salida se ha registrado con exito", "Alta Salida Turistica",
				        JOptionPane.INFORMATION_MESSAGE);
				// Limpio el internal frame antes de cerrar la ventana
	            limpiarFormulario();
	            setVisible(false);
			}else if(i==1) {
				JOptionPane.showMessageDialog(this, "La Salida con el nombre ingresado ya existe", "Alta Salida Turistica",
	                    JOptionPane.ERROR_MESSAGE);
			}	        	        
	    }
	}
	
	private void limpiarFormulario() {
	 	nombreSal.setText("");
	 	lugarSalida.setText("");
	 	cantTuristas.setText("");
	 	comboAct.setSelectedItem("");
	 	comboDep.setSelectedItem("");
	}

}