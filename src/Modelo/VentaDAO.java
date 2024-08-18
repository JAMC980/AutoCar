
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
    
public int RegistrarVenta(Venta ve) {
    String sql = "INSERT INTO factura_venta (fecha, Empleado_idEmpleado, Cliente_idCliente, Vehiculo_idVehiculo, sucursal_idsucursal, seguro_idseguro, Total, mpago_idmpago) VALUES (CURRENT_DATE,?,?,?,?,?,?,?)";
    int r = 0;
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, ve.getEmpleado());
        ps.setInt(2, ve.getCliente());
        ps.setInt(3, ve.getVehiculo());
        ps.setInt(4, ve.getSucursal());
        ps.setInt(5, ve.getSeguro());
        ps.setDouble(6, ve.getTotal());
        ps.setInt(7, ve.getMpago());
        r = ps.executeUpdate();  // Cambiado a executeUpdate()
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return r;
}

    
}
