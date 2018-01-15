/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Helper;
import Controlador.HelperSV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class App_PreLiqViaticos extends javax.swing.JInternalFrame {

    /**
     * Creates new form App_PreLiqViaticos
     */
    DefaultTableModel modelo = new DefaultTableModel();
    HelperSV oSV;
    Helper oper;   
   
    public void updateT() {
        oper.limpiaTabla(modelo, tabla);
        modelo = oSV.searchSV(modelo, Integer.parseInt(App_Principal.codigo.getText()),0);
        tabla.setModel(modelo);
    }

    
        private Timer timer;
    /*
     * 1000ms ---- 1s
     *  120.000ms = 2m
     * */
    private int delay = 60000;
    
    
    public void correr(){
        
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ActionListener action = new ActionListener()
                {   
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        updateT();

                    }
                };
 
                timer = new Timer(delay, action);
                timer.setInitialDelay(0);
                timer.start();
            }
        });
    }
    
    public App_PreLiqViaticos() {
        initComponents();
                initComponents();
        String Titulos[]={"ID","SERIE","FECHA","DESCRIPCIÓN","IMPORTE","LIQUIDADO","ESTADO"};
        modelo.setColumnIdentifiers(Titulos);
        oper = new Helper();
        oSV = new HelperSV();
        modelo = oSV.searchSV(modelo, Integer.parseInt(App_Principal.codigo.getText()),0);
        tabla.setModel(modelo);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(1);// 
        tabla.getColumnModel().getColumn(1).setPreferredWidth(125);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(75);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.correr();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VALIDACIONES PENDIENTES DE VIATICOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 14))); // NOI18N

        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("ABRIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                if(tabla.getSelectedRow()==-1 && tabla.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UNA LIQUIDACIÓN PENDIENTE");
        } else if (tabla.getSelectedRow() >= 0) {
            int fila = tabla.getSelectedRow();
//            App_LiqCCPendientes.codLiq = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
//            App_LiqCCPendientes.bandera = 1;
//            App_LiqCCPendientes eP = new App_LiqCCPendientes();
//            App_Principal.escritorio.add(eP);
//            eP.setLocation(100, 100);
//            eP.show();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}