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
 * @author eduar
 */
public class CrearNotas {
    public boolean crearNota(String user, String pass, Nota nota) throws ClassNotFoundException{
        Byte negrita = null;
        Byte cursiva = null;
        Byte subrayar = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/animales",user,pass);
            Statement stmt = con.createStatement();
            if(nota.isNegrita()){
                negrita = 1;
            }else{negrita=0;}
            
            if(nota.isCursiva()){
                cursiva = 1;
            }else{cursiva=0;}
            
            if(nota.isSubrayar()){
                subrayar = 1;
            }else{subrayar=0;}

            stmt.executeUpdate("INSERT INTO notas VALUES (null,'"+nota.getTitulo()+"','"+nota.getNota()+"',"+negrita+","
                    +cursiva+","+subrayar+","+nota.getFondoColor()+",'"+nota.getCrearDate()+"','"+nota.getModifDate()+"')");
            
            stmt.close();
            con.close();
        }catch(SQLException sqle){}
        return true;
    }
}
