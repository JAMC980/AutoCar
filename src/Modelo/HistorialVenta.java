
package Modelo;

import java.util.Date;


public class HistorialVenta {
    
    private int idHistorial;
    private String sucursal;
    private int idfactura_venta;
    private int empleado_idempleado;
    private int cliente_idcliente;
    private int vehiculo_idVehiculo;
    private Date fechaventa;
    private String descripcion;
    private Double costo;
    private String mpago;

    public HistorialVenta() {
    }

    public HistorialVenta(int idHistorial, String sucursal, int idfactura_venta, int empleado_idempleado, int cliente_idcliente, int vehiculo_idVehiculo, Date fechaventa, String descripcion, Double costo, String mpago) {
        this.idHistorial = idHistorial;
        this.sucursal = sucursal;
        this.idfactura_venta = idfactura_venta;
        this.empleado_idempleado = empleado_idempleado;
        this.cliente_idcliente = cliente_idcliente;
        this.vehiculo_idVehiculo = vehiculo_idVehiculo;
        this.fechaventa = fechaventa;
        this.descripcion = descripcion;
        this.costo = costo;
        this.mpago = mpago;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getIdfactura_venta() {
        return idfactura_venta;
    }

    public void setIdfactura_venta(int idfactura_venta) {
        this.idfactura_venta = idfactura_venta;
    }

    public int getEmpleado_idempleado() {
        return empleado_idempleado;
    }

    public void setEmpleado_idempleado(int empleado_idempleado) {
        this.empleado_idempleado = empleado_idempleado;
    }

    public int getCliente_idcliente() {
        return cliente_idcliente;
    }

    public void setCliente_idcliente(int cliente_idcliente) {
        this.cliente_idcliente = cliente_idcliente;
    }

    public int getVehiculo_idVehiculo() {
        return vehiculo_idVehiculo;
    }

    public void setVehiculo_idVehiculo(int vehiculo_idVehiculo) {
        this.vehiculo_idVehiculo = vehiculo_idVehiculo;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getMpago() {
        return mpago;
    }

    public void setMpago(String mpago) {
        this.mpago = mpago;
    }
    
    
    
}
