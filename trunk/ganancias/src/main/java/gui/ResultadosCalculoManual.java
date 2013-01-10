package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;

public class ResultadosCalculoManual extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		try {
			ResultadosCalculoManual dialog = new ResultadosCalculoManual("0", "2", "3" , "5", "6");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ResultadosCalculoManual(String label1, String label2, String label3,String label4, String label5) {
		setResizable(false);
		setTitle("Resultados del calculo Manual");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("ScrollBar.shadow"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Ganancia Neta A: " + label1);
			lblNewLabel.setBounds(82, 22, 287, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ganancia Neta B: " + label2);
			lblNewLabel_1.setBounds(82, 49, 287, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Ganancia Neta C: " + label3);
			lblNewLabel_2.setBounds(82, 76, 287, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Impuesto a pagar en el año: " + label4);
			lblNewLabel_3.setBounds(82, 103, 287, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Impuesto a pagar por mes: " + label5);
			lblNewLabel_4.setBounds(82, 130, 287, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(176, 196, 222));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();			}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
