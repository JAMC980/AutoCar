/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jorge
 */
public class Cliente {
    private int idPersona;
    private int idCliente;
    private String Pnombre;
    private String Snombre;
    private String Papellido;
    private String Sapellido;
    private String telefono;
    private String correo;
    private String direccion;
    private int personat;

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    

    public String getPnombre() {
        return Pnombre;
    }

    public void setPnombre(String Pnombre) {
        this.Pnombre = Pnombre;
    }

    public String getSnombre() {
        return Snombre;
    }

    public void setSnombre(String Snombre) {
        this.Snombre = Snombre;
    }

    public String getPapellido() {
        return Papellido;
    }

    public void setPapellido(String Papellido) {
        this.Papellido = Papellido;
    }

    public String getSapellido() {
        return Sapellido;
    }

    public void setSapellido(String Sapellido) {
        this.Sapellido = Sapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPersonat() {
        return personat;
    }

    public void setPersonat(int personat) {
        this.personat = personat;
    }
    
    
}
