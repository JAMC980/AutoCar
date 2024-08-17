/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jorge
 */
public class Vehiculo {
    private int idVehiculo;
    private String VIN;
    private String marca;
    private String modelo;
    private String color;
    private String año;
    private String tipo;
    private double costo_venta;
    private double costo_renta;
    private String Bodega;
    private String Proveedor;
    private String Estado;
    

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo, String VIN, String marca, String modelo, String color, String año, String tipo, double costo_venta, double costo_renta, String Bodega, String Proveedor,String Estado) {
        this.idVehiculo = idVehiculo;
        this.VIN = VIN;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
        this.tipo = tipo;
        this.costo_venta = costo_venta;
        this.costo_renta = costo_renta;
        this.Bodega = Bodega;
        this.Proveedor = Proveedor;
        this.Estado = Estado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto_venta() {
        return costo_venta;
    }

    public void setCosto_venta(double costo_venta) {
        this.costo_venta = costo_venta;
    }

    public double getCosto_renta() {
        return costo_renta;
    }

    public void setCosto_renta(double costo_renta) {
        this.costo_renta = costo_renta;
    }

    public String getBodega() {
        return Bodega;
    }

    public void setBodega(String Bodega) {
        this.Bodega = Bodega;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
