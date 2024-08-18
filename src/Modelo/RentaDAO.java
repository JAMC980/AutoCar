
package Modelo;

import java.util.Date;


public class RentaDAO {
    private int idfactura_renta;
    private Date fechaEmision;
    private int Empleado;
    private int Cliente;
    private int Vehiculo;
    private int Sucursal;
    private int Seguro;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int Aval;
    private Double Total;
    private int Mpago;

    public RentaDAO() {
    }

    public RentaDAO(int idfactura_renta, Date fechaEmision, int Empleado, int Cliente, int Vehiculo, int Sucursal, int Seguro, Date fecha_inicio, Date fecha_fin, int Aval, Double Total, int Mpago) {
        this.idfactura_renta = idfactura_renta;
        this.fechaEmision = fechaEmision;
        this.Empleado = Empleado;
        this.Cliente = Cliente;
        this.Vehiculo = Vehiculo;
        this.Sucursal = Sucursal;
        this.Seguro = Seguro;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.Aval = Aval;
        this.Total = Total;
        this.Mpago = Mpago;
    }

    public int getIdfactura_renta() {
        return idfactura_renta;
    }

    public void setIdfactura_renta(int idfactura_renta) {
        this.idfactura_renta = idfactura_renta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getAval() {
        return Aval;
    }

    public void setAval(int Aval) {
        this.Aval = Aval;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public int getMpago() {
        return Mpago;
    }

    public void setMpago(int Mpago) {
        this.Mpago = Mpago;
    }
    
    
}
