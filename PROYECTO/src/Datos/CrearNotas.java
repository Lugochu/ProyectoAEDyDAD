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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class CrearNotas {
    public boolean crearNota(String user, String pass, Nota nota, Usuario usu){
        Byte negrita = null;
        Byte cursiva = null;
        Byte subrayar = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas",user,pass);
                    Statement stmt = con.createStatement()) {
                stmt.executeUpdate("INSERT INTO notas (titulo,nota,negrita,cursiva,subrayar,fondoColor,crearDate,modifDate,idUsuario) VALUES ('"+nota.getTitulo()+"','"+nota.getNota()+"',"+nota.isNegrita()+","
                        +nota.isCursiva()+","+nota.isSubrayar()+","+nota.getFondoColor()+",'"+nota.getCrearDate()+"','"+nota.getModifDate()+"','"+usu.getEmail()+"')");
            }
        }catch(SQLException sqle){
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
