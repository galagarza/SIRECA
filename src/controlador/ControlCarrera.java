/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Carrera;
import modelo.RegistroCarreras;

import vista.GUIRegistroCarreras;
import vista.PanelBotones;
import vista.PanelCarrera;
import vista.PanelTablaCarrera;
import vista.Ventana;

/**
 *
 * @author aaron
 */
public class ControlCarrera implements ActionListener {

    private PanelCarrera panelCarrera;
    GUIRegistroCarreras agregar;
    RegistroCarreras registroCarrera;
    PanelTablaCarrera guiCarreraT;

    public ControlCarrera(PanelCarrera panelCarrera, GUIRegistroCarreras agregar, RegistroCarreras registroCarrera, PanelTablaCarrera guiCarreraT) {
        this.panelCarrera = panelCarrera;
        this.registroCarrera = registroCarrera;
        this.agregar = agregar;
        this.guiCarreraT = guiCarreraT;
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_AGREGAR)) {
            if (panelCarrera.getTxtSigla().equalsIgnoreCase("")) {
                GUIRegistroCarreras.mensaje("Debe ingresar la sigla de la carrera");
            } else if (panelCarrera.getTxtNombre().equalsIgnoreCase("")) {
                GUIRegistroCarreras.mensaje("Debe agregar el nombre de la carrera.");
            } else {
                GUIRegistroCarreras.mensaje(registroCarrera.agregarCarrera(new Carrera(panelCarrera.getTxtSigla(), panelCarrera.getTxtNombre(), panelCarrera.getCbCategoria())));
                panelCarrera.limpiar();
                guiCarreraT.setValores(registroCarrera.getMatrizCarreras(), Carrera.getEtiquetas());
                if (GUIRegistroCarreras.mensajeConfirmar("Desea agregar otra carrera?") == 1) {
                    agregar.dispose();
                }
            }
        }//fin de agregar
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_MODIFICAR)) {
            //Ventana.mensaje(registroCarrera.consultarTodo());
            guiCarreraT.setValores(registroCarrera.getMatrizCarreras(), Carrera.getEtiquetas());
            agregar.dispose();
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_ELIMINAR)) {
            // System.exit(0);
            Ventana.mensaje(registroCarrera.deleteEstudiante(new Carrera(panelCarrera.getTxtSigla(), panelCarrera.getTxtNombre(), panelCarrera.getCbCategoria())));
            guiCarreraT.setValores(registroCarrera.getMatrizCarreras(), Carrera.getEtiquetas());
            agregar.dispose();
        }
    }

}
