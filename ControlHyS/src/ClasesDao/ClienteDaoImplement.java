/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDao;

import Conexion.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;

/**
 *
 * @author javi
 */
public class ClienteDaoImplement implements ClienteDao{
    private Statement statement;
    private String sql;
    private ResultSet rs;
    private Connection connection;
    private PreparedStatement ps;

    @Override
    public ArrayList<Cliente> listar() {
            connection = ConnectionFactory.getConnection();
            ArrayList<Cliente> clientes = new ArrayList<>();
            sql="SELECT * FROM clientes";
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            connection.close();
            while (rs.next()) {
                
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
                c.setEmail(rs.getString("Email"));
                clientes.add(c);
                }
            return clientes;            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;

    }

    @Override
    public void insertarCliente(Cliente c) {
             
        connection = ConnectionFactory.getConnection();
        sql="INSERT INTO clientes (nombre,direccion,email,telefono) VALUES(?,?,?,?) ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,c.getNombre() );
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
            connection.close();
                 
                        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    @Override
    public void modificarCliente(Cliente c) {
        connection =ConnectionFactory.getConnection();
        sql = "UPDATE clientes SET nombre=?, direccion=?, email =?, telefono=? WHERE id_cliente=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,c.getNombre() );
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
    @Override
    public void eliminarCliente(Cliente c) {
            
        connection =ConnectionFactory.getConnection();
        sql ="DELETE FROM clientes WHERE id_cliente=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getId_cliente());
            ps.executeUpdate();
            connection.close();
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}
