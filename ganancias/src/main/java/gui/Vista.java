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
import model.ProcesoCalculoAutomatico;
import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionB;
import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.HibernateHome;

public class Vista {

	private JFrame frmProgramaDeImpuesto;
	private JFileChooser fileChooser = new JFileChooser();
	
	private HibernateHome<DeduccionA> homeDecA = (HibernateHome<DeduccionA>) HibernateApplication
			.getInstance().getHome(DeduccionA.class);
	
	private HibernateHome<DeduccionB> homeDecB = (HibernateHome<DeduccionB>) HibernateApplication
			.getInstance().getHome(DeduccionB.class);
	
	private HibernateHome<DeduccionC> homeDecC = (HibernateHome<DeduccionC>) HibernateApplication
			.getInstance().getHome(DeduccionC.class);
	
	private CamposParaCalculoAnualHibernateHome homeDecAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
			.getInstance().getHome(CamposParaCalculoAnual.class);

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
		homeDecAnual.agregar(new CamposParaCalculoAnual(new Float(0.00),new Float(10000.00),new Float(0.00),new Float(9),new Float(0.00)));
		homeDecA.agregar(new DeduccionA(new Float(12960), new Float(62208), new Float(14400), new Float(7200), new Float(5400)));
		homeDecB.agregar(new DeduccionB(new Float(996.23), new Float(996.23),new Float(12996.23),new Float(20000.00)));
		homeDecC.agregar(new DeduccionC(new Float(5),new Float(5),new Float(5),new Float(0.06),new Float(35)));
		initialize();
		
	}


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
					JOptionPane.showMessageDialog(frmProgramaDeImpuesto, "No es posible guardar el archivo, compruebe que sea del formato correcto",
							"Mensaje", JOptionPane.ERROR_MESSAGE);				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (FormatoEmpleadoException e1) {
					JOptionPane.showMessageDialog(frmProgramaDeImpuesto, "No es posible guardar el archivo, compruebe que sea del formato correcto",
							"Mensaje", JOptionPane.ERROR_MESSAGE);	
				} catch (NoSuchMethodException e1) {
					JOptionPane.showMessageDialog(frmProgramaDeImpuesto, "No es posible guardar el archivo, compruebe que sea del formato correcto",
							"Mensaje", JOptionPane.ERROR_MESSAGE);	
				}

			}
		}
	}

}
