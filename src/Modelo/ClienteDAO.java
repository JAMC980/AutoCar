 
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
public boolean RegistrarCliente(Cliente cl) {
    String sql = "INSERT INTO persona (Pnombre, Snombre, Papellido, Sapellido, telefono, correo, direccion, personat_idpersonat)  VALUES (?,?,?,?,?,?,?,?)";
   
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        //ps.setInt(1, cl.getIdPersona());
        ps.setString(1, cl.getPnombre());
        ps.setString(2, cl.getSnombre());
        ps.setString(3, cl.getPapellido());
        ps.setString(4, cl.getSapellido());
        ps.setString(5, cl.getTelefono());
        ps.setString(6, cl.getCorreo());
        ps.setString(7, cl.getDireccion());
        ps.setInt(8, cl.getPersonat());
        ps.execute();
        
        return true;
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
    }finally{
        try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    }

    
    
   public List<Cliente> ListarCliente() {
    List<Cliente> ListaCl = new ArrayList<>();
    String sql = "SELECT * FROM persona p "
            + "INNER JOIN cliente c ON c.Persona_idPersona = p.idPersona";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Cliente cl = new Cliente();
            cl.setIdCliente(rs.getInt("idCliente"));
            cl.setPnombre(rs.getString("Pnombre"));
            cl.setSnombre(rs.getString("Snombre"));
            cl.setPapellido(rs.getString("Papellido"));
            cl.setSapellido(rs.getString("Sapellido"));
            cl.setTelefono(rs.getString("telefono"));
            cl.setCorreo(rs.getString("correo"));
            cl.setDireccion(rs.getString("direccion"));
            ListaCl.add(cl);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    return ListaCl;
}

    public boolean EliminarCliente(int idPersona){
    String sql = "DELETE FROM persona WHERE idPersona = ?";
    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ps.execute();
        return true;
    }catch(SQLException e){
        System.out.println(e.toString());
        return false;
    }finally{
        try{
        con.close();
    }catch (SQLException ex) {
        System.out.println(ex.toString());
        }
            
    }
        
    }
    
    public boolean ModificarCliente(Cliente cl){
        String sql = "UPDATE persona SET Pnombre = ?, Snombre = ?, Papellido = ?, Sapellido = ?, telefono = ?, correo = ?,direccion = ? WHERE idPersona = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,cl.getPnombre());
            ps.setString(2,cl.getSnombre());
            ps.setString(3,cl.getPapellido());
            ps.setString(4,cl.getSapellido());
            ps.setString(5,cl.getTelefono());
            ps.setString(6,cl.getCorreo());
            ps.setString(7,cl.getDireccion());
            ps.setInt(8,cl.getIdPersona());
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
    public Cliente Buscarcliente(int idcliente){
        Cliente cl = new Cliente();
        String sql = "SELECT * \n" +
"FROM cliente c \n" +
"INNER JOIN persona p ON p.idpersona = c.persona_idpersona\n" +
"WHERE c.idcliente = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,idcliente);
            rs = ps.executeQuery();
            if(rs.next()){
                cl.setPnombre(rs.getString("Pnombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("Direccion"));
            
            }
        }catch(SQLException e){
            System.out.println(e);
        
        }
        return cl;
    }
    
}
