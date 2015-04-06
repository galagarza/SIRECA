/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.RegistroCarreras;
import vista.GUICarrerasTable;
import vista.GUISIRECA;
import vista.Ventana;

/**
 *
 * @author aaron
 */
public class ControlSIRECA implements ActionListener{
    private Ventana guiSIRECA;
    private RegistroCarreras registroCarrera;

    
    public ControlSIRECA(Ventana guiSIRECA){
        this.guiSIRECA=guiSIRECA;
        registroCarrera=new RegistroCarreras();
    }

    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equalsIgnoreCase(Ventana.MENU_CARRERA)){
            guiSIRECA.dispose();
            
            GUICarrerasTable guiCarrera=new GUICarrerasTable(registroCarrera);
            guiCarrera.setVisible(true);
        }
        if(evento.getActionCommand().equalsIgnoreCase(Ventana.MENU_SALIR)){
            System.exit(0);
        }
        
    }
    
}
