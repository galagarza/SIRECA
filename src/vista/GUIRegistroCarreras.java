/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlCarrera;
import javax.swing.JOptionPane;
import modelo.RegistroCarreras;

/**
 *
 * @author aaron
 */
public class GUIRegistroCarreras extends javax.swing.JDialog {

    /**
     * Creates new form Agregar
     */
    public GUIRegistroCarreras(java.awt.Frame parent, boolean modal, RegistroCarreras registroCarrera,PanelTablaCarrera guiCarreraT) {
        super(parent, modal);
        initComponents();
        ControlCarrera control = new ControlCarrera(panelCarrera1, this, registroCarrera,guiCarreraT);
        panelBotones.escuchar(control);
    }

    public PanelBotones getPanelB() {
        return this.panelBotones;
    }

    public PanelCarrera getPanelC() {
        return this.panelCarrera1;
    }

    public static void mensaje(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
    public static int mensajeConfirmar(String data) {
      return  JOptionPane.showConfirmDialog(null, data);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCarrera1 = new vista.PanelCarrera();
        panelBotones = new vista.PanelBotones();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelCarrera1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCarrera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.PanelBotones panelBotones;
    private vista.PanelCarrera panelCarrera1;
    // End of variables declaration//GEN-END:variables
}