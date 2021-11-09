/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Manager;

import ObjetosBD.Grupo;
import ObjetosBD.Nota;
import ObjetosBD.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2damab
 */
public class Consultar {

    private String email = "proyectonotas";
    private String pass = "Pantalla1";

    public ArrayList<Nota> consultarNotas(Usuario user) {
        ArrayList<Nota> list = new ArrayList();
        int idNota;
        String titulo, nota;
        boolean negrita, cursiva, subrayar;
        int fondoColor;
        Date crearDate, modifDate;
        String idUsuario;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM notas WHERE idUsuario='" + user.getEmail() + "'")) {
                while (res.next()) {
                    idNota = res.getInt("idNota");
                    titulo = res.getString("titulo");
                    nota = res.getString("nota");
                    negrita = res.getBoolean("negrita");
                    cursiva = res.getBoolean("cursiva");
                    subrayar = res.getBoolean("subrayar");
                    fondoColor = res.getInt("fondoColor");
                    crearDate = res.getDate("crearDate");
                    modifDate = res.getDate("modifDate");
                    idUsuario = res.getString("idUsuario");
                    list.add(new Nota(idNota, titulo, nota, negrita, cursiva, subrayar, fondoColor, crearDate, modifDate, idUsuario));
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Nota consultarNota(int idNotaBuscar) {
        int idNota;
        String titulo, nota;
        boolean negrita, cursiva, subrayar;
        int fondoColor;
        Date crearDate, modifDate;
        String idUsuario;
        Nota notaCorrecta = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM notas WHERE idNota=" + idNotaBuscar + "")) {
                while (res.next()) {
                    idNota = res.getInt("idNota");
                    titulo = res.getString("titulo");
                    nota = res.getString("nota");
                    negrita = res.getBoolean("negrita");
                    cursiva = res.getBoolean("cursiva");
                    subrayar = res.getBoolean("subrayar");
                    fondoColor = res.getInt("fondoColor");
                    crearDate = res.getDate("crearDate");
                    modifDate = res.getDate("modifDate");
                    idUsuario = res.getString("idUsuario");
                    notaCorrecta = new Nota(idNota, titulo, nota, negrita, cursiva, subrayar, fondoColor, crearDate, modifDate, idUsuario);
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notaCorrecta;
    }

    public Usuario consultarUsuario(String emailUsuario) {
        Usuario user = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE email='" + emailUsuario + "'")) {
                while (res.next()) {
                    user = new Usuario(res.getString("email"),
                            res.getString("nombre"),
                            res.getString("idIcono"),
                            res.getByte("tipoUser"),
                            res.getString("idIcono"),
                            res.getString("keyGrup"));
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public Grupo consultaGrupo(int idGrupo) {
        Grupo group;
        int idgrupo = 0;
        String nombre = "";
        String emailOwner = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM grupo WHERE idGrupo=" + idGrupo)) {
                while (res.next()) {
                    idgrupo = res.getInt("idgrupo");
                    nombre = res.getString("nombre");
                    emailOwner = res.getString("emailOwner");
                }
                return group = new Grupo(idgrupo, nombre, emailOwner);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Grupo consultaGrupoNombre(String nombreGrupo) {
        Grupo group;
        int idgrupo = 0;
        String nombre = "";
        String emailOwner = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM grupo WHERE nombre='" + nombreGrupo + "'")) {
                while (res.next()) {
                    idgrupo = res.getInt("idgrupo");
                    nombre = res.getString("nombre");
                    emailOwner = res.getString("emailOwner");
                }
                return group = new Grupo(idgrupo, nombre, emailOwner);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Usuario> consultaUsuariosGrupo(int idGrupo) {

        ArrayList<Usuario> list = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectonotas", email, pass);
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM usuarios WHERE keyGroup="+idGrupo)) {
                while (res.next()) {
                    list.add(new Usuario(res.getString("email"),
                            res.getString("nombre"),
                            res.getString("pass"),
                            res.getInt("tipoUser"),
                            res.getString("idIcono"),
                            res.getInt("keyGroup"),
                            res.getString("nombreGroup")));
                }
            }
            return list;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
