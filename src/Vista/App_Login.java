/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Helper;
import Controlador.HelperUsuarios;
import Modelo.Usuarios;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Maestro
 */
public class App_Login extends javax.swing.JFrame {

    /**
     * Creates new form App_LoginF
     */
    
    
    public void bloqPermisos(int permisos)
    {
        switch(permisos)
        {
            case 1:
                break;
            case 2:
                  App_Principal.obsB.setEnabled(false);
                  App_Principal.denB.setEnabled(false);
                  App_Principal.apB.setEnabled(false);
                  App_Principal.obsB1.setEnabled(false);
                  App_Principal.denB1.setEnabled(false);
                  App_Principal.apB1.setEnabled(false);
                  App_Principal.gerencia.setVisible(false);
                  App_Principal.transportes.setVisible(false);
                break;
            case 3:
//                App_Principal.archivo.setEnabled(false);
                  App_Principal.incaja.setEnabled(false);
                  App_Principal.ecch.setEnabled(false);
                  App_Principal.ecch1.setEnabled(false);
                break;
            case 4:
                App_Principal.mcaja.setEnabled(false);
                App_Principal.panelSCC.setVisible(false);
                App_Principal.gerencia.setVisible(false);
                App_Principal.panelSV.setVisible(false);
                break;
            case 5:
                App_Principal.mcaja.setEnabled(false);
                App_Principal.panelSV.setVisible(false);
                App_Principal.gerencia.setVisible(false);
                App_Principal.transportes.setVisible(false);
                break;
                
                
        }
    }    
    
    
    Helper oper;
    HelperUsuarios oU;
    public App_Login() {
        super("SYS DOMINGUEZ HERRERA");
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/reportes/finanzas.png")).getImage());
        oper = new Helper();
        oU = new HelperUsuarios();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboP1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cboP = new javax.swing.JComboBox<>();

        cboP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "ROOT", "FINANZAS", "GERENCIA", "COMERCIAL" }));
        cboP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboP1KeyPressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("USUARIO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CONTRASEÑA:");

        txtuser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtuser.setText("willymb");

        btnAcceder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAcceder.setText("ACCEDER");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpass.setText("2000");
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("PERMISOS:");

        cboP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "ROOT", "FINANZAS", "GERENCIA", "TRANSPORTES", "PRODUCCION", "PROYECTOS", "CALIDAD", "LOGISTICA & SISTEMAS" }));
        cboP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboPKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpass)
                            .addComponent(txtuser)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(cboP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcceder)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceder)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtuser.setText("");
        txtpass.setText("");
        txtuser.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        // TODO add your handling code here:
        String user = txtuser.getText();
        String pw   = txtpass.getText();
        int permisos = cboP.getSelectedIndex();
        if(cboP.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Selector en blanco");
        }else{
            if(oper.validarUsuario(user, pw,permisos)==true){
            App_Principal app = new App_Principal();
            app.setExtendedState(MAXIMIZED_BOTH);
            Usuarios u = oU.getCUser(user);
            app.nombre.setText(u.getUsuarioNombres());
            app.codigoU = u.getUsuarioId();
            app.codigo.setText(String.valueOf(u.getUsuarioId()));
            app.permisos = u.getUsuarioPermisos();
            bloqPermisos(permisos);
            app.setVisible(true);
            this.dispose();
        JOptionPane.showMessageDialog(null,"Bienvenido al sistema: "+user);
        }else{
            JOptionPane.showMessageDialog(null,"Error: Verifique usuario - contraseña o credenciales");
        }  
        }


    }//GEN-LAST:event_btnAccederActionPerformed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        char cTeclaPresionada = evt.getKeyChar();

        //Da click al boton elegido
        if(cTeclaPresionada==KeyEvent.VK_ENTER){
            btnAcceder.doClick();
        }
    }//GEN-LAST:event_txtpassKeyPressed

    private void cboPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboPKeyPressed
        // TODO add your handling code here:}
        char cTeclaPresionada = evt.getKeyChar();
        //Da click al boton elegido
        if(cTeclaPresionada==KeyEvent.VK_ENTER){
            btnAcceder.doClick();
        }
    }//GEN-LAST:event_cboPKeyPressed

    private void cboP1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboP1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboP1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JComboBox<String> cboP;
    private javax.swing.JComboBox<String> cboP1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
