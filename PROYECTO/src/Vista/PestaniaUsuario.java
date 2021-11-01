package Vista;

import Datos.Consultar;
import Datos.CrearNotas;
import Datos.Modificar;
import Datos.Nota;
import Datos.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.*;

public class PestaniaUsuario extends JPanel implements MouseListener {

    private JMenuItem colorAmarillo;
    private JMenuItem colorVerde;
    private JMenuItem colorAzul;
    private JMenuItem colorRosa;
    private JMenuItem actualizar;
    private JFrame frame;
    private Usuario user;
    private ArrayList<Nota> notas;

    private final Color amarillo = new Color(247, 243, 146);
    private final Color amarilloOscuro = new Color(236, 232, 117);

    private final Color verde = new Color(207, 248, 172);
    private final Color verdeOscuro = new Color(179, 232, 134);

    private final Color azul = new Color(187, 207, 242);
    private final Color azulOscuro = new Color(152, 180, 228);

    private final Color rosa = new Color(242, 182, 234);
    private final Color rosaOscuro = new Color(228, 154, 218);

    public PestaniaUsuario(JFrame frame, Usuario user) {
        this.frame = frame;
        this.user = user;
        initComponents();
        addMenuEmergente();
        addEventos(new ControladorMenus(this));
        iniciarMiniaturas();
    }

    public void iniciarMiniaturas() {
        this.removeAll();
        Consultar consulta = new Consultar();
        notas = consulta.consultarNotas("root", "Pantalla1", this.user);

        for (Nota nota : notas) {

            this.add(panelPosItMiniatura(nota.getTitulo(), nota.getNota(), comprobarColor(nota.getFondoColor()), nota.getIdNota()));
            System.out.println(nota.toString());
        }
        this.repaint();
    }

    private final void addEventos(ControladorMenus controlador) {
        colorVerde.addActionListener(controlador);
        colorAmarillo.addActionListener(controlador);
        colorAzul.addActionListener(controlador);
        colorRosa.addActionListener(controlador);
        actualizar.addActionListener(controlador);
    }

    private final void addMenuEmergente() {
        JPopupMenu menuEmergente = new JPopupMenu();

        JMenu nuevaNota = new JMenu("Nueva nota");
        colorAmarillo = new JMenuItem("Amarillo");
        colorVerde = new JMenuItem("Verde");
        colorAzul = new JMenuItem("Azul");
        colorRosa = new JMenuItem("Rosa");

        actualizar = new JMenuItem("Actualizar");

        nuevaNota.add(colorAmarillo);
        nuevaNota.add(colorVerde);
        nuevaNota.add(colorAzul);
        nuevaNota.add(colorRosa);

        menuEmergente.add(nuevaNota);
        menuEmergente.add(actualizar);

        this.setComponentPopupMenu(menuEmergente);
    }

    public JPanel panelPosItMiniatura(String tituloStr, String notaStr, Color[] colores, int idNota) {
        JPanel panelPosIt = new JPanel();
        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();

        tituloStr = tituloStr.toUpperCase();
        JLabel titulo = new JLabel(tituloStr);
        titulo.setForeground(Color.white);

        JTextArea nota = new JTextArea(notaStr);

        nota.setLineWrap(true);
        nota.setLayout(new GridLayout());
        nota.setName(String.valueOf(idNota));
        nota.addMouseListener(this);
        nota.setEditable(false);
        nota.setBackground(colores[1]);

        panelPosIt.setPreferredSize(new Dimension(320, 300));
        panelPosItNorte.setPreferredSize(new Dimension(0, 50));

        panelPosItNorte.setBackground(colores[0]);
        panelPosItNorte.add(titulo);
        panelPosItCentro.setBackground(colores[1]);
        panelPosItCentro.add(nota);
        panelPosItCentro.setLayout(new CardLayout(20, 10));

        panelPosIt.setLayout(new BorderLayout());
        panelPosIt.add(panelPosItNorte, "North");
        panelPosIt.add(panelPosItCentro, "Center");
        panelPosIt.setName(String.valueOf(idNota));
        panelPosIt.addMouseListener(this);
        return panelPosIt;
    }

