package models;

public class Sucursal {

    private int idSucursal;
    private String nombreSucursal;
    private String ciudad;
    private String direccion;

    public Sucursal(int idSucursal, String nombreSucursal, String ciudad, String direccion) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Sucursal() {
        this.idSucursal = -1;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return idSucursal + " - " + nombreSucursal + " - " + ciudad;
    }
}
