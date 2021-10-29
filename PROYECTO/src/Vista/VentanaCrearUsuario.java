/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Lugo
 */
public class VentanaCrearUsuario extends PanelEsquema
        implements ActionListener, ItemListener, MouseListener {

    private JComboBox<String> combo1;
    private FramePrincipal frame;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private String idIcono = "";
    private JPanel panelIconos;
    private static JPanel[] panelesIconos = new JPanel[10];
    private JPanel panelCentro;
    private JPanel panelFormulario;
    private JLabel lbIcono;

    public VentanaCrearUsuario(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelCentro(frame), "Center");
    }

    public JPanel panelCentro(JFrame frame) {

        //<editor-fold defaultstate="collapsed" desc="PanelCentro">
        panelCentro = new JPanel();
        panelCentro.setOpaque(false);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="PanelBordes">
        JPanel panelBordes = new JPanel();
        panelBordes.setLayout(new BoxLayout(panelBordes, 1));
        panelBordes.setPreferredSize(new Dimension(500, 500));
        panelBordes.setBackground(new Color(255, 255, 255, 20));
        panelBordes.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));

//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Panel Formulario Y Botones">
        JPanel panelFormYBotones = new JPanel();
        panelFormYBotones.setOpaque(false);
        panelFormulario = new JPanel();
        JPanel panelBotones = new JPanel();
        panelFormulario.setOpaque(false);
        panelBotones.setOpaque(false);
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CORREO">
        JPanel panelEtiquetaCorreo = new JPanel();
        panelEtiquetaCorreo.setLayout(new CardLayout());
        panelEtiquetaCorreo.setOpaque(false);
        JLabel lbCorreo = new JLabel("Correo");
        panelEtiquetaCorreo.add(lbCorreo);

        lbCorreo.setLayout(null);
        lbCorreo.setForeground(Color.white);
        panelFormulario.add(panelEtiquetaCorreo);
        JTextField tfCorreo = new JTextField(30);
        panelFormulario.add(tfCorreo);
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CONTRASENIA">
        JPanel panelContrasenia = new JPanel();
        panelContrasenia.setLayout(new CardLayout());
        JLabel lbContrasenia = new JLabel("Password");
        panelContrasenia.add(lbContrasenia);
        panelContrasenia.setOpaque(false);
        lbContrasenia.setForeground(Color.white);
        lbContrasenia.setOpaque(false);
        panelFormulario.add(panelContrasenia);
        JPasswordField tfContrasenia = new JPasswordField();
        panelFormulario.add(tfContrasenia);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="NOMBRE">
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new CardLayout());
        JLabel lbNombre = new JLabel("Nombre");
        panelNombre.add(lbNombre);
        panelNombre.setOpaque(false);
        lbNombre.setForeground(Color.white);
        panelFormulario.add(panelNombre);
        JTextField tfNombre = new JTextField();
        panelFormulario.add(tfNombre);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="SEXO">
        JPanel panelSexo = new JPanel();
        panelSexo.setLayout(new CardLayout());
        JLabel lbSexo = new JLabel("Sexo");
        panelSexo.add(lbSexo);
        panelSexo.setOpaque(false);
        lbSexo.setForeground(Color.white);
        panelFormulario.add(panelSexo);

        JPanel panelRadioButtons = new JPanel();

        radio1 = new JRadioButton("Hombre");
        radio1.setForeground(Color.white);
        radio1.setOpaque(false);
        radio2 = new JRadioButton("Mujer");
        radio2.setForeground(Color.white);
        radio2.setOpaque(false);

        radio3 = new JRadioButton("Otro");
        radio3.setForeground(Color.white);
        radio3.setOpaque(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        panelRadioButtons.add(radio1);
        panelRadioButtons.add(radio2);
        panelRadioButtons.add(radio3);
        panelRadioButtons.setBackground(new Color(0, 0, 0, 0));
        panelFormulario.add(panelRadioButtons);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LISTA">
        JPanel panelLista = new JPanel();
        panelLista.setOpaque(false);
        panelLista.setLayout(new CardLayout());
        combo1 = new JComboBox<String>();
        combo1.setBounds(10, 10, 80, 20);
        add(combo1);
        combo1.addItem("A");
        combo1.addItem("B");
        combo1.addItem("C");
        combo1.addItem("D");
        combo1.addItem("E");
        combo1.addItemListener(this);
        panelLista.add(combo1);

        panelFormulario.add(panelLista);
        //</editor-fold>

        tablaIconos();

        //<editor-fold defaultstate="collapsed" desc="BOTONES">
        JButton atras = new JButton("Atras");
        atras.addActionListener(this);
        panelBotones.add(atras);
        JButton registrarse = new JButton("Registrate");
        registrarse.addActionListener(this);
        panelBotones.add(registrarse);
        //</editor-fold>

        panelCentro.add(panelBordes);
        panelBordes.add(panelFormYBotones);
        panelFormYBotones.add(panelFormulario);
        panelFormYBotones.add(panelBotones);

        return panelCentro;
    }

    public void tablaIconos() {
        //<editor-fold defaultstate="collapsed" desc="TABLA ICONOS">
        lbIcono = new JLabel("Icono");
        lbIcono.setForeground(Color.white);
        lbIcono.setOpaque(false);
        panelFormulario.add(lbIcono);
        panelIconos = new JPanel();
        panelIconos.setBackground(new Color(255, 255, 255, 0));

        panelIconos.setLayout(new GridLayout(2, 5));
        JLabel etiquetaIcono;
        ImageIcon img;
        JButton boton;
        String idImg = "";
        int idImagen = 1;
        for (int i = 0; i < 10; i++) {
            if (idImagen < 10) {

                img = new ImageIcon("src/imagenes/avatar0" + idImagen + ".png");
                idImg = "id.0" + String.valueOf(idImagen);
            } else {
                img = new ImageIcon("src/imagenes/avatar" + idImagen + ".png");
                idImg = "id." + String.valueOf(idImagen);

            }

            etiquetaIcono = new JLabel(img);
//                etiquetaIcono.setOpaque(false);
            panelesIconos[i] = new JPanel();
            panelesIconos[i].setName(idImg);
            panelesIconos[i].add(etiquetaIcono);
            panelesIconos[i].setBackground(new Color(255, 255, 255, 0));
            panelesIconos[i].addMouseListener(this);
            panelesIconos[i].setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            panelesIconos[i].setBackground(new Color(39, 124, 131, 0));

            panelIconos.add(panelesIconos[i]);
            idImagen++;
        }
        panelFormulario.add(panelIconos);
        //</editor-fold>
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Atras")) {
            frame.remove(this);
            frame.add(new VentanaIniciarSesion(frame));
            frame.setVisible(true);
            frame.repaint();
        } else if (ae.getActionCommand().equals("Registrate")) {
            frame.remove(this);
            frame.add(new VentanaUsuario(frame));
            frame.setVisible(true);
            frame.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        idIcono = me.toString().substring(
                me.toString().lastIndexOf(" ") + 1,
                me.toString().length()
        );
        System.out.println(idIcono);
        for (int i = 0; i < 10; i++) {
            if (panelesIconos[i].getName().equals(idIcono)) {
                panelFormulario.remove(lbIcono);
                panelIconos.removeAll();
                tablaIconos();
                panelesIconos[i].setBorder(BorderFactory.createBevelBorder(
                        0, new Color(54, 171, 163), new Color(54, 171, 163),
                        new Color(32, 84, 106), new Color(32, 84, 106)));
                panelCentro.repaint();
            }
        }
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
