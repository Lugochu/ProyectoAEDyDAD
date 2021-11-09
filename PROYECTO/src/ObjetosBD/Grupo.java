/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosBD;

/**
 *
 * @author Lugo
 */
public class Grupo {
    private int idGrupo;
    private String nombre;
    private String emailOwner;

    public Grupo(int idGrupo, String nombre, String emailOwner) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.emailOwner = emailOwner;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailOwner() {
        return emailOwner;
    }

    public void setEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", nombre=" + nombre + ", emailOwner=" + emailOwner + '}';
    }
    
    
}
