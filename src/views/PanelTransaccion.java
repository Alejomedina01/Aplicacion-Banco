package views;

import models.Transaccion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import java.text.DecimalFormat;

public class PanelTransaccion extends JPanel {


	public PanelTransaccion(Transaccion transaccion) {
		setLayout(null);
		setBorder(new LineBorder(new Color(139, 0, 0)));
		JLabel lblRetiro = new JLabel("Retiro");
		lblRetiro.setBounds(10, 11, 52, 20);
		lblRetiro.setForeground(new Color(45, 64, 89));
		lblRetiro.setFont(new Font("Dialog", Font.BOLD, 15));
		add(lblRetiro);
		
		JLabel lblCodigo = new JLabel("Codigo:" + " " + transaccion.getIdTransaccion());
		lblCodigo.setForeground(new Color(45, 64, 89));
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCodigo.setBounds(250, 11, 166, 20);
		add(lblCodigo);
		
		JLabel lblFecha = new JLabel("Fecha:" + " " + transaccion.getFechaTransaccion());
		lblFecha.setForeground(new Color(45, 64, 89));
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFecha.setBounds(10, 65, 200, 14);
		add(lblFecha);
		
		JLabel monto = new JLabel("$ " + (new DecimalFormat().format(transaccion.getMontoTransaccion())));
		monto.setBounds(180, 35, 194, 23);
		monto.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		monto.setForeground(new Color(234, 84, 85));
		add(monto);

		JLabel lblSucursal = new JLabel("Sucursal: " + transaccion.getSucursal().getIdSucursal());
		lblSucursal.setForeground(new Color(45, 64, 89));
		lblSucursal.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSucursal.setBounds(250, 65, 202, 14);
		add(lblSucursal);
	}

}
