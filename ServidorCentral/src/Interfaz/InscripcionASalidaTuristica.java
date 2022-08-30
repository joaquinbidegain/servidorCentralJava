package Interfaz;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Logica.Turistico.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class InscripcionASalidaTuristica extends JInternalFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public InscripcionASalidaTuristica(IControladorTuristico ict) {

		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Salida Turistica");
        setBounds(30, 30, 517, 509);

        getContentPane().setLayout(null);
        
        JComboBox comboBoxDepto = new JComboBox();
        comboBoxDepto.setBounds(142, 41, 215, 22);
        getContentPane().add(comboBoxDepto);
        
        JLabel lblNewLabel = new JLabel("Departamentos:");
        lblNewLabel.setBounds(207, 23, 108, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Actividades del Departamento:");
        lblNewLabel_1.setBounds(176, 74, 181, 14);
        getContentPane().add(lblNewLabel_1);
        
        JComboBox comboBoxActDelDepto = new JComboBox();
        comboBoxActDelDepto.setBounds(142, 90, 215, 22);
        getContentPane().add(comboBoxActDelDepto);
        
        JLabel lblNewLabel_2 = new JLabel("Salidas del Departamento:");
        lblNewLabel_2.setBounds(183, 123, 149, 14);
        getContentPane().add(lblNewLabel_2);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(142, 138, 215, 22);
        getContentPane().add(comboBox);
        
        JButton btnNewButton = new JButton("Filtrar");
        btnNewButton.setBounds(207, 171, 73, 22);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("Informacion de la Salida Turistica");
        lblNewLabel_3.setBounds(165, 204, 229, 14);
        getContentPane().add(lblNewLabel_3);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(112, 226, 297, 2);
        getContentPane().add(separator);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(93, 243, 116, 20);
        getContentPane().add(textField);
        
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(312, 243, 116, 20);
        getContentPane().add(textField_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Nombre: ");
        lblNewLabel_3_1.setBounds(41, 246, 58, 14);
        getContentPane().add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_4 = new JLabel("Lugar:");
        lblNewLabel_4.setBounds(268, 246, 46, 14);
        getContentPane().add(lblNewLabel_4);
        
        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(93, 280, 116, 20);
        getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(312, 280, 116, 20);
        getContentPane().add(textField_3);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Fecha de Alta:");
        lblNewLabel_3_1_1.setBounds(10, 283, 80, 14);
        getContentPane().add(lblNewLabel_3_1_1);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Fecha de salida:");
        lblNewLabel_3_1_1_1.setBounds(219, 283, 96, 14);
        getContentPane().add(lblNewLabel_3_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(248, 315, 67, 20);
        getContentPane().add(textField_4);
        
        JLabel lblNewLabel_5 = new JLabel("Cantidad Turistas:");
        lblNewLabel_5.setBounds(130, 318, 108, 14);
        getContentPane().add(lblNewLabel_5);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(142, 366, 215, 22);
        getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel_6 = new JLabel("Turistas:");
        lblNewLabel_6.setBounds(229, 346, 97, 14);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_5_1 = new JLabel("Cantidad Turistas:");
        lblNewLabel_5_1.setBounds(142, 405, 108, 14);
        getContentPane().add(lblNewLabel_5_1);
        
        textField_5 = new JTextField();
        textField_5.setBounds(248, 402, 67, 20);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);
        
        JButton btnNewConfirmar = new JButton("Confirmar");
        btnNewConfirmar.setBounds(112, 430, 89, 23);
        getContentPane().add(btnNewConfirmar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(286, 430, 89, 23);
        getContentPane().add(btnCancelar);
		
	}
}
