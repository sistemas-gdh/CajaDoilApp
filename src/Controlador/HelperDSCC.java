/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleSc;
import Persistencia.NewHibernateUtil;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
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

public class HelperDSCC {

     public DefaultTableModel obtenerDSC(DefaultTableModel modelo,long sid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleSc p where p.solicitudCaja.scId = "+sid);
        List<DetalleSc> lista = (List<DetalleSc>) q.list();
        Iterator<DetalleSc> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            DetalleSc p = (DetalleSc) iter.next();
            modelo.addRow(new Object[]{p.getDscId(),p.getDscDesc(),p.getUmedidas().getUnidadmDesc(),p.getDscUso(),p.getDscCantidad(),p.getDscImporte(),p.getDscSt()});
        }
        session.close();
        return modelo; 
    }
     
         public List<DetalleSc> searchDSC(long sid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleSc p where p.solicitudCaja.scId = "+sid);
        List<DetalleSc> lista = (List<DetalleSc>) q.list();
        tx.commit();
        return lista; 
    } 
     
//    public DefaultTableModel buscaProveedores(String texto, DefaultTableModel modelo,int llave) {
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//        if (llave == 1) {
//            Query q = session.createQuery("select p.proveedorId,p.proveedorRuc,p.proveedorRs "
//                + "from Proveedores as p where p.proveedorRuc like '%"+ texto +"%'");
//            List<Object[]> lista = (List<Object[]>) q.list();
//            tx.commit();
//            for (Object[] p : lista) {
//                modelo.addRow(new Object[]{
//                    p[0], p[1],p[2]
//                });
//            }
//        } else {
//            if (llave == 2) {
//                Query q = session.createQuery("select p.proveedorId,p.proveedorRuc,p.proveedorRs "
//                + "from Proveedores as p where p.proveedorRs like '%"+ texto +"%'");
//                List<Object[]> lista = (List<Object[]>) q.list();
//                tx.commit();
//                for (Object[] p : lista) {
//                    modelo.addRow(new Object[]{
//                        p[0], p[1],p[2]
//                    });
//                }
//            } 
//        }
//        session.close();
//        return modelo;
//
//    } 
    
    public DetalleSc getCUser(String texto) {
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuarios as p where p.usuarioUser like '%"+ texto +"%'");
        DetalleSc p = (DetalleSc) q.uniqueResult();
        
        

        session.close();
        return p;
    }
    
    public void actualizar(DetalleSc p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setDscId(id);
            session.update(p);  
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public void eliminar(long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction();   
            DetalleSc p = (DetalleSc)session.load(DetalleSc.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public DetalleSc buscaDSCC(long id)
    {
        DetalleSc p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (DetalleSc)session.get(DetalleSc.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
