/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexion.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Formularios.Login;

/**
 *
 * @author javi
 */
public class MetodosLogin {
    private Statement statement;
    private String sql;
    private ResultSet rs;
    private Connection connection;
    private PreparedStatement ps;
    public int validarIngreso (){
    
    
    String usuario= Login.jtUsuario.getText();
    String clave = String.valueOf(Login.jpContrasenia.getPassword());
    
    int resultado=0;
    connection= ConnectionFactory.getConnection();
    sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"'AND contrasenia= ('"+clave+"')";
        try {
            statement = connection.createStatement();
            rs= statement.executeQuery(sql);
            connection.close();
            
            if (rs.next()) {
                resultado= 1;
                
            }
        } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, ex, "El usuario o contraseña son incorrectos", JOptionPane.ERROR_MESSAGE);

        }
    
    return resultado;
    }
    
    
}
