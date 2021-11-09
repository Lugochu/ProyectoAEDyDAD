/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BD_Manager.Consultar;
import ObjetosBD.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Lugo
 */
public class VentanaUsuario extends PanelEsquema implements ActionListener, MouseListener, ItemListener {

    private JPanel panelNorte;
    private FramePrincipal frame;
    private Usuario user;
    private ArrayList<Usuario> usuarios;
    private String rutaIconoUser = "src/imagenes/";
    private String opcionGrafico = "";
    private final String[] textoGraficos={"Grafico de area"
            ,"Grafico de barras"
            ,"Grafico de barras 3D"
            ,"Grafico de lineas"
            ,"Grafico de lineas 3D"};
            
    public VentanaUsuario(FramePrincipal frame, Usuario user) {
        super();
        this.frame = frame;
        this.user = user;
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(panelNorteUsuarios(), "North");
        if (user.getTipoUser()) {
            Consultar consulta = new Consultar();
            usuarios = consulta.consultaUsuariosGrupo(this.user.getIdGroup());
            add(panelCentro(), "Center");
        } else {
            add(panelCentro(), "Center");
        }
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
        JPanel panelNorteGrafica = new JPanel();
        panelNorteGrafica.setLayout(new FlowLayout(1, 40, 20));
        panelNorteGrafica.setOpaque(false);
        //<editor-fold defaultstate="collapsed" desc="LISTA">
        JComboBox<String> combo1 = new JComboBox<String>();
        combo1.setBounds(10, 10, 80, 20);
        add(combo1);
        combo1.addItem(textoGraficos[0]);
        combo1.addItem(textoGraficos[1]);
        combo1.addItem(textoGraficos[2]);
        combo1.addItem(textoGraficos[3]);
        combo1.addItem(textoGraficos[4]);
        combo1.addItemListener(this);
        panelNorteGrafica.add(combo1);

        //</editor-fold>
        JButton botonGrafica = new JButton("Generar grafico");
        botonGrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (opcionGrafico.equals("")) {
                    opcionGrafico="Grafico de area";
                }
                new Grafica(opcionGrafico,frame,user);
            }
        });
        panelNorteGrafica.add(botonGrafica);
        panelNorte.add(panelNorteGrafica, "West");
//</editor-fold>
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

    @Override
    public void itemStateChanged(ItemEvent ie) {
        opcionGrafico=ie.getItem().toString();
    }
}
