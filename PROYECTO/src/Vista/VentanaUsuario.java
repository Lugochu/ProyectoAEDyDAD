/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.Consultar;
import Datos.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Lugo
 */
public class VentanaUsuario extends PanelEsquema implements ActionListener, MouseListener {

    private JPanel panelNorte;
    private FramePrincipal frame;
    private Usuario user;
    private ArrayList<Usuario> usuarios;
    private String rutaIconoUser = "src/imagenes/";

    public VentanaUsuario(FramePrincipal frame, Usuario user) {
        super();
        this.frame = frame;
        this.user = user;
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if (user.getTipoUser()) {
            Consultar consulta = new Consultar();
            usuarios = consulta.consultaUsuariosGrupo(user.getIdGroup());
            add(panelCentro(0), "Center");
        } else {
            add(panelCentro(1), "Center");
        }
        add(panelNorteUsuarios(), "North");
    }

    public JPanel panelNorteUsuarios() {
        panelNorte = super.getPanelNorte();
        panelNorte.setLayout(new BorderLayout());
//<editor-fold defaultstate="collapsed" desc="icono">
        JPanel panelNorteIconos = new JPanel();
        panelNorteIconos.setLayout(new FlowLayout(1, 20, 20));
        panelNorteIconos.setOpaque(false);
        JButton botonIcono = new JButton();
        ImageIcon img = new ImageIcon(rutaIconoUser + user.getIdIcono() + ".png");
        botonIcono.setBorder(BorderFactory.createEmptyBorder());
        botonIcono.setContentAreaFilled(false);
        botonIcono.setIcon(img);
        botonIcono.addActionListener(this);
        panelNorteIconos.add(botonIcono);
        panelNorte.add(panelNorteIconos, "East");
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Boton grafica">
        JPanel panelNorteBotones = new JPanel();
        panelNorteBotones.setLayout(new FlowLayout(1, 20, 20));
        panelNorteBotones.setOpaque(false);
        JButton botonGrafica = new JButton("Generar grafico");
        botonGrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        panelNorteBotones.add(botonGrafica);
        panelNorte.add(panelNorteBotones, "West");
//</editor-fold>
        return panelNorte;
    }

    public JPanel panelCentro(int op) {

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new CardLayout());
        panelCentro.setOpaque(false);
        JPanel panelCentro2 = new JPanel();
        JPanel panelCentro3 = new JPanel();

        panelCentro2.setOpaque(false);
        panelCentro3.setOpaque(false);

        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane panelPestanias = new JTabbedPane();
        if (user.getTipoUser()) {
            if (!usuarios.isEmpty()) {
                for (Usuario usuario : usuarios) {
                    PestaniaUsuario pestania = new PestaniaUsuario(frame, usuario);
                    pestania.setName(usuario.getEmail());
                    JScrollPane scroll = new JScrollPane(pestania,
                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    scroll.setOpaque(false);
                    scroll.getViewport().setOpaque(false);
                    scroll.getVerticalScrollBar().setUnitIncrement(16);
                    panelPestanias.addTab(usuario.getNombre(), null, scroll, null);
                    panelCentro.add(panelPestanias);
                }
            } else {
                PestaniaUsuario pestania = new PestaniaUsuario(frame, user);
                pestania.setName(user.getEmail());
                JScrollPane scroll = new JScrollPane(pestania,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setOpaque(false);
                scroll.getViewport().setOpaque(false);

                scroll.getVerticalScrollBar().setUnitIncrement(16);
                panelPestanias.addTab(user.getNombre(), null, scroll, null);
                panelCentro.add(panelPestanias);
            }

        } else {
            PestaniaUsuario pestania = new PestaniaUsuario(frame, user);
            panelCentro.add(pestania);
        }
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.remove(this);
        frame.add(new VentanaConfiguracionUsuario(frame, user));
        frame.setVisible(true);
        frame.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
