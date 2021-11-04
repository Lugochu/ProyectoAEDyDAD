/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.Usuario;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lugo
 */
public class VentanaConfiguracionUsuario extends PanelEsquema {

    private JFrame frame;
    private Usuario user;

    public VentanaConfiguracionUsuario(JFrame frame, Usuario user) {
        super();
        this.frame = frame;
        this.user = user;
        add(PanelCentro(), "Center");
    }

    public JPanel PanelCentro() {
        //Danielugodominguez@gmail.com
        final String[] etiquetas = {"Cambiar nombre", "Cambiar password", "Generar grafico semanal"};
        JPanel panelCentro = new JPanel();
        JPanel panelConfig = new JPanel();
        panelConfig.setOpaque(false);
        panelCentro.setOpaque(false);
        panelConfig.setLayout(new BoxLayout(panelConfig, 1));
        JButton boton1 = new JButton(etiquetas[0]);
        JButton boton2 = new JButton(etiquetas[1]);
        JButton boton3 = new JButton(etiquetas[2]);


        JLabel lbNombre = new JLabel(etiquetas[0]);
        JLabel lbCorreo = new JLabel(etiquetas[1]);
        JLabel lbaaaaaaaaaa = new JLabel(etiquetas[2]);
        panelConfig.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));

        panelConfig.add(boton1);
        panelConfig.add(boton2);
        panelConfig.add(boton3);
        panelCentro.add(panelConfig);
        return panelCentro;
    }

}
