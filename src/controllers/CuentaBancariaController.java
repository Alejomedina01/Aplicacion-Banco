package controllers;
import models.CuentaBancaria;
import java.sql.*;

public class CuentaBancariaController {

    private Connection connection;
    private Statement statement;
    private double saldo;

    public CuentaBancariaController() {
        this.connection = null;
        this.statement = null;
    }

    private void initConnection() throws SQLException {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/banco?user=root&password=");
            this.statement = this.connection.createStatement();
            this.statement.setQueryTimeout(15);
    }

    public CuentaBancaria getCuentaFromDB(int cuenta, String clave) throws SQLException {
        this.initConnection();
        ResultSet resultSet = this.statement.executeQuery("SELECT b.id_cuenta, c.nombre_cliente, c.apellido_cliente, b.saldo, t.descripcion\n" +
                "FROM CUENTAS_BANCARIAS b, CLIENTES c, TIPOS_CUENTAS t\n" +
                "WHERE b.id_cliente = c.id_cliente\n" +
                "AND b.id_tipo_cuenta = t.id_tipo_cuenta\n" +
                "AND b.id_cuenta = " + cuenta +
                "\nAND b.clave = SHA2('" + clave + "', 256)");
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        while (resultSet.next()) {
            cuentaBancaria = new CuentaBancaria(resultSet.getInt("id_cuenta"),
                    resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_cliente"),
                    resultSet.getDouble("saldo"),
                    resultSet.getString("descripcion"));
        }
        saldo = cuentaBancaria.getSaldo();
        this.connection.close();
        return cuentaBancaria;
    }

    public CuentaBancaria getCuentaFromDB(int cuenta) throws SQLException {
        this.initConnection();
        ResultSet resultSet = this.statement.executeQuery("SELECT b.id_cuenta, c.nombre_cliente, c.apellido_cliente, b.saldo, t.descripcion\n" +
                "FROM CUENTAS_BANCARIAS b, CLIENTES c, TIPOS_CUENTAS t\n" +
                "WHERE b.id_cliente = c.id_cliente\n" +
                "AND b.id_tipo_cuenta = t.id_tipo_cuenta\n" +
                "AND b.id_cuenta = " + cuenta);
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        while (resultSet.next()) {
            cuentaBancaria = new CuentaBancaria(resultSet.getInt("id_cuenta"),
                    resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_cliente"),
                    resultSet.getDouble("saldo"),
                    resultSet.getString("descripcion"));
        }
        saldo = cuentaBancaria.getSaldo();
        this.connection.close();
        return cuentaBancaria;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
