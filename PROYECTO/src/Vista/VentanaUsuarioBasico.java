/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lugo
 */
public class VentanaUsuarioBasico extends PanelEsquema {

    private FramePrincipal frame;

    public VentanaUsuarioBasico(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelNorteUsuarios(), "North");
        setOpaque(true);
    }

    public JPanel panelNorteUsuarios() {
        JPanel panelNorte = super.getPanelNorte();

        panelNorte.setOpaque(true);
        JPanel panelNorteIconos = new JPanel();
        panelNorteIconos.setBackground(Color.yellow);
        panelNorteIconos.setPreferredSize(new Dimension(500, 500));
        panelNorteIconos.add(new JLabel("aaaaaaaaaaaaaaaaaaaaa"));
        JButton boton = new JButton("aaaaaaaaa");
        panelNorteIconos.add(boton);
        panelNorte.add(panelNorteIconos);

        return panelNorte;
    }


}
