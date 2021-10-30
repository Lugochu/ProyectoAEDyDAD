/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author 2damab
 */
public class Usuario {
    private String email;
    private String nombre;
    private String pass;
    private int tipoUser;
    private String idIcono;
    private String keyGrup;
    
    public Usuario (String email, String nombre, String pass, int tipoUser, String idIcono, String keyGrup){
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        this.tipoUser = tipoUser;
        this.idIcono = idIcono;
        this.keyGrup = keyGrup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public String getIdIcono() {
        return idIcono;
    }

    public void setIdIcono(String idIcono) {
        this.idIcono = idIcono;
    }

    public String getKeyGrup() {
        return keyGrup;
    }

    public void setKeyGrup(String keyGrup) {
        this.keyGrup = keyGrup;
    }
    
}
