package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;


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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoManual window = new CalculoManual();
					window.frmImpuestoALas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Calculo manual");
		frmImpuestoALas.setBounds(100, 100, 781, 573);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Volver al inicio");
		button.setBounds(10, 11, 136, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmImpuestoALas.getContentPane().setLayout(null);
		frmImpuestoALas.getContentPane().add(button);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(47, 30, 703, 482);
		frmImpuestoALas.getContentPane().add(desktopPane);
		
		JLabel lblRemuneracionNetaImponibble = new JLabel("Remuneracion neta imponible");
		lblRemuneracionNetaImponibble.setBounds(25, 12, 261, 15);
		desktopPane.add(lblRemuneracionNetaImponibble);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(25, 43, 205, 15);
		desktopPane.add(lblEstadoCivil);
		
		textField = new JTextField();
		textField.setBounds(276, 10, 138, 19);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Soltero", "Casado"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(276, 38, 138, 24);
		desktopPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Cant de hijos");
		lblNewLabel.setBounds(25, 76, 122, 15);
		desktopPane.add(lblNewLabel);
		
		JLabel lblCantPersonasA = new JLabel("Cant personas a cargo");
		lblCantPersonasA.setBounds(25, 114, 161, 15);
		desktopPane.add(lblCantPersonasA);
		
		JLabel lblGastosDeSepelio = new JLabel("Gastos de sepelio");
		lblGastosDeSepelio.setBounds(35, 176, 70, 15);
		desktopPane.add(lblGastosDeSepelio);
		
		JLabel lblSeguroDeVida = new JLabel("Seguro de vida");
		lblSeguroDeVida.setBounds(35, 224, 70, 15);
		desktopPane.add(lblSeguroDeVida);
		
		JLabel lblDonaciones = new JLabel("Donaciones");
		lblDonaciones.setBounds(25, 261, 70, 15);
		desktopPane.add(lblDonaciones);
		
		JLabel lblCuotasMedicoAsistenciales = new JLabel("Cuotas Medico Asistenciales");
		lblCuotasMedicoAsistenciales.setBounds(25, 299, 70, 15);
		desktopPane.add(lblCuotasMedicoAsistenciales);
		
		JLabel lblHonorariosMedicos = new JLabel("Honorarios medicos");
		lblHonorariosMedicos.setBounds(12, 320, 70, 15);
		desktopPane.add(lblHonorariosMedicos);
		
		JLabel lblInteresesPorCredito = new JLabel("Intereses por credito");
		lblInteresesPorCredito.setBounds(25, 347, 70, 15);
		desktopPane.add(lblInteresesPorCredito);
		
		JLabel lblServicioDomestico = new JLabel("Servicio domestico");
		lblServicioDomestico.setBounds(25, 374, 70, 15);
		desktopPane.add(lblServicioDomestico);
		
		JLabel lblImpuestoAlCheque = new JLabel("Impuesto al cheque sobre creditos");
		lblImpuestoAlCheque.setBounds(25, 401, 70, 15);
		desktopPane.add(lblImpuestoAlCheque);
		
		JLabel lblMontoDevolucionCompra = new JLabel("Monto devolucion compra al exterior");
		lblMontoDevolucionCompra.setBounds(25, 428, 70, 15);
		desktopPane.add(lblMontoDevolucionCompra);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(203, 420, 106, 23);
		desktopPane.add(button_1);
		
		JButton button_2 = new JButton("Aceptar");
		button_2.setBounds(363, 420, 118, 23);
		desktopPane.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 74, 138, 20);
		desktopPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(276, 112, 138, 20);
		desktopPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(276, 174, 138, 20);
		desktopPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(276, 216, 138, 20);
		desktopPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(276, 256, 138, 20);
		desktopPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(276, 297, 138, 20);
		desktopPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(276, 336, 138, 20);
		desktopPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(276, 380, 138, 20);
		desktopPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(276, 422, 138, 20);
		desktopPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(276, 462, 138, 20);
		desktopPane.add(textField_10);
	}
}
