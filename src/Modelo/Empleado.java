
package Modelo;


public class Empleado {
    private int idEmpleado;
    private int idPersona;
    private String pnombre;
    private int rol;
    private int sucursal;

    public Empleado() {
    }

    public Empleado(int idEmpleado, int idPersona,String pnombre, int rol, int sucursal) {
        this.idEmpleado = idEmpleado;
        this.idPersona = idPersona;
        this.rol = rol;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }
    
    
    
    
    
}
