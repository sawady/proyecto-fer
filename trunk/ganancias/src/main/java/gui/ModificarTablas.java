package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionB;
import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.HibernateHome;
import java.awt.Color;
import javax.swing.UIManager;

public class ModificarTablas {

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
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ModificarTablas window = new ModificarTablas();
	// window.frmImpuestoALas.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public ModificarTablas() {
		initialize();
		this.mostrarDatosEnPantallaDeduccionA();
		this.mostrarDatosEnPantallaDeduccionB();
		this.mostrarDatosEnPantallaDeduccionC();
		this.mostrarDatosEnPantallCalculoAnual();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImpuestoALas = new JFrame();
		frmImpuestoALas.getContentPane().setBackground(new Color(176, 196, 222));
		frmImpuestoALas.setResizable(false);
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Modificar tablas");
		frmImpuestoALas.setBounds(100, 100, 783, 431);
		frmImpuestoALas.setVisible(true);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImpuestoALas.getContentPane().setLayout(null);

		JButton button = new JButton("Volver al inicio");
		button.setBounds(21, 11, 153, 29);
		frmImpuestoALas.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmImpuestoALas.dispose();
			}
		});

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(31, 54, 734, 322);
		frmImpuestoALas.getContentPane().add(tabbedPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ScrollBar.shadow"));
		tabbedPane.addTab("Deducciones(A)", null, desktopPane, null);

		JLabel lblNombre = new JLabel("Mínimo no imponible");
		lblNombre.setBounds(57, 41, 253, 14);
		desktopPane.add(lblNombre);

		textField = new JTextField();
		textField.setBounds(310, 41, 138, 20);
		desktopPane.add(textField);
		textField.setColumns(10);

		JLabel lblDeduccinEspecal = new JLabel("Deducci\u00F3n especal");
		lblDeduccinEspecal.setBounds(57, 80, 253, 14);
		desktopPane.add(lblDeduccinEspecal);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(310, 80, 138, 20);
		desktopPane.add(textField_1);

		JLabel lblTopeAnualPor = new JLabel("Tope anual por conyuge");
		lblTopeAnualPor.setBounds(57, 124, 253, 14);
		desktopPane.add(lblTopeAnualPor);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(310, 124, 138, 20);
		desktopPane.add(textField_2);

		JLabel lblTopeAnualPor_1 = new JLabel("Tope anual por hijos");
		lblTopeAnualPor_1.setBounds(57, 166, 253, 14);
		desktopPane.add(lblTopeAnualPor_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(310, 166, 138, 20);
		desktopPane.add(textField_3);

		JLabel lblTopeAnualPor_2 = new JLabel("Tope anual por persona a cargo");
		lblTopeAnualPor_2.setBounds(57, 206, 253, 14);
		desktopPane.add(lblTopeAnualPor_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(310, 206, 138, 20);
		desktopPane.add(textField_4);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(170, 255, 106, 23);
		desktopPane.add(btnCancelar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(330, 255, 118, 23);
		desktopPane.add(btnAceptar);

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(UIManager.getColor("Separator.shadow"));
		tabbedPane.addTab("Deducciones(B)", null, desktopPane_1, null);

		JLabel label = new JLabel("Tope anual gastos de sepelio");
		label.setBounds(52, 43, 226, 14);
		desktopPane_1.add(label);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(310, 41, 138, 20);
		desktopPane_1.add(textField_5);

		JLabel label_1 = new JLabel("Tope anual seguro de vida");
		label_1.setBounds(52, 82, 226, 14);
		desktopPane_1.add(label_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(310, 80, 138, 20);
		desktopPane_1.add(textField_6);

		JLabel label_2 = new JLabel("Tope anual servicio domestico");
		label_2.setBounds(52, 126, 226, 18);
		desktopPane_1.add(label_2);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(310, 124, 138, 20);
		desktopPane_1.add(textField_7);

		JLabel label_3 = new JLabel("Tope anual crédito hipotecario");
		label_3.setBounds(52, 168, 226, 14);
		desktopPane_1.add(label_3);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(310, 166, 138, 20);
		desktopPane_1.add(textField_8);

		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(170, 255, 106, 23);
		desktopPane_1.add(button_1);

		JButton button_2 = new JButton("Aceptar");
		button_2.setBounds(330, 255, 118, 23);
		desktopPane_1.add(button_2);

		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(UIManager.getColor("ScrollBar.shadow"));
		tabbedPane.addTab("Deducciones(C)", null, desktopPane_2, null);

		JLabel lblCuotaMedicoAsistencial = new JLabel(
				"Cuota Médico Asistencial");
		lblCuotaMedicoAsistencial.setBounds(51, 41, 225, 14);
		desktopPane_2.add(lblCuotaMedicoAsistencial);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(310, 41, 138, 20);
		desktopPane_2.add(textField_9);

		JLabel lblHonorariosMedicos = new JLabel("Honorarios Medicos");
		lblHonorariosMedicos.setBounds(51, 80, 176, 14);
		desktopPane_2.add(lblHonorariosMedicos);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(310, 80, 138, 20);
		desktopPane_2.add(textField_10);

		JLabel lblDonaciones = new JLabel("Donaciones");
		lblDonaciones.setBounds(51, 124, 176, 14);
		desktopPane_2.add(lblDonaciones);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(310, 124, 138, 20);
		desktopPane_2.add(textField_11);

		JLabel lblImpuestoAlCheque = new JLabel("Imp al Cheque sobre créditos");
		lblImpuestoAlCheque.setBounds(51, 166, 240, 14);
		desktopPane_2.add(lblImpuestoAlCheque);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(310, 166, 138, 20);
		desktopPane_2.add(textField_12);

		JLabel lblDeduccionImpCheque = new JLabel(
				"Deducción imp. cheque sobre Cred");
		lblDeduccionImpCheque.setBounds(51, 206, 251, 14);
		desktopPane_2.add(lblDeduccionImpCheque);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(310, 206, 138, 20);
		desktopPane_2.add(textField_13);

		JButton button_3 = new JButton("Cancelar");
		button_3.setBounds(170, 255, 106, 23);
		desktopPane_2.add(button_3);

		JButton button_4 = new JButton("Aceptar");
		button_4.setBounds(330, 255, 118, 23);
		desktopPane_2.add(button_4);

		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(UIManager.getColor("ScrollBar.thumbHighlight"));
		tabbedPane.addTab("Impuesto Anual", null, desktopPane_3, null);

		JLabel label_9 = new JLabel("Ganancia neta imponible desde");
		label_9.setBounds(41, 41, 240, 14);
		desktopPane_3.add(label_9);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(310, 41, 138, 20);
		desktopPane_3.add(textField_14);

		JLabel label_10 = new JLabel("Ganancia neta imponible hasta");
		label_10.setBounds(41, 80, 240, 14);
		desktopPane_3.add(label_10);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(310, 80, 138, 20);
		desktopPane_3.add(textField_15);

		JLabel label_11 = new JLabel("Base que se debe pagar");
		label_11.setBounds(41, 124, 240, 14);
		desktopPane_3.add(label_11);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(310, 124, 138, 20);
		desktopPane_3.add(textField_16);

		JLabel label_12 = new JLabel("Porcentaje estra por excedente");
		label_12.setBounds(41, 166, 240, 14);
		desktopPane_3.add(label_12);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(310, 166, 138, 20);
		desktopPane_3.add(textField_17);

		JLabel label_13 = new JLabel("Valor de excedente");
		label_13.setBounds(41, 206, 251, 14);
		desktopPane_3.add(label_13);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(310, 206, 138, 20);
		desktopPane_3.add(textField_18);

		JButton button_5 = new JButton("Cancelar");
		button_5.setBounds(170, 255, 106, 23);
		desktopPane_3.add(button_5);

		JButton button_6 = new JButton("Aceptar");
		button_6.setBounds(330, 255, 118, 23);
		desktopPane_3.add(button_6);

	}

	public void mostrarDatosEnPantallaDeduccionA() {
		HibernateHome<DeduccionA> homeDecA = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		DeduccionA deduccionA = homeDecA.getFirst();
		textField.setText(Float.toString(deduccionA.getMin_no_imp()));
		textField_1.setText(Float.toString(deduccionA.getDedu_espe()));
		textField_2.setText(Float.toString(deduccionA.getConyuge()));
		textField_3.setText(Float.toString(deduccionA.getHijos()));
		textField_4.setText(Float.toString(deduccionA.getOtros()));

	}
	
	public void mostrarDatosEnPantallaDeduccionB() {
		HibernateHome<DeduccionB> homeDecB = (HibernateHome<DeduccionB>) HibernateApplication
				.getInstance().getHome(DeduccionB.class);
		DeduccionB deduccionB = homeDecB.getFirst();
		textField_5.setText(Float.toString(deduccionB.getGast_sepe_anu()));
		textField_6.setText(Float.toString(deduccionB.getSeg_vida_anu()));
		textField_7.setText(Float.toString(deduccionB.getServ_dom_anu()));
		textField_8.setText(Float.toString(deduccionB.getInt_cred_hip_anu()));

	}
	public void mostrarDatosEnPantallaDeduccionC() {
		HibernateHome<DeduccionC> homeDecC = (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		DeduccionC deduccionC = homeDecC.getFirst();
		textField_9.setText(Float.toString(deduccionC.getCout_med_asist_anu()));
		textField_10.setText(Float.toString(deduccionC.getHonor_med_anu()));
		textField_11.setText(Float.toString(deduccionC.getDonac_anu()));
		textField_12.setText(Float.toString(deduccionC.getImp_cheq_cred_anu()));
		textField_13.setText(Float.toString(deduccionC.getDeb_total_imp_cheq_cred_anu()));
	}
	
	public void mostrarDatosEnPantallCalculoAnual() {
		CamposParaCalculoAnualHibernateHome homeDecC = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		CamposParaCalculoAnual camposParaCalculoAnual = homeDecC.getFirst();
		textField_14.setText(Float.toString(camposParaCalculoAnual.getDesde()));
		textField_15.setText(Float.toString(camposParaCalculoAnual.getHasta()));
		textField_16.setText(Float.toString(camposParaCalculoAnual.getBase()));
		textField_17.setText(Float.toString(camposParaCalculoAnual.getPor_extra()));
		textField_18.setText(Float.toString(camposParaCalculoAnual.getSobre_exced()));
	}

}