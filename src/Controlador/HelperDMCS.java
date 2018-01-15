/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleMcs;
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

public class HelperDMCS {
    
    Helper oper = new Helper();
    
         public List<DetalleMcs> obtenerDMCS(long mcsid,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcs p where p.movimientosCajas.mcsId = "+mcsid +" and p.dmcsEstado = "+estado);
        List<DetalleMcs> lista = (List<DetalleMcs>) q.list();
        
        session.close();
        return lista; 
    } 
     
         public DefaultTableModel obtenerDMCS(DefaultTableModel modelo,int estado,long mcsid)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcs p where p.movimientosCajas.mcsId = "+mcsid +" and p.dmcsEstado = "+estado);
        List<DetalleMcs> lista = (List<DetalleMcs>) q.list();
        Iterator<DetalleMcs> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            DetalleMcs p = (DetalleMcs) iter.next();
            modelo.addRow(new Object[]{p.getDmcsId(),p.getDmcsDesc(),p.getUnidadmId(),p.getDmcsCant(),p.getDmcsImporte(),p.getDmcsSt(),oper.validarEstado(p.getDmcsEstado())});
        }
        session.close();
        return modelo; 
    }
    
    public int searchLiqS(long mcsid,int estado)
    {
        int ent = 0;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from DetalleMcs p where p.movimientosCajas.mcsId = "+mcsid +" and p.dmcsEstado = "+estado);
        List<Object[]> listaResultados = q.list();
        tx.commit();
        ent = listaResultados.size();
        session.close();
        return ent;
    }     
     
     /*
          private Long dmcsId;
     private MovimientosCajas movimientosCajas;
     private String unidadmId;
     private String dmcsDesc;
     private Double dmcsCant;
     private Double dmcsImporte;
     private Double dmcsSt;
     private String dmcsDoc;
     private String dmcsProveedor;
     private String dmcsDocserie;
     private Double dmcsDoctotal;
     private Date dmcsDocfecha;
     private Integer dmcsEstado;
     */
     
    public void aEstadoDS(long codDMCS,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String 
            hqlUpdate = "update DetalleMcs c "
                    + "set c.dmcsEstado = :newDmcsEstado "
                    + "where c.dmcsId = :oldDMCS"; 
        session.createQuery( hqlUpdate )
                .setInteger("newDmcsEstado", estado)
                .setLong("oldDMCS", codDMCS)
                .executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    } 
     
     
    public void aDMCS(long codDMCS,String unidadm,String desc,double cant,double pu,double st,String doc,String prov,String serie,Date fecha,double total){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String 
            hqlUpdate = "update DetalleMcs c "
                    + "set c.unidadmId = :newUnidadmId,"
                    + "c.dmcsDesc = :newDmcsDesc,"
                    + "c.dmcsCant = :newDmcsCant,"
                    + "c.dmcsImporte =:newDmcsImporte,"
                    + "c.dmcsSt =:newDmcsSt,"
                    + "c.dmcsDoc =:newDmcsDoc,"
                    + "c.dmcsProveedor =:newDmcsProveedor,"
                    + "c.dmcsDocserie =:newDmcsSerie,"
                    + "c.dmcsDocfecha =:newDmcsDocFecha,"
                    + "c.dmcsDoctotal =:newDmcsDocTotal,"
                    + "c.dmcsEstado =1 "
                    + "where c.dmcsId = :oldDMCS";  
 
        
        session.createQuery( hqlUpdate )
                .setString("newUnidadmId", unidadm)
                .setString("newDmcsDesc", desc)
                .setDouble("newDmcsCant", cant)
                .setDouble("newDmcsImporte", pu)
                .setDouble("newDmcsSt", st)
                .setString("newDmcsDoc", doc)
                .setString("newDmcsProveedor", prov)
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
    
    public void actualizar(DetalleMcs p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setDmcsId(id);
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
            DetalleMcs p = (DetalleMcs)session.load(DetalleMcs.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public DetalleMcs buscaDMCS(long id)
    {
        DetalleMcs p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (DetalleMcs)session.get(DetalleMcs.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
