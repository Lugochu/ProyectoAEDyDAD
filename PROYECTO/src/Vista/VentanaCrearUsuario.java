/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
public class VentanaCrearUsuario extends PanelEsquema implements ActionListener, ItemListener {

    private JComboBox<String> combo1;

    private FramePrincipal frame;

    public VentanaCrearUsuario(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelCentro(frame), "Center");
        setOpaque(false);
    }

    public JPanel panelCentro(JFrame frame) {
        JPanel panelBordes = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panelFormulario = new JPanel();
        JPanel panelBotones = new JPanel();
        panelCentro.setOpaque(false);
        panelBordes.setPreferredSize(new Dimension(500, 300));

        panelBordes.setBackground(new Color(255, 255, 255, 20));
        panelFormulario.setOpaque(false);
        panelBotones.setOpaque(false);

        panelBordes.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));

        panelCentro.setLayout(new BoxLayout(panelCentro, 1));
        panelFormulario.setLayout(new BoxLayout(panelFormulario, 1));

        //<editor-fold defaultstate="collapsed" desc="CORREO">
        JLabel lbCorreo = new JLabel("Correo");
        lbCorreo.setForeground(Color.white);
        lbCorreo.setOpaque(false);
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
        JRadioButton radio1 = new JRadioButton("Hombre");
        radio1.setForeground(Color.white);
        radio1.setOpaque(false);
        JRadioButton radio2 = new JRadioButton("Mujer");
        radio2.setForeground(Color.white);
        radio2.setOpaque(false);
        JRadioButton radio3 = new JRadioButton("Otro");
        radio3.setForeground(Color.white);
        radio3.setOpaque(false);
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

        //<editor-fold defaultstate="collapsed" desc="BOTONES">
        JButton atras = new JButton("Atras");
        atras.addActionListener(this);
        panelBotones.add(atras);
        JButton registrarse = new JButton("Registrate");
        registrarse.addActionListener(this);
        panelBotones.add(registrarse);
        //</editor-fold>

        panelBordes.add(panelCentro);
        panelCentro.add(panelFormulario);
        panelCentro.add(panelBotones);

        panelBordes.repaint();
        return panelBordes;
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
            System.out.println(seleccionado);
        }
    }
}
