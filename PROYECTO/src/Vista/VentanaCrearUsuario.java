/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
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
public class VentanaCrearUsuario extends PanelEsquema implements ActionListener, ItemListener, MouseListener {

    private JComboBox<String> combo1;

    private FramePrincipal frame;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JPanel panelIcono;
    private String idIcono;
    private JPanel panelIconos;

    public VentanaCrearUsuario(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelCentro(frame), "Center");
        setOpaque(false);
    }

    public JPanel panelCentro(JFrame frame) {

        //<editor-fold defaultstate="collapsed" desc="PanelCentro">
        JPanel panelCentro = new JPanel();
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

        JPanel panelFormulario = new JPanel();
        JPanel panelBotones = new JPanel();

        panelFormulario.setOpaque(false);
        panelBotones.setOpaque(false);

        panelFormulario.setLayout(new BoxLayout(panelFormulario, 1));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CORREO">
        JLabel lbCorreo = new JLabel("Correo");
        lbCorreo.setPreferredSize(new Dimension(300, 100));
        lbCorreo.setHorizontalTextPosition(10);
        lbCorreo.setForeground(Color.white);
//        lbCorreo.setOpaque(false);
        panelFormulario.add(lbCorreo);
        JTextField tfCorreo = new JTextField(30);
        panelFormulario.add(tfCorreo);
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CONTRASENIA">
        JLabel lbContrasenia = new JLabel("Password");
        lbContrasenia.setForeground(Color.white);
        lbContrasenia.setOpaque(false);
        panelFormulario.add(lbContrasenia);
        JPasswordField tfContrasenia = new JPasswordField();
        panelFormulario.add(tfContrasenia);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="NOMBRE">
        JLabel lbNombre = new JLabel("Nombre");
        lbNombre.setForeground(Color.white);
        lbNombre.setOpaque(false);
        panelFormulario.add(lbNombre);
        JTextField tfNombre = new JTextField();
        panelFormulario.add(tfNombre);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="SEXO">
        JLabel lbSexo = new JLabel("Sexo");
        lbSexo.setForeground(Color.white);
        lbSexo.setOpaque(false);
        panelFormulario.add(lbSexo);
        radio1 = new JRadioButton("Hombre");
        radio1.setForeground(Color.white);
        radio1.setOpaque(false);
        radio1.addMouseListener(this);
        radio2 = new JRadioButton("Mujer");
        radio2.setForeground(Color.white);
//        radio2.setOpaque(false);
        radio3 = new JRadioButton("Otro");
        radio3.setForeground(Color.white);
//        radio3.setOpaque(false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);

        panelFormulario.add(radio1);
        panelFormulario.add(radio2);
        panelFormulario.add(radio3);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="LISTA">
        combo1 = new JComboBox<String>();
        combo1.setBounds(10, 10, 80, 20);
        add(combo1);
        combo1.addItem("A");
        combo1.addItem("B");
        combo1.addItem("C");
        combo1.addItem("D");
        combo1.addItem("E");
        combo1.addItemListener(this);
        panelFormulario.add(combo1);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="TABLA ICONOS">
        JLabel lbIcono = new JLabel("Icono");
        lbIcono.setForeground(Color.white);
        lbIcono.setOpaque(false);
        panelFormulario.add(lbIcono);
        panelIconos = new JPanel();
        panelIconos.setOpaque(false);

        panelIconos.setLayout(new GridLayout(2, 5));

        panelIcono = new JPanel();
        JLabel etiquetaIcono;
        JButton[][] botonesIconos = new JButton[2][5];
        ImageIcon img;
        JButton boton;
        String idImg = "";
        int idImagen = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (idImagen < 10) {

                    img = new ImageIcon("src/imagenes/avatar0" + idImagen + ".png");
                    idImg = "id.0" + String.valueOf(idImagen);
                } else {
                    img = new ImageIcon("src/imagenes/avatar" + idImagen + ".png");
                    idImg = "id." + String.valueOf(idImagen);

                }

                etiquetaIcono = new JLabel(img);
//                etiquetaIcono.setOpaque(false);
                panelIcono = new JPanel();
                panelIcono.setName(idImg);
                panelIcono.add(etiquetaIcono);
                panelIcono.setOpaque(false);
                panelIcono.addMouseListener(this);

                //                boton = new JButton();
                //                boton.setBorder(BorderFactory.createEmptyBorder());
                //                boton.setContentAreaFilled(false);
                //                boton.setOpaque(false);
                //
                //                boton.setIcon(img);
                //                botonesIconos[i][j] = boton;
                ////                botonesIconos[i][j].addFocusListener(this);
                //
                //                panelIconos.add(botonesIconos[i][j]);
                panelIconos
                        .add(panelIcono);
                idImagen++;
            }
        }
        panelFormulario.add(panelIconos);
        //</editor-fold>

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Atras")) {
            frame.remove(this);
            frame.add(new VentanaIniciarSesion(frame));
            frame.setVisible(true);
            frame.repaint();
        } else if (ae.getActionCommand().equals("Registrate")) {
            frame.remove(this);
            frame.add(new VentanaUsuarioBasico(frame));
            frame.setVisible(true);
            frame.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
//            System.out.println(seleccionado);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        idIcono = me.toString().substring(me.toString().lastIndexOf(" ") + 1, me.toString().length());
        for (int i = 0; i < 10; i++) {

            if (panelIconos.getAccessibleContext().getAccessibleChild(i).toString().substring(panelIconos.getAccessibleContext().getAccessibleChild(i).toString().lastIndexOf("id."), panelIconos.getAccessibleContext().getAccessibleChild(i).toString().lastIndexOf("id.") + 5).equals(idIcono)) {
                panelIconos.getAccessibleContext().getAccessibleChild(i).getAccessibleContext().getAccessibleComponent().setBackground(Color.yellow);
            }
//            panelIconos.getAccessibleContext().getAccessibleChild(i).getAccessibleContext().getAccessibleComponent().setBackground(Color.yellow);
//            System.out.println(panelIconos.getAccessibleContext().getAccessibleChild(i).getAccessibleContext().getAccessibleComponent().setBackground(Color.yellow));

        }

//        panelIcono.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        System.out.println("aaaaaaaa");
//        radio1.setOpaque(false);
////        radio1.setBorder(BorderFactory.createEmptyBorder());
//        radio1.setContentAreaFilled(false);
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
