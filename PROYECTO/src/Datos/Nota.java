/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author 2damab
 */
public class Nota {
    private int idNota;
    private String titulo;
    private String nota;
    private String negrita;
    private String cursiva;
    private String subrayar;
    private String fondoColor;
    private Date crearDate;
    private Date modifDate;
    
    public Nota(int idNota, String titulo, String nota, String negrita, String cursiva, String subrayar, String fondoColor, Date crearDate, Date modifDate){
        this.idNota = idNota;
        this.titulo = titulo;
        this.nota = nota;
        this.negrita = negrita;
        this.cursiva = cursiva;
        this.subrayar = subrayar;
        this.fondoColor = fondoColor;
        this.crearDate = crearDate;
        this.modifDate = modifDate;
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

    public String getNegrita() {
        return negrita;
    }

    public void setNegrita(String negrita) {
        this.negrita = negrita;
    }

    public String getCursiva() {
        return cursiva;
    }

    public void setCursiva(String cursiva) {
        this.cursiva = cursiva;
    }

    public String getSubrayar() {
        return subrayar;
    }

    public void setSubrayar(String subrayar) {
        this.subrayar = subrayar;
    }

    public String getFondoColor() {
        return fondoColor;
    }

    public void setFondoColor(String fondoColor) {
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
    
}
