/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.Date;
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

    public ArrayList<Nota> consultarNotas(String email, String pass, Usuario user) throws ClassNotFoundException {
        ArrayList<Nota> list = new ArrayList();
        int idNota;
        String titulo;
        String nota; 
        boolean negrita;
        boolean cursiva;
        boolean subrayar;
        int fondoColor;
        Date crearDate;
        Date modifDate;
        String idUsuario;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM notas WHERE idUsuario='" + user.getEmail() + "'");
            while (res.next()) {
                idNota = res.getInt("idNota");
                titulo = res.getString("titulo");
                nota = res.getString("nota");
                if (res.getByte("negrita") == 1) {
                    negrita = true;
                } else {
                    negrita = false;
                }
                if (res.getByte("cursiva") == 1) {
                    cursiva = true;
                } else {
                    cursiva = false;
                }
                if (res.getByte("subrayar") == 1) {
                    subrayar = true;
                } else {
                    subrayar = false;
                }
                fondoColor=res.getInt("fondoColor");
                crearDate = res.getDate("crearDate");
                modifDate = res.getDate("modifDate");
                idUsuario = res.getString("idUsuario");
                list.add(new Nota(idNota, titulo, nota, negrita, cursiva ,subrayar, fondoColor , crearDate,modifDate ,idUsuario ));
            }
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException sqle) {
        }
        return list;
    }

    public Usuario consultarUsuario(String email, String pass) throws ClassNotFoundException {
        Usuario user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE email='" + email + "'");
            while (res.next()) {
                user = new Usuario(res.getString("email"), res.getString("nombre"), res.getString("idIcono"), res.getByte("tipoUser"), res.getString("idIcono"), res.getString("keyGrup"));
            }
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException sqle) {
        }
        return user;
    }

    /*public int consultaGrupo(String email, String pass) throws ClassNotFoundException {
        int idgrupo = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM grupo WHERE email='" + email + "'");
            idgrupo = res.getInt("idgrupo");
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException sqle) {
        }
        return idgrupo;
    }*/
    
    public ArrayList<Usuario> consultaUsuariosGrupo(String email, String pass, String keyGroup) throws ClassNotFoundException {
        
        ArrayList<Usuario> list = new ArrayList();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE keyGroup='" + keyGroup + "'");
            while (res.next()) {
            list.add(new Usuario(res.getString("email"), res.getString("nombre"), res.getString("idIcono"), res.getByte("tipoUser"), res.getString("idIcono"), res.getString("keyGrup")));
            }
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException sqle) {
        }
        return list;
    }
}
