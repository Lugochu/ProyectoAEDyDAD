/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2damab
 */
public class Modificar {
    public boolean modificarNota(String email, String pass, Nota nota) throws ClassNotFoundException{
         
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass);
            Statement stmt = con.createStatement();
             stmt.executeUpdate("UPDATE notas SET nota='"+nota.getNota()+"', negrita='"+nota.getNegrita()+"', cursiva='"+nota.getCursiva()+"', subrayar='"+nota.getSubrayar()+"', "
                     + "fondoColor='"+nota.getFondoColor()+"', modifDate='"+nota.getModifDate()+"' WHERE idNota='"+nota.getIdNota()+"'");
                
            stmt.close();
            con.close();
            
        }catch(SQLException sqle){}
        
        return true;
    }
    
    public boolean modificarUsuario(String email, String pass, Usuario user) throws ClassNotFoundException{
         
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass);
            Statement stmt = con.createStatement();
             stmt.executeUpdate("UPDATE usuarios SET nombre='"+user.getNombre()+"', pass='"+user.getPass()+"', tipoUser="+user.getTipoUser()+", "
                     + "idIcono='"+user.getIdIcono()+"', keyGrup='"+user.getKeyGrup()+"' WHERE email='"+user.getEmail()+"'");
                
            stmt.close();
            con.close();
            
        }catch(SQLException sqle){}
        
        return true;
    }
    public boolean modificarEmail(String email, String pass, Usuario user) throws ClassNotFoundException{
         
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass);
            Statement stmt = con.createStatement();
             stmt.executeUpdate("UPDATE usuarios SET email='"+user.getEmail()+"' WHERE nombre='"+user.getNombre()+"'");
                
            stmt.close();
            con.close();
            
        }catch(SQLException sqle){}
        
        return true;
    }
    
}