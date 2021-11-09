/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Manager;

import ObjetosBD.Nota;
import ObjetosBD.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2damab
 */
public class Modificar {
    private String email="proyectonotas";
    private String pass="Pantalla1";
    
    public boolean modificarNota(Nota nota){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement()) {
                stmt.executeUpdate("UPDATE notas SET titulo='" + nota.getTitulo() + "', nota='" + nota.getNota() + "', negrita=" + nota.isNegrita() + ", cursiva=" +nota.isCursiva()+ ", subrayar=" +nota.isSubrayar()+ ","
                        + " fondoColor=" + nota.getFondoColor() + ", modifDate='" + nota.getModifDate() + "' WHERE idNota=" + nota.getIdNota() + "");
                
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean modificarUsuario(Usuario user){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass); 
                    Statement stmt = con.createStatement()) {
                stmt.executeUpdate("UPDATE usuarios SET nombre='" + user.getNombre() + "', pass='" + user.getPass() + "', tipoUser=" + user.getTipoUser() + ", "
                        + "idIcono='" + user.getIdIcono() + "', keyGrup='" + user.getNombreGroup() + "' WHERE email='" + user.getEmail() + "'");
                
            }

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean modificarEmail(Usuario user){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass); 
                    Statement stmt = con.createStatement()) {
                stmt.executeUpdate("UPDATE usuarios SET email='" + user.getEmail() + "' WHERE nombre='" + user.getNombre() + "'");
                
            }

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

}
