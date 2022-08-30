package Interfaz;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import Logica.Turistico.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaSalidaTuristica extends JInternalFrame{
	private JComboBox comboDep;
	private JComboBox comboAct;
	private JTextField nombreSalida;
	private JTextField cantTuristas;
	private JTextField lugarSalida;
	private JTextField fechaAlta;
	private JTextField txtFechaSalida;
	private JTextField txtNombreActividad;
	private JComboBox comboSal;
	private JLabel lblNewLabel;
	private JLabel lblCantidadTuristas;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	
	public ConsultaSalidaTuristica(IControladorTuristico ict, DTInfoSalida dtinfosal) {
		if(dtinfosal == null) {

			
			getContentPane().setBackground(new Color(240, 255, 255));
			setResizable(true);
	        setIconifiable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Consulta Salida Turistica");
	        setBounds(30, 30, 528, 446);
	        getContentPane().setLayout(null);
	        
	        JLabel salidas = new JLabel("Actividades Turisticas");
	        salidas.setHorizontalAlignment(SwingConstants.CENTER);
	        salidas.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        salidas.setBounds(78, 61, 362, 21);
	        getContentPane().add(salidas);
	        
	        JSeparator separator_1 = new JSeparator();
	        separator_1.setBounds(78, 29, 362, 2);
	        getContentPane().add(separator_1);
	        
	        JLabel departamentos = new JLabel("Departamentos");
	        departamentos.setHorizontalAlignment(SwingConstants.CENTER);
	        departamentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        departamentos.setBounds(78, 10, 362, 21);
	        getContentPane().add(departamentos);
	        
	        JSeparator separator_2 = new JSeparator();
	        separator_2.setBounds(78, 80, 362, 2);
	        getContentPane().add(separator_2);
	        
	        
	      
	        comboDep = new JComboBox();
	        comboDep.setBounds(78, 41, 362, 21);
	        comboDep.setVisible(true);
	        Set<String> deps = ict.listarDepartamentos();
	        if(deps != null) {
	        	for(String dp : deps){
	        		comboDep.addItem(dp);
	        	}
	        }
	        getContentPane().add(comboDep);
	         
	        
	        comboAct = new JComboBox();
	        comboAct.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (e.getSource()==comboAct) {
						//ACA TENGO QUE UTILIZAR SELECCIONADO PARA HACER UNA BUSQUEDA EN BACK Y OBTENER TODOS LOS DATOS BASICOS DEL USUARIO
				            String actSelec=(String)comboAct.getSelectedItem();
				            comboSal.removeAllItems();
				            Set<String> salAsociadas = ict.listaSalidasAsociadas(actSelec);
				            if(salAsociadas != null) {
				    	        for(String asoc : salAsociadas){
				    	        	comboSal.addItem(asoc);
				    	        }
				            }
					  }
	        	}
	        });
	        comboAct.setBounds(78, 92, 362, 21);
	        getContentPane().add(comboAct);
	        
	        
	      
	        JSeparator separator_2_1 = new JSeparator();
	        separator_2_1.setBounds(78, 194, 362, 2);
	        getContentPane().add(separator_2_1);
	        
	        JLabel lblDatosSalidaTuristica = new JLabel("Datos Salida Turistica");
	        lblDatosSalidaTuristica.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDatosSalidaTuristica.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblDatosSalidaTuristica.setBounds(78, 175, 362, 21);
	        getContentPane().add(lblDatosSalidaTuristica);
	        
	        nombreSalida = new JTextField();
	        nombreSalida.setText("Nombre Salida");
	        nombreSalida.setBounds(78, 245, 158, 19);
	        getContentPane().add(nombreSalida);
	        nombreSalida.setColumns(10);
	        nombreSalida.setEditable(false);
	        
	        cantTuristas = new JTextField();
	        cantTuristas.setText("Cantidad Turistas");
	        cantTuristas.setColumns(10);
	        cantTuristas.setBounds(282, 245, 158, 19);
	        getContentPane().add(cantTuristas);
	        cantTuristas.setEditable(false);
	
	        
	        lugarSalida = new JTextField();
	        lugarSalida.setText("Lugar de Salida");
	        lugarSalida.setColumns(10);
	        lugarSalida.setBounds(78, 292, 158, 19);
	        getContentPane().add(lugarSalida);
	        lugarSalida.setEditable(false);
	
	        
	        fechaAlta = new JTextField();
	        fechaAlta.setText("Fecha Alta");
	        fechaAlta.setColumns(10);
	        fechaAlta.setBounds(282, 292, 158, 19);
	        getContentPane().add(fechaAlta);
	        fechaAlta.setEditable(false);
	
	        
	        txtFechaSalida = new JTextField();
	        txtFechaSalida.setText("Fecha Salida");
	        txtFechaSalida.setColumns(10);
	        txtFechaSalida.setBounds(78, 343, 158, 19);
	        getContentPane().add(txtFechaSalida);
	        txtFechaSalida.setEditable(false);
	
	        
	        txtNombreActividad = new JTextField();
	        txtNombreActividad.setText("Nombre Actividad");
	        txtNombreActividad.setColumns(10);
	        txtNombreActividad.setBounds(282, 343, 158, 19);
	        getContentPane().add(txtNombreActividad);
	        txtNombreActividad.setEditable(false);
	        
	        
	        
	        
	        comboSal = new JComboBox();
	        comboSal.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
		            String salSelec1=(String)comboSal.getSelectedItem();
	        		if (e.getSource()==comboSal && salSelec1 != null) {
			            String salSelec=(String)comboSal.getSelectedItem();
			            if(salSelec!= null) {
				            DTInfoSalida infoSal = ict.datosSalida(salSelec);
		
				            nombreSalida.setText(infoSal.getNombre());
				            cantTuristas.setText(String.valueOf(infoSal.getCantMax()));
				            lugarSalida.setText(infoSal.getLugarSalida());
				            
				            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH");
					  		String fecha = formatter.format(infoSal.getFechaAlta());
				            fechaAlta.setText(fecha);
				            
				            String fechaS = formatter.format(infoSal.getFechaSalida());
				            txtFechaSalida.setText(fechaS);
				            
				            txtNombreActividad.setText(infoSal.getActividadAsociada().getNombre());
	
			            }
	        		}
	        	}
	        });
	        comboSal.setBounds(78, 144, 362, 21);
	        getContentPane().add(comboSal);
	        
	        
	        
	        JSeparator separator_2_1_1 = new JSeparator();
	        separator_2_1_1.setBounds(78, 133, 362, 2);
	        getContentPane().add(separator_2_1_1);
	        
	        JLabel lblSalidasTuristicas = new JLabel("Salidas Turisticas");
	        lblSalidasTuristicas.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSalidasTuristicas.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblSalidasTuristicas.setBounds(78, 113, 362, 21);
	        getContentPane().add(lblSalidasTuristicas);
	        
	        lblNewLabel = new JLabel("Nombre Salida");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setBounds(78, 222, 158, 13);
	        getContentPane().add(lblNewLabel);
	        
	        lblCantidadTuristas = new JLabel("Cantidad Turistas");
	        lblCantidadTuristas.setHorizontalAlignment(SwingConstants.CENTER);
	        lblCantidadTuristas.setBounds(282, 222, 158, 13);
	        getContentPane().add(lblCantidadTuristas);
	        
	        lblNewLabel_2 = new JLabel("Lugar Salida");
	        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2.setBounds(78, 269, 158, 13);
	        getContentPane().add(lblNewLabel_2);
	        
	        lblNewLabel_3 = new JLabel("Fecha Alta");
	        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_3.setBounds(282, 269, 158, 13);
	        getContentPane().add(lblNewLabel_3);
	        
	        lblNewLabel_4 = new JLabel("Fecha Salida");
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setBounds(78, 320, 158, 13);
	        getContentPane().add(lblNewLabel_4);
	        
	        lblNewLabel_5 = new JLabel("Nombre Actividad");
	        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_5.setBounds(282, 320, 158, 13);
	        getContentPane().add(lblNewLabel_5);
	        
	        
	        comboDep.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (e.getSource()==comboDep) {
						//ACA TENGO QUE UTILIZAR SELECCIONADO PARA HACER UNA BUSQUEDA EN BACK Y OBTENER TODOS LOS DATOS BASICOS DEL USUARIO
						  	comboAct.removeAllItems();
						  	comboSal.removeAllItems();
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
	        
	        
	
		}else {
			
				getContentPane().setBackground(new Color(240, 255, 255));
				setResizable(true);
		        setIconifiable(true);
		        setMaximizable(true);
		        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		        setClosable(true);
		        setTitle("Consulta Salida Turistica");
		        setBounds(30, 30, 528, 446);
		        getContentPane().setLayout(null);
		        
		        JSeparator separator_2_1_1 = new JSeparator();
		        separator_2_1_1.setBounds(78, 133, 362, 2);
		        getContentPane().add(separator_2_1_1);
		        
		        JLabel lblSalidasTuristicas = new JLabel("Salidas Turisticas");
		        lblSalidasTuristicas.setHorizontalAlignment(SwingConstants.CENTER);
		        lblSalidasTuristicas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        lblSalidasTuristicas.setBounds(78, 113, 362, 21);
		        getContentPane().add(lblSalidasTuristicas);
		        
		        lblNewLabel = new JLabel("Nombre Salida");
		        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel.setBounds(78, 222, 158, 13);
		        getContentPane().add(lblNewLabel);
		        
		        lblCantidadTuristas = new JLabel("Cantidad Turistas");
		        lblCantidadTuristas.setHorizontalAlignment(SwingConstants.CENTER);
		        lblCantidadTuristas.setBounds(282, 222, 158, 13);
		        getContentPane().add(lblCantidadTuristas);
		        
		        lblNewLabel_2 = new JLabel("Lugar Salida");
		        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel_2.setBounds(78, 269, 158, 13);
		        getContentPane().add(lblNewLabel_2);
		        
		        lblNewLabel_3 = new JLabel("Fecha Alta");
		        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel_3.setBounds(282, 269, 158, 13);
		        getContentPane().add(lblNewLabel_3);
		        
		        lblNewLabel_4 = new JLabel("Fecha Salida");
		        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel_4.setBounds(78, 320, 158, 13);
		        getContentPane().add(lblNewLabel_4);
		        
		        lblNewLabel_5 = new JLabel("Nombre Actividad");
		        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel_5.setBounds(282, 320, 158, 13);
		        getContentPane().add(lblNewLabel_5);
			  
		        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH");
		        String fechaAlt = formatter.format(dtinfosal.getFechaAlta());		  		
		        String fechaSal = formatter.format(dtinfosal.getFechaAlta());	
			  
			  
			  
			  
			  	nombreSalida = new JTextField();
				nombreSalida.setText(dtinfosal.getNombre());
		        nombreSalida.setBounds(78, 245, 158, 19);
		        getContentPane().add(nombreSalida);
		        nombreSalida.setColumns(10);
		        nombreSalida.setEditable(false);
		        
		        cantTuristas = new JTextField();
				 cantTuristas.setText(String.valueOf(dtinfosal.getCantMax()));
		        cantTuristas.setColumns(10);
		        cantTuristas.setBounds(282, 245, 158, 19);
		        getContentPane().add(cantTuristas);
		        cantTuristas.setEditable(false);
		
		        
		        lugarSalida = new JTextField();
				lugarSalida.setText(dtinfosal.getLugarSalida());
		        lugarSalida.setColumns(10);
		        lugarSalida.setBounds(78, 292, 158, 19);
		        getContentPane().add(lugarSalida);
		        lugarSalida.setEditable(false);
		
		        
		        fechaAlta = new JTextField();
				fechaAlta.setText(fechaAlt);
		        fechaAlta.setColumns(10);
		        fechaAlta.setBounds(282, 292, 158, 19);
		        getContentPane().add(fechaAlta);
		        fechaAlta.setEditable(false);
		
		        
		        txtFechaSalida = new JTextField();
				txtFechaSalida.setText(fechaSal);
		        txtFechaSalida.setColumns(10);
		        txtFechaSalida.setBounds(78, 343, 158, 19);
		        getContentPane().add(txtFechaSalida);
		        txtFechaSalida.setEditable(false);
		
		        
		        txtNombreActividad = new JTextField();
				txtNombreActividad.setText(dtinfosal.getActividadAsociada().getNombre());
		        txtNombreActividad.setColumns(10);
		        txtNombreActividad.setBounds(282, 343, 158, 19);
		        getContentPane().add(txtNombreActividad);
		        txtNombreActividad.setEditable(false);
		}
	}
}
