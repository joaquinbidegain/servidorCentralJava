package Interfaz;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import Logica.Paquete.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;






public class CrearPaqueteActTuristicas extends JInternalFrame{

	/*private IControladorPaquete icp;
	
	private JTextField textFieldNombre;
    private JTextField textFieldDescuento;
    private JTextField tesxtFieldValidez;
    private JTextField tesxtFieldDescripcion;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseDescuento;
    private JLabel lblIngreseValidez;
    private JLabel lblIngreseDescripcion;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JTextField textField_1;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
	
	*/public CrearPaqueteActTuristicas(IControladorPaquete icp) {}
	/*
		this.icp = icp;
		
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Paquete Actividad Turistica");
        setBounds(10, 40, 637, 432);
        
        
        
        
        
        
        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label = new JLabel("");
        
        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        
        label_1 = new JLabel("");
        
        label_2 = new JLabel("");
        
        label_3 = new JLabel("");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Descuento");
        
        JLabel lblNewLabel_2 = new JLabel("Validez");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion");
        
        JButton btnNewButton = new JButton("Confirmar");
        
        JButton btnNewButton_1 = new JButton("Cancelar");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(46)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3)
        						.addComponent(lblNewLabel_2))
        					.addGap(18)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(textField_3, 367, 367, 367)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        									.addGap(20)
        									.addComponent(lblNewLabel_1)
        									.addGap(12)
        									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        								.addGroup(groupLayout.createSequentialGroup()
        									.addComponent(btnNewButton)
        									.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
        									.addComponent(btnNewButton_1)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGap(229)
        									.addComponent(label, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
        								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))))
        			.addGap(12))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(23)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(label, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(73)
        					.addComponent(lblNewLabel_3))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(47)
        					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNewButton_1)
        						.addComponent(btnNewButton))
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
        );
        getContentPane().setLayout(groupLayout);
        
        */
}