    public void panelEditarPosIt(String tituloStr, String notaStr, Color[] colores, Nota notaAEditar) {
        JDialog panelPosItModal = new JDialog(frame, tituloStr);

        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();
        JPanel panelPosItSur = new JPanel();

        panelPosItNorte.setPreferredSize(new Dimension(0, 50));
        panelPosItNorte.setBackground(colores[0]);
        tituloStr = tituloStr.toUpperCase();
        JTextArea titulo = new JTextArea(tituloStr);
        titulo.setOpaque(false);

        titulo.setForeground(Color.white);
        panelPosItNorte.add(titulo);

        panelPosItCentro.setBackground(colores[1]);
        panelPosItCentro.setLayout(new CardLayout(20, 10));
        JTextArea nota = new JTextArea(notaStr);

        nota.setLineWrap(true);
        nota.setLayout(new GridLayout());
        nota.setName(String.valueOf(notaAEditar.getIdNota()));
        nota.setBackground(colores[1]);
        panelPosItCentro.add(nota);
        JCheckBox negrita = new JCheckBox();
        JCheckBox cursiva = new JCheckBox();
        JCheckBox subrayada = new JCheckBox();
        panelPosItSur.add(negrita);
        panelPosItSur.add(cursiva);
        panelPosItSur.add(subrayada);
        JButton boton = new JButton("Actualizar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Modificar modificar = new Modificar();
                notaAEditar.setNota(nota.getText());
                notaAEditar.setTitulo(titulo.getText());
                boolean prueba = modificar.modificarNota("root", "Pantalla1", notaAEditar);
                if (prueba) {
                    panelPosItModal.setVisible(false);
                    iniciarMiniaturas();
                }
            }
        });
        panelPosItSur.add(boton);

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

    public void panelCrearPosIt(Color[] colores, int opco) {
        JDialog panelPosItModal = new JDialog(frame);

        JPanel panelPosItNorte = new JPanel();
        JPanel panelPosItCentro = new JPanel();
        JPanel panelPosItSur = new JPanel();

        panelPosItNorte.setPreferredSize(new Dimension(0, 50));
        panelPosItNorte.setBackground(colores[0]);
        panelPosItCentro.setBackground(colores[1]);
        panelPosItCentro.setLayout(new CardLayout(20, 10));
        JTextArea titulo = new JTextArea(" ");
        titulo.setOpaque(false);
        titulo.setForeground(Color.white);
        panelPosItNorte.add(titulo);

        JTextArea nota = new JTextArea(" ");
        nota.setLineWrap(true);
        nota.setLayout(new GridLayout());
        nota.setBackground(colores[1]);
        panelPosItCentro.add(nota);
        JCheckBox negrita = new JCheckBox();
        JCheckBox cursiva = new JCheckBox();
        JCheckBox subrayada = new JCheckBox();
        panelPosItSur.add(negrita);
        panelPosItSur.add(cursiva);
        panelPosItSur.add(subrayada);
        JButton boton = new JButton("Guardar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Nota notaACrear = new Nota(titulo.getText(),nota.getText(),negrita.isSelected(),cursiva.isSelected(),subrayada.isSelected(),opco,new Date(2021,11,1),new Date(2021,11,1),user.getEmail());
                CrearNotas crearNotas = new CrearNotas();
                boolean prueba = crearNotas.crearNota("root", "Pantalla1", notaACrear,user);
                if (prueba) {
                    panelPosItModal.setVisible(false);
                    iniciarMiniaturas();
                }
            }
        });
        panelPosItSur.add(boton);
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

    public Color[] comprobarColor(int numColor) {
        Color[] color = new Color[2];
        switch (numColor) {
            case 0:
                color[0] = amarilloOscuro;
                color[1] = amarillo;
                break;
            case 1:
                color[0] = verdeOscuro;
                color[1] = verde;
                break;
            case 2:
                color[0] = azulOscuro;
                color[1] = azul;
                break;
            case 3:
                color[0] = rosaOscuro;
                color[1] = rosa;
                break;
        }
        return color;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getClickCount() == 2) {
            String idNota = me.toString().substring(me.toString().lastIndexOf(" ") + 1, me.toString().length());
            Consultar consulta = new Consultar();
            Nota nota = consulta.consultarNota("root", "Pantalla1", Integer.valueOf(idNota));
            panelEditarPosIt(nota.getTitulo(), nota.getNota(), comprobarColor(nota.getFondoColor()), nota);
        }
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

    private class ControladorMenus implements ActionListener {

        private JPanel panel;

        public ControladorMenus(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Amarillo":
                    panelCrearPosIt(comprobarColor(0),0);
                    break;
                case "Verde":
                    panelCrearPosIt(comprobarColor(1),1);
                    break;
                case "Azul":
                    panelCrearPosIt(comprobarColor(2),2);
                    break;
                case "Rosa":
                    panelCrearPosIt(comprobarColor(3),3);
                    break;
                case "Actualizar":
                    break;
            }
        }

    }

    private void initComponents() {
        setOpaque(false);
        setLayout(new FlowLayout(3, 50, 50));
    }

}
