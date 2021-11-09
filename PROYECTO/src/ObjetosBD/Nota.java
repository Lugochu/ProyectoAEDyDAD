/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosBD;

import java.sql.Date;

/**
 *
 * @author 2damab
 */
public class Nota {

    private int idNota;
    private String titulo;
    private String nota;
    private boolean negrita;
    private boolean cursiva;
    private boolean subrayar;
    private int fondoColor;
    private Date crearDate;
    private Date modifDate;
    private String idUsuario;

    public Nota(String titulo, String nota, boolean negrita, boolean cursiva, boolean subrayar, int fondoColor, Date crearDate, Date modifDate, String idUsuario) {
        this.titulo = titulo;
        this.nota = nota;
        this.negrita = negrita;
        this.cursiva = cursiva;
        this.subrayar = subrayar;
        this.fondoColor = fondoColor;
        this.crearDate = crearDate;
        this.modifDate = modifDate;
        this.idUsuario = idUsuario;
    }

    public Nota(int idNota, String titulo, String nota, boolean negrita, boolean cursiva, boolean subrayar, int fondoColor, Date crearDate, Date modifDate, String idUsuario) {
        this.idNota = idNota;
        this.titulo = titulo;
        this.nota = nota;
        this.negrita = negrita;
        this.cursiva = cursiva;
        this.subrayar = subrayar;
        this.fondoColor = fondoColor;
        this.crearDate = crearDate;
        this.modifDate = modifDate;
        this.idUsuario = idUsuario;
    }

    public int getIdNota() {
        return idNota;

    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public boolean isNegrita() {
        return negrita;
    }

    public void setNegrita(boolean negrita) {
        this.negrita = negrita;
    }

    public boolean isCursiva() {
        return cursiva;
    }

    public void setCursiva(boolean cursiva) {
        this.cursiva = cursiva;
    }

    public boolean isSubrayar() {
        return subrayar;
    }

    public void setSubrayar(boolean subrayar) {
        this.subrayar = subrayar;
    }

    public int getFondoColor() {
        return fondoColor;
    }

    public void setFondoColor(int fondoColor) {
        this.fondoColor = fondoColor;
    }

    public Date getCrearDate() {
        return crearDate;
    }

    public void setCrearDate(Date crearDate) {
        this.crearDate = crearDate;
    }

    public Date getModifDate() {
        return modifDate;
    }

    public void setModifDate(Date modifDate) {
        this.modifDate = modifDate;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", titulo=" + titulo + ", nota=" + nota + ", negrita=" + negrita + ", cursiva=" + cursiva + ", subrayar=" + subrayar + ", fondoColor=" + fondoColor + ", crearDate=" + crearDate + ", modifDate=" + modifDate + ", idUsuario=" + idUsuario + '}';
    }

}
