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
import java.util.ArrayList;

/**
 *
 * @author 2damab
 */
public class Consultar {
    
    public ArrayList<Nota> consultarNotas (String email, String pass, int idGrup) throws ClassNotFoundException{
        ArrayList<Nota> list = new ArrayList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM notas WHERE idgrupo='"+idGrup+"'");
                while(res.next()){
                    list.add(new Nota(res.getInt("idNota"),res.getString("titulo"),res.getString("nota"),res.getString("negrita"),res.getString("cursiva"),res.getString("subrayar"),res.getString("fondoColor"),res.getDate("crearDate"),res.getDate("modifDate")));
                }
            res.close();
            stmt.close();
            con.close();
            
        }catch(SQLException sqle){}
        return list;
    }
    
    public Usuario consultarUsuario(String email, String pass) throws ClassNotFoundException{
        Usuario user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",email,pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE email='"+email+"'");
                while(res.next()){
                    user = new Usuario(res.getString("email"),res.getString("nombre"),res.getString("idIcono"),res.getInt("tipoUser"),res.getString("idIcono"),res.getString("keyGrup"));
                }
            res.close();
            stmt.close();
            con.close();
            
        }catch(SQLException sqle){}
        return user;
    }
}
