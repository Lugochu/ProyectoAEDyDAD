/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lugo
 */
public class FramePrincipal extends JFrame {
    private String rutaImagenBackgroud="/imagenes/degradadoFrame.jpg";
    private FondoPanel fondo = new FondoPanel(rutaImagenBackgroud);

    public FramePrincipal() {
        initComponents();
    }

    public void initComponents() {
        setContentPane(fondo);
        setLayout(new CardLayout());
        add(new VentanaIniciarSesion(this));
        //<editor-fold defaultstate="collapsed" desc="CONFIGURACION DEL FRAME">
        setTitle("Prueba");
        //CARGAR DIMENSION DE LA PANTALLA
        Dimension pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //DARLE UNA MEDIDA Y COLOCARLO EN EL CENTRO DE LA PANTALLA
        setPreferredSize(new Dimension((int) (pantalla.getWidth() / 2), (int) (pantalla.getHeight() / 2)));
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //</editor-fold>

    }


    public static void main(String[] args) {
        new FramePrincipal().setVisible(true);
    }

}

class FondoPanel extends JPanel {

    private Image imagen;
    private String rutaImg;
    
    
    public FondoPanel(String rutaImg){
        this.rutaImg=rutaImg;
    }
    
    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource(rutaImg)).getImage();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

        setOpaque(false);

        super.paint(g);
    }
    
    
}
