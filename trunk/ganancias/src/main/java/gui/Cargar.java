package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Cargar {

	private JFrame frmImpuestoALas;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cargar window = new Cargar();
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
	public Cargar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImpuestoALas = new JFrame();
		frmImpuestoALas.setTitle("Impuesto a las ganancias - Carga de excel.");
		frmImpuestoALas.setBounds(100, 100, 781, 433);
		frmImpuestoALas.setVisible(true);
		frmImpuestoALas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImpuestoALas.getContentPane().setLayout(null);
		
		JButton button = new JButton("Volver al inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmImpuestoALas.dispose();
			}
		});
		button.setBounds(10, 11, 136, 29);
		frmImpuestoALas.getContentPane().add(button);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Cargar Excel");
		fileChooser.setBounds(58, 52, 673, 326);
		fileChooser.cancelSelection();
		frmImpuestoALas.getContentPane().add(fileChooser);
	}
}
