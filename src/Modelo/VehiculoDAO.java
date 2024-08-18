
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


public class VehiculoDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarVehiculo(Vehiculo v){
    String sql = "INSERT into vehiculo(idVehiculo,VIN,marca,modelo,color,año,tipo,costo_venta,costo_renta,Bodega_idBodega,Proveedor_idProveedor,estado_idestado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, v.getIdVehiculo());
        ps.setString(2, v.getVIN());
        ps.setString(3, v.getMarca());
        ps.setString(4, v.getModelo());
        ps.setString(5, v.getColor());
        ps.setString(6, v.getAño());
        ps.setString(7, v.getTipo());
        ps.setDouble(8, v.getCosto_venta());
        ps.setDouble(9, v.getCosto_renta());
        ps.setString(10, v.getBodega());
        ps.setString(11, v.getProveedor());
        ps.setString(12, v.getEstado());
        ps.execute();
        return true;
    }catch(SQLException e){
        System.out.println(e.toString());
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    }
    
    
    public List ListarVehiculo(){
        List<Vehiculo> Listav = new ArrayList();
        String sql = "SELECT v.idVehiculo idVehiculo,v.VIN VIN,v.marca Marca,v.modelo Modelo,v.color Color,v.año año,v.tipo Tipo,v.costo_venta Costo_venta,v.costo_renta Costo_renta,b.nombre Bodega,p.nombre Proveedor,e.nombre Estado FROM vehiculo v\n" +
"INNER JOIN estado e ON e.idestado = v.estado_idestado\n" +
"INNER JOIN bodega b ON b.idbodega = v.Bodega_idBodega\n" +
"INNER JOIN proveedor p ON p.idProveedor = v.Proveedor_idProveedor\n"
                 +"GROUP BY idVehiculo\n " +
                 "ORDER BY v.idVehiculo";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Vehiculo v = new Vehiculo();
                v.setIdVehiculo(rs.getInt("idVehiculo"));
                v.setVIN(rs.getString("VIN"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setColor(rs.getString("color"));
                v.setAño(rs.getString("año"));
                v.setTipo(rs.getString("tipo"));
                v.setCosto_venta(Double.parseDouble(rs.getString("costo_venta")));
                v.setCosto_renta(Double.parseDouble(rs.getString("costo_renta")));
                v.setBodega(rs.getString("Bodega"));
                v.setProveedor(rs.getString("Proveedor"));
                v.setEstado(rs.getString("Estado"));
                Listav.add(v);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Listav;
    }
    
    public boolean EliminarVehiculo(int id){
        String sql = "DELETE FROM vehiculo WHERE idVehiculo=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.print(e.toString());
            }
        }
    }
    
    public boolean ModificarVehiculo(Vehiculo v){
        String sql = "UPDATE vehiculo SET VIN=?,marca=?,modelo=?,color=?,año=?,tipo=?,costo_venta=?,costo_renta=?,Bodega_idBodega=?,Proveedor_idProveedor=?,estado_idestado=? WHERE idVehiculo=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,v.getVIN());
            ps.setString(2,v.getMarca());
            ps.setString(3,v.getModelo());
            ps.setString(4,v.getColor());
            ps.setString(5,v.getAño());
            ps.setString(6,v.getTipo());
            ps.setDouble(7,v.getCosto_venta());
            ps.setDouble(8,v.getCosto_renta());
            ps.setString(9,v.getBodega());
            ps.setString(10,v.getProveedor());
            ps.setString(11,v.getEstado());
            ps.setInt(12,v.getIdVehiculo());
            ps.execute();
            return true;

        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }        
        
    }
    
    public Vehiculo BuscarVehiculo(int idVehiculo){
        Vehiculo vehiculo = new Vehiculo();
        String sql = "SELECT v.*, e.nombre, b.nombre \n" +
"FROM vehiculo v\n" +
"INNER JOIN estado e ON v.estado_idestado = e.idEstado\n" +
"INNER JOIN bodega b ON v.Bodega_idBodega = b.idbodega \n" +
"WHERE v.idVehiculo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVehiculo);
            rs = ps.executeQuery();
            if (rs.next()){
                vehiculo.setVIN(rs.getString("VIN"));
                vehiculo.setCosto_venta(rs.getDouble("costo_venta"));
                vehiculo.setEstado(rs.getString("nombre"));
                vehiculo.setBodega(rs.getString("b.nombre"));
                   
            }  
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return vehiculo;
    }
    
    
   public void consultarSeguro(JComboBox comboseguro){
       String sql = "SELECT tipo FROM seguro";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               comboseguro.addItem(rs.getString("tipo"));
           
           }
       } catch (SQLException e){
           System.out.print(e.toString());
       }
  
    }
 
      public void consultarmpago(JComboBox combompago){
       String sql = "SELECT CONCAT(idmpago, ' ', metodo_pago) FROM `mpago`;";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               combompago.addItem(rs.getString("metodo_pago)"));
           
           }
       } catch (SQLException e){
           System.out.print(e.toString());
       }
  
    }
      
    public void consultarmpagoNR(JComboBox comboboxseguroNR){
       String sql = "SELECT CONCAT(idmpago, ' - ', metodo_pago) FROM `mpago`;";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               comboboxseguroNR.addItem(rs.getString("CONCAT(idmpago, ' - ', metodo_pago)"));
           
           }
       } catch (SQLException e){
           System.out.print(e.toString());
       }
  
    }
}
