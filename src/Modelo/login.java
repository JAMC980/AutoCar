
package Modelo;

public class login {
    private int idsucursal;
    private String nombre;
    private String pass;
    

    public login() {
    }

    public login(int idsucursal, String nombre, String pass) {
        this.idsucursal = idsucursal;
        this.nombre = nombre;
        this.pass = pass;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

  
}
