package Interfaz;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Logica.Turistico.DTInfoActividadTuristica;
import Logica.Turistico.DTInfoSalida;
import Logica.Turistico.IControladorTuristico;
import Logica.Usuario.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.util.Iterator;
import java.util.Set;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaUsuario extends JInternalFrame {
	
	private JComboBox comboAct;
	private JComboBox comboSal;
	private JComboBox comboUs;
	private JTextField txtTipoUsuario;
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


	
	
	public ConsultaUsuario(IControladorUsuario icu , IControladorTuristico ict, JFrame frmGestionDeUsuarios) {
		getContentPane().setBackground(new Color(240, 255, 255));
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Usuario");
        setBounds(30, 30, 520, 401);

        getContentPane().setLayout(null);
        comboUs = new JComboBox();
        comboUs.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		comboUs.removeAllItems();
        		Set<DTUsuario> usuarios = icu.listaUsuario();
                if(usuarios != null) {
        			for(DTUsuario u : usuarios){
        				comboUs.addItem(u.getNickname());
        	        }
                }
        	}
        });
        
        
        //obtengo la lista de departamentos del sistema
        Set<DTUsuario> usuarios = icu.listaUsuario();
        if(usuarios != null) {
			for(DTUsuario u : usuarios){
				comboUs.addItem(u.getNickname());
	        }
        }

		comboUs.setBounds(52, 62, 388, 21);
		getContentPane().add(comboUs);
		
		
		
		JLabel lblNewLabel = new JLabel("Listado Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 39, 395, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informacion Usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(52, 93, 395, 13);
		getContentPane().add(lblNewLabel_1);
		

		JTextField nombreUs = new JTextField();
		nombreUs.setBounds(52, 135, 167, 19);
		getContentPane().add(nombreUs);
		nombreUs.setColumns(10);
		nombreUs.setEditable(false);
		nombreUs.setText("Nombre");

		
		
		JTextField apellidoUs = new JTextField();
		apellidoUs.setBounds(280, 135, 160, 19);
		getContentPane().add(apellidoUs);
		apellidoUs.setColumns(10);
		apellidoUs.setEditable(false);
		apellidoUs.setText("Apellido");


		JTextField emailUs = new JTextField();
		emailUs.setColumns(10);
		emailUs.setBounds(52, 174, 167, 19);
		getContentPane().add(emailUs);
		emailUs.setEditable(false);
		emailUs.setText("Email");

		
		JTextField nickUs = new JTextField();
		nickUs.setColumns(10);
		nickUs.setBounds(280, 174, 160, 19);
		getContentPane().add(nickUs);
		nickUs.setEditable(false);
		nickUs.setText("Nickname");

		
		JTextField fechaUs = new JTextField();
		fechaUs.setColumns(10);
		fechaUs.setBounds(52, 210, 167, 19);
		getContentPane().add(fechaUs);
		fechaUs.setEditable(false);
		fechaUs.setText("Fecha Nacimiento");
		
		comboAct = new JComboBox();
		
		comboAct.setBounds(52, 264, 293, 21);
		comboAct.setVisible(false);
		getContentPane().add(comboAct);
		
		comboSal  = new JComboBox();
		comboSal.setBounds(52, 264, 293, 21);
		comboSal.setVisible(false);
		getContentPane().add(comboSal);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 50, 395, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(52, 104, 395, 2);
		getContentPane().add(separator_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(280, 124, 167, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(52, 163, 167, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nickname");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setBounds(280, 163, 167, 13);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Fecha Nacimiento");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2.setBounds(52, 198, 167, 13);
		getContentPane().add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 124, 167, 13);
		getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(52, 239, 395, 2);
		getContentPane().add(separator_2);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setText("Tipo Usuario");
		txtTipoUsuario.setEditable(false);
		txtTipoUsuario.setColumns(10);
		txtTipoUsuario.setBounds(280, 210, 160, 19);
		getContentPane().add(txtTipoUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(52, 251, 395, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnVer = new JButton("Ver");
		
		btnVer.setBounds(355, 264, 85, 21);
		getContentPane().add(btnVer);
		
		
		comboUs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
	            String seleccionado1=(String)comboUs.getSelectedItem();
        		if (e.getSource()==comboUs && seleccionado1 != null) {
			            String seleccionado=(String)comboUs.getSelectedItem();
			            comboSal.removeAllItems();
			            comboAct.removeAllItems();
			            DTUsuario user = icu.obtenerUsuario(seleccionado);
			            nombreUs.setText(user.getNombre());
			            apellidoUs.setText(user.getApellido());
			            nickUs.setText(user.getNickname());
			            emailUs.setText(user.getEmail());
			            
			            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH");
				  		String fechaNac = formatter.format(user.getNacimiento());
			            fechaUs.setText(fechaNac);
			            
			            
			            boolean esTur = icu.esTurista(user.getNickname());
			            if(esTur) {
			            	txtTipoUsuario.setText("Turista");
			            	Set<DTInfoSalida> dtsal = icu.obtenerSalidasTuristicas(user.getNickname());
				            if(dtsal != null) {
				            	for(DTInfoSalida sal : dtsal){
				            		comboSal.addItem(sal.getNombre());
				            	}
				            	lblNewLabel_1_1.setText("Listado de Salidas Turisticas");
				            	comboSal.setVisible(true);
				    			comboAct.setVisible(false);
				    			
				    			
				            }
				            }else {
				            	txtTipoUsuario.setText("Proveedor");	
				            	Set<DTInfoActividadTuristica> dtact = icu.obtenerActividadesTuristicas(user.getNickname());
					            if(dtact != null) {
					    			for(DTInfoActividadTuristica act : dtact){
					    				comboAct.addItem(act.getNombre());
					    	        }
					            	lblNewLabel_1_1.setText("Listado de Actividades Turisticas");
					            	comboAct.setVisible(true);
					    			comboSal.setVisible(false);
					    			
				    			
				            }
			            }
				  	}
			  }
        });
		
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            String seleccionado=(String)comboUs.getSelectedItem();
	            DTUsuario user = icu.obtenerUsuario(seleccionado);
	            boolean esTur = icu.esTurista(user.getNickname());
	            if(esTur) {
		            String selSal=(String)comboSal.getSelectedItem();
		            if(selSal != null) {
		            	DTInfoSalida dtsal = ict.datosSalida(selSal);		            	
		            	ConsultaSalidaTuristica altaSalTurInternalFrame = new ConsultaSalidaTuristica(ict,dtsal);
		            	altaSalTurInternalFrame.setVisible(true);
		            	frmGestionDeUsuarios.add(altaSalTurInternalFrame);	            	
		            }
	            	
	            }else {
		            String selAct=(String)comboAct.getSelectedItem();
		            if(selAct != null) {
		            	Set<DTInfoActividadTuristica> dtact = icu.obtenerActividadesTuristicas(user.getNickname());
		            	Iterator<DTInfoActividadTuristica> itr = dtact.iterator();
		            	boolean encontrado = false;
		            	DTInfoActividadTuristica u = null;
		            	String a = " ";
		            	while(itr.hasNext() && (a !=selAct)) {
		            		u =itr.next();
		            		a = u.getNombre();
		            	}

		            	ConsultaActividadTuristica consActTurInternalFrame = new ConsultaActividadTuristica(ict,u);
		            	consActTurInternalFrame.setVisible(true);
		            	frmGestionDeUsuarios.add(consActTurInternalFrame);	            	
		            	
	            }
			}

			}

		});
	
	}
}

	