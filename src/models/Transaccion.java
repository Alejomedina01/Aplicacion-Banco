package models;

public class Transaccion {

    private int idTransaccion;
    private double montoTransaccion;
    private String fechaTransaccion;
    private Sucursal sucursal;
    private int cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    public Transaccion(int idTransaccion, double montoTransaccion, String fechaTransaccion, int cuentaOrigen) {
        this.idTransaccion = idTransaccion;
        this.montoTransaccion = montoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.cuentaOrigen = cuentaOrigen;
    }

    public Transaccion() {
        this.idTransaccion = -1;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
