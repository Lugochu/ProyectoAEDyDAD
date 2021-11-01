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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2damab
 */
public class InicioSesion {

    private String user;
    private String pass;

    public InicioSesion() {
        this.user = "root";
        this.pass = "Pantalla1";
    }

    public boolean verificarInicio(String email, String pass1) {
        boolean verificado = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
            try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery("SELECT email, pass FROM usuarios WHERE email='" + email + "'")) {
                while (res.next()) {
                    verificado = res.getString("email").equals(email) && res.getString("pass").equals(pass1);
                }
                res.close();
                stmt.close();
            }
            System.out.println(verificado);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificado;
    }

    public boolean tipoSesion(String email, String pass1) {
        boolean verificado = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
            try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery("SELECT tipoUser FROM usuarios WHERE email='" + email + "'")) {
                verificado = res.getByte("tipoUser") != 0;
            }

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificado;
    }

    public boolean VerificarEmail(String email) {
        boolean verificado = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
            try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery("SELECT email, pass FROM usuarios WHERE email='" + email + "'")) {
                verificado = res.getString("email").equals(email);
            }

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificado;
    }

    public Usuario objUsuario(String email, String pass) {
        Usuario user1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
            try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE email='" + email + "'")) {
                while (res.next()) {
                    user1 = new Usuario();
                    user1.setEmail(res.getString("email"));
                    user1.setNombre(res.getString("nombre"));
                    user1.setPass(res.getString("pass"));
                    user1.setTipoUser(res.getInt("tipoUser"));
                    user1.setIdIcono(res.getString("idIcono"));
                    user1.setKeyGrup(res.getString("keyGroup"));
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user1;
    }

}
