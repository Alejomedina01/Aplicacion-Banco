package controllers;

import models.Sucursal;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class SucursalesController {

    private Connection connection;
    private Statement statement;

    public SucursalesController() {
        this.connection = null;
        this.statement = null;
    }

    private void initConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/banco?user=root&password=");
        this.statement = this.connection.createStatement();
        this.statement.setQueryTimeout(15);
    }

    public List<Sucursal> getSucursalesFromDB() throws SQLException {
        this.initConnection();
        List<Sucursal> listaSucursales = new Vector<>();
        ResultSet resultSet = this.statement.executeQuery("SELECT s.id_sucursal, s.nombre_sucursal, l.nombre_ciudad, l.direccion\n" +
                "FROM SUCURSALES s, LUGARES l\n" +
                "WHERE s.id_lugar = l.id_lugar;");
        Sucursal sucursal = new Sucursal();
        while (resultSet.next()) {
            sucursal = new Sucursal(resultSet.getInt("id_sucursal"),
            resultSet.getString("nombre_sucursal"),
            resultSet.getString("nombre_ciudad"),
                    resultSet.getString("direccion"));
            listaSucursales.add(sucursal);
        }
        this.connection.close();
        return listaSucursales;
    }

    public List<Sucursal> getUsedSucursales(int id_cuenta) throws SQLException {
        this.initConnection();
        List<Sucursal> listaSucursales = new Vector<>();
        ResultSet resultSet = this.statement.executeQuery("SELECT DISTINCT s.id_sucursal, s.nombre_sucursal, l.nombre_ciudad, l.direccion\n" +
                "FROM SUCURSALES s, LUGARES l, TRANSACCIONES t\n" +
                "WHERE t.id_sucursal = s.id_sucursal\n" +
                "AND s.id_lugar = l.id_lugar\n" +
                "AND t.id_cuenta_origen =" + id_cuenta);
        Sucursal sucursal = new Sucursal();
        while (resultSet.next()) {
            sucursal = new Sucursal(resultSet.getInt("id_sucursal"),
                    resultSet.getString("nombre_sucursal"),
                    resultSet.getString("nombre_ciudad"),
                    resultSet.getString("direccion"));
            listaSucursales.add(sucursal);
        }
        this.connection.close();
        return listaSucursales;
    }
}
