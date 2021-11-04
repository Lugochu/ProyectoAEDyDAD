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
 * @author 2damab
 */
public class Registro {

    private String user = "proyectonotas";
    private String pass = "Pantalla1";

    public boolean crearGrupo(String nombreGrupo, String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO grupo (nombre,emailOwner) VALUES ('" + nombreGrupo + "','" + email + "')");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Registro(Usuario user1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass);
                    Statement stmt = con.createStatement()) {
                if (user1.getTipoUser()) {
                    Consultar consulta = new Consultar();
                    Grupo group = consulta.consultaGrupo(user1.getIdGroup());
                    stmt.executeUpdate("INSERT INTO usuarios VALUES ('" + user1.getEmail() + "','" + user1.getNombre() + "','" + user1.getPass() + "'," + user1.getTipoUser() + ",'" + user1.getIdIcono() + "'," + group.getIdGrupo() + ",'" + group.getNombre() + "')");
                } else if (!user1.getTipoUser()) {
                    stmt.executeUpdate("INSERT INTO usuarios VALUES ('" + user1.getEmail() + "','" + user1.getNombre() + "','" + user1.getPass() + "'," + user1.getTipoUser() + ",'" + user1.getIdIcono() + "'," + user1.getIdGroup() + ",'" + user1.getNombreGroup() + "')");
                }

            }
            return true;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
