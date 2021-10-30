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
public class InicioSesion {
    private String user = "root";
    private String pass = "root";
    
    public boolean VerificarInicio(String email, String pass1) throws ClassNotFoundException{
        boolean verificado = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",user,pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT email, pass FROM usuarios WHERE email='"+email+"'");
            if(res.getString("email").equals(email) && res.getString("pass").equals(pass1)){
                verificado = true;
            }else{
                verificado = false;
            }
            res.close();
            stmt.close();
            
        }catch(SQLException sqle){}
        return verificado;
    }  
    public boolean tipoSesion(String email, String pass1) throws ClassNotFoundException{
        boolean verificado = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",user,pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT tipoUser FROM usuarios WHERE email='"+email+"'");
            if(res.getInt("tipoUser")==0){
                verificado = false;
            }else{
                verificado = true;
            }
            res.close();
            stmt.close();
            
        }catch(SQLException sqle){}
        return verificado;
    }
    
    public boolean VerificarEmail(String email) throws ClassNotFoundException{
        boolean verificado = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",user,pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT email, pass FROM usuarios WHERE email='"+email+"'");
            if(res.getString("email").equals(email)){
                verificado = true;
            }else{
                verificado = false;
            }
            res.close();
            stmt.close();
            
        }catch(SQLException sqle){}
        return verificado;
    }  
    
    public Usuario objUsuario(String email, String pass1) throws ClassNotFoundException{ 
        Usuario user1 = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass1);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE email='"+email+"'");
            
            if(res.next()){
                user1.setEmail(res.getString("email"));
                user1.setNombre(res.getString("nombre"));
                user1.setPass(res.getString("pass"));
                user1.setTipoUser(res.getInt("tipoUser"));
                user1.setIdIcono(res.getString("idIcono"));
                user1.setKeyGrup(res.getString("keyGrup"));
            }
            res.close();
            stmt.close();
            
        }catch(SQLException sqle){}
        return user1;
    }  
    
}
