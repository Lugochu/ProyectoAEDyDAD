/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BD_Manager.Consultar;
import ObjetosBD.Grupo;
import BD_Manager.Registro;
import ObjetosBD.Usuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Lugo
 */
public class VentanaCrearUsuario extends PanelEsquema
        implements ActionListener, MouseListener,
        FocusListener, ChangeListener {

    private Dimension tamanioTextFields = new Dimension(200, 25);
    private FramePrincipal frame;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private String idIcono = "";
    private JPanel panelIconos;
    private static JPanel[] panelesIconos = new JPanel[10];
    private JPanel panelCentro;
    private JPanel panelFormulario;
    private JLabel lbIcono;
    private JTextField tfCorreo;
    private JLabel lbCorreoError;
    private JPanel panelEtiquetaCorreoError;
    private JPanel panelBordes;
    private JLabel lbNombreError;
    private JLabel lbContraseniaError;
    private JLabel lbRadioButtonError;
    private JPanel panelLbIcono;
    private JPanel panelNombreError;
    private JTextField tfNombre;
    private JPanel panelErrorIcono;
    private JButton registrarse;
    private JButton atras;
    private JPanel panelLbGrupo;
    private JTextField tfGrupo;
    private int tipoUsu = 0;
    private JPanel panelBordesGrupo;
    private JPanel panelFormYBotones;
    private JPanel panelRadioButtons;
    private JPasswordField tfContrasenia;
    private JLabel lbNombre;
    private JLabel iconoError;
    private JLabel lbGrupoError;

    public VentanaCrearUsuario(FramePrincipal frame) {
        super();
        this.frame = frame;
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(panelCentro(frame), "Center");
    }

    public JPanel panelCentro(JFrame frame) {

        //<editor-fold defaultstate="collapsed" desc="PanelCentro">
        panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="PanelBordes">
        panelBordes = new JPanel();
        panelBordes.setLayout(new FlowLayout(1, 30, 30));
        panelBordes.setBackground(new Color(255, 255, 255, 20));
        panelBordes.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Panel Formulario Y Botones">
        panelFormYBotones = new JPanel();
        panelFormYBotones.setOpaque(false);
        panelFormYBotones.setLayout(new BoxLayout(panelFormYBotones, 1));
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
        lbCorreo.setForeground(Color.white);
        panelFormulario.add(panelEtiquetaCorreo);

        tfCorreo = new JTextField(30);
        tfCorreo.setText("");
        tfCorreo.addFocusListener(this);
        tfCorreo.setPreferredSize(tamanioTextFields);
        panelEtiquetaCorreoError = new JPanel();
        panelEtiquetaCorreoError.setLayout(new CardLayout());
        panelEtiquetaCorreoError.setOpaque(false);
        lbCorreoError = new JLabel(" ");
        lbCorreoError.setForeground(Color.red);
        panelEtiquetaCorreoError.add(lbCorreoError);
        panelFormulario.add(tfCorreo);
        panelFormulario.add(panelEtiquetaCorreoError);
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
        tfContrasenia = new JPasswordField();
        tfContrasenia.setText("");
        tfContrasenia.setPreferredSize(tamanioTextFields);
        JPanel panelContraseniaError = new JPanel();
        panelContraseniaError.setLayout(new CardLayout());
        lbContraseniaError = new JLabel(" ");
        lbContraseniaError.setForeground(Color.red);
        panelContraseniaError.add(lbContraseniaError);
        panelContraseniaError.setOpaque(false);
        panelFormulario.add(tfContrasenia);
        panelFormulario.add(panelContraseniaError);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="NOMBRE">
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new CardLayout());
        lbNombre = new JLabel("Nombre");
        panelNombre.add(lbNombre);
        panelNombre.setOpaque(false);
        lbNombre.setForeground(Color.white);
        panelFormulario.add(panelNombre);
        tfNombre = new JTextField("");
        tfNombre.setPreferredSize(tamanioTextFields);
        panelNombreError = new JPanel();
        panelNombreError.setLayout(new CardLayout());
        panelNombreError.setBackground(Color.yellow);
        lbNombreError = new JLabel(" ");
        lbNombreError.setForeground(Color.red);
        panelNombreError.add(lbNombreError);
        panelNombreError.setOpaque(false);
        panelFormulario.add(tfNombre);
        panelFormulario.add(panelNombreError);
        //</editor-fold>

        tablaIconos();

        //<editor-fold defaultstate="collapsed" desc="tipoDeUsuario">
        JPanel panelTipoUsuario = new JPanel();
        panelTipoUsuario.setLayout(new CardLayout());
        JLabel lbTipoUsuario = new JLabel("Tipo de usuario");
        panelTipoUsuario.add(lbTipoUsuario);
        panelTipoUsuario.setOpaque(false);
        lbTipoUsuario.setForeground(Color.white);
        panelFormulario.add(panelTipoUsuario);

        panelRadioButtons = new JPanel();

        radio1 = new JRadioButton("Administrador");
        radio1.addChangeListener(this);
        radio1.addMouseListener(this);
        radio1.addFocusListener(this);
        radio1.setForeground(Color.white);
        radio1.setOpaque(false);
        radio2 = new JRadioButton("Usuario normal");
        radio2.addChangeListener(this);
        radio2.addFocusListener(this);
        radio2.addMouseListener(this);
        radio2.setForeground(Color.white);
        radio2.setOpaque(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        panelRadioButtons.add(radio1);
        panelRadioButtons.add(radio2);
        panelRadioButtons.setBackground(new Color(0, 0, 0, 0));

        JPanel panelRadioButtonError = new JPanel();
        panelRadioButtonError.setLayout(new CardLayout());
        lbRadioButtonError = new JLabel(" ");
        lbRadioButtonError.setForeground(Color.red);
        panelRadioButtonError.add(lbRadioButtonError);
        panelRadioButtonError.setOpaque(false);
        panelFormulario.add(panelRadioButtons);
        panelFormulario.add(panelRadioButtonError);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="BOTONES">
        atras = new JButton("Atras");
        atras.addActionListener(this);
        panelBotones.add(atras);
        registrarse = new JButton("Siguiente");
        registrarse.addActionListener(this);
        panelBotones.add(registrarse);
        //</editor-fold>

        panelCentro.add(panelFormYBotones);
        panelFormYBotones.add(panelBordes);
        panelBordes.add(panelFormulario);
        panelFormYBotones.add(panelBotones);

        return panelCentro;
    }

    public void tablaIconos() {
        panelLbIcono = new JPanel();
        panelLbIcono.setOpaque(false);
        panelLbIcono.setLayout(new CardLayout());
        lbIcono = new JLabel("Icono");
        lbIcono.setForeground(Color.white);
        lbIcono.setOpaque(false);
        panelLbIcono.add(lbIcono);
        panelIconos = new JPanel();
        panelIconos.setBackground(new Color(255, 255, 255, 0));

        panelIconos.setLayout(new GridLayout(2, 5));
        JLabel etiquetaIcono;
        ImageIcon img;
        JButton boton;
        String idImg = "";

        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                idImg = "id_0" + i;
                img = new ImageIcon("src/imagenes/" + idImg + ".png");
            } else {
                idImg = "id_" + i;
                img = new ImageIcon("src/imagenes/" + idImg + ".png");

            }

            etiquetaIcono = new JLabel(img);
            panelesIconos[i - 1] = new JPanel();
            panelesIconos[i - 1].setName(idImg);
            panelesIconos[i - 1].add(etiquetaIcono);
            panelesIconos[i - 1].setBackground(new Color(255, 255, 255, 0));
            panelesIconos[i - 1].addMouseListener(this);
            panelesIconos[i - 1].setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            panelesIconos[i - 1].setBackground(new Color(39, 124, 131, 0));

            panelIconos.add(panelesIconos[i - 1]);
        }
        panelErrorIcono = new JPanel();
        iconoError = new JLabel(" ");
        iconoError.setForeground(Color.red);
        panelErrorIcono.add(iconoError);
        panelErrorIcono.setLayout(new CardLayout());
        panelErrorIcono.setOpaque(false);
        panelFormulario.add(panelLbIcono, 9);
        panelFormulario.add(panelIconos, 10);
        panelFormulario.add(panelErrorIcono, 11);
    }

    public void panelGrupo(String etiqueta) {
        panelBordesGrupo = new JPanel();
        panelBordesGrupo.setLayout(new FlowLayout(1, 30, 30));
        panelBordesGrupo.setBackground(new Color(255, 255, 255, 20));
        panelBordesGrupo.setBorder(BorderFactory.createBevelBorder(0, new Color(54, 171, 163), new Color(54, 171, 163), new Color(32, 84, 106), new Color(32, 84, 106)));
        JPanel panelFormularioGrupo = new JPanel();
        panelFormularioGrupo.setLayout(new BoxLayout(panelFormularioGrupo, 1));
        panelFormularioGrupo.setOpaque(false);
        panelLbGrupo = new JPanel();
        panelLbGrupo.setOpaque(false);
        panelLbGrupo.setLayout(new CardLayout());
        JLabel lbGrupo = new JLabel(etiqueta);
        lbGrupo.setForeground(Color.white);
        panelLbGrupo.add(lbGrupo);
        tfGrupo = new JTextField();
        tfGrupo.setPreferredSize(tamanioTextFields);
        tfGrupo.setForeground(Color.red);
        JPanel panelGrupoError = new JPanel();
        panelGrupoError.setOpaque(false);
        panelGrupoError.setLayout(new CardLayout());
        lbGrupoError = new JLabel(" ");
        panelFormularioGrupo.add(panelLbGrupo);
        panelFormularioGrupo.add(tfGrupo);
        panelGrupoError.add(lbGrupoError);
        panelFormularioGrupo.add(panelGrupoError);
        panelBordesGrupo.add(panelFormularioGrupo);
        panelFormYBotones.add(panelBordesGrupo, 1);
    }

    public void validarMinString(String str, JLabel texto) {
        if (str.isEmpty()) {
            texto.setText("Error, campo vacio");
        }
    }

    public boolean validarMaxString(String str, int tamanio, JLabel fallo) {
        if (str.length() <= tamanio) {
            return true;
        } else {
            fallo.setText("Error, maximo " + tamanio + " caracteres");
            this.repaint();
            this.repaint();
            return false;
        }
    }

    public boolean comprobarVacios() {
        if (!tfNombre.getText().isEmpty()
                && !tfContrasenia.getText().isEmpty()
                && !tfCorreo.getText().isEmpty()) {
            return true;
        } else {
            validarMinString(tfNombre.getText(), lbNombreError);
            validarMinString(tfContrasenia.getText(), lbContraseniaError);
            validarMinString(tfCorreo.getText(), lbCorreoError);
            this.repaint();
            return false;
        }
    }

    public boolean comprobarFormularioRelleno() {
        return validarMaxString(tfNombre.getText(), 30, lbNombreError)
                && validarMaxString(Arrays.toString(tfContrasenia.getPassword()), 30, lbContraseniaError)
                && validarMaxString(tfCorreo.getText(), 40, lbCorreoError)
                && validarEmail(tfCorreo.getText());
    }

    public boolean comprobarFormulario() {
        boolean vacio = comprobarVacios();
        boolean lleno = comprobarFormularioRelleno();
        return vacio == true && lleno == true;
    }

    public boolean comprobarKeyGroup() {
        boolean vacio;
        boolean max;
        if (!tfGrupo.getText().isEmpty()) {
            vacio = true;
        } else {
            lbGrupoError.setText("Error, campo vacio");
            this.repaint();
            vacio = false;
        }
        if (tfGrupo.getText().length() <= 50) {
            max = true;
        } else {
            lbGrupoError.setText("Error, maximo 50 caracteres");
            this.repaint();
            max = false;
        }
        return vacio && max;
    }

    public boolean validarEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find() == true;
    }

    public void desactivarPrimerFormulario() {
        for (Component component : panelFormulario.getComponents()) {
            component.setEnabled(false);
        }
        for (Component component : panelRadioButtons.getComponents()) {
            component.setEnabled(false);
        }
        for (int i = 0; i < 10; i++) {
            panelIconos.setEnabled(false);
            panelesIconos[i].setEnabled(false);
        }
    }

    public void errorLabelReset() {
        lbNombreError.setText(" ");
        lbContraseniaError.setText(" ");
        lbCorreoError.setText(" ");
        lbRadioButtonError.setText(" ");
        iconoError.setText(" ");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Atras":
                frame.remove(this);
                frame.add(new VentanaIniciarSesion(frame));
                frame.setVisible(true);
                frame.repaint();
                break;
            case "Siguiente":
                errorLabelReset();
                if (!validarEmail(tfCorreo.getText())) {
                    lbCorreoError.setText("Error, correo no valido");
                    this.repaint();
                }
                switch (tipoUsu) {
                    case 0:
                        lbRadioButtonError.setText("Error, escoge un tipo de usuario");
                        this.repaint();
                        comprobarFormulario();
                        if (idIcono.equals("")) {
                            iconoError.setText("Error, escoge un icono");
                            this.repaint();
                        }
                        break;
                    case 1:
                        if (comprobarFormulario()) {
                            desactivarPrimerFormulario();
                            panelGrupo("Introduce un nombre para crear un grupo");
                            registrarse.setText("Registrate");
                            registrarse.setActionCommand("Registrate");
                        }
                        break;
                    case 2:
                        if (comprobarFormulario()) {
                            desactivarPrimerFormulario();
                            panelGrupo("Introduce la clave del grupo que te quieres unir");
                            registrarse.setText("Registrate");
                            registrarse.setActionCommand("Registrate");
                        }
                        break;
                    default:
                        break;
                }
                break;
            case "Registrate":
                if (comprobarKeyGroup()) {
                    char[] arrayLetras = tfContrasenia.getPassword();
                    String contrasenia = "";
                    for (char arrayLetra : arrayLetras) {
                        contrasenia += arrayLetra;
                    }
                    if (idIcono.equals("")) {
                        iconoError.setText("Error, escoge un icono");
                        this.repaint();
                    } else {
                        String correo = String.valueOf(tfCorreo.getText().charAt(0)).toUpperCase() + tfCorreo.getText().substring(1, tfCorreo.getText().length());
                        Usuario user = null;
                        Registro regis = new Registro();
                        if (radio1.isSelected()) {
                            if (regis.crearGrupo(tfGrupo.getText(), correo)) {
                                Consultar consulta = new Consultar();
                                Grupo grupo = consulta.consultaGrupoNombre(tfGrupo.getText());
                                if (regis.Registro(user = new Usuario(correo, tfNombre.getText(), contrasenia, tipoUsu, idIcono, grupo.getIdGrupo(), grupo.getNombre()))) {
                                    frame.remove(this);
                                    frame.add(new VentanaUsuario(frame, user));
                                    frame.setVisible(true);
                                    frame.repaint();
                                }
                            }
                        } else if (radio2.isSelected()) {
                            String nombreGrupo = tfGrupo.getText().substring(tfGrupo.getText().lastIndexOf("-") + 1, tfGrupo.getText().length());
                            int id = Integer.valueOf(tfGrupo.getText().substring(0, tfGrupo.getText().lastIndexOf("-")));
                            Consultar consulta = new Consultar();
                            Grupo group = consulta.consultaGrupo(id);
                            if (group.getIdGrupo() != 0) {
                                user = new Usuario(correo, tfNombre.getText(), contrasenia, tipoUsu, idIcono, id, nombreGrupo);
                                if (regis.Registro(user)) {
                                    frame.remove(this);
                                    frame.add(new VentanaUsuario(frame, user));
                                    frame.setVisible(true);
                                    frame.repaint();
                                }
                            } else {
                                lbGrupoError.setText("Error, no existe el grupo");
                            }
                        }
                    }
                    break;
                }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        for (int i = 0; i < 10; i++) {
            if (me.getSource().equals(panelesIconos[i])) {
                idIcono = me.toString().substring(
                        me.toString().lastIndexOf(" ") + 1,
                        me.toString().length()
                );
                if (panelesIconos[i].getName().equals(idIcono)) {
                    panelFormulario.remove(panelLbIcono);
                    panelFormulario.remove(panelErrorIcono);
                    panelIconos.removeAll();
                    tablaIconos();
                    panelesIconos[i].setBorder(BorderFactory.createBevelBorder(
                            0, new Color(54, 171, 163), new Color(54, 171, 163),
                            new Color(32, 84, 106), new Color(32, 84, 106)));
                    panelCentro.repaint();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource().equals(radio1) || me.getSource().equals(radio2)) {
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource().equals(radio1) || me.getSource().equals(radio2)) {
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource().equals(radio1) || me.getSource().equals(radio2)) {
            this.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource().equals(radio1) || me.getSource().equals(radio2)) {
            this.repaint();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource().equals(radio1) || fe.getSource().equals(radio2)) {
            this.repaint();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (fe.getSource().equals(radio1) || fe.getSource().equals(radio2)) {
            this.repaint();
        }
        if (fe.getSource().equals(tfCorreo)) {
            if (!validarEmail(tfCorreo.getText())) {
                lbCorreoError.setText("Error, correo no valido");
            } else {
                lbCorreoError.setText(" ");
            }
            this.repaint();
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        if (radio1.isSelected()) {
            tipoUsu = 1;
        } else if (radio2.isSelected()) {
            tipoUsu = 2;
        }
    }
}
