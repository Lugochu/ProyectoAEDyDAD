/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BD_Manager.Consultar;
import ObjetosBD.Nota;
import ObjetosBD.Usuario;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Lugo
 */
public class Grafica {

    private String tipoGrafico;
    private JFrame frame;
    private Usuario user;
    private ArrayList<Nota> notas;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private int[] cantidadNotas = {0, 0, 0, 0};

    public Grafica(String tipoGrafico, JFrame frame, Usuario user) {
        this.tipoGrafico = tipoGrafico;
        this.frame = frame;
        this.user = user;
        Consultar consulta = new Consultar();
        notas = consulta.consultarNotas(this.user);
        for (Nota nota : notas) {
            switch (nota.getFondoColor()) {
                case 0:
                    cantidadNotas[0]++;
                    break;
                case 1:
                    cantidadNotas[1]++;
                    break;
                case 2:
                    cantidadNotas[2]++;
                    break;
                default:
                    cantidadNotas[3]++;
                    break;
            }
        }
        generarDataset();
        generarGrafico(tipoGrafico, "Cantidad notas", "Colores", "Cantidad");
    }

    public void llenarDataSet(String categoria, int valor, String valorTemporal) {
        dataset.setValue(valor, categoria, valorTemporal);
    }

    public void generarDataset() {
        llenarDataSet("Cantidad notas", cantidadNotas[0], "Notas amarillas");
        llenarDataSet("Cantidad notas", cantidadNotas[1], "Notas verdes");
        llenarDataSet("Cantidad notas", cantidadNotas[2], "Notas azul");
        llenarDataSet("Cantidad notas", cantidadNotas[3], "Notas rosa");

    }

    public void generarGrafico(String tipo, String titulo, String leyenda2, String leyenda) {
        ChartPanel grafico = null;
        JDialog modal = new JDialog(frame, tipoGrafico, Dialog.ModalityType.APPLICATION_MODAL);
        modal.setSize(500, 500);
        JFreeChart chart = null;
        switch (tipo) {
            case "":
            case "Grafico de area":

                chart = ChartFactory.createAreaChart(titulo, leyenda2,
                        leyenda, dataset, PlotOrientation.VERTICAL,
                        true, true, false);

                break;
            case "Grafico de barras":
                chart = ChartFactory.createBarChart3D(titulo,
                        leyenda2, leyenda, dataset, PlotOrientation.VERTICAL,
                        true, true, false);
                break;
            case "Grafico de barras 3D":
                chart = ChartFactory.createBarChart(titulo,
                        leyenda2, leyenda, dataset, PlotOrientation.VERTICAL,
                        true, true, false);
                break;
            case "Grafico de lineas":
                chart = ChartFactory.createLineChart(titulo,
                        leyenda2, leyenda, dataset, PlotOrientation.VERTICAL,
                        true, true, false);
                break;
            case "Grafico de lineas 3D":
                chart = ChartFactory.createLineChart3D(titulo,
                        leyenda2, leyenda, dataset, PlotOrientation.VERTICAL,
                        true, true, false);
                break;
        }
        grafico = new ChartPanel(chart);
        modal.add(grafico);
        modal.setVisible(true);
    }
}
