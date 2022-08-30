package Interfaz;
import Logica.Usuario.*;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import Logica.Usuario.*;

/**
 * JInternalFrame que permite registrar un nuevo usuario al sistema.
 * 
 * @author Grupo02
 *
 */


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

public class AltaUsuario extends JInternalFrame {
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNickname;
	private JTextField txtEmail;
	private JTextField txtUrl;
	private JTextField txtNacionalidad;
	private JTextField txtDescripcion;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private ButtonGroup grupoDeRadios;
	
	 
	
	
	public AltaUsuario(IControladorUsuario icu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.NORTH);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Proveedor");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUrl.setEditable(true);
				txtDescripcion.setEditable(true);
			}
		});
		rdbtnNewRadioButton = new JRadioButton("Turista");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUrl.setEditable(false);
				txtDescripcion.setEditable(false);
			}
		});
		panel.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton_1);
		
		grupoDeRadios = new ButtonGroup();
		grupoDeRadios.add(rdbtnNewRadioButton_1);
		grupoDeRadios.add(rdbtnNewRadioButton);
		
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 240));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(113, 42, 85, 19);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(275, 42, 85, 19);
		desktopPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNickname = new JTextField();
		txtNickname.setBounds(113, 71, 85, 19);
		desktopPane.add(txtNickname);
		txtNickname.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(113, 97, 247, 19);
		desktopPane.add(txtEmail);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()==true && checkFormularioTurista()) {
					//EJECUTO UNA FUNCION DE REGISTRAR BACKEND CON TURISTA
					registrarTurista(icu);
				}else if (rdbtnNewRadioButton_1.isSelected() == true && checkFormularioProv()) {			
					//EJECUTO UNA FUNCION DE REGISTRAR BACKEND CON PROVEEDOR
					registrarProveedor(icu);
				}else if (checkFormularioTurista()) {
					//DEJAR CAMPO VACIO Y MANTENER ESTE IF
				}
			}
		});
		btnNewButton.setBounds(113, 220, 85, 21);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(275, 220, 85, 21);
		desktopPane.add(btnNewButton_1);
		
		txtUrl = new JTextField();
		
		txtUrl.setColumns(10);
		txtUrl.setBounds(113, 191, 247, 19);
		desktopPane.add(txtUrl);
		
		txtNacionalidad = new JTextField();
	
		txtNacionalidad.setBounds(275, 71, 85, 19);
		desktopPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(58, 45, 45, 13);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(220, 45, 45, 13);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nickname");
		lblNewLabel_2.setBounds(58, 74, 45, 13);
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(58, 103, 45, 13);
		desktopPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionalidad");
		lblNewLabel_4.setBounds(208, 74, 66, 13);
		desktopPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setBounds(58, 152, 52, 13);
		desktopPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("URL");
		lblNewLabel_6.setBounds(58, 194, 45, 13);
		desktopPane.add(lblNewLabel_6);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(113, 149, 247, 32);
		desktopPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_7.setBounds(58, 126, 113, 13);
		desktopPane.add(lblNewLabel_7);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(181, 123, 179, 19);
		desktopPane.add(dateChooser);
		
		  
		
	}
	
	
	private void limpiarFormulario() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtNickname.setText("");
		txtEmail.setText("");
		txtDescripcion.setText("");
		txtUrl.setText("");
		txtNacionalidad.setText("");
		dateChooser.setDate(null);
		grupoDeRadios.clearSelection();

		
	}
	
	 private boolean checkFormularioTurista() {
	        String nombreU = this.txtNombre.getText();
	        String apellidoU = this.txtApellido.getText();
	        String nick = this.txtNickname.getText();
	        String email = this.txtEmail.getText();
	        String nac = this.txtNacionalidad.getText();
	
	        if (nombreU.isEmpty() || apellidoU.isEmpty() || nick.isEmpty() || email.isEmpty() || nac.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }else {
	        	return true;
	        }
	        
	   }
	 
	 private boolean checkFormularioProv() {
	        String nombreU = this.txtNombre.getText();
	        String apellidoU = this.txtApellido.getText();
	        String nick = this.txtNickname.getText();
	        String email = this.txtEmail.getText();
	        String url = this.txtUrl.getText();
	        String desc = this.txtDescripcion.getText();
	
	        if (nombreU.isEmpty() || apellidoU.isEmpty() || nick.isEmpty() || email.isEmpty() || desc.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }else {
	        	return true;
	        }
	        
	   }
	 protected void registrarTurista(IControladorUsuario icu) {
		 	String nombreU = this.txtNombre.getText();
	        String apellidoU = this.txtApellido.getText();
	        String nick = this.txtNickname.getText();
	        String email = this.txtEmail.getText();
		 	Date fechaNac = this.dateChooser.getDate();
	        String nac = this.txtNacionalidad.getText();
	        
	        
		 	int i = icu.ingresoTurista(nick, nombreU, apellidoU, email, fechaNac, nac);
		 	if(i==1) {
		 		JOptionPane.showMessageDialog(this, "El Usuario se ha registrado con exito", "Registrar Usuario",
	                    JOptionPane.INFORMATION_MESSAGE);
		 		limpiarFormulario();
		 		setVisible(false);
		 		
		 		
		 	}else if(i==2) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el mail ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}else if(i==3) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el Nickname ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}else if(i==4) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el Nickname y Email ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}
		}
	 
	 private void registrarProveedor(IControladorUsuario icu) {
		 	String nombreU = this.txtNombre.getText();
	        String apellidoU = this.txtApellido.getText();
	        String nick = this.txtNickname.getText();
	        String email = this.txtEmail.getText();
		 	Date fechaNac = this.dateChooser.getDate();
		 	String url = this.txtUrl.getText();
		    String desc = this.txtDescripcion.getText();
		 	
		    int i = icu.ingresoProveedor(nick,nombreU,apellidoU,email,fechaNac,desc,url);
		    if(i==1) {
		 		JOptionPane.showMessageDialog(this, "El Usuario se ha registrado con exito", "Registrar Usuario",
	                    JOptionPane.INFORMATION_MESSAGE);
		 		limpiarFormulario();
		 		setVisible(false);
		 		
		 	}else if(i==2) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el mail ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}else if(i==3) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el Nickname ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}else if(i==4) {
		 		JOptionPane.showMessageDialog(this, "Ya existe un usuario registrado con el Nickname y Email ingresado", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
		 	}
			
		}
	
}
	
	
	
