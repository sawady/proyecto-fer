package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.entities.CamposParaCalculoAnual;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;

public class EditarTablaCalculoAnual extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private CamposParaCalculoAnualHibernateHome homeDecAnual;
	CamposParaCalculoAnual aModificar;

	private static final long serialVersionUID = 1L;

	public EditarTablaCalculoAnual(CamposParaCalculoAnual withId,
			CamposParaCalculoAnualHibernateHome homeDecAnual2) {
		setResizable(false);
		getContentPane().setBackground(new Color(176, 196, 222));
		this.aModificar = withId;
		this.homeDecAnual = homeDecAnual2;
		this.inicialize();
	}
	
	public void inicialize() {
		getContentPane().setLayout(null);
		
		JButton button_1 = new JButton("Volver al inicio");
		button_1.setBounds(12, 12, 136, 29);
		getContentPane().add(button_1);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Button.select"));
		desktopPane.setBounds(22, 61, 596, 315);
		getContentPane().add(desktopPane);
		
		JLabel label = new JLabel("Ganancia neta imponible desde");
		label.setBounds(51, 41, 225, 14);
		desktopPane.add(label);
		
		textField = new JTextField();
		textField.setText("0.0");
		textField.setColumns(10);
		textField.setBounds(310, 41, 138, 20);
		desktopPane.add(textField);
		
		JLabel label_1 = new JLabel("Ganancia neta imponible hasta");
		label_1.setBounds(51, 80, 176, 14);
		desktopPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("0.0");
		textField_1.setColumns(10);
		textField_1.setBounds(310, 80, 138, 20);
		desktopPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Base que se debe pagar");
		label_2.setBounds(51, 124, 176, 14);
		desktopPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setText("0.0");
		textField_2.setColumns(10);
		textField_2.setBounds(310, 124, 138, 20);
		desktopPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Porcentaje estra por excedente");
		label_3.setBounds(51, 166, 240, 14);
		desktopPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setText("0.0");
		textField_3.setColumns(10);
		textField_3.setBounds(310, 166, 138, 20);
		desktopPane.add(textField_3);
		
		JLabel label_4 = new JLabel("Valor de excedente");
		label_4.setBounds(51, 206, 251, 14);
		desktopPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("0.0");
		textField_4.setColumns(10);
		textField_4.setBounds(310, 206, 138, 20);
		desktopPane.add(textField_4);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(170, 255, 106, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEnPantalla();
			}
		});
		desktopPane.add(button);
		
		JButton button_2 = new JButton("Guardar");
		button_2.setBounds(330, 255, 118, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar();
			}
		});
		desktopPane.add(button_2);
	}
	private void mostrarEnPantalla(){
		textField.setText(Float.toString(aModificar.getDesde()));
		textField_1.setText(Float.toString(aModificar.getHasta()));
		textField_2.setText(Float.toString(aModificar.getBase()));
		textField_3.setText(Float.toString(aModificar.getPor_extra()));
		textField_4.setText(Float.toString(aModificar.getSobre_exced()));
		
	}
	
	
	private void botonGuardar(){
		validarFloat(textField,"Ganancia neta imponible desde");
		Float  txt14 = Float.parseFloat(textField.getText());
		validarFloat(textField_1,"Ganancia neta imponible hasta");
		Float  txt15 = Float.parseFloat(textField_1.getText());
		validarFloat(textField_2,"Base que se debe pagar");
		Float  txt16 = Float.parseFloat(textField_2.getText());
		validarFloat(textField_3,"Porcentaje estra por excedente");
		Float  txt17 = Float.parseFloat(textField_3.getText());
		validarFloat(textField_4,"Valor de excedente");
		Float  txt18 = Float.parseFloat(textField_4.getText());
		homeDecAnual.eliminar(aModificar);
		CamposParaCalculoAnual nuevo = new CamposParaCalculoAnual(txt14, txt15, txt16, txt17, txt18);
		homeDecAnual.agregar(nuevo);
		aModificar = nuevo;
		JOptionPane.showMessageDialog(this, "Se han guardado sus cambios",
				"Mensaje", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
	}

	private void validarFloat(JTextField texto, String campo){
		try{
			Float.parseFloat(texto.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, " Solo se permiten números en el campo: " + campo);
			texto.setText(null);
		}
	}

}
