package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.entities.DeduccionA;
import model.entities.DeduccionB;
import model.entities.DeduccionC;
import model.entities.TopeSalarial;
import persistencia.HibernateApplication;
import persistencia.Actions.ActionEditarDeduccionA;
import persistencia.Actions.ActionEditarDeduccionB;
import persistencia.Actions.ActionEditarDeduccionC;
import persistencia.Actions.ActionEditarTope;
import persistencia.Actions.ActionGetFirstDeduccionA;
import persistencia.Actions.ActionGetFirstDeduccionB;
import persistencia.Actions.ActionGetFirstDeduccionC;
import persistencia.Actions.ActionGetFirstTope;
import persistencia.Actions.ActionTraerTodosAnual;

public class ModificarTablas {

	private JFrame frmImpuestoALas;
	private TableModelAnual tableModel;
	private JTable tableAnual;
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
	private JTextField textField_13;
	private JTextField textField_12;
	private JTextField textField_14;

	/**
	 * Create the application.
	 */
	public ModificarTablas() {
		initialize();
		this.mostrarDatosEnPantallaDeduccionA();
		this.mostrarDatosEnPantallaDeduccionB();
		this.mostrarDatosEnPantallaDeduccionC();
		this.mostrarDatosEnPantallaTope();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConfiguration();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(31, 24, 734, 322);
		frmImpuestoALas.getContentPane().add(tabbedPane);

		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBackground(UIManager.getColor("ScrollBar.shadow"));
		tabbedPane.addTab("Tope salarial", null, desktopPane_4, null);

		JLabel lblSoltero = new JLabel("Soltero");
		lblSoltero.setBounds(86, 47, 225, 14);
		desktopPane_4.add(lblSoltero);

		textField_12 = new JTextField();
		textField_12.setText("0.0");
		textField_12.setColumns(10);
		textField_12.setBounds(341, 45, 138, 20);
		desktopPane_4.add(textField_12);

		JLabel lblCasado = new JLabel("Casado");
		lblCasado.setBounds(86, 86, 176, 14);
		desktopPane_4.add(lblCasado);

		textField_14 = new JTextField();
		textField_14.setText("0.0");
		textField_14.setColumns(10);
		textField_14.setBounds(341, 86, 138, 20);
		desktopPane_4.add(textField_14);

		JButton button_2 = new JButton("Cancelar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 botonCancelarTope();
			}
		});
		button_2.setBounds(205, 261, 106, 23);
		desktopPane_4.add(button_2);

		JButton button_4 = new JButton("Guardar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccionTope();
			}
		});
		button_4.setBounds(365, 261, 118, 23);
		desktopPane_4.add(button_4);

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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccionA();
			}
		});
		desktopPane.add(btnCancelar);

		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccionA();
				JOptionPane.showMessageDialog(frmImpuestoALas,
						"Los cambios se guardaron satisfactoriamente",
						"Información", JOptionPane.INFORMATION_MESSAGE);
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccionB();
			}
		});
		desktopPane_1.add(button_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(330, 255, 118, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccionB();
			}
		});
		desktopPane_1.add(btnGuardar);

		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(UIManager.getColor("ScrollBar.shadow"));
		tabbedPane.addTab("Deducciones(C)", null, desktopPane_2, null);

		JLabel lblCuotaMedicoAsistencial = new JLabel(
				"Cuota Médico Asistencial");
		lblCuotaMedicoAsistencial.setBounds(51, 41, 225, 14);
		desktopPane_2.add(lblCuotaMedicoAsistencial);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(306, 39, 138, 20);
		desktopPane_2.add(textField_9);

		JLabel lblHonorariosMedicos = new JLabel("Honorarios Medicos");
		lblHonorariosMedicos.setBounds(51, 80, 176, 14);
		desktopPane_2.add(lblHonorariosMedicos);
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(306, 80, 138, 20);
		desktopPane_2.add(textField_10);

		JLabel lblDonaciones = new JLabel("Donaciones");
		lblDonaciones.setBounds(51, 124, 176, 14);
		desktopPane_2.add(lblDonaciones);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(306, 124, 138, 20);
		desktopPane_2.add(textField_11);

		JLabel lblDeduccionImpCheque = new JLabel(
				"Deducción imp.cheque sobre Cred");
		lblDeduccionImpCheque.setBounds(51, 166, 262, 14);
		desktopPane_2.add(lblDeduccionImpCheque);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(306, 166, 138, 20);
		desktopPane_2.add(textField_13);

		JButton button_3 = new JButton("Cancelar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelarAccionC();
			}
		});
		button_3.setBounds(170, 255, 106, 23);
		desktopPane_2.add(button_3);

		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptarAccionC();
			}
		});
		btnGuardar_1.setBounds(330, 255, 118, 23);
		desktopPane_2.add(btnGuardar_1);

		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(UIManager
				.getColor("ScrollBar.thumbHighlight"));
		tabbedPane.addTab("Impuesto Anual", null, desktopPane_3, null);

		// tabla

		desktopPane_3.add(tabla());

		JButton btnEditarFila = new JButton("Editar Fila");
		btnEditarFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableAnual.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frmImpuestoALas,
							"Seleccione una fila primero", "Mensaje",
							JOptionPane.ERROR_MESSAGE);
				} else {
					new EditarTablaCalculoAnual((Float) tableModel.getValueAt(
							tableAnual.getSelectedRow(), 0));
					frmImpuestoALas.dispose();
				}

			}
		});
		btnEditarFila.setBounds(460, 278, 124, 25);
		desktopPane_3.add(btnEditarFila);

		JButton button = new JButton("Volver al inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImpuestoALas.dispose();
			}
		});
		button.setBounds(612, 358, 153, 29);
		frmImpuestoALas.getContentPane().add(button);
	}
	// Auxiliares

	private void frameConfiguration() {
		frmImpuestoALas = new JFrame();
		frmImpuestoALas.getContentPane()
				.setBackground(new Color(176, 196, 222));
		frmImpuestoALas.setResizable(false);
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Modificar tablas");
		frmImpuestoALas.setBounds(100, 100, 783, 431);
		frmImpuestoALas.setVisible(true);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmImpuestoALas.getContentPane().setLayout(null);
	}

	//tabla
	public void cargarModelTabla() {
		ActionTraerTodosAnual action = new ActionTraerTodosAnual();
		HibernateApplication.getInstance().execute(action);
		tableModel.actualizarme(action.getResult());
	}

	private JScrollPane tabla() {
		this.tableModel = new TableModelAnual();
		tableAnual = new JTable(tableModel);
		this.tableModel.addColumn("Desde");
		this.tableModel.addColumn("Hasta");
		this.tableModel.addColumn("Base");
		this.tableModel.addColumn("Porcentaje estra por excedente");
		this.tableModel.addColumn("Valor de excedente");
		this.cargarModelTabla();
		JScrollPane scrollPane = new JScrollPane(tableAnual);
		scrollPane.setBounds(15, 12, 569, 131);
		return scrollPane;
	}

	
	//mostrarDatos 
	public void mostrarDatosEnPantallaDeduccionA() {
		ActionGetFirstDeduccionA action = new ActionGetFirstDeduccionA();
		HibernateApplication.getInstance().execute(action);
		DeduccionA deduccionA = action.getResult();
		textField.setText(Float.toString(deduccionA.getMin_no_imp()));
		textField_1.setText(Float.toString(deduccionA.getDedu_espe()));
		textField_2.setText(Float.toString(deduccionA.getConyuge()));
		textField_3.setText(Float.toString(deduccionA.getHijos()));
		textField_4.setText(Float.toString(deduccionA.getOtros()));

	}

	public void mostrarDatosEnPantallaDeduccionB() {
		ActionGetFirstDeduccionB action = new ActionGetFirstDeduccionB();
		HibernateApplication.getInstance().execute(action);
		DeduccionB deduccionB = action.getResult();
		textField_5.setText(Float.toString(deduccionB.getGast_sepe_anu()));
		textField_6.setText(Float.toString(deduccionB.getSeg_vida_anu()));
		textField_7.setText(Float.toString(deduccionB.getServ_dom_anu()));
		textField_8.setText(Float.toString(deduccionB.getInt_cred_hip_anu()));

	}

	public void mostrarDatosEnPantallaDeduccionC() {
		ActionGetFirstDeduccionC action = new ActionGetFirstDeduccionC();
		HibernateApplication.getInstance().execute(action);
		DeduccionC deduccionC = action.getResult();
		textField_9.setText(Float.toString(deduccionC.getCout_med_asist_anu()));
		textField_10.setText(Float.toString(deduccionC.getHonor_med_anu()));
		textField_11.setText(Float.toString(deduccionC.getDonac_anu()));
		textField_13.setText(Float.toString(deduccionC
				.getDeb_total_imp_cheq_cred_anu()));
	}

	private void mostrarDatosEnPantallaTope() {
		ActionGetFirstTope action = new ActionGetFirstTope();
		HibernateApplication.getInstance().execute(action);
		TopeSalarial tope = action.getResult();
		textField_12.setText(Float.toString(tope.getSoltero()));
		textField_14.setText(Float.toString(tope.getCasado()));
	}
	
	//Boton cancelar
	private void botonCancelarAccionA() {
		mostrarDatosEnPantallaDeduccionA();
	}

	private void botonCancelarAccionB() {
		mostrarDatosEnPantallaDeduccionB();
	}

	private void botonCancelarAccionC() {
		mostrarDatosEnPantallaDeduccionC();
	}
	
	private void botonCancelarTope() {
		mostrarDatosEnPantallaTope();
	}

	//Boton Aceptar
	private void botonAceptarAccionA() {
		validarFloat(textField, "Mínimo no imponible");
		Float txt0 = Float.parseFloat(textField.getText());
		validarFloat(textField_1, "Deducci\u00F3n especal");
		Float txt1 = Float.parseFloat(textField_1.getText());
		validarFloat(textField_2, "Tope anual por conyuge");
		Float txt2 = Float.parseFloat(textField_2.getText());
		validarFloat(textField_3, "Tope anual por hijos");
		Float txt3 = Float.parseFloat(textField_3.getText());
		validarFloat(textField_4, "Tope anual por persona a cargo");
		Float txt4 = Float.parseFloat(textField_4.getText());
		DeduccionA nuevo = new DeduccionA(txt0, txt1, txt2, txt3, txt4);
		HibernateApplication.getInstance().execute(
				new ActionEditarDeduccionA(nuevo));
		mostrarDatosEnPantallaDeduccionA();
	}

	private void botonAceptarAccionB() {
		validarFloat(textField_5, "Tope anual gastos de sepelio");
		Float txt5 = Float.parseFloat(textField_5.getText());
		validarFloat(textField_6, "Tope anual seguro de vida");
		Float txt6 = Float.parseFloat(textField_6.getText());
		validarFloat(textField_7, "Tope anual servicio domestico");
		Float txt7 = Float.parseFloat(textField_7.getText());
		validarFloat(textField_8, "Tope anual crédito hipotecario");
		Float txt8 = Float.parseFloat(textField_8.getText());
		DeduccionB nuevo = new DeduccionB(txt5, txt6, txt7, txt8);
		HibernateApplication.getInstance().execute(
				new ActionEditarDeduccionB(nuevo));
		mostrarDatosEnPantallaDeduccionB();
	}

	private void botonAceptarAccionC() {
		validarFloat(textField_9, "Cuota Médico Asistencial");
		Float txt9 = Float.parseFloat(textField_9.getText());
		validarFloat(textField_10, "Honorarios Medicos");
		Float txt10 = Float.parseFloat(textField_10.getText());
		validarFloat(textField_11, "Donaciones");
		Float txt11 = Float.parseFloat(textField_11.getText());
		validarFloat(textField_13, "Deducción imp. cheque sobre Cred");
		Float txt13 = Float.parseFloat(textField_13.getText());
		DeduccionC nuevo = new DeduccionC(txt9, txt10, txt11, txt13);
		HibernateApplication.getInstance().execute(
				new ActionEditarDeduccionC(nuevo));
		mostrarDatosEnPantallaDeduccionC();
	}

	private void botonAceptarAccionTope(){
		validarFloat(textField_12, "Soltero");
		Float txt12 = Float.parseFloat(textField_12.getText());
		validarFloat(textField_14, "Casado");
		Float txt14 = Float.parseFloat(textField_14.getText());
		TopeSalarial nuevo = new TopeSalarial(txt12, txt14);
		HibernateApplication.getInstance().execute(
				new ActionEditarTope(nuevo));
		mostrarDatosEnPantallaTope();
		
	}
	
	////Validar
	private void validarFloat(JTextField texto, String campo) {
		try {
			Float.parseFloat(texto.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					" Solo se permiten números en el campo: " + campo);
			texto.setText(null);
		}
	}
}
