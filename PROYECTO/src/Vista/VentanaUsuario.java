/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.Consultar;
import Datos.Nota;
import Datos.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
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

    private final Color amarillo = new Color(247, 243, 146);
    private final Color amarilloOscuro = new Color(236, 232, 117);

    private final Color verde = new Color(207, 248, 172);
    private final Color verdeOscuro = new Color(179, 232, 134);

    private final Color azul = new Color(187, 207, 242);
    private final Color azulOscuro = new Color(152, 180, 228);

    private final Color rosa = new Color(242, 182, 234);
    private final Color rosaOscuro = new Color(228, 154, 218);

    private String rutaIconoUser = "src/imagenes/";

    public VentanaUsuario(FramePrincipal frame, Usuario user) {
        super();
        this.frame = frame;
        this.user = user;
        Consultar consulta = new Consultar();

        usuarios = consulta.consultaUsuariosGrupo("root", "Pantalla1", user.getKeyGrup());
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        add(panelNorteUsuarios(), "North");
        add(panelCentro(), "Center");

    }

    public JPanel panelNorteUsuarios() {
        panelNorte = super.getPanelNorte();
        panelNorte.setLayout(new BorderLayout());
        JPanel panelNorteIconos = new JPanel();
        panelNorteIconos.setLayout(new FlowLayout(1, 20, 20));
        panelNorteIconos.setOpaque(false);

        JButton boton = new JButton();
        ImageIcon img = new ImageIcon(rutaIconoUser + user.getIdIcono() + ".png");
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
        for (Usuario usuario : usuarios) {
            panelPestanias.addTab(usuario.getNombre(), null, new PestaniaUsuario(frame, usuario), null);
        }
        panelCentro.add(panelPestanias);
        return panelCentro;
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
