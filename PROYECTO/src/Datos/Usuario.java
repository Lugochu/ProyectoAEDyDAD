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
    private boolean tipoUser;
    private String idIcono;
    private String keyGrup;

    public Usuario(String email, String nombre, String pass, int tipoUser, String idIcono, String keyGrup) {
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        if (tipoUser == 0) {
            this.tipoUser = false;
        } else if(tipoUser == 1) {
            this.tipoUser = true;
        }
        this.idIcono = idIcono;
        this.keyGrup = keyGrup;
    }

    public Usuario() {
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

    public boolean getTipoUser() {
        return tipoUser;
    }

    public boolean setTipoUser(int tipoUser) {
        if (tipoUser == 0) {
            this.tipoUser = false;
        } else {
            this.tipoUser = true;
        }
        return false;
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

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nombre=" + nombre + ", pass=" + pass + ", tipoUser=" + tipoUser + ", idIcono=" + idIcono + ", keyGrup=" + keyGrup + '}';
    }

}
