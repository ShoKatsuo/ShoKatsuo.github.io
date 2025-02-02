
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class hospital extends JFrame {

	private JPanel contentPane;
	private JTextField txtDonation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospital frame = new hospital();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hospital() {
		setTitle("Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donaci\u00F3n(S/.)");
		lblNewLabel.setBounds(10, 41, 76, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtS = new JTextArea();
		txtS.setBounds(10, 88, 520, 162);
		contentPane.add(txtS);
		
		JButton btnErase = new JButton("Borrar");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDonation.setText("");
				txtS.setText("");
				txtDonation.requestFocus();
			}
		});
		btnErase.setBounds(234, 37, 92, 23);
		contentPane.add(btnErase);
		
		txtDonation = new JTextField();
		txtDonation.setBounds(96, 38, 86, 20);
		contentPane.add(txtDonation);
		txtDonation.setColumns(10);
		
		JButton btnProcess = new JButton("Procesar");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double donacion,medicina,pediatria, neumologia, traumatologia, ginecologia;
				donacion = Double.parseDouble(txtDonation.getText());
				medicina = donacion * 0.17;
				pediatria = 0.35 * donacion;
				traumatologia = 0.23 * donacion;
				neumologia = 0.15 * donacion;
				ginecologia = donacion - (medicina+pediatria+traumatologia+neumologia);
				
				DecimalFormat df=new DecimalFormat("##.00");
				txtS.setText("Reparto de la donaci�n"+"\n");
				txtS.append("Medicina General: "+"\t"+df.format(medicina)+"\n");
				txtS.append("Pediatria: "+"\t\t"+df.format(pediatria)+"\n");
				txtS.append("Traumatologia: "+"\t\t"+df.format(traumatologia)+"\n");
				txtS.append("Neumologia: "+"\t\t"+df.format(neumologia)+"\n");
				txtS.append("Ginecologia: "+"\t\t"+df.format(ginecologia)+"\n");
			}
		});
		btnProcess.setBounds(336, 37, 92, 23);
		contentPane.add(btnProcess);
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(438, 37, 92, 23);
		contentPane.add(btnClose);
	}
}
