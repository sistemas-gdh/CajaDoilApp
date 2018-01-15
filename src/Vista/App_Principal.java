/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conn.Conexion;
import Controlador.Helper;
import Controlador.HelperDSCC;
import Controlador.HelperMCD;
import Controlador.HelperMCS;
import Controlador.HelperSCC;
import Controlador.HelperSCD;
import Controlador.HelperSCS;
import Controlador.HelperSV;
import Controlador.HelperUnidadM;
import Controlador.HelperUsuarios;
import Modelo.DetalleMcd;
import Modelo.DetalleMcs;
import Modelo.DetalleSc;
import Modelo.MovimientosCajas;
import Modelo.MovimientosCajasd;
import Modelo.SaldoCajad;
import Modelo.SaldoCajas;
import Modelo.SolicitudCaja;
import Modelo.Usuarios;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luisv
 */
public class App_Principal extends javax.swing.JFrame {

    /**
     * Creates new form App_Principal
     */
    
    public static int permisos;
    public static int codigoU;
    
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel md = new DefaultTableModel();
    
    Conexion conn = new Conexion();
    
    public void updateT(){
        oper.limpiaTabla(modelo,tablascc);
        modelo = oSCC.obtenerSCC(modelo,permisos,codigoU);
        tablascc.setModel(modelo);
    }  
    
        public void updateTSV(){
        oper.limpiaTabla(md,tablasv);
        md = oSV.obtenerSV(md,permisos,codigoU);
        tablasv.setModel(md);
    }  
    
    Helper oper;
    HelperSCC oSCC;
    HelperUsuarios oU;
    HelperMCS oMCS;
    HelperDSCC oDSCC;
    HelperUnidadM oUM;
    HelperMCD oMCD;
    HelperSCS oSCS;
    HelperSCD oSCD;
    HelperSV oSV;
    
