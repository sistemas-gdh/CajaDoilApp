/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Helper;
import Controlador.HelperMCD;
import Controlador.HelperMCS;
import Controlador.HelperSCD;
import Controlador.HelperSCS;
import Controlador.HelperUsuarios;
import Modelo.MovimientosCajas;
import Modelo.MovimientosCajasd;
import Modelo.SaldoCajad;
import Modelo.SaldoCajas;
import Modelo.Usuarios;

/**
 *
 * @author Luis
 */
public class App_InCajaChica extends javax.swing.JInternalFrame {

    /**
     * Creates new form App_InCajaChica
     */
    Helper oper;
    HelperUsuarios oU;
    HelperMCS oMCS;
    HelperMCD oMCD;
    HelperSCS oSCS;
    HelperSCD oSCD;
    
    public App_InCajaChica() {
        initComponents();
        oper = new Helper();
        oU = new HelperUsuarios();
        oMCS = new HelperMCS();
        oMCD = new HelperMCD();
        oSCS = new HelperSCS();
        oSCD = new HelperSCD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechai = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        moneda = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Descripción:");

        desc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESO DE CAJA CHICA");

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Importe:");

        jButton1.setText("NUEVA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Moneda:");

        moneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<>", "SOLES", "DOLARES" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(desc))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fechai, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(monto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fechai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        desc.setText("");
        fechai.setDate(null);
        monto.setText("");
        moneda.setSelectedIndex(0);
        desc.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Usuarios uu = oU.buscaUsuarios(Integer.parseInt(App_Principal.codigo.getText()));
        
        double mont = Double.parseDouble(monto.getText());
        if(moneda.getSelectedIndex()==1){
            MovimientosCajas temppc = oMCS.getLast();
            long corr = 0;
            if (temppc == null) {
                corr = 1;
            } else {
                corr = temppc.getMcsId() + 1;
            }

            String serie = oper.generarSerie(corr, 2);
            MovimientosCajas mcsx = new MovimientosCajas(uu, serie, fechai.getDate(), desc.getText(), mont, mont, 0.0, 0.0, uu.getUsuarioId(), 100, corr, 1,1);
            oper.registrar(mcsx);
            MovimientosCajas tmcsx = oMCS.buscaMCS(oper.getNextID());
            SaldoCajas tempsc = oSCS.getLast();
            if(tempsc == null){
                SaldoCajas scx = new SaldoCajas(tmcsx,mont,0.0,mont,0);
                oper.registrar(scx);
            }else{
               SaldoCajas scx = new SaldoCajas(tmcsx,mont,0.0,tempsc.getScsSaldo()+mont,0); 
               oper.registrar(scx);
            }
        }else{
            MovimientosCajasd temppc = oMCD.getLast();
            long corr = 0;
            if (temppc == null) {
                corr = 1;
            } else {
                corr = temppc.getMcdId() + 1;
            }

            String serie = oper.generarSerie(corr, 2);
            MovimientosCajasd mcdx = new MovimientosCajasd(uu, serie, fechai.getDate(), desc.getText(), mont, mont, 0.0, 0.0, uu.getUsuarioId(), 100, corr, 1);
            oper.registrar(mcdx);
            MovimientosCajasd tmcsx = oMCD.buscaMCD(oper.getNextID());
            SaldoCajad tempscd = oSCD.getLast();
            if(tempscd == null){
                SaldoCajad scx = new SaldoCajad(tmcsx,mont,0.0,mont,0);
                oper.registrar(scx);
            }else{
               SaldoCajad scx = new SaldoCajad(tmcsx,mont,0.0,tempscd.getScdSaldo()+mont,0); 
               oper.registrar(scx);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc;
    private com.toedter.calendar.JDateChooser fechai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> moneda;
    private javax.swing.JTextField monto;
    // End of variables declaration//GEN-END:variables
}
