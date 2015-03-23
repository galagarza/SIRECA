/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Carrera;
import modelo.RegistroCarreras;
import vista.GUIRegistroCarreras;
import vista.GUICarrerasTable;
import vista.PanelBotones;
import vista.PanelCarrera;
import vista.PanelTablaCarrera;
import vista.Ventana;

/**
 *
 * @author aaron
 */
public class ControlTablaCarrera implements ActionListener, ItemListener, MouseListener {

    private RegistroCarreras registroCarrera;
    private PanelTablaCarrera guiCarreraT;
    private int controlBusca = 0;
    private PanelBotones panelB;

    public ControlTablaCarrera(RegistroCarreras registroCarrera, PanelTablaCarrera guiCarreraT) {
        this.registroCarrera = registroCarrera;
        this.guiCarreraT = guiCarreraT;
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equalsIgnoreCase(PanelTablaCarrera.BTN_AGREGAR)) {
            GUIRegistroCarreras agregar = new GUIRegistroCarreras(null, true, registroCarrera, guiCarreraT);

            panelB = agregar.getPanelB();
            panelB.enableModDel(false);
            agregar.setVisible(true);
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelTablaCarrera.BTN_BUSCAR)) {
            if (controlBusca == 1) {
                guiCarreraT.setValores(
                        registroCarrera.getMatrizBuscar(guiCarreraT.getTxtConsulta(), 1),
                        Carrera.getEtiquetas());
                guiCarreraT.limpiar();
            }
            if (controlBusca == 2) {
                guiCarreraT.setValores(
                        registroCarrera.getMatrizBuscar(guiCarreraT.getTxtConsulta(), 2),
                        Carrera.getEtiquetas());
                guiCarreraT.limpiar();
            }
            if (controlBusca == 3) {
                guiCarreraT.setValores(
                        registroCarrera.getMatrizBuscar(guiCarreraT.getTxtConsulta(), 3),
                        Carrera.getEtiquetas());
                guiCarreraT.limpiar();
            }
        }

    }

    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            if (this.guiCarreraT.getCombo().equalsIgnoreCase("All")) {
//                Agregar.mensaje("All");
                guiCarreraT.editableCampoBuscar(false);

                guiCarreraT.setValores(registroCarrera.getMatrizCarreras(), Carrera.getEtiquetas());
            }
            if (this.guiCarreraT.getCombo().equalsIgnoreCase("Sigla")) {
                guiCarreraT.setEtiqueta("Sigla:");
                guiCarreraT.editableCampoBuscar(true);
                controlBusca = 1;

            }
            if (this.guiCarreraT.getCombo().equalsIgnoreCase("Nombre")) {
                guiCarreraT.setEtiqueta("Nombre:");
                guiCarreraT.editableCampoBuscar(true);
                controlBusca = 2;
            }
            if (this.guiCarreraT.getCombo().equalsIgnoreCase("Categoria")) {
                guiCarreraT.setEtiqueta("Categoría:");
                guiCarreraT.editableCampoBuscar(true);
                controlBusca = 3;
            }
        }
    }

    public void mouseClicked(MouseEvent me) {
        String[] datosFila = guiCarreraT.getdatosFila();
        GUIRegistroCarreras agrega = new GUIRegistroCarreras(null, true, registroCarrera, guiCarreraT);
        PanelCarrera panelC = agrega.getPanelC();
        panelC.setTxtSigla(datosFila[0]);
        panelC.setTxtNombre(datosFila[1]);
        panelC.setTxtCategoria(datosFila[2]);
        panelB = agrega.getPanelB();
        panelB.enableAgregar(false);
        panelB.enableModDel(true);
        agrega.setVisible(true);

    }

    public void mousePressed(MouseEvent me) {
        System.err.println(me.getX());
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

}
