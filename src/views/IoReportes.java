package views;

import controllers.Controller;
import models.Transaccion;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.util.List;
import java.util.Vector;

public class IoReportes extends JDialog {

    private JScrollPane scrollPane;

    public IoReportes(Controller control) {
		setBounds(100, 100, 584, 383);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel_4 = new JLabel("Reportes y mas");
		lblNewLabel_4.setForeground(new Color(234, 84, 85));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setBounds(216, 11, 135, 20);
		getContentPane().add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(404, 42, 2, 271);
		getContentPane().add(separator);
		
		JButton btnR = new JButton("Transacciones");
		btnR.setForeground(new Color(222, 205, 195));
		btnR.setFont(new Font("Dialog", Font.BOLD, 13));
		btnR.setBackground(new Color(45, 64, 89));
		btnR.setActionCommand("transacciones");
		btnR.addActionListener(control);
		btnR.setBounds(416, 67, 142, 27);
		getContentPane().add(btnR);
		
		JButton btnReporteMeses = new JButton("Reporte Meses");
		btnReporteMeses.setForeground(new Color(222, 205, 195));
		btnReporteMeses.setFont(new Font("Dialog", Font.BOLD, 13));
		btnReporteMeses.setBackground(new Color(45, 64, 89));
		btnReporteMeses.setActionCommand("mes");
		btnReporteMeses.addActionListener(control);
		btnReporteMeses.setBounds(416, 162, 142, 27);
		getContentPane().add(btnReporteMeses);
		
		JButton btnSucursales = new JButton("Sucursales");
		btnSucursales.setForeground(new Color(222, 205, 195));
		btnSucursales.setFont(new Font("Dialog", Font.BOLD, 13));
		btnSucursales.setBackground(new Color(45, 64, 89));
		btnSucursales.setActionCommand("sucursales");
		btnSucursales.addActionListener(control);
		btnSucursales.setBounds(416, 257, 142, 27);
		getContentPane().add(btnSucursales);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 384, 271);
		scrollPane.setHorizontalScrollBar(null);
	}

	public void setPanel(JPanel panelx) {
		scrollPane.setVerticalScrollBar(new JScrollBar());
        scrollPane.setViewportView(panelx);
		add(scrollPane);
		SwingUtilities.updateComponentTreeUI(scrollPane);
	}
}
