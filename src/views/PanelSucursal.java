package views;

import models.Sucursal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PanelSucursal extends JPanel {

	
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblCiudad;
	private JLabel lblDireccion;

	public PanelSucursal(Sucursal suc) {
		setBorder(new LineBorder(new Color(128, 0, 0)));
		setLayout(null);
		
		lblId = new JLabel("id: " + suc.getIdSucursal());
		lblId.setForeground(new Color(45, 64, 89));
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(10, 11, 115, 20);
		add(lblId);
		
		lblNombre = new JLabel("Nombre: " + suc.getNombreSucursal());
		lblNombre.setForeground(new Color(45, 64, 89));
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(135, 11, 239, 20);
		add(lblNombre);
		
		lblCiudad = new JLabel("Ciudad: " + suc.getCiudad());
		lblCiudad.setForeground(new Color(45, 64, 89));
		lblCiudad.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCiudad.setBounds(10, 59, 131, 20);
		add(lblCiudad);
		
		lblDireccion = new JLabel("Direccion: " + suc.getDireccion());
		lblDireccion.setForeground(new Color(45, 64, 89));
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDireccion.setBounds(148, 59, 226, 20);
		add(lblDireccion);
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCiudad() {
		return lblCiudad;
	}

	public void setLblCiudad(JLabel lblCiudad) {
		this.lblCiudad = lblCiudad;
	}

	public JLabel getLblDireccion() {
		return lblDireccion;
	}

	public void setLblDireccion(JLabel lblDireccion) {
		this.lblDireccion = lblDireccion;
	}
}