    private Timer timer;
    /*
     * 1000ms ---- 1s
     *  120.000ms = 2m
     * */
    private int delay = 15000;
    
    
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
                        updateTSV();
                    }
                };
 
                timer = new Timer(delay, action);
                timer.setInitialDelay(0);
                timer.start();
            }
        });
    }
    
    public App_Principal() {
        super("SYS DOMINGUEZ HERRERA");
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/reportes/finanzas.png")).getImage());
        oper = new Helper();
        oSCC = new HelperSCC();
        oU = new HelperUsuarios();
        oMCS = new HelperMCS();
        oDSCC = new HelperDSCC();
        oUM = new HelperUnidadM();
        oMCD = new HelperMCD();
        oSCS = new HelperSCS();
        oSCD = new HelperSCD();
        oSV = new HelperSV();
        
        String t[]={"ID","SERIE","FECHA","DESCRIPCION","RESPONSABLE","AREA","IMPORTE","MONEDA","G.GENERAL","G.COMERCIAL","ADMIN.","BYPASS"};
        modelo.setColumnIdentifiers(t);
        modelo = oSCC.obtenerSCC(modelo,permisos,codigoU);
        tablascc.setModel(modelo);
        tablascc.getColumnModel().getColumn(0).setPreferredWidth(1);// 
        tablascc.getColumnModel().getColumn(1).setPreferredWidth(90);
        tablascc.getColumnModel().getColumn(2).setPreferredWidth(105);
        tablascc.getColumnModel().getColumn(3).setPreferredWidth(125);
        tablascc.getColumnModel().getColumn(4).setPreferredWidth(125);
        tablascc.getColumnModel().getColumn(5).setPreferredWidth(95);
        tablascc.getColumnModel().getColumn(6).setPreferredWidth(35);
        tablascc.getColumnModel().getColumn(7).setPreferredWidth(35);
        tablascc.getColumnModel().getColumn(8).setPreferredWidth(35);
        tablascc.getColumnModel().getColumn(9).setPreferredWidth(35);
        tablascc.getColumnModel().getColumn(10).setPreferredWidth(35);
        tablascc.getColumnModel().getColumn(11).setPreferredWidth(35);
        md.setColumnIdentifiers(t);
        md = oSV.obtenerSV(md,permisos,codigoU);
        tablasv.setModel(md);
        
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

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        panelSV = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablasv = new javax.swing.JTable();
        apB = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        denB = new javax.swing.JButton();
        obsB = new javax.swing.JButton();
        ecch = new javax.swing.JButton();
        panelSCC = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablascc = new javax.swing.JTable();
        apB1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        denB1 = new javax.swing.JButton();
        obsB1 = new javax.swing.JButton();
        ecch1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        mcaja = new javax.swing.JMenu();
        incaja = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        gerencia = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        transportes = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        nombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        nombre.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel3.setText("ID:");

        codigo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        codigo.setText("jLabel3");

        panelSV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SOLICITUDES DE VIATICOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 14))); // NOI18N

        tablasv.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tablasv);

        apB.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        apB.setForeground(new java.awt.Color(0, 102, 51));
        apB.setText("APROBAR");
        apB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apBActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 204));
        jButton3.setText("VER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        denB.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        denB.setForeground(new java.awt.Color(255, 0, 0));
        denB.setText("DENEGAR");
        denB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denBActionPerformed(evt);
            }
        });

        obsB.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        obsB.setForeground(new java.awt.Color(255, 153, 0));
        obsB.setText("OBSERVAR");
        obsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obsBActionPerformed(evt);
            }
        });

        ecch.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        ecch.setText("ENVIAR A CAJA CHICA");
        ecch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSVLayout = new javax.swing.GroupLayout(panelSV);
        panelSV.setLayout(panelSVLayout);
        panelSVLayout.setHorizontalGroup(
            panelSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelSVLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(ecch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 602, Short.MAX_VALUE)
                        .addComponent(obsB)
                        .addGap(18, 18, 18)
                        .addComponent(denB)
                        .addGap(18, 18, 18)
                        .addComponent(apB)))
                .addContainerGap())
        );
        panelSVLayout.setVerticalGroup(
            panelSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apB)
                    .addComponent(jButton3)
                    .addComponent(denB)
                    .addComponent(obsB)
                    .addComponent(ecch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSCC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SOLICITUDES DE CAJA CHICHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 14))); // NOI18N

        tablascc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(tablascc);

        apB1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        apB1.setForeground(new java.awt.Color(0, 102, 51));
        apB1.setText("APROBAR");
        apB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apB1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 204));
        jButton4.setText("VER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        denB1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        denB1.setForeground(new java.awt.Color(255, 0, 0));
        denB1.setText("DENEGAR");
        denB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denB1ActionPerformed(evt);
            }
        });

        obsB1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        obsB1.setForeground(new java.awt.Color(255, 153, 0));
        obsB1.setText("OBSERVAR");
        obsB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obsB1ActionPerformed(evt);
            }
        });

        ecch1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        ecch1.setText("ENVIAR A CAJA CHICA");
        ecch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSCCLayout = new javax.swing.GroupLayout(panelSCC);
        panelSCC.setLayout(panelSCCLayout);
        panelSCCLayout.setHorizontalGroup(
            panelSCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSCCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelSCCLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(ecch1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(obsB1)
                        .addGap(18, 18, 18)
                        .addComponent(denB1)
                        .addGap(18, 18, 18)
                        .addComponent(apB1)))
                .addContainerGap())
        );
        panelSCCLayout.setVerticalGroup(
            panelSCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apB1)
                    .addComponent(jButton4)
                    .addComponent(denB1)
                    .addComponent(obsB1)
                    .addComponent(ecch1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(nombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(codigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panelSV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panelSCC, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/files.png"))); // NOI18N
        archivo.setMnemonic('f');
        archivo.setText("Archivo");

        jMenu3.setText("SOLICITUD DE CAJA");

        jMenuItem2.setText("SOLICITAR CAJA CHICA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("MIS SOLICITUDES");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        archivo.add(jMenu3);

        jMenu2.setText("LIQUIDACIONES");

        jMenuItem1.setText("LIQUIDAR CAJA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("MIS LIQUIDACIONES");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        archivo.add(jMenu2);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        archivo.add(exitMenuItem);

        menuBar.add(archivo);

        mcaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Finance48.png"))); // NOI18N
        mcaja.setText("Caja");

        incaja.setText("INGRESO A CAJA ");
        incaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incajaActionPerformed(evt);
            }
        });
        mcaja.add(incaja);

        jMenu1.setText("LIQUIDACIONES - USUARIOS");

        jMenuItem5.setText("VALIDAR LIQUIDACION");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        mcaja.add(jMenu1);

        menuBar.add(mcaja);

        gerencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gerencia.png"))); // NOI18N
        gerencia.setText("Gerencia");

        jMenuItem6.setText("VERIFICAR LIQUIDACIONES");
        gerencia.add(jMenuItem6);

        menuBar.add(gerencia);

        transportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transport.png"))); // NOI18N
        transportes.setText("Transportes");

        jMenu6.setText("SOLICITUD DE VIATICOS");

        jMenuItem7.setText("SOLICITAR VIATICOS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("MIS SOLICITUDES DE VIATICOS");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        transportes.add(jMenu6);

        jMenu4.setText("LIQUIDACIONES DE VIATICOS");

        jMenuItem9.setText("LIQUIDAR VIATICOS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("MIS LIQUIDACIONES");
        jMenu4.add(jMenuItem10);

        transportes.add(jMenu4);

        menuBar.add(transportes);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contacto");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Acerca De");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void obsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obsBActionPerformed
        // TODO add your handling code here:
        int fila = tablasv.getSelectedRow();
        int codscc = Integer.parseInt(tablasv.getValueAt(fila, 0).toString());
        oSCC.aodSCC(codscc, 3, Integer.parseInt(codigo.getText()),4);
        updateT();
    }//GEN-LAST:event_obsBActionPerformed

    private void denBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denBActionPerformed
        // TODO add your handling code here:
        int fila = tablasv.getSelectedRow();
        int codscc = Integer.parseInt(tablasv.getValueAt(fila, 0).toString());
        oSCC.aodSCC(codscc, 2, Integer.parseInt(codigo.getText()),5);
        updateT();
    }//GEN-LAST:event_denBActionPerformed

    private void apBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apBActionPerformed
        // TODO add your handling code here:
        int fila = tablasv.getSelectedRow();
        int codscc = Integer.parseInt(tablasv.getValueAt(fila, 0).toString());
        oSCC.aodSCC(codscc, 1, Integer.parseInt(codigo.getText()),1);
        updateT();
    }//GEN-LAST:event_apBActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                if(tablasv.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato");
        }else{
                try {
            conn.conectar();

            String dir = "C:\\cajareport\\report_scc.jrxml";
            Map parametros = new HashMap();
            parametros.put("codscc", Integer.parseInt(tablasv.getValueAt(tablasv.getSelectedRow(), 0).toString()));
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, parametros, conn.getConn());
            JasperViewer.viewReport(mostrarReporte, false);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex);
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ecchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecchActionPerformed
        // TODO add your handling code here:
        int fila = tablasv.getSelectedRow();
        String mon = tablasv.getValueAt(fila, 7).toString();
        Usuarios uu = oU.buscaUsuarios(Integer.parseInt(codigo.getText()));
        long codSC = Long.parseLong(tablasv.getValueAt(fila, 0).toString());
        SolicitudCaja scx = oSCC.buscaSCC(codSC);
        String aprob1 = tablasv.getValueAt(fila, 11).toString();
        if (aprob1.equalsIgnoreCase("APROBADA")) {
            if(mon.equalsIgnoreCase("SOLES")){
             /*GET SERIE DE MOVIMIENTO*/   
            MovimientosCajas temppc = oMCS.getLast();
            long corr = 0;
            if (temppc == null) {
                corr = 1;
            } else {
                corr = temppc.getMcsId() + 1;
            }
            String serie = oper.generarSerie(corr, 2);
            /*FIN GET SERIE DE MOVIMIENTO*/
            SaldoCajas tempscs = oSCS.getLast();
            if(tempscs == null){
                JOptionPane.showMessageDialog(this, "NO ES POSIBLE PROCESAR SU SOLICITUD");
            }else{
                if(tempscs.getScsSaldo()<scx.getScImporte()){
                    JOptionPane.showMessageDialog(this, "FONDOS INSUFICIENTES");
                }else{
                    MovimientosCajas mcs = new MovimientosCajas(uu, serie, oper.getF(), scx.getScDesc(), scx.getScImporte(), 0.0, 0.0, 0.0, scx.getUsuarios().getUsuarioId(), 0, corr, 2);
                    oper.registrar(mcs);
                    MovimientosCajas tmcs = oMCS.buscaMCS(oper.getNextID());
                    SaldoCajas scss = new SaldoCajas(tmcs, 0.0, scx.getScImporte(), tempscs.getScsSaldo() - scx.getScImporte(), 0);
                    oper.registrar(scss);
                    List<DetalleSc> listaa = oDSCC.searchDSC(codSC);
                    Iterator<DetalleSc> iter = listaa.iterator();

                    while (iter.hasNext()) {
                        DetalleSc p = (DetalleSc) iter.next();
                        DetalleMcs tdmcs = new DetalleMcs(tmcs, p.getUmedidas().getUnidadmDesc(), p.getDscDesc(), p.getDscCantidad(), p.getDscImporte(), p.getDscSt(), "default", "defaullt", "default", 0.0, oper.getF(), 0);
                        oper.registrar(tdmcs);
                    }
                    oSCC.aESCC(scx.getScId(), 2);
                    updateT();
                }
            }
        }else if(mon.equalsIgnoreCase("DOLARES")){
             /*GET SERIE DE MOVIMIENTO D*/ 
            MovimientosCajasd temppcd = oMCD.getLast();
            long corr = 0;
            if (temppcd == null) {
                corr = 1;
            } else {
                corr = temppcd.getMcdId() + 1;
            }
            String serie = oper.generarSerie(corr, 3);
            /*FIN GET SERIE DE MOVIMIENTO D*/
            SaldoCajad tempscd = oSCD.getLast();
            if(tempscd == null){
                JOptionPane.showMessageDialog(this, "NO ES POSIBLE PROCESAR SU SOLICITUD");
            }else{
                if(tempscd.getScdSaldo()<scx.getScImporte()){
                    JOptionPane.showMessageDialog(this, "FONDOS INSUFICIENTES");
                }else{
                    MovimientosCajasd mcd = new MovimientosCajasd(uu, serie, oper.getF(), scx.getScDesc(), scx.getScImporte(), 0.0, 0.0, 0.0, scx.getUsuarios().getUsuarioId(), 0, corr, 2);
                    oper.registrar(mcd);
                    MovimientosCajasd tmcd = oMCD.buscaMCD(oper.getNextID());
                    SaldoCajad scss = new SaldoCajad(tmcd, 0.0, scx.getScImporte(), tempscd.getScdSaldo() - scx.getScImporte(), 0);
                    oper.registrar(scss);
                    List<DetalleSc> listax = oDSCC.searchDSC(codSC);
                    Iterator<DetalleSc> iter = listax.iterator();

                    while (iter.hasNext()) {
                        DetalleSc p = (DetalleSc) iter.next();
                        DetalleMcd tdmcs = new DetalleMcd(tmcd, p.getUmedidas().getUnidadmDesc(), p.getDscDesc(), p.getDscCantidad(), p.getDscImporte(), p.getDscSt(), "default", "defaullt", "default", 0.0, oper.getF(), 0);
                        oper.registrar(tdmcs);
                    }
                    oSCC.aESCC(scx.getScId(), 2);
                    updateT();
                }

            }
        }else{
            JOptionPane.showMessageDialog(this, "INCORRECTO");
        }
        }else{
            JOptionPane.showMessageDialog(this, "IMPOSIBLE DE COMPLETAR OPERACION");
        }
        
        
    }//GEN-LAST:event_ecchActionPerformed

    private void incajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incajaActionPerformed
        // TODO add your handling code here:
         App_InCajaChica d = new App_InCajaChica();
        this.escritorio.add(d);
        d.show();
    }//GEN-LAST:event_incajaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        App_PreLiqCaja xx = new App_PreLiqCaja();
        this.escritorio.add(xx);
        xx.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        App_SCajaChica d = new App_SCajaChica();
        this.escritorio.add(d);
        d.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        App_MisSolicitudesCC msc = new App_MisSolicitudesCC();
        this.escritorio.add(msc);
        msc.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        App_PreLiqPendientes xx = new App_PreLiqPendientes();
        this.escritorio.add(xx);
        xx.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        App_MisLiquidacionesCC xx = new App_MisLiquidacionesCC();
        this.escritorio.add(xx);
        xx.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        App_SViaticos d = new App_SViaticos();
        this.escritorio.add(d);
        d.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
         App_MisSViaticos d = new App_MisSViaticos();
        this.escritorio.add(d);
        d.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
                 App_PreLiqViaticos d = new App_PreLiqViaticos();
        this.escritorio.add(d);
        d.show();
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void apB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apB1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void denB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_denB1ActionPerformed

    private void obsB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obsB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obsB1ActionPerformed

    private void ecch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecch1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(App_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(App_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(App_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(App_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new App_Principal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    public static javax.swing.JButton apB;
    public static javax.swing.JButton apB1;
    public static javax.swing.JMenu archivo;
    public static javax.swing.JLabel codigo;
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JButton denB;
    public static javax.swing.JButton denB1;
    public static javax.swing.JButton ecch;
    public static javax.swing.JButton ecch1;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem exitMenuItem;
    public static javax.swing.JMenu gerencia;
    private javax.swing.JMenu helpMenu;
    public static javax.swing.JMenuItem incaja;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JMenu mcaja;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JLabel nombre;
    public static javax.swing.JButton obsB;
    public static javax.swing.JButton obsB1;
    public static javax.swing.JPanel panelSCC;
    public static javax.swing.JPanel panelSV;
    private javax.swing.JTable tablascc;
    private javax.swing.JTable tablasv;
    public static javax.swing.JMenu transportes;
    // End of variables declaration//GEN-END:variables

}
