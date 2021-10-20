package controllers;

import models.CuentaBancaria;
import models.Sucursal;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

public class Controller implements ActionListener {

    private IoLogIn login;
    private IoManager manager;
    private IoReportes reportes;
    private CuentaBancaria cuenta;
    private List<Sucursal> list;
    private TransaccionesController transcon;
    private CuentaBancariaController cuentaDB;

    public Controller() {
        login = new IoLogIn(this);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "entrar":
                enterToCuenta();
                break;
            case "reportes":
                openReports();
                break;
            case "retirar":
                withdraw();
                break;
            case "sucursales":
                usedSucursales();
                break;
            case "transacciones":
                setPanelTransactions();
                break;
            case "mes":
                calculateTransPerMonth();
                break;
        }
    }

    private void enterToCuenta(){
        int cuenta = Integer.parseInt(login.getTxtUser());
        String pass = login.getPasswordField();
        cuentaDB = new CuentaBancariaController();
        try {
            CuentaBancaria cuentaModel = cuentaDB.getCuentaFromDB(cuenta, pass);
            if (cuentaModel.getIdCuenta() != -1){
                setInformationToIO(cuentaModel);
                setSucursalesToIO();
                this.cuenta = cuentaModel;
                login.setVisible(false);
                transcon = new TransaccionesController();
            }else {
                JOptionPane.showMessageDialog(null,"Los datos ingresados son incorrectos");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setSucursalesToIO() throws SQLException {
        SucursalesController sucursales = new SucursalesController();
        list = sucursales.getSucursalesFromDB();
        for (int i = 0; i < list.size(); i++) {
            manager.addComboBox(list.get(i).toString());
        }
    }

    private void setInformationToIO(CuentaBancaria cuentaBancaria){
        manager = new IoManager(this);
        manager.setVisible(true);
        manager.setNumeroCuenta(String.valueOf(cuentaBancaria.getIdCuenta()));
        manager.setTitular(cuentaBancaria.getTitular());
        manager.setSaldo("$ " + (new DecimalFormat().format(cuentaBancaria.getSaldo())));
        manager.setTipoCuenta(cuentaBancaria.getTipoCuenta());
    }

    private void openReports() {
        reportes = new IoReportes(this);
        reportes.setVisible(true);
    }

    private void setPanelTransactions() {
        PanelTransacciones panel = new PanelTransacciones();
        try {
            panel.importTransactions(transcon.getTransaccionesFromDB(this.cuenta.getIdCuenta(), this));
            reportes.setPanel(panel);
            reportes.setVisible(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Sucursal searchSucursal(int id_sucursal){
        Sucursal s = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdSucursal() == id_sucursal){
                s = list.get(i);
            }
        }
        return s;
    }

    public Sucursal searchSucursal(String sucursal){
        Sucursal s = new Sucursal();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().equals(sucursal)){
                s = list.get(i);
            }
        }
        return s;
    }

    private void withdraw(){
        double monto =Double.valueOf(manager.getTextField());
        double saldo = cuentaDB.getSaldo();
        Sucursal sucursal = searchSucursal(manager.getComboBox());
        if (monto < saldo){
            try {
                boolean isInsert = transcon.insertWithdraw(monto, sucursal.getIdSucursal() , cuenta.getIdCuenta());
                transcon.updateSaldo(cuenta.getIdCuenta(), cuenta.getSaldo() - monto);
                cuenta = cuentaDB.getCuentaFromDB(cuenta.getIdCuenta());
                manager.setSaldo("$ " + (new DecimalFormat().format(cuenta.getSaldo())));
                manager.setTextField("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "No hay suficiente dinero para retirar");
        }
    }

    private void usedSucursales(){
        PanelSucursales panel = new PanelSucursales();
        SucursalesController sucu = new SucursalesController();
        try {
            panel.importSucursales(sucu.getUsedSucursales(cuenta.getIdCuenta()));
            reportes.setPanel(panel);
            reportes.setVisible(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void  calculateTransPerMonth(){
        int month = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes"));
        int year = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año"));
        PanelTransacciones panel = new PanelTransacciones();
        try {
            panel.importTransactions(transcon.getTransaccionesPerMonth(this.cuenta.getIdCuenta(), month, year, this));
            reportes.setPanel(panel);
            reportes.setVisible(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
