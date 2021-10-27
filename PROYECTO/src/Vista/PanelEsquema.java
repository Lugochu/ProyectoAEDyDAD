/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Lugo
 */
public class PanelEsquema extends JPanel {

    private JPanel panelNorte;

    public PanelEsquema() {
        setLayout(new BorderLayout());
        add(panelNorte(), "North");
        setOpaque(false);
    }

    public PanelEsquema(int i) {
        setLayout(new BorderLayout());
        add(panelNorte(), "North");
        setOpaque(false);
    }

    public JPanel panelNorte() {
        panelNorte = new JPanel();
        panelNorte.setOpaque(false);
        panelNorte.setPreferredSize(new Dimension(0, 100));
        return panelNorte;
    }

    public JPanel getPanelNorte() {
        return panelNorte;
    }

    public void setPanelNorte(JPanel panelNorte) {
        this.panelNorte = panelNorte;
    }

}
