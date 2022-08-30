package Interfaz;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Logica.Turistico.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ConsultaActividadTuristica extends JInternalFrame{
	
	private IControladorTuristico controlTur;
	private JTextField textNombre;
	private JTextField textDepartamento;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JTextField textAlta;
	private JComboBox<String> comboBoxDepto;
	private JComboBox<String> comboBoxAct;
	private JComboBox<String> comboSalidas;
	private JComboBox<String> comboPaquetes;

	public ConsultaActividadTuristica(IControladorTuristico ict, DTInfoActividadTuristica dtinfoact ) {
		if (dtinfoact == null) {
		

			setResizable(true);
	        setIconifiable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Consulta Actividad turistica");
	        setBounds(30, 30, 519, 421);
	
	        getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Departamentos:");
	        lblNewLabel.setBounds(211, 22, 128, 14);
	        getContentPane().add(lblNewLabel);
	        
	        comboBoxDepto = new JComboBox<String>();
	      //obtengo la lista de departamentos del sistema
			Set<String> deptos = ict.listarDepartamentos();
	        comboBoxDepto.setBounds(97, 90, 281, 22);
	        if(deptos != null) {
				for(String d : deptos){
					comboBoxDepto.addItem(d);
		        }
	        }
	        comboBoxDepto.setBounds(81, 42, 376, 22);
	        comboBoxAct = new JComboBox<String>();
	        comboBoxAct.setVisible(true);
	        comboBoxAct.setBounds(81, 87, 376, 22);
	        comboBoxDepto.addItemListener(new ItemListener() {
				  public void itemStateChanged(ItemEvent itemEvent) {
					  if (itemEvent.getSource()==comboBoxDepto) {
				            String deptoSelec=(String)comboBoxDepto.getSelectedItem();
				            Set<String> act_depto = ict.obtenerActividadesDepartamento(deptoSelec);
				            if(act_depto != null) {
				    	        for(String ad : act_depto){
				    	        	comboBoxAct.addItem(ad);
				    	        }
				            }
				            comboBoxAct.setSelectedItem("");
				            comboBoxAct.addItemListener(new ItemListener() {
				  			  public void itemStateChanged(ItemEvent itemEvent) {
				  				  if (itemEvent.getSource()==comboBoxAct) {
				  			            String actSelec=(String)comboBoxAct.getSelectedItem();
				  			            DTInfoActividadTuristica info = ict.seleccionarActividadTuristica(actSelec, deptoSelec);
					  			  		textNombre.setText(info.getNombre());
					  					textDepartamento.setText(info.getDepartamento());
					  					textDescripcion.setText(info.getDescripcion());
					  					textDuracion.setText(String.valueOf(info.getDuracionxHora()));
					  					textCosto.setText(String.valueOf(info.getCostoxTurista()));
					  					textAlta.setText(String.valueOf(info.getFechaAlta()));
				  			            
				  			            comboBoxAct.setBounds(81, 87, 376, 22);
				  			            getContentPane().add(comboBoxAct);
				  				  }
				  			  }
				          });
				            
				            getContentPane().add(comboBoxAct);
					  }
				  }
	        });
	        
	        
	        getContentPane().add(comboBoxDepto);
	      
	        JLabel lblNewLabel_1 = new JLabel("Actividades turisticas:");
	        lblNewLabel_1.setBounds(208, 69, 131, 14);
	        getContentPane().add(lblNewLabel_1);
	        
	        //obtengo el departamento seleccionado arriba
	        String deptoSelec = (String)comboBoxDepto.getSelectedItem();
	        
	        
	        
	        JLabel lblNewLabel_2 = new JLabel("Informacion de la Actividad:");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblNewLabel_2.setBounds(184, 152, 216, 14);
	        getContentPane().add(lblNewLabel_2);
	        
	        textNombre = new JTextField();
	        textNombre.setEditable(false);
	        textNombre.setBounds(97, 188, 116, 20);
	        getContentPane().add(textNombre);
	        textNombre.setColumns(10);
	        
	        textDepartamento = new JTextField();
	        textDepartamento.setEditable(false);
	        textDepartamento.setColumns(10);
	        textDepartamento.setBounds(329, 188, 128, 20);
	        getContentPane().add(textDepartamento);
	        
	        textDescripcion = new JTextField();
	        textDescripcion.setEditable(false);
	        textDescripcion.setColumns(10);
	        textDescripcion.setBounds(97, 219, 116, 20);
	        getContentPane().add(textDescripcion);
	        
	        textDuracion = new JTextField();
	        textDuracion.setEditable(false);
	        textDuracion.setColumns(10);
	        textDuracion.setBounds(329, 219, 128, 20);
	        getContentPane().add(textDuracion);
	        
	        textCosto = new JTextField();
	        textCosto.setEditable(false);
	        textCosto.setColumns(10);
	        textCosto.setBounds(97, 250, 116, 20);
	        getContentPane().add(textCosto);
	        
	        textAlta = new JTextField();
	        textAlta.setEditable(false);
	        textAlta.setColumns(10);
	        textAlta.setBounds(329, 250, 128, 20);
	        getContentPane().add(textAlta);
	        
	        JLabel lblNewLabel_3 = new JLabel("Nombre: ");
	        lblNewLabel_3.setBounds(42, 191, 58, 14);
	        getContentPane().add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("Departamento:");
	        lblNewLabel_4.setBounds(240, 191, 99, 14);
	        getContentPane().add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("Descripcion:");
	        lblNewLabel_5.setBounds(24, 222, 76, 14);
	        getContentPane().add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_5_1 = new JLabel("Duracion:");
	        lblNewLabel_5_1.setBounds(260, 222, 92, 14);
	        getContentPane().add(lblNewLabel_5_1);
	        
	        JLabel lblNewLabel_6 = new JLabel("Costo:");
	        lblNewLabel_6.setBounds(42, 252, 64, 17);
	        getContentPane().add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_7 = new JLabel("Fecha Alta:");
	        lblNewLabel_7.setBounds(260, 253, 119, 14);
	        getContentPane().add(lblNewLabel_7);
	        
	        JButton btnNewButton = new JButton("Cerrar");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                limpiarFormulario();
	                setVisible(false);
	            }
	        });
	        btnNewButton.setBounds(208, 327, 89, 23);
	        getContentPane().add(btnNewButton);
	        
	        JSeparator separator = new JSeparator();
	        separator.setBounds(95, 175, 362, 2);
	        getContentPane().add(separator);
	        
	        comboSalidas = new JComboBox<String>();
	        comboSalidas.setBounds(97, 281, 116, 22);
	        getContentPane().add(comboSalidas);
	        
	        comboPaquetes = new JComboBox<String>();
	        comboPaquetes.setBounds(329, 281, 128, 22);
	        getContentPane().add(comboPaquetes);
	        
	        JLabel lblNewLabel_8 = new JLabel("Salidas:");
	        lblNewLabel_8.setBounds(42, 285, 46, 14);
	        getContentPane().add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_9 = new JLabel("Paquetes:");
	        lblNewLabel_9.setBounds(260, 285, 76, 14);
	        getContentPane().add(lblNewLabel_9);
        
		}else {

			setResizable(true);
	        setIconifiable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Consulta Actividad turistica");
	        setBounds(30, 30, 519, 421);
	
	        getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel("Actividades turisticas:");
	        lblNewLabel_1.setBounds(208, 69, 131, 14);
	        getContentPane().add(lblNewLabel_1);
	        
	        //obtengo el departamento seleccionado arriba
	        String deptoSelec = (String)comboBoxDepto.getSelectedItem();
	        
	        
	        
	        JLabel lblNewLabel_2 = new JLabel("Informacion de la Actividad:");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblNewLabel_2.setBounds(184, 152, 216, 14);
	        getContentPane().add(lblNewLabel_2);
	        
	        textNombre = new JTextField();
	        textNombre.setEditable(false);
	        textNombre.setBounds(97, 188, 116, 20);
	        getContentPane().add(textNombre);
	        textNombre.setColumns(10);
	        
	        textDepartamento = new JTextField();
	        textDepartamento.setEditable(false);
	        textDepartamento.setColumns(10);
	        textDepartamento.setBounds(329, 188, 128, 20);
	        getContentPane().add(textDepartamento);
	        
	        textDescripcion = new JTextField();
	        textDescripcion.setEditable(false);
	        textDescripcion.setColumns(10);
	        textDescripcion.setBounds(97, 219, 116, 20);
	        getContentPane().add(textDescripcion);
	        
	        textDuracion = new JTextField();
	        textDuracion.setEditable(false);
	        textDuracion.setColumns(10);
	        textDuracion.setBounds(329, 219, 128, 20);
	        getContentPane().add(textDuracion);
	        
	        textCosto = new JTextField();
	        textCosto.setEditable(false);
	        textCosto.setColumns(10);
	        textCosto.setBounds(97, 250, 116, 20);
	        getContentPane().add(textCosto);
	        
	        textAlta = new JTextField();
	        textAlta.setEditable(false);
	        textAlta.setColumns(10);
	        textAlta.setBounds(329, 250, 128, 20);
	        getContentPane().add(textAlta);
	        
	        JLabel lblNewLabel_3 = new JLabel("Nombre: ");
	        lblNewLabel_3.setBounds(42, 191, 58, 14);
	        getContentPane().add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("Departamento:");
	        lblNewLabel_4.setBounds(240, 191, 99, 14);
	        getContentPane().add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("Descripcion:");
	        lblNewLabel_5.setBounds(24, 222, 76, 14);
	        getContentPane().add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_5_1 = new JLabel("Duracion:");
	        lblNewLabel_5_1.setBounds(260, 222, 92, 14);
	        getContentPane().add(lblNewLabel_5_1);
	        
	        JLabel lblNewLabel_6 = new JLabel("Costo:");
	        lblNewLabel_6.setBounds(42, 252, 64, 17);
	        getContentPane().add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_7 = new JLabel("Fecha Alta:");
	        lblNewLabel_7.setBounds(260, 253, 119, 14);
	        getContentPane().add(lblNewLabel_7);
			
		}
			
	}

	
	private void limpiarFormulario() {
		textNombre.setText("");
		textDepartamento.setText("");
		textDescripcion.setText("");
		textDuracion.setText("");
		textCosto.setText("");
		textAlta.setText("");
    }
}
