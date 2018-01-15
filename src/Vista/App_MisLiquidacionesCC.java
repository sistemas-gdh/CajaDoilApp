/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conn.Conexion;
import Controlador.Helper;
import Controlador.HelperMCD;
import Controlador.HelperMCS;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Luis
 */
public class App_MisLiquidacionesCC extends javax.swing.JInternalFrame {

    /**
     * Creates new form App_MisSolicitudesCC
     */
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel mod = new DefaultTableModel();
    HelperMCD oMCD;
    HelperMCS oMCS;
    Helper oper;   
   
    public void updateT(int estado,int band,String busq) {
        oper.limpiaTabla(modelo, tablas);
        if(band == 1){
           modelo = oMCS.getMcsByUser(modelo, Integer.parseInt(App_Principal.codigo.getText()),estado); 
        }else{
           modelo = oMCS.getMcsByUserSerie(modelo, Integer.parseInt(App_Principal.codigo.getText()), busq);
        }
        tablas.setModel(modelo);
    }
    public void updateTD(int estado,int band,String busq) {
        oper.limpiaTabla(mod, tablad);
        if(band == 1){
            mod = oMCD.getMcdByUser(mod, Integer.parseInt(App_Principal.codigo.getText()),estado);
        }else{
            mod = oMCD.getMcdByUserSerie(mod, Integer.parseInt(App_Principal.codigo.getText()),busq);
        }
        tablad.setModel(mod);
    }
    
    Conexion conn = new Conexion();
    
    public App_MisLiquidacionesCC() {
        initComponents();
        String Titulos[]={"ID","SERIE","FECHA","DESCRIPCIÓN","IMPORTE","LIQUIDADO","ESTADO"};
        modelo.setColumnIdentifiers(Titulos);
        mod.setColumnIdentifiers(Titulos);
        oper = new Helper();
        oMCD = new HelperMCD();
        oMCS = new HelperMCS();
        modelo = oMCS.getMcsByUser(modelo, Integer.parseInt(App_Principal.codigo.getText()),0);
        mod = oMCD.getMcdByUser(mod, Integer.parseInt(App_Principal.codigo.getText()),0);
        tablas.setModel(modelo);
        tablad.setModel(mod);
        tablas.getColumnModel().getColumn(0).setPreferredWidth(1);// 
        tablas.getColumnModel().getColumn(1).setPreferredWidth(125);
        tablas.getColumnModel().getColumn(2).setPreferredWidth(75);
        tablas.getColumnModel().getColumn(3).setPreferredWidth(200);
        tablas.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablas.getColumnModel().getColumn(5).setPreferredWidth(50);
        tablas.getColumnModel().getColumn(6).setPreferredWidth(50);
        tablad.getColumnModel().getColumn(0).setPreferredWidth(1);// 
        tablad.getColumnModel().getColumn(1).setPreferredWidth(125);
        tablad.getColumnModel().getColumn(2).setPreferredWidth(75);
        tablad.getColumnModel().getColumn(3).setPreferredWidth(200);
        tablad.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablad.getColumnModel().getColumn(5).setPreferredWidth(50);
        tablad.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboSearch = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablad = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboSearch1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        buscar1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablas = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIQUIDACIONES EN DOLARES:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 12), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("BUSCAR:");

        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POR LIQUIDAR", "SUBIDO", "V° B° DE CAJA", "V° B° DE GERENCIA", "OBSERVADO", "CERRADO" }));

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jButton3.setText("CARGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buscar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(tablad);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jButton1.setText("VER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIQUIDACIONES EN SOLES:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 12), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("BUSCAR:");

        cboSearch1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POR LIQUIDAR", "SUBIDO", "V° B° DE CAJA", "V° B° DE GERENCIA", "OBSERVADO", "CERRRADA" }));

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jButton4.setText("CARGAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buscar1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar1KeyReleased(evt);
            }
        });

        jScrollPane2.setViewportView(tablas);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jButton5.setText("VER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(buscar1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (tablad.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato");
        } else {
            try {
                conn.conectar();

                String dir = "C:\\cajareport\\report_scc.jrxml";
                Map parametros = new HashMap();
                parametros.put("codscc", Integer.parseInt(tablad.getValueAt(tablad.getSelectedRow(), 0).toString()));
                JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, parametros, conn.getConn());
                JasperViewer.viewReport(mostrarReporte, false);
            } catch (JRException | ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int estado = cboSearch.getSelectedIndex();
        if(estado  == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opción");
        }else{
           updateTD(estado,1,"");
        }
               
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        // TODO add your handling code here:
        updateTD(0,2,buscar.getText());
        
    }//GEN-LAST:event_buscarKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int estado = cboSearch1.getSelectedIndex();
        if (estado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opción");
        } else {
            updateT(estado,1,"");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar1KeyReleased
        // TODO add your handling code here:
         updateT(0,2,buscar.getText());
    }//GEN-LAST:event_buscar1KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                if (tablas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato");
        } else {
            try {
                conn.conectar();

                String dir = "C:\\cajareport\\mcs_report.jrxml";
                Map parametros = new HashMap();
                parametros.put("mcsid", Long.parseLong(tablas.getValueAt(tablas.getSelectedRow(), 0).toString()));
                JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, parametros, conn.getConn());
                JasperViewer.viewReport(mostrarReporte, false);
            } catch (JRException | ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField buscar1;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JComboBox<String> cboSearch1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablad;
    private javax.swing.JTable tablas;
    // End of variables declaration//GEN-END:variables
}