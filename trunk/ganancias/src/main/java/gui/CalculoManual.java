package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CalculoManual {

	private JFrame frmImpuestoALas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JComboBox comboBox;

	/**
	 * Create the application.
	 */
	public CalculoManual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImpuestoALas = new JFrame();
		frmImpuestoALas.getContentPane()
				.setBackground(new Color(176, 196, 222));
		frmImpuestoALas.setResizable(false);
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Calculo manual");
		frmImpuestoALas.setBounds(100, 100, 781, 672);
		frmImpuestoALas.setVisible(true);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Volver al inicio");
		button.setBounds(10, 11, 136, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmImpuestoALas.dispose();
			}
		});
		frmImpuestoALas.getContentPane().setLayout(null);
		frmImpuestoALas.getContentPane().add(button);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ScrollBar.shadow"));
		desktopPane.setBounds(42, 52, 703, 568);
		frmImpuestoALas.getContentPane().add(desktopPane);

		JLabel lblRemuneracionNetaImponibble = new JLabel(
				"Remuneracion neta imponible");
		lblRemuneracionNetaImponibble.setBounds(45, 34, 222, 15);
		desktopPane.add(lblRemuneracionNetaImponibble);

		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(45, 62, 205, 15);
		desktopPane.add(lblEstadoCivil);

		textField = new JTextField();
		textField.setBounds(324, 34, 138, 19);
		desktopPane.add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Soltero",
				"Casado" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(324, 62, 138, 24);
		desktopPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Cantidad de hijos");
		lblNewLabel.setBounds(45, 98, 187, 15);
		desktopPane.add(lblNewLabel);

		JLabel lblCantPersonasA = new JLabel("Cantidad personas a cargo");
		lblCantPersonasA.setBounds(45, 136, 207, 15);
		desktopPane.add(lblCantPersonasA);

		JLabel lblGastosDeSepelio = new JLabel("Gastos de sepelio");
		lblGastosDeSepelio.setBounds(45, 174, 161, 15);
		desktopPane.add(lblGastosDeSepelio);

		JLabel lblSeguroDeVida = new JLabel("Seguro de vida");
		lblSeguroDeVida.setBounds(45, 206, 159, 15);
		desktopPane.add(lblSeguroDeVida);

		JLabel lblDonaciones = new JLabel("Donaciones");
		lblDonaciones.setBounds(45, 238, 138, 15);
		desktopPane.add(lblDonaciones);

		JLabel lblCuotasMedicoAsistenciales = new JLabel(
				"Cuotas Medico Asistenciales");
		lblCuotasMedicoAsistenciales.setBounds(45, 272, 205, 15);
		desktopPane.add(lblCuotasMedicoAsistenciales);

		JLabel lblHonorariosMedicos = new JLabel("Honorarios médicos");
		lblHonorariosMedicos.setBounds(45, 304, 205, 15);
		desktopPane.add(lblHonorariosMedicos);

		JLabel lblInteresesPorCredito = new JLabel("Intereses por crédito");
		lblInteresesPorCredito.setBounds(45, 344, 187, 15);
		desktopPane.add(lblInteresesPorCredito);

		JLabel lblServicioDomestico = new JLabel("Servicio doméstico");
		lblServicioDomestico.setBounds(45, 384, 166, 15);
		desktopPane.add(lblServicioDomestico);

		JLabel lblImpuestoAlCheque = new JLabel(
				"Impuesto al cheque sobre créditos");
		lblImpuestoAlCheque.setBounds(45, 419, 259, 19);
		desktopPane.add(lblImpuestoAlCheque);

		JLabel lblMontoDevolucionCompra = new JLabel(
				"Monto devolución compra al exterior");
		lblMontoDevolucionCompra.setBounds(45, 456, 277, 15);
		desktopPane.add(lblMontoDevolucionCompra);

		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(193, 521, 106, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ponerCamposEnBlanco();
			}
		});
		desktopPane.add(button_1);

		JButton button_2 = new JButton("Aceptar");
		button_2.setBounds(354, 519, 118, 23);
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog();
			}
		});
		desktopPane.add(button_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 98, 138, 20);
		desktopPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 136, 138, 20);
		desktopPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(324, 174, 138, 20);
		desktopPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(324, 206, 138, 20);
		desktopPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(324, 238, 138, 20);
		desktopPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(324, 270, 138, 20);
		desktopPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(324, 302, 138, 20);
		desktopPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(324, 342, 138, 20);
		desktopPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(324, 382, 138, 20);
		desktopPane.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(324, 414, 138, 20);
		desktopPane.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(324, 455, 138, 20);
		desktopPane.add(textField_11);
	}

	private void ponerCamposEnBlanco() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		textField_10.setText("");
		textField_11.setText("");
	}

	private void showDialog() {
		if (textField.getText().equals("") || textField_1.getText().equals("")
				|| textField_2.getText().equals("")
				|| textField_3.getText().equals("")
				|| textField_4.getText().equals("")
				|| textField_5.getText().equals("")
				|| textField_6.getText().equals("")
				|| textField_7.getText().equals("")
				|| textField_8.getText().equals("")
				|| textField_9.getText().equals("")
				|| textField_10.getText().equals("")
				|| textField_11.getText().equals("")) {
			JOptionPane.showMessageDialog(frmImpuestoALas,
					"Debe completar todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
		} 	
		else {
			model.calculo.CalculoManual resultados = resultadosCalculoManual();
			new ResultadosCalculoManual(new String(" "
					+ resultados.gananciaNetaA()), new String(" "
					+ resultados.gananciaNetaB()), new String(" "
					+ resultados.gananciaNetaC()), new String(" "
					+ resultados.impuestoAPagarEnElAnio()), new String(" "
					+ resultados.impuestoAPagarPorMes()));
		}
	}

	private model.calculo.CalculoManual resultadosCalculoManual() {
		validarFloat(textField, "Remuneracion neta imponible");
		Float rnif = Float.parseFloat(textField.getText());
		validarInteger(textField_1,"Cantidad de hijos");
		Integer cantHijos = Integer.parseInt(textField_1.getText());
		validarInteger(textField_2, "Cantidad personas a cargo");
		Integer persACargo = Integer.parseInt(textField_2.getText());
		validarFloat(textField_3, "Gastos de sepelio");
		Float gastSepe = Float.parseFloat(textField_3.getText());
		validarFloat(textField_4,"Seguro de vida");
		Float segVida = Float.parseFloat(textField_4.getText());
		validarFloat(textField_5, "Donaciones");
		Float donaciones = Float.parseFloat(textField_5.getText());
		validarFloat(textField_6, "Cuotas Medico Asistenciales");
		Float coutMedAsis = Float.parseFloat(textField_6.getText());
		validarFloat(textField_7, "Honorarios médicos");
		Float honorariosMed = Float.parseFloat(textField_7.getText());
		validarFloat(textField_8, "Intereses por crédito");
		Float intCredHip = Float.parseFloat(textField_8.getText());
		validarFloat(textField_9,"Servicio doméstico");
		Float servDom = Float.parseFloat(textField_9.getText());
		validarFloat(textField_10, "Impuesto al cheque sobre créditos");
		Float impSobreCred = Float.parseFloat(textField_10.getText());
		validarFloat(textField_11, "Monto devolución compra al exterior");
		Float devExterior = Float.parseFloat(textField_11.getText());
		Integer estadoCivil = comboBox.getSelectedIndex(); // 0 = soltero 1=
															// casado
		return new model.calculo.CalculoManual(rnif, estadoCivil, cantHijos,
				persACargo, gastSepe, segVida, donaciones, coutMedAsis,
				honorariosMed, intCredHip, servDom, impSobreCred, devExterior);

	}

	private void validarFloat(JTextField texto, String campo){
		try{
			Float.parseFloat(texto.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, " Solo se permiten números en el campo: " + campo);
			texto.setText(null);
		}
	}
	
	private void validarInteger(JTextField texto, String campo){
		try{
			Integer.parseInt(texto.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null," Solo se permiten números en el campo: " + campo);
			texto.setText(null);
		}
	}
	
}
