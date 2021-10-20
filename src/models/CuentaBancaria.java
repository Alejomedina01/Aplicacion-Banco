package models;

public class CuentaBancaria {

    private int idCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta;
 //   private String clave;

    public CuentaBancaria(int idCuenta, String titular, double saldo, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public CuentaBancaria() {
        idCuenta = -1;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta=" + idCuenta +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                '}';
    }
}
