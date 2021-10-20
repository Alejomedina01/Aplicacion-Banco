package views;

import models.Transaccion;

import java.awt.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PanelTransacciones extends JPanel {

	private int heigth = 0;
	
	public PanelTransacciones() {
		setLayout(null);
	}
	
	public void importTransactions(List<Transaccion> list) {
		removeAll();
		heigth = 0;
		for (int i = 0; i < list.size(); i++) {
			PanelTransaccion tran = new PanelTransaccion(list.get(i));
			tran.setBounds(0, this.heigth, 384, 90);
			heigth += tran.getHeight();
			add(tran);
		}
		setPreferredSize(new Dimension(268, heigth));
	}
}
