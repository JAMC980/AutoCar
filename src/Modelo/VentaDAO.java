
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public int RegistrarVenta(Venta ve){
        String sql ="INSERT INTO factura_venta (fecha,empleado_idempleado,cliente_idcliente,vehiculo_idvehiculo,sucursal_idsucursal,seguro_idseguro,total,mpago_idmpago) VALUES (?,?,?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) ve.getFecha());
            ps.setInt(2,ve.getEmpleado());
            ps.setInt(3,ve.getCliente());
            ps.setInt(4,ve.getVehiculo());
            ps.setInt(5,ve.getSucursal());
            ps.setInt(6,ve.getSeguro());
            ps.setDouble(7,ve.getTotal());
            ps.setInt(8,ve.getMpago());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return r;
    }
    
}
