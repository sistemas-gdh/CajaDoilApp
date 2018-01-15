/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuarios;
import Persistencia.NewHibernateUtil;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luisv
 */
public class Helper {
    

    
    public boolean validarUsuario(String usuario, String clave, int cod) {
        boolean hecho = false;
        Usuarios user = null;
        String sentencia = "from Usuarios u where u.usuarioUser='" + usuario
                + "' and u.usuarioPassword='" + clave + "' and u.usuarioPermisos='" + cod + "' and u.usuarioEstado='1'";
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery(sentencia);
            List<Usuarios> listaUsuarios = (List<Usuarios>) q.list();
            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
                hecho = true;
            } else {
                System.out.println("fracaso");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return hecho;
    }

    public void registrar(Object x) {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.save(x);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Insertado Correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    public void limpiaTabla(DefaultTableModel temp, JTable t) {
        try {
            temp = (DefaultTableModel) t.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String validarEstado(int estado) {
        String aprob ="";
        switch (estado) {
            case 0:
                aprob = "POR LIQUIDAR";
                break;
            case 1:
                aprob = "SUBIDO";
                break;
            case 2:
                aprob = "V° B° DE CAJA";
                break;
            case 3:
                aprob = "V° B° DE GERENCIA";
                break;
            case 4:
                aprob = "OBSERVADO";
                break;
        }
        return aprob;
    }
    
    public String validarESC(int estado) {
        String aprob ="";
        switch (estado) {
            case 0:
                aprob = "PENDIENTE";
                break;
            case 1:
                aprob = "APROBADA";
                break;
            case 2:
                aprob = "RECABAR DINERO";
                break;
            case 3:
                aprob = "CERRADA";
                break;
            case 4:
                aprob = "OBSERVADA";
                break;
            case 5:
                aprob = "DENEGADA";
                break;
        }
        return aprob;
    }
    
    public String validarAprob(int estado) {
        String aprob = "";
        switch (estado) {
            case 1:
                aprob = "APROBADO";
                break;
            case 2:
                aprob = "DENEGADO";
                break;
            case 3:
                aprob = "OBSERVADO";
        }
        return aprob;
    }
    


    public Date getF() {
        Date date = null;
        Calendar Cal = Calendar.getInstance();
        String fec = Cal.get(Cal.YEAR) + "-" + (Cal.get(Cal.MONTH) + 1) + "-" + Cal.get(Cal.DATE) + " " + Cal.get(Cal.HOUR_OF_DAY) + ":" + Cal.get(Cal.MINUTE) + ":" + Cal.get(Cal.SECOND);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter.parse(fec);
        } catch (ParseException ex) {
        }

        return date;
    }
    
        
    
    public long getNextID(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        long xx = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
        tx.commit();
        session.close();
        return xx;
    }

    public String setFechaBackUp(int valor) {
        String fecha = "";
        Calendar Cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        switch (valor) {
            case 1:
                //SEMANAL
                Cal.add(Calendar.DATE, 7);
                fecha = sdf.format(Cal.getTime());
                break;
            case 2:
                //QUINCENAL
                Cal.add(Calendar.DATE, 15);
                fecha = sdf.format(Cal.getTime());
                break;
            case 3:
                //MENSUAL
                Cal.add(Calendar.MONTH, 1);
                fecha = sdf.format(Cal.getTime());
                break;
            case 4:
                //BIMESTRAL
                Cal.add(Calendar.MONTH, 2);
                fecha = sdf.format(Cal.getTime());
                break;
            case 5:
                //TRIMESTRAL
                Cal.add(Calendar.MONTH, 3);
                fecha = sdf.format(Cal.getTime());
                break;
            case 6:
                //SEMESTRAL
                Cal.add(Calendar.MONTH, 6);
                fecha = sdf.format(Cal.getTime());
                break;
            case 7:
                //ANUAL
                Cal.add(Calendar.YEAR, 1);
                fecha = sdf.format(Cal.getTime());
                break;
            case 8:
                //BIANUAL:
                Cal.add(Calendar.YEAR, 2);
                fecha = sdf.format(Cal.getTime());
        }
        return fecha;
    }

    public Date StringADate(String strFecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        return fecha;
    }

    public BigDecimal getB(String valor) {
        BigDecimal PV = new BigDecimal(valor);
        return PV;
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public String generarSerie(long valor,int llave) {
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        String cc= "";
        switch(llave){
            case 1:
                cc += "N° SC-";
                break;
            case 2:
                cc += "N° MC S/ -";
                break;
            case 3:
                cc = "N° MC $ -";
                break; 
            case 4:
                cc += "N° SV-";
                break;
        }
        if (valor > 0 && valor < 10) {
            cc += "00000" + valor + "-" + año;
        } else if (valor >= 10 && valor <= 99) {
            cc += "0000" + valor + "-" + año;
        } else if (valor >= 100 && valor <= 999) {
            cc += "000" + valor + "-" + año;
        } else if (valor >= 1000 && valor <= 9999) {
            cc += "00" + valor + "-" + año;
        } else if (valor >= 10000 && valor <= 99999) {
            cc += "0" + valor + "-" + año;
        } else if (valor >= 100000) {
            cc += valor + "-" + año;
        }
        return cc;
    }


}                           
