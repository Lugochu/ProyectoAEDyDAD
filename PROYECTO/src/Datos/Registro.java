/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2damab
 */
public class Registro {
    private String user = "root";
    private String pass = "root";
    
    public boolean Registro(String email, String nombre, String pass1, String idIcono, int tipoUser, String keyGrup) throws ClassNotFoundException{
        //ResultSet resultado = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/animales",user,pass);
            Statement stmt = con.createStatement();
            if(tipoUser==0){
                stmt.executeUpdate("CREATE USER '"+email+"'@'proyectonotas' IDENTIFIED BY '"+pass1+"'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '"+email+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '"+email+"'@'proyectonotas'");
            }else{
                stmt.executeUpdate("CREATE USER '"+email+"'@'proyectonotas' IDENTIFIED BY '"+pass1+"'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '"+email+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.grupo TO '"+email+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '"+email+"'@'proyectonotas'");
            }
            
            stmt.executeUpdate("INSERT INTO usuarios VALUES ('"+email+"','"+nombre+"','"+pass1+"','"+idIcono+"',"+tipoUser+",'"+keyGrup+"')");
            
            stmt.close();
            con.close();
        }catch(SQLException sqle){}
        return true;
    }
}
