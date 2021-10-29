/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lugo
 */
public class VentanaIniciarSesion extends PanelEsquema implements ActionListener {

    private FramePrincipal frame;

    public VentanaIniciarSesion(FramePrincipal frame) {
        super();
        this.frame = frame;
        add(panelCentro(), "Center");
    }

    public JPanel panelCentro() {

        JPanel panelCentro = new JPanel();
        JPanel panelFormYBotones = new JPanel();
        JPanel formulario = new JPanel();
        JPanel botones = new JPanel();
        panelCentro.setOpaque(false);
        panelFormYBotones.setOpaque(false);
        formulario.setOpaque(false);
        botones.setOpaque(false);
        panelFormYBotones.setLayout(new BoxLayout(panelFormYBotones, BoxLayout.Y_AXIS));

        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS));

        //CORREO
        JLabel lbCorreo = new JLabel("Correo");
        lbCorreo.setForeground(Color.white);
        lbCorreo.setOpaque(false);
        formulario.add(lbCorreo);
        JTextField tfCorreo = new JTextField(20);
        formulario.add(tfCorreo);
        //CONTRASE?A
        JLabel lbContrasenia = new JLabel("Password");
        lbContrasenia.setForeground(Color.white);
        lbContrasenia.setOpaque(false);
        formulario.add(lbContrasenia);
        JPasswordField tfContrasenia = new JPasswordField();
        formulario.add(tfContrasenia);
        //BOTONES
        JButton iniciarSesion = new JButton("Iniciar sesion");
        iniciarSesion.addActionListener(this);
        JButton regristrate = new JButton("Regristrate");
        regristrate.addActionListener(this);
        botones.add(iniciarSesion);
        botones.add(regristrate);

        panelCentro.add(panelFormYBotones);
        panelFormYBotones.add(formulario);
        panelFormYBotones.add(botones);

        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Regristrate")) {
            frame.remove(this);
            frame.add(new VentanaCrearUsuario(frame));
            frame.setVisible(true);
        } else if (ae.getActionCommand().equals("Iniciar sesion")) {
            System.out.println("");
        }
    }

}
