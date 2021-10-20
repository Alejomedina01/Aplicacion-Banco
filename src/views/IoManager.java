package views;

import controllers.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IoManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel numeroCuenta;
	private JLabel titular;
	private JLabel saldo;
	private JLabel tipoCuenta;
	private JComboBox<String> comboBox;

	public IoManager(Controller control) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de cuenta:");
		lblNewLabel.setBounds(10, 11, 145, 14);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(45, 64, 89));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titular:");
		lblNewLabel_1.setBounds(343, 11, 63, 14);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(45, 64, 89));
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 241, 524, 2);
		contentPane.add(separator);
		
		ImageIcon imagen = new ImageIcon(IoManager.class.getResource("/data/circle-preview.png"));
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(168, 36, 209, 177);
		lblNewLabel_2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(190, 177, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de cuenta:");
		lblNewLabel_3.setBounds(10, 216, 121, 14);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(45, 64, 89));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Retirar dinero");
		lblNewLabel_4.setBounds(230, 254, 107, 14);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(234, 84, 85));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Monto a retirar:");
		lblNewLabel_5.setBounds(10, 280, 121, 14);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_5.setForeground(new Color(45, 64, 89));
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(143, 279, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sucursal:");
		lblNewLabel_6.setBounds(310, 280, 75, 14);
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(45, 64, 89));
		contentPane.add(lblNewLabel_6);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(387, 279, 157, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Retirar");
		btnNewButton.setBounds(216, 310, 107, 23);
		btnNewButton.setForeground(new Color(222, 205, 195));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(45, 64, 89));
		btnNewButton.addActionListener(control);
		btnNewButton.setActionCommand("retirar");
		contentPane.add(btnNewButton);
		
		numeroCuenta = new JLabel("");
		numeroCuenta.setBounds(155, 8, 145, 20);
		numeroCuenta.setFont(new Font("Dialog", Font.BOLD, 15));
		numeroCuenta.setForeground(new Color(45, 64, 89));
		contentPane.add(numeroCuenta);
		
		titular = new JLabel("");
		titular.setBounds(407, 8, 151, 20);
		titular.setFont(new Font("Dialog", Font.BOLD, 15));
		titular.setForeground(new Color(45, 64, 89));
		contentPane.add(titular);
		
		saldo = new JLabel("");
		saldo.setBounds(195, 93, 136, 42);
		saldo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		saldo.setForeground(new Color(45, 64, 89));
		contentPane.add(saldo);
		
		tipoCuenta = new JLabel("");
		tipoCuenta.setBounds(126, 216, 89, 14);
		tipoCuenta.setFont(new Font("Dialog", Font.BOLD, 15));
		tipoCuenta.setForeground(new Color(45, 64, 89));
		contentPane.add(tipoCuenta);
		
		JLabel lblNewLabel_4_1 = new JLabel("SALDO");
		lblNewLabel_4_1.setForeground(new Color(234, 84, 85));
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(240, 64, 70, 14);
		contentPane.add(lblNewLabel_4_1);

		JButton btnReportes = new JButton("Reportes");
		btnReportes.setForeground(new Color(222, 205, 195));
		btnReportes.setFont(new Font("Dialog", Font.BOLD, 13));
		btnReportes.setBackground(new Color(45, 64, 89));
		btnReportes.setActionCommand("reportes");
		btnReportes.addActionListener(control);
		btnReportes.setBounds(437, 207, 107, 23);
		contentPane.add(btnReportes);
	}

	public String getTextField() {
		return textField.getText();
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
	}

	public String getNumeroCuenta() {
		return numeroCuenta.getText();
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta.setText(numeroCuenta);
	}

	public String getTitular() {
		return titular.getText();
	}

	public void setTitular(String titular) {
		this.titular.setText(titular);
	}

	public String getSaldo() {
		return saldo.getText();
	}

	public void setSaldo(String saldo) {
		this.saldo.setText(saldo);
	}

	public String getTipoCuenta() {
		return tipoCuenta.getText();
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta.setText(tipoCuenta);
	}

	public String getComboBox() {
		return String.valueOf(comboBox.getSelectedItem());
	}

	public void addComboBox(String sucursal) {
		this.comboBox.addItem(sucursal);
	}
}
