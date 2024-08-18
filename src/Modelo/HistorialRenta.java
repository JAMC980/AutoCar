
package Modelo;

import java.util.Date;


public class HistorialRenta {
    private int idHistorial;
    private String sucursal;
    private int idfactura_renta;
    private int empleado;
    private int cliente;
    private int vehiculo;
    private int aval;
    private Date fechainicio;
    private Date fechafin;
    private Double costototal;
    private String mpago;

    public HistorialRenta() {
    }

    public HistorialRenta(int idHistorial, String sucursal, int idfactura_renta, int empleado, int cliente, int vehiculo, int aval, Date fechainicio, Double costototal, String mpago) {
        this.idHistorial = idHistorial;
        this.sucursal = sucursal;
        this.idfactura_renta = idfactura_renta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.aval = aval;
        this.fechainicio = fechainicio;
        this.costototal = costototal;
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

    public int getIdfactura_renta() {
        return idfactura_renta;
    }

    public void setIdfactura_renta(int idfactura_renta) {
        this.idfactura_renta = idfactura_renta;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getAval() {
        return aval;
    }

    public void setAval(int aval) {
        this.aval = aval;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    
    

    public Double getCostototal() {
        return costototal;
    }

    public void setCostototal(Double costototal) {
        this.costototal = costototal;
    }

    public String getMpago() {
        return mpago;
    }

    public void setMpago(String mpago) {
        this.mpago = mpago;
    }
    
    
}
