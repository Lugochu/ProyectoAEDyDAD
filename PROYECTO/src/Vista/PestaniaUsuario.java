package Vista;

import BD_Manager.Consultar;
import BD_Manager.CrearNotas;
import BD_Manager.Modificar;
import ObjetosBD.Nota;
import ObjetosBD.Usuario;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PestaniaUsuario extends JPanel implements MouseListener {

    private JMenuItem colorAmarillo;
    private JMenuItem colorVerde;
    private JMenuItem colorAzul;
    private JMenuItem colorRosa;
    private JMenuItem actualizar;
    private JFrame frame;
    private Usuario user;
    private ArrayList<Nota> notas;
    private int altura;

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
        addMenuEmergente();
        addEventos(new ControladorMenus());
        iniciarMiniaturas();
        initComponents();
    }

    public void iniciarMiniaturas() {
        this.removeAll();
        Consultar consulta = new Consultar();
        notas = consulta.consultarNotas(this.user);
        if (!notas.isEmpty()) {
            this.altura = (int) (notas.size() / 5) * 500;
            for (Nota nota : notas) {
                PanelMiniaturas panelRedondeado = new PanelMiniaturas(nota.getTitulo(), nota.getNota(), comprobarColor(nota.getFondoColor()), nota.getIdNota());
                panelRedondeado.addMouseListener(this);
                panelRedondeado.getNota().addMouseListener(this);
                this.add(panelRedondeado);
            }
        } else {
            JLabel etiqueta = new JLabel("Haz click derecho para crear tu primera nota");
            etiqueta.setFont(new Font("Roboto", Font.PLAIN, 30));
            etiqueta.setForeground(Color.white);
            this.add(etiqueta);
        }
        this.updateUI();
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

    public class PanelMiniaturas extends JPanel {

        private int arcw = 40;
        private int arch = 40;
        private Color[] colores;
        private String tituloStr;
        private String notaStr;
        private int idNota;
        private JTextArea nota;

        public PanelMiniaturas(String tituloStr, String notaStr, Color[] colores, int idNota) {
            super();

            this.colores = colores;
            this.tituloStr = tituloStr;
            this.notaStr = notaStr;
            this.idNota = idNota;

            this.setOpaque(false);
            this.setPreferredSize(new Dimension(320, 300));
            this.setLayout(new BorderLayout());
            this.setName(String.valueOf(idNota));
            this.add(panelPosItNorte(), "North");
            this.add(panelPosItCentro(), "Center");
        }

        public JPanel panelPosItNorte() {
            JPanel panelPosItNorte = new JPanel();
            panelPosItNorte.setPreferredSize(new Dimension(0, 50));
            panelPosItNorte.setBackground(colores[0]);

            tituloStr = tituloStr.toUpperCase();
            JLabel titulo = new JLabel(tituloStr);
            titulo.setForeground(Color.white);

            panelPosItNorte.add(titulo);
            return panelPosItNorte;
        }

        public JPanel panelPosItCentro() {
            JPanel panelPosItCentro = new JPanel();
            nota = new JTextArea(notaStr);
            nota.setLineWrap(true);
            nota.setLayout(new GridLayout());
            nota.setName(String.valueOf(idNota));
            nota.setEditable(false);
            nota.setBackground(colores[1]);

            panelPosItCentro.setBackground(colores[1]);
            panelPosItCentro.add(nota);
            panelPosItCentro.setLayout(new CardLayout(20, 10));
            return panelPosItCentro;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Paint oldPaint = g2.getPaint();
            RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                    0, 0, getWidth(), getHeight() - 1, getArcw(), getArch());

            g2.clip(r2d);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setStroke(new BasicStroke(4f));
            g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);

            g2.setPaint(oldPaint);
            super.paintComponent(g);
        }

        public int getArcw() {
            return arcw;
        }

        public void setArcw(int arcw) {
            this.arcw = arcw;
        }

        public int getArch() {
            return arch;
        }

        public void setArch(int arch) {
            this.arch = arch;
        }

        public JTextArea getNota() {
            return nota;
        }

    }

    public class PanelPosIt extends JDialog {

        private String tituloStr;
        private String notaStr;
        private Color[] colores;
        private Nota notaAEditar;
        private JTextArea titulo;
        private JTextArea nota;
        private int opco;

        public PanelPosIt(Color[] colores, int opco) {
            super();
            this.colores = colores;
            this.opco = opco;

            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(500, 600));
            this.add(panelPosItNorte(1), "North");
            this.add(panelPosItCentro(1), "Center");
            this.add(panelPosItSur(1, this), "South");
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

        public PanelPosIt(String tituloStr, String notaStr, Color[] colores, Nota notaAEditar) {
            super();
            this.tituloStr = tituloStr;
            this.notaStr = notaStr;
            this.colores = colores;
            this.notaAEditar = notaAEditar;

            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(500, 600));
            this.setResizable(false);
            this.add(panelPosItNorte(0), "North");
            this.add(panelPosItCentro(0), "Center");
            this.add(panelPosItSur(0, this), "South");
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

        public JPanel panelPosItNorte(int op) {
            JPanel panelPosItNorte = new JPanel();
            panelPosItNorte.setPreferredSize(new Dimension(0, 50));
            panelPosItNorte.setBackground(colores[0]);
            if (op == 0) {
                tituloStr = tituloStr.toUpperCase();
                titulo = new JTextArea(tituloStr);
            } else {
                titulo = new JTextArea(" ");
            }
            titulo.setOpaque(false);
            titulo.setForeground(Color.white);
            panelPosItNorte.add(titulo);
            return panelPosItNorte;
        }

        public JPanel panelPosItCentro(int op) {
            JPanel panelPosItCentro = new JPanel();
            panelPosItCentro.setBackground(colores[1]);
            panelPosItCentro.setLayout(new CardLayout(20, 10));
            if (op == 0) {
                nota = new JTextArea(notaStr);
                nota.setName(String.valueOf(notaAEditar.getIdNota()));
            } else {
                nota = new JTextArea(" ");
            }
            nota.setLineWrap(true);
            nota.setLayout(new GridLayout());
            nota.setBackground(colores[1]);
            panelPosItCentro.add(nota);
            return panelPosItCentro;
        }

        public JPanel panelPosItSur(int op, JDialog padre) {
            JPanel panelPosItSur = new JPanel();
            JPanel panelPosItSurCheckBox = new JPanel();

            JCheckBox negrita = new JCheckBox("Negrita");
            JCheckBox cursiva = new JCheckBox("Cursiva");
            JCheckBox subrayada = new JCheckBox("Subrayada");
            panelPosItSurCheckBox.add(negrita);
            panelPosItSurCheckBox.add(cursiva);
            panelPosItSurCheckBox.add(subrayada);
            JButton boton = new JButton();

            if (op == 0) {
                boton.setText("Actualizar");
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Modificar modificar = new Modificar();
                        notaAEditar.setNota(nota.getText());
                        notaAEditar.setTitulo(titulo.getText());
                        boolean prueba = modificar.modificarNota(notaAEditar);
                        if (prueba) {
                            padre.setVisible(false);
                            iniciarMiniaturas();
                        }
                    }
                });
            } else {
                boton.setText("Crear");
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Nota notaACrear = new Nota(titulo.getText(), nota.getText(), negrita.isSelected(), cursiva.isSelected(), subrayada.isSelected(), opco, new Date(LocalDateTime.now().getMonth().getValue(), LocalDateTime.now().getMonth().getValue(), LocalDateTime.now().getMonth().getValue()), new Date(2021, 11, 1), user.getEmail());
                        CrearNotas crearNotas = new CrearNotas();
                        boolean prueba = crearNotas.crearNota(notaACrear, user);
                        if (prueba) {
                            padre.setVisible(false);
                            iniciarMiniaturas();
                        }
                    }
                });

            }
            JButton botonGuardar = new JButton("Guardar en txt");
            botonGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser filesave = new JFileChooser();
                    filesave.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
                    int returnVal = filesave.showSaveDialog(botonGuardar);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        try {
                            File file = filesave.getSelectedFile();
                            PrintWriter os = new PrintWriter(file);
                            os.print("TITULO: \n" + titulo.getText());
                            os.print("NOTA: \n" + nota.getText());
                            os.close();
                        } catch (IOException e1) {
                        }
                    }
                }
            });
            panelPosItSur.add(panelPosItSurCheckBox);
            panelPosItSur.add(botonGuardar);
            panelPosItSur.add(boton);
            return panelPosItSur;
        }
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

    private class ControladorMenus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Amarillo":
                    new PanelPosIt(comprobarColor(0), 0);
                    break;
                case "Verde":
                    new PanelPosIt(comprobarColor(1), 1);
                    break;
                case "Azul":
                    new PanelPosIt(comprobarColor(2), 2);
                    break;
                case "Rosa":
                    new PanelPosIt(comprobarColor(3), 3);
                    break;
                case "Actualizar":
                    break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getClickCount() == 2) {
            String idNota = me.toString().substring(me.toString().lastIndexOf(" ") + 1, me.toString().length());
            Consultar consulta = new Consultar();
            Nota nota = consulta.consultarNota(Integer.valueOf(idNota));
            new PanelPosIt(nota.getTitulo(), nota.getNota(), comprobarColor(nota.getFondoColor()), nota);
            this.repaint();
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

    private void initComponents() {
        setOpaque(false);
        setLayout(new FlowLayout(1, 50, 50));
        setPreferredSize(new Dimension(frame.getWidth(), altura));

    }

}
