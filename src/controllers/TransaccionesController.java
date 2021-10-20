package controllers;

import models.Transaccion;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class TransaccionesController {

    private Connection connection;
    private Statement statement;

    public TransaccionesController() {
        this.connection = null;
        this.statement = null;
    }

    private void initConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/banco?user=root&password=");
        this.statement = this.connection.createStatement();
        this.statement.setQueryTimeout(15);
    }

    public List<Transaccion> getTransaccionesFromDB(int id_cuenta, Controller control) throws SQLException {
        this.initConnection();
        List<Transaccion> listaTransaccion = new Vector<>();
        ResultSet resultSet = this.statement.executeQuery("SELECT t.id_transaccion, t.monto_transaccion, t.fecha_transaccion, t.id_cuenta_origen, t.id_sucursal\n" +
                "FROM transacciones t, sucursales s, lugares l\n" +
                "WHERE t.id_sucursal = s.id_sucursal\n" +
                "AND s.id_lugar = l.id_lugar\n" +
                "AND t.id_cuenta_origen =" + id_cuenta);
        Transaccion transaccion = new Transaccion();
        while (resultSet.next()) {
            transaccion = new Transaccion(resultSet.getInt("id_transaccion"),
                    resultSet.getDouble("monto_transaccion"),
                    resultSet.getString("fecha_transaccion"),
                    resultSet.getInt("id_cuenta_origen"));
            transaccion.setSucursal(control.searchSucursal(resultSet.getInt("id_sucursal")));
            listaTransaccion.add(transaccion);
        }
        this.connection.close();
        return listaTransaccion;
    }

    public boolean insertWithdraw(double monto_transaccion, int id_sucursal, int id_cuenta_origen) throws SQLException {
        this.initConnection();
        int rowsIns = this.statement.executeUpdate("INSERT INTO TRANSACCIONES VALUES (NULL," + monto_transaccion + ", (SELECT NOW())," + id_sucursal + ", 1," + id_cuenta_origen + ", null)");
        this.connection.close();
        return rowsIns == 1;
    }

    public boolean updateSaldo(int id_cuenta, double nuevoSaldo) throws SQLException {
        this.initConnection();
        int rowsIns = this.statement.executeUpdate("CALL `update_saldo`("+ id_cuenta +","+ nuevoSaldo + ")");
        this.connection.close();
        return rowsIns == 1;
    }

    public List<Transaccion> getTransaccionesPerMonth(int id_cuenta, int mes, int anio, Controller control) throws SQLException {
        this.initConnection();
        List<Transaccion> listaTransaccion = new Vector<>();
        ResultSet resultSet = this.statement.executeQuery("SELECT * \n" +
                "FROM transacciones \n" +
                "WHERE EXTRACT(MONTH FROM fecha_transaccion) = " + mes +
                "\nAND EXTRACT(YEAR FROM fecha_transaccion) = " + anio +
                "\nAND id_cuenta_origen = " + id_cuenta);
        Transaccion transaccion = new Transaccion();
        while (resultSet.next()) {
            transaccion = new Transaccion(resultSet.getInt("id_transaccion"),
                    resultSet.getDouble("monto_transaccion"),
                    resultSet.getString("fecha_transaccion"),
                    resultSet.getInt("id_cuenta_origen"));
            transaccion.setSucursal(control.searchSucursal(resultSet.getInt("id_sucursal")));
            listaTransaccion.add(transaccion);
        }
        this.connection.close();
        return listaTransaccion;
    }

}