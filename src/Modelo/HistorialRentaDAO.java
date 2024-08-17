
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HistorialRentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List ListarRentas(){
        List<HistorialRenta>ListaR = new ArrayList();
        String sql = "SELECT * \n" +
"FROM \n" +
"    historialrenta h\n" +
"JOIN \n" +
"    sucursal s ON h.sucursal_idsucursal = s.idsucursal\n" +
"JOIN \n" +
"    empleado e ON h.empleado_idempleado = e.idempleado\n" +
"JOIN \n" +
"    cliente c ON h.cliente_idcliente = c.idcliente\n" +
"JOIN \n" +
"    mpago m ON h.mpago_idmpago = m.idmpago\n" +
"JOIN\n" +
"    aval a ON a.idaval = h.aval_idaval\n" +
"JOIN\n" +
"    vehiculo v ON v.idVehiculo = h.vehiculo_idVehiculo";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            HistorialRenta hr = new HistorialRenta();
            hr.setIdHistorial(rs.getInt("idHistorial"));
            hr.setSucursal(rs.getString("nombre"));
            hr.setIdfactura_renta(rs.getInt("idfactura_renta"));
            hr.setEmpleado(rs.getInt("idempleado"));
            hr.setCliente(rs.getInt("idcliente"));
            hr.setVehiculo(rs.getInt("idVehiculo"));
            hr.setAval(rs.getInt("idaval"));
            hr.setFechainicio(rs.getDate("fechainicio"));
            hr.setFechafin(rs.getDate("fechafin"));
            hr.setCostototal(rs.getDouble("costoTotal"));
            hr.setMpago(rs.getString("metodo_pago"));
            ListaR.add(hr);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaR;
    }
    
}
