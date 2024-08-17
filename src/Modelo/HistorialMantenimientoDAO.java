
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HistorialMantenimientoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List ListarMantenimientos(){
        List<HistorialMantenimiento>ListaM = new ArrayList();
        String sql = "SELECT * \n" +
"FROM \n" +
"    historialmantenimiento h\n" +
"JOIN \n" +
"    sucursal s ON h.sucursal_idsucursal = s.idsucursal\n" +
"JOIN \n" +
"    empleado e ON h.empleado_idempleado = e.idempleado\n" +
"JOIN \n" +
"    cliente c ON h.cliente_idcliente = c.idcliente\n" +
"JOIN\n" +
"    vehiculo v ON v.idVehiculo = h.vehiculo_idVehiculo";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            HistorialMantenimiento hm = new HistorialMantenimiento();
            hm.setIdHistorial(rs.getInt("idHistorial"));
            hm.setSucursal(rs.getString("nombre"));
            hm.setIdfactura_mantenimiento(rs.getInt("idfactura_mantenimiento"));
            hm.setEmpleado(rs.getInt("idempleado"));
            hm.setCliente(rs.getInt("idcliente"));
            hm.setVehiculo(rs.getInt("idVehiculo"));
            hm.setFechaMantenimiento(rs.getDate("fechaMantenimiento"));
            hm.setDescripcion(rs.getString("descripcion"));
            hm.setCosto(rs.getDouble("costo"));
            ListaM.add(hm);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaM;
    }
    
}
