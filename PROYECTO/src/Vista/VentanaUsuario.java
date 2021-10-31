/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
    
    private final Color amarillo = new Color(247, 243, 146);
    private final Color amarilloOscuro = new Color(236, 232, 117);

    private final Color verde = new Color(207, 248, 172);
    private final Color verdeOscuro = new Color(179, 232, 134);

    private final Color azul = new Color(187, 207, 242);
    private final Color azulOscuro = new Color(152, 180, 228);

    private final Color rosa = new Color(242, 182, 234);
    private final Color rosaOscuro = new Color(228, 154, 218);

    private String rutaIconoUser = "src/imagenes/user.png";

    public VentanaUsuario(FramePrincipal frame, Usuario user) {
        super();
        this.frame = frame;
        this.user = user;
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
        for (int i = 0; i < 50; i++) {
            panelCentro2.add(panelPosItMiniatura("Esto es una prueba de titulo", "Esto es una prueba de nota "
                    + "Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto "
                    + "es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es un"
                    + "a prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una pru"
                    + "eba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba d"
                    + "e nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de not"
                    + "a Esto es una prueba de nota Esto es una prueba de nota adsdadsasd Esto es una prueba "
                    + "de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de not"
                    + "a Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto"
                    + " es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es u"
                    + "na prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una pr"
                    + "ueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba "
                    + "de nota Esto es una prueba de nota Esto es una prueba de nota adsdadsasd Esto es una p"
                    + "rueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba"
                    + " de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de no"
                    + "ta Esto es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Es"
                    + "to es una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es"
                    + " una prueba de nota Esto es una prueba de nota Esto es una prueba de nota Esto es una "
                    + "prueba de nota Esto es una prueba de nota Esto es una prueba de nota adsdadsasd",
                    rosaOscuro, rosa));

        }
        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane panelPestanias = new JTabbedPane();

        panelPestanias.addTab(user.getNombre(), null, panelCentro2, null);
        panelPestanias.addTab("Tab 1", null, panelCentro3, null);

        panelCentro.add(panelPestanias);
        return panelCentro;
    }

    public JPanel crearPestania(String nombre) {
        JPanel pestania = new JPanel();
        pestania.setName(nombre);
        return pestania;
    }

    public JPanel panelPosItMiniatura(String tituloStr, String notaStr, Color colorTitulo, Color colorNota) {
        JPanel panelPosIt = new JPanel();
        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();

        tituloStr = tituloStr.toUpperCase();
        JLabel titulo = new JLabel(tituloStr);
        titulo.setForeground(Color.white);

        JTextArea nota = new JTextArea(notaStr);


        nota.setLineWrap(true);
        nota.setLayout(new GridLayout());
        nota.addMouseListener(this);
        nota.setEditable(false);
        nota.setBackground(colorNota);

        panelPosIt.setPreferredSize(new Dimension(320, 300));
        panelPosItNorte.setPreferredSize(new Dimension(0, 50));

        panelPosItNorte.setBackground(colorTitulo);
        panelPosItNorte.add(titulo);
        panelPosItCentro.setBackground(colorNota);
        panelPosItCentro.add(nota);
        panelPosItCentro.setLayout(new CardLayout(20, 10));

        panelPosIt.setLayout(new BorderLayout());
        panelPosIt.add(panelPosItNorte, "North");
        panelPosIt.add(panelPosItCentro, "Center");
        panelPosIt.addMouseListener(this);
        return panelPosIt;
    }

    public void panelPosIt(String titulo, String nota, Color colorTitulo, Color colorNota) {
        JDialog panelPosItModal = new JDialog(frame, titulo);

        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();
        JPanel panelPosItSur = new JPanel();

        panelPosItNorte.setPreferredSize(new Dimension(0, 50));
        panelPosItNorte.setBackground(rosaOscuro);
        panelPosItCentro.setBackground(rosa);
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
