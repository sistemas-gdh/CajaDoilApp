/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleSv;
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

public class HelperDSV {

     public DefaultTableModel obtenerDSC(DefaultTableModel modelo,long sid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleSv p where p.solicitudViaticos.svId = "+sid);
        List<DetalleSv> lista = (List<DetalleSv>) q.list();
        Iterator<DetalleSv> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            DetalleSv p = (DetalleSv) iter.next();
            modelo.addRow(new Object[]{p.getDsvId(),p.getChoferes().getChBrevete(),p.getTractos().getTPlaca(),p.getRemolques().getRPlaca(),p.getDsvSt()});
        }
        session.close();
        return modelo; 
    }
     
         public List<DetalleSv> searchDSV(long sid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleSv p where p.solicitudViaticos.svId = "+sid);
        List<DetalleSv> lista = (List<DetalleSv>) q.list();
        tx.commit();
        session.close();
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
    
//    public DetalleSv getCUser(String texto) {
//        
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("from Usuarios as p where p.usuarioUser like '%"+ texto +"%'");
//        DetalleSv p = (DetalleSv) q.uniqueResult();
//        
//        
//
//        session.close();
//        return p;
//    }
    
    public void actualizar(DetalleSv p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setDsvId(id);
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
            DetalleSv p = (DetalleSv)session.load(DetalleSv.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public DetalleSv buscaDSCC(long id)
    {
        DetalleSv p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (DetalleSv)session.get(DetalleSv.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
