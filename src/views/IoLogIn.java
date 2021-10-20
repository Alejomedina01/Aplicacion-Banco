package views;

import controllers.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IoLogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuenta;
	private JPasswordField passwordField;

	public IoLogIn(Controller control) {
		setBounds(100, 100, 335, 274);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(229, 229, 229));
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(222, 205, 195), new Color(222, 205, 195)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("INICIO DE SESI\u00D3N");
		lblNewLabel.setBounds(82, 11, 154, 14);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(234, 84, 85));
		contentPanel.add(lblNewLabel);
		
		txtCuenta = new JTextField();
		txtCuenta.setBounds(132, 79, 154, 20);
		contentPanel.add(txtCuenta);
		txtCuenta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00B0 Cuenta");
		lblNewLabel_1.setBounds(23, 80, 99, 14);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(45, 64, 89));
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Clave:");
		lblNewLabel_2.setBounds(23, 127, 99, 14);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(45, 64, 89));
		contentPanel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 126, 154, 20);
		contentPanel.add(passwordField);
		
		JButton btnLogIn = new JButton("Entrar");
		btnLogIn.setBounds(109, 170, 89, 23);
		btnLogIn.setForeground(new Color(222, 205, 195));
		btnLogIn.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLogIn.setBackground(new Color(45, 64, 89));
		btnLogIn.addActionListener(control);
		btnLogIn.setActionCommand("entrar");
		contentPanel.add(btnLogIn);
	
	}

	public String getTxtUser() {
		return txtCuenta.getText();
	}


	public String getPasswordField() {
		String result = new String(passwordField.getPassword());
		return result;
	}
	
}
