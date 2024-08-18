
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Empleado BuscarEmpleado(int idempleado){
        Empleado em = new Empleado();
        String sql = "SELECT *,p.pnombre \n" +
"FROM empleado e \n" +
"INNER JOIN persona p ON p.idpersona = e.persona_idpersona\n" +
"WHERE e.idempleado = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,idempleado);
            rs = ps.executeQuery();
            if(rs.next()){
                em.setPnombre(rs.getString("pnombre"));
            }
            
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return em;
    }
    
}
