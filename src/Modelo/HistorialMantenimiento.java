
package Modelo;

import java.util.Date;


public class HistorialMantenimiento {
    private int idHistorial;
    private String sucursal;
    private int idfactura_mantenimiento;
    private int empleado;
    private int cliente;
    private int vehiculo;
    private Date fechaMantenimiento;
    private String Descripcion;
    private Double costo;

    public HistorialMantenimiento() {
    }

    public HistorialMantenimiento(int idHistorial, String sucursal, int idfactura_mantenimiento, int empleado, int cliente, int vehiculo, Date fechaMantenimiento, String Descripcion, Double costo) {
        this.idHistorial = idHistorial;
        this.sucursal = sucursal;
        this.idfactura_mantenimiento = idfactura_mantenimiento;
        this.empleado = empleado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaMantenimiento = fechaMantenimiento;
        this.Descripcion = Descripcion;
        this.costo = costo;
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

    public int getIdfactura_mantenimiento() {
        return idfactura_mantenimiento;
    }

    public void setIdfactura_mantenimiento(int idfactura_mantenimiento) {
        this.idfactura_mantenimiento = idfactura_mantenimiento;
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

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    
    
}
