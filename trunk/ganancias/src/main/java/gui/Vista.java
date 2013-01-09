package gui;

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

import model.FormatoEmpleadoException;
import model.ProcesoCalculoAutomatico;
import javax.swing.UIManager;
import java.awt.Color;

public class Vista {

	private JFrame frmProgramaDeImpuesto;

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
	}

	JFileChooser fileChooser = new JFileChooser();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaDeImpuesto = new JFrame();
		frmProgramaDeImpuesto.getContentPane().setBackground(new Color(176, 196, 222));
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

		JButton btnNewButton_1 = new JButton("Modificacion de datos");
		btnNewButton_1.setBounds(255, 213, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModificarTablas();
			}
		});

		JButton btnNewButton_2 = new JButton("Carga manual");
		btnNewButton_2.setBounds(255, 300, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalculoManual();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(627, 357, 91, 23);
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
					new ProcesoCalculoAutomatico(file.getPath());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FormatoEmpleadoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

}