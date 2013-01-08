package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaDeImpuesto = new JFrame();
		frmProgramaDeImpuesto.setTitle("Programa de impuesto a las ganancias.");
		frmProgramaDeImpuesto.setBounds(100, 100, 781, 433);
		frmProgramaDeImpuesto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaDeImpuesto.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar Excel");
		btnNewButton.setBounds(255, 123, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Cargar();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modificacion de datos.");
		btnNewButton_1.setBounds(255, 213, 254, 50);
		frmProgramaDeImpuesto.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModificarTablas();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Carga manual.");
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
	
}
