/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlSIRECA;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form GUIPrincipal
     */
    public Ventana() {
        initComponents();
        ControlSIRECA control=new ControlSIRECA(this);
        this.escuchar(control);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miCarrera = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        miSalir.setText("Salir");
        jMenu1.add(miSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registro");

        miCarrera.setText("Carreras");
        jMenu2.add(miCarrera);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miCarrera;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables

    public void escuchar(ActionListener control){
        this.miCarrera.addActionListener(control);
        this.miSalir.addActionListener(control);
    }
    
    public static final String MENU_SALIR="Salir";
    public static final String MENU_CARRERA="Carreras";
    
    public static void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, mensaje, WIDTH);
    }

}