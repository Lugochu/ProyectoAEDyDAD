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
    
    public boolean Registro(Usuario user1) throws ClassNotFoundException{
        Byte tipoUser = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/animales",user,pass);
            Statement stmt = con.createStatement();
            if(user1.getTipoUser()==false){
                stmt.executeUpdate("CREATE USER '"+user1.getEmail()+"'@'proyectonotas' IDENTIFIED BY '"+user1.getPass()+"'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '"+user1.getEmail()+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '"+user1.getEmail()+"'@'proyectonotas'");
                tipoUser=0;
            }else{
                stmt.executeUpdate("CREATE USER '"+user1.getEmail()+"'@'proyectonotas' IDENTIFIED BY '"+user1.getPass()+"'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '"+user1.getEmail()+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.grupo TO '"+user1.getEmail()+"'@'proyectonotas'");
                stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '"+user1.getEmail()+"'@'proyectonotas'");
                tipoUser=1;
            }
            
            stmt.executeUpdate("INSERT INTO usuarios VALUES ('"+user1.getEmail()+"','"+user1.getNombre()+"','"+user1.getPass()+"','"+user1.getIdIcono()+"',"+tipoUser+",'"+user1.getKeyGrup()+"')");
            
            stmt.close();
            con.close();
        }catch(SQLException sqle){}
        return true;
    }
}
