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

    private String user = "root";
    private String pass = "Pantalla1";

    public boolean Registro(Usuario user1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", user, pass); Statement stmt = con.createStatement()) {
                if (!user1.getTipoUser()) {
                    stmt.executeUpdate("CREATE USER '" + user1.getEmail() + "'@'proyectonotas' IDENTIFIED BY '" + user1.getPass() + "'");
                    stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '" + user1.getEmail() + "'@'proyectonotas'");
                    stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '" + user1.getEmail() + "'@'proyectonotas'");
                } else {
                    stmt.executeUpdate("CREATE USER '" + user1.getEmail() + "'@'proyectonotas' IDENTIFIED BY '" + user1.getPass() + "'");
                    stmt.executeUpdate("GRANT ALL ON proyectonotas.notas TO '" + user1.getEmail() + "'@'proyectonotas'");
                    stmt.executeUpdate("GRANT ALL ON proyectonotas.grupo TO '" + user1.getEmail() + "'@'proyectonotas'");
                    stmt.executeUpdate("GRANT ALL ON proyectonotas.usuarios TO '" + user1.getEmail() + "'@'proyectonotas'");
                }

                stmt.executeUpdate("INSERT INTO usuarios VALUES ('" + user1.getEmail() + "','" + user1.getNombre() + "','" + user1.getPass() + "'," + user1.getTipoUser() + ",'" + user1.getIdIcono()+ "','" + user1.getKeyGrup() + "')");

            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
