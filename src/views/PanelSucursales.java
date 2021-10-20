package views;

import models.Sucursal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelSucursales extends JPanel {

    private int heigth = 0;

    public PanelSucursales() {
        setLayout(null);
    }

    public void importSucursales(List<Sucursal> list) {
        removeAll();
        heigth = 0;
        for (int i = 0; i < list.size(); i++) {
            PanelSucursal suc = new PanelSucursal(list.get(i));
            suc.setBounds(0, this.heigth, 384, 90);
            heigth += suc.getHeight();
            add(suc);
        }
        setPreferredSize(new Dimension(268, heigth));
    }
}
