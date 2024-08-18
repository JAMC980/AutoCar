
package Modelo;

import java.util.Date;

public class Venta {
    private int idfactura_venta;
    private Date fecha;
    private int Empleado;
    private int Cliente;
    private int Vehiculo;
    private int Sucursal;
    private int Seguro;
    private Double Total;
    private int mpago;

    public Venta() {
    }

    public Venta(int idfactura_venta, Date fecha, int Empleado, int Cliente, int Vehiculo, int Sucursal, int Seguro, Double Total, int mpago) {
        this.idfactura_venta = idfactura_venta;
        this.fecha = fecha;
        this.Empleado = Empleado;
        this.Cliente = Cliente;
        this.Vehiculo = Vehiculo;
        this.Sucursal = Sucursal;
        this.Seguro = Seguro;
        this.Total = Total;
        this.mpago = mpago;
    }

    public int getIdfactura_venta() {
        return idfactura_venta;
    }

    public void setIdfactura_venta(int idfactura_venta) {
        this.idfactura_venta = idfactura_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(int Empleado) {
        this.Empleado = Empleado;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    public int getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(int Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public int getSucursal() {
        return Sucursal;
    }

    public void setSucursal(int Sucursal) {
        this.Sucursal = Sucursal;
    }

    public int getSeguro() {
        return Seguro;
    }

    public void setSeguro(int Seguro) {
        this.Seguro = Seguro;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public int getMpago() {
        return mpago;
    }

    public void setMpago(int mpago) {
        this.mpago = mpago;
    }
    
    
    
}
