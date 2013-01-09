package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
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

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CalculoManual window = new CalculoManual();
//					window.frmImpuestoALas.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		frmImpuestoALas.getContentPane().setBackground(new Color(176, 196, 222));
		frmImpuestoALas.setResizable(false);
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Calculo manual");
		frmImpuestoALas.setBounds(100, 100, 781, 672);
		frmImpuestoALas.setVisible(true);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Volver al inicio");
		button.setBounds(10, 11, 136, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmImpuestoALas.dispose();			}
		});
		frmImpuestoALas.getContentPane().setLayout(null);
		frmImpuestoALas.getContentPane().add(button);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ScrollBar.shadow"));
		desktopPane.setBounds(42, 52, 703, 568);
		frmImpuestoALas.getContentPane().add(desktopPane);
		
		JLabel lblRemuneracionNetaImponibble = new JLabel("Remuneracion neta imponible");
		lblRemuneracionNetaImponibble.setBounds(45, 34, 222, 15);
		desktopPane.add(lblRemuneracionNetaImponibble);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(45, 62, 205, 15);
		desktopPane.add(lblEstadoCivil);
		
		textField = new JTextField();
		textField.setBounds(324, 34, 138, 19);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Soltero", "Casado"}));
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
		
		JLabel lblCuotasMedicoAsistenciales = new JLabel("Cuotas Medico Asistenciales");
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
		
		JLabel lblImpuestoAlCheque = new JLabel("Impuesto al cheque sobre créditos");
		lblImpuestoAlCheque.setBounds(45, 425, 259, 19);
		desktopPane.add(lblImpuestoAlCheque);
		
		JLabel lblMontoDevolucionCompra = new JLabel("Monto devolución compra al exterior");
		lblMontoDevolucionCompra.setBounds(45, 456, 277, 15);
		desktopPane.add(lblMontoDevolucionCompra);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(193, 521, 106, 23);
		desktopPane.add(button_1);
		
		JButton button_2 = new JButton("Aceptar");
		button_2.setBounds(354, 519, 118, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		textField_10.setBounds(324, 423, 138, 20);
		desktopPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(324, 455, 138, 20);
		desktopPane.add(textField_11);
	}
}