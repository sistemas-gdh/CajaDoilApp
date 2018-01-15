/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleMcd;
import Persistencia.NewHibernateUtil;
import java.awt.HeadlessException;
import java.util.Date;
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

public class HelperDMCD {
    
    Helper oper = new Helper();

     public List<DetalleMcd> obtenerDMCD(long mcsid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcd p where p.movimientosCajasd.mcdId = "+mcsid);
        List<DetalleMcd> lista = (List<DetalleMcd>) q.list();
        
        session.close();
        return lista; 
    }
     
     
             public void aEstadoDD(long codDMCS,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String 
            hqlUpdate = "update DetalleMcd c "
                    + "set c.dmcdEstado = :newDmcdEstado "
                    + "where c.dmcdId = :oldDMCS";
        
        session.createQuery( hqlUpdate )
                .setInteger("newDmcdEstado", estado)
                .setLong("oldDMCS", codDMCS)
                .executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    } 
     
         public void aDMCD(long codDMCS,String unidadm,String desc,double cant,double pu,double st,String doc,String prov,String serie,Date fecha,double total){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String 
            hqlUpdate = "update DetalleMcd c "
                    + "set c.unidadmId = :newUnidadmId,"
                    + "c.dmcdDesc = :newDmcsDesc,"
                    + "c.dmcdCant = :newDmcsCant,"
                    + "c.dmcdImporte =:newDmcsImporte,"
                    + "c.dmcdSt =:newDmcsSt,"
                    + "c.dmcdDoc =:newDmcsDoc,"
                    + "c.dmcdProveedor =:newDmcdProveedor,"
                    + "c.dmcdDocserie =:newDmcsSerie,"
                    + "c.dmcdDocfecha =:newDmcsDocFecha,"
                    + "c.dmcdDoctotal =:newDmcsDocTotal,"
                    + "c.dmcdEstado =1 "
                    + "where c.dmcdId = :oldDMCS";  
 
        
        session.createQuery( hqlUpdate )
                .setString("newUnidadmId", unidadm)
                .setString("newDmcsDesc", desc)
                .setDouble("newDmcsCant", cant)
                .setDouble("newDmcsImporte", pu)
                .setDouble("newDmcsSt", st)
                .setString("newDmcsDoc", doc)
                .setString("newDmcdProveedor", prov)
                .setString("newDmcsSerie", serie)
                .setDate("newDmcsDocFecha", fecha)
                .setDouble("newDmcsDocTotal", total)
                .setLong("oldDMCS", codDMCS)
                .executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    } 
     
            public DefaultTableModel obtenerDMCD(DefaultTableModel modelo,int estado,long mcdid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcd p where p.movimientosCajasd.mcdId = "+mcdid +" and p.dmcdEstado = "+estado);
        List<DetalleMcd> lista = (List<DetalleMcd>) q.list();
        Iterator<DetalleMcd> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            DetalleMcd p = (DetalleMcd) iter.next();
            modelo.addRow(new Object[]{p.getDmcdId(),p.getDmcdDesc(),p.getUnidadmId(),p.getDmcdCant(),p.getDmcdImporte(),p.getDmcdSt(),oper.validarEstado(p.getDmcdEstado())});
        }
        session.close();
        return modelo; 
    }  
    
                public int searchLiqD(long mcsid,int estado)
    {
        int ent = 0;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcd p where p.movimientosCajasd.mcdId = "+mcsid +" and p.dmcdEstado = "+estado);
        List<Object[]> listaResultados = q.list();
        tx.commit();
        ent = listaResultados.size();
        session.close();
        return ent;
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
    
//    public DetalleMcs getCUser(String texto) {
//        
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("from Usuarios as p where p.usuarioUser like '%"+ texto +"%'");
//        DetalleMcs p = (DetalleMcs) q.uniqueResult();
//        
//        
//
//        session.close();
//        return p;
//    }
    
    public void actualizar(DetalleMcd p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setDmcdId(id);
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
            DetalleMcd p = (DetalleMcd)session.load(DetalleMcd.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public DetalleMcd buscaDMCD(long id)
    {
        DetalleMcd p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (DetalleMcd)session.get(DetalleMcd.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
