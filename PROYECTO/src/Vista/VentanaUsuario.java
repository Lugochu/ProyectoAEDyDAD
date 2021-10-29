/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Lugo
 */
public class VentanaUsuario extends PanelEsquema implements ActionListener, MouseListener {

    private JPanel panelNorte;
    private FramePrincipal frame;
    private final Color amarillo = new Color(247, 243, 146);
    private final Color verde = new Color(207, 248, 172);
    private final Color azul = new Color(187, 207, 242);
    private final Color rosa = new Color(242, 182, 234);
    private String rutaIconoUser = "src/imagenes/user.png";
    
    public VentanaUsuario(FramePrincipal frame) {
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
        ImageIcon img = new ImageIcon(rutaIconoUser);
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
        JPanel panelCentro2 = new JPanel(new FlowLayout(3, 50, 50));
        JPanel panelCentro3 = new JPanel();

        panelCentro2.setOpaque(false);
        panelCentro3.setOpaque(false);
        for (int i = 0; i < 10; i++) {
            panelCentro2.add(panelPosItMiniatura("", ""));

        }
        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane panelPestanias = new JTabbedPane();

        panelPestanias.addTab("Tab 1", null, panelCentro2,null);
        panelPestanias.addTab("Tab 1", null, panelCentro3, "Does nothing");

        panelCentro.add(panelPestanias);
        return panelCentro;
    }

    public JPanel crearPestania(String nombre) {
        JPanel pestania = new JPanel();
        pestania.setName(nombre);
        return pestania;

    }

    public JPanel panelPosItMiniatura(String titulo, String nota) {
        JPanel panelPosIt = new JPanel();
        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();
        JPanel panelPosItSur = new JPanel();

        panelPosIt.setPreferredSize(new Dimension(300, 300));
        panelPosItNorte.setPreferredSize(new Dimension(0, 50));
        panelPosItNorte.setBackground(rosa);
        panelPosItCentro.setBackground(amarillo);

        panelPosIt.setLayout(new BorderLayout());
        panelPosIt.add(panelPosItNorte, "North");
        panelPosIt.add(panelPosItCentro, "Center");
        panelPosIt.add(panelPosItSur, "South");
        panelPosIt.addMouseListener(this);
        return panelPosIt;
    }

    public void panelPosIt(String titulo, String nota, Color colorTitulo, Color colorNota) {
        JDialog panelPosItModal = new JDialog(frame, titulo);

        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();
        JPanel panelPosItSur = new JPanel();

        panelPosItNorte.setPreferredSize(new Dimension(0, 50));
        panelPosItNorte.setBackground(rosa);
        panelPosItCentro.setBackground(amarillo);
        JCheckBox negrita = new JCheckBox();
        JCheckBox cursiva = new JCheckBox();
        JCheckBox subrayada = new JCheckBox();
        panelPosItSur.add(negrita);
        panelPosItSur.add(cursiva);
        panelPosItSur.add(subrayada);

        JPanel panelPosIt = new JPanel();
        panelPosIt.setPreferredSize(new Dimension(400, 500));
        panelPosIt.setLayout(new BorderLayout());
        panelPosIt.add(panelPosItNorte, "North");
        panelPosIt.add(panelPosItCentro, "Center");
        panelPosIt.add(panelPosItSur, "South");
        panelPosItModal.add(panelPosIt);
        panelPosItModal.setLocationRelativeTo(null);
        panelPosItModal.pack();
        panelPosItModal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("AAAAAAA");
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getClickCount() == 2) {
            System.out.println(me.getSource());
            panelPosIt("", "", null, null);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
