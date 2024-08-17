
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HistorialVentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List ListarVentas(){
        List<HistorialVenta>ListaV = new ArrayList();
        String sql = "SELECT * \n" +
"FROM \n" +
"    historialventa h\n" +
"JOIN \n" +
"    sucursal s ON h.sucursal_idsucursal = s.idsucursal\n" +
"JOIN \n" +
"    empleado e ON h.empleado_idempleado = e.idempleado\n" +
"JOIN \n" +
"    cliente c ON h.cliente_idcliente = c.idcliente\n" +
"JOIN \n" +
"    mpago m ON h.mpago_idmpago = m.idmpago;";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            HistorialVenta hv = new HistorialVenta();
            hv.setIdHistorial(rs.getInt("idHistorial"));
            hv.setSucursal(rs.getString("nombre"));
            hv.setIdfactura_venta(rs.getInt("idfactura_venta"));
            hv.setEmpleado_idempleado(rs.getInt("idempleado"));
            hv.setCliente_idcliente(rs.getInt("idcliente"));
            hv.setVehiculo_idVehiculo(rs.getInt("vehiculo_idVehiculo"));
            hv.setFechaventa(rs.getDate("fechaventa"));
            hv.setDescripcion(rs.getString("descripcion"));
            hv.setCosto(rs.getDouble("costo"));
            hv.setMpago(rs.getString("metodo_pago"));
            ListaV.add(hv);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaV;
    }
    
}
