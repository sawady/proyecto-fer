package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.FormatoEmpleadoException;
import model.calculo.ActionCalculoAutomatico;
import persistencia.HibernateApplication;
import persistencia.Actions.ActionCargaInicial;

public class Vista {

	private JFrame frmProgramaDeImpuesto;
	private JFileChooser fileChooser = new JFileChooser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frmProgramaDeImpuesto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	HibernateApplication.getInstance().execute(new ActionCargaInicial()); //TODO
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaDeImpuesto = new JFrame();
		frmProgramaDeImpuesto.getContentPane().setBackground(
				new Color(176, 196, 222));
		frmProgramaDeImpuesto.setTitle("Programa de impuesto a las ganancias.");
		frmProgramaDeImpuesto.setBounds(100, 100, 781, 433);
		frmProgramaDeImpuesto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaDeImpuesto.getContentPane().setLayout(null);
		fileChooser.setDialogTitle("Cargar Excel");
		fileChooser.setBounds(58, 52, 673, 326);
		fileChooser.addChoosableFileFilter(new ExcelFilter());

		JButton btnNewButton = new JButton("Cargar Excel");
		btnNewButton.setBounds(255, 123, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new SaveListener());

		JButton btnNewButton_1 = new JButton("Modificar valores de tablas");
		btnNewButton_1.setBounds(255, 302, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModificarTablas();
			}
		});

		JButton btnNewButton_2 = new JButton("Carga manual");
		btnNewButton_2.setBounds(255, 213, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalculoManual();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(602, 371, 133, 23);
		frmProgramaDeImpuesto.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vista.this.frmProgramaDeImpuesto.dispose();
			}
		});

		JLabel lblImpuestoALas = new JLabel("Impuesto a las ganancias");
		lblImpuestoALas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblImpuestoALas.setBounds(241, 49, 390, 39);
		frmProgramaDeImpuesto.getContentPane().add(lblImpuestoALas);
	}

	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = fileChooser.showSaveDialog(frmProgramaDeImpuesto);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					ActionCalculoAutomatico action = new ActionCalculoAutomatico(file.getPath());
					HibernateApplication.getInstance().execute(action);
					JOptionPane
					.showMessageDialog(
							frmProgramaDeImpuesto,
							"El archivo generado se guardo en su carpeta personal",
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane
							.showMessageDialog(
									frmProgramaDeImpuesto,
									"No es posible guardar el archivo, compruebe que sea del formato correcto",
									"Mensaje", JOptionPane.ERROR_MESSAGE);
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (FormatoEmpleadoException e1) {
					JOptionPane
							.showMessageDialog(
									frmProgramaDeImpuesto,
									"No es posible guardar el archivo, compruebe que sea del formato correcto",
									"Mensaje", JOptionPane.ERROR_MESSAGE);
				} catch (NoSuchMethodException e1) {
					JOptionPane
							.showMessageDialog(
									frmProgramaDeImpuesto,
									"No es posible guardar el archivo, compruebe que sea del formato correcto",
									"Mensaje", JOptionPane.ERROR_MESSAGE);
				}

			}
		}
	}

}
