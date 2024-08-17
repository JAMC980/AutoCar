
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
        
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    
    public login log(String nombre, String pass){
        login l = new login();
        String sql = "Select * From sucursal WHERE nombre = ? AND pass = ?";
        try {
           con  = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, nombre);
            ps.setString(2,pass);
           rs = ps.executeQuery();
           if(rs.next()){
                l.setIdsucursal(rs.getInt("idsucursal"));
                l.setNombre(rs.getString("nombre"));
                l.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
}
