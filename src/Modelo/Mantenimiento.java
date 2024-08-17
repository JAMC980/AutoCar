 
package Modelo;

import java.time.LocalDateTime;
import java.util.Date;


public class Mantenimiento {
    private int idfactura_mantenimiento;
    private Date fecha;
    private int Empleado;
    private int Cliente;
    private int Vehiculo;
    private int Sucursal;
    private String Descripcion;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Double Total;
    private String mpago;

    public Mantenimiento() {
    }

    public Mantenimiento(int idfactura_mantenimiento, Date fecha, int Empleado, int Cliente, int Vehiculo, int Sucursal, String Descripcion, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.idfactura_mantenimiento = idfactura_mantenimiento;
        this.fecha = fecha;
        this.Empleado = Empleado;
        this.Cliente = Cliente;
        this.Vehiculo = Vehiculo;
        this.Sucursal = Sucursal;
        this.Descripcion = Descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getIdfactura_mantenimiento() {
        return idfactura_mantenimiento;
    }

    public void setIdfactura_mantenimiento(int idfactura_mantenimiento) {
        this.idfactura_mantenimiento = idfactura_mantenimiento;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public String getMpago() {
        return mpago;
    }

    public void setMpago(String mpago) {
        this.mpago = mpago;
    }
    
    
    
    
}
