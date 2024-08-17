
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MantenimientoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Mantenimiento BuscarMantenimiento(int idfm){
        Mantenimiento mantenimiento = new Mantenimiento();
        String sql = "SELECT * FROM factura_mantenimiento WHERE idfactura_mantenimiento = ? ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idfm);
            rs = ps.executeQuery();
            if(rs.next()){
                mantenimiento.setDescripcion(rs.getString("Descripcion"));
                mantenimiento.setMpago(rs.getString("mpago_idmpago"));
                mantenimiento.setTotal(rs.getDouble("Total"));
                mantenimiento.setTotal(rs.getDouble("fecha_inicio"));
                mantenimiento.setTotal(rs.getDouble("fecha_fin"));
                
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    return mantenimiento;
    }
    
}
