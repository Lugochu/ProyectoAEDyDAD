/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.InicioSesion;
import Datos.Usuario;
import java.awt.Color;
import java.awt.Dimension;
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

    private Dimension tamanioTextFields = new Dimension(200, 25);
    private FramePrincipal frame;
    private JPasswordField tfContrasenia;
    private JTextField tfCorreo;
    private JLabel lbError;
    
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
        lbError = new JLabel(" ");
        JLabel lbCorreo = new JLabel("Correo");
        lbCorreo.setForeground(Color.white);
        lbCorreo.setOpaque(false);
        formulario.add(lbCorreo);
        tfCorreo = new JTextField(20);
        tfCorreo.setPreferredSize(tamanioTextFields);
        formulario.add(tfCorreo);
        //CONTRASE?A
        JLabel lbContrasenia = new JLabel("Password");
        lbContrasenia.setForeground(Color.white);
        lbContrasenia.setOpaque(false);
        formulario.add(lbContrasenia);
        tfContrasenia = new JPasswordField();
        tfContrasenia.setPreferredSize(tamanioTextFields);
        formulario.add(tfContrasenia);
        //BOTONES
        JButton iniciarSesion = new JButton("Iniciar sesion");
        iniciarSesion.addActionListener(this);
        JButton regristrate = new JButton("Regristrate");
        regristrate.addActionListener(this);
        botones.add(iniciarSesion);
        botones.add(regristrate);

        panelCentro.add(panelFormYBotones);
        panelFormYBotones.add(lbError);
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
            InicioSesion is = new InicioSesion();
            char[] arrayLetras = tfContrasenia.getPassword();
            String contrasenia = "";
            String correo = String.valueOf(tfCorreo.getText().charAt(0)).toUpperCase() + tfCorreo.getText().substring(1, tfCorreo.getText().length());
            for (char arrayLetra : arrayLetras) {
                contrasenia += arrayLetra;
            }
            if (is.verificarInicio(correo, contrasenia)) {
                frame.remove(this);
                Usuario usu = new Usuario();
                usu = is.objUsuario(tfCorreo.getText(), contrasenia);
                frame.add(new VentanaUsuario(frame, usu));
                frame.setVisible(true);
            } else {
                lbError.setText("Error, usuario o contrase?a incorrecta.");
            }
        }
    }

}
