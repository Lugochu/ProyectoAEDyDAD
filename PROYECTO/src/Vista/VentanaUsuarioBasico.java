/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Lugo
 */
public class VentanaUsuarioBasico extends PanelEsquema implements ActionListener {

    private JPanel panelNorte;
    private FramePrincipal frame;

    public VentanaUsuarioBasico(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelNorteUsuarios(), "North");
        add(panelCentro(), "Center");

    }

    public JPanel panelNorteUsuarios() {
        panelNorte = super.getPanelNorte();
        panelNorte.setLayout(new BorderLayout());
        JPanel panelNorteIconos = new JPanel();
        panelNorteIconos.setOpaque(false);

        JButton boton = new JButton();
        ImageIcon img = new ImageIcon("src/imagenes/user.png");
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setContentAreaFilled(false);
        boton.setIcon(img);
        boton.addActionListener(this);
        panelNorteIconos.add(boton);
        panelNorte.add(panelNorteIconos, "East");

        return panelNorte;
    }

    public JPanel panelCentro() {

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new CardLayout());
        panelCentro.setOpaque(false);
        JPanel panelCentro2 = new JPanel();
        JPanel panelCentro3 = new JPanel();

        panelCentro2.setOpaque(false);
        panelCentro3.setOpaque(false);

        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane panelPestanias = new JTabbedPane();

        panelPestanias.addTab("Tab 1", null, panelCentro2, "Does nothing");
        panelPestanias.addTab("Tab 1", null, panelCentro3, "Does nothing");

        panelCentro.add(panelPestanias);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("AAAAAAA");
    }

}
