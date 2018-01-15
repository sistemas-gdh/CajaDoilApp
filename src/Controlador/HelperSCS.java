/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SaldoCajas;
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

public class HelperSCS {

     public DefaultTableModel obtenerSCAJAS(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from SaldoCajas p");
        List<SaldoCajas> lista = (List<SaldoCajas>) q.list();
        Iterator<SaldoCajas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SaldoCajas p = (SaldoCajas) iter.next();
            String aprob="";
            if(p.getScsEstado()==1){
                aprob = "VALIDADO";
            }else if(p.getScsEstado()==2){
                aprob = "OBSERVADO";
            }
            modelo.addRow(new Object[]{p.getScsId(),p.getScsDebe(),p.getScsHaber(),p.getScsSaldo(),aprob});
        }
        session.close();
        return modelo; 
    }
     
    public SaldoCajas getLast() {
        SaldoCajas pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (SaldoCajas) session.createQuery("SELECT c from SaldoCajas as c ORDER BY c.scsId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
        tx.commit();
        session.close();
        return pp;
        
    }

    
//    public void aodSCC(int codSCC,int valor,int llave){
//        try{
//                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//	Transaction tx = session.beginTransaction();
//        String hqlUpdate = "";
//        switch(llave){
//            case 2:
//            hqlUpdate = "update SolicitudCaja c set c.scAprob1 = :newAprobx where c.scId = :oldSCC";  
//            break;
//            case 3:
//            hqlUpdate = "update SolicitudCaja c set c.scAprob2 = :newAprobx where c.scId = :oldSCC"; 
//            break;
//            case 14:
//            hqlUpdate = "update SolicitudCaja c set c.scAprob3 = :newAprobx where c.scId = :oldSCC"; 
//            break;   
//        }
//        session.createQuery( hqlUpdate ).setInteger("newAprobx", valor).setInteger("oldSCC", codSCC).executeUpdate();
//        tx.commit();
//        session.close(); 
//        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
//       }catch(HibernateException | HeadlessException e){
//            JOptionPane.showMessageDialog(null,"Error: "+e);
//        }
//
//    }
    
    
    
    
     

//    public DefaultTableModel buscaProdCalidad(String texto, DefaultTableModel modelo) {
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//            Query q = session.createQuery("select p.piId,p.FLlegada,p.proveedores.proveedorRs,p.zonas.zonaDesc "
//                + "from ProductosIngreso as p where p.proveedores.proveedorRs like '%"+ texto +"%' order by p.piId desc");
//            List<Object[]> lista = (List<Object[]>) q.list();
//            tx.commit();
//            for (Object[] p : lista) {
//                modelo.addRow(new Object[]{
//                    p[0], p[1],p[2],p[3]
//                });
//            }
//        session.close();
//        return modelo;
//    } 
//    
//        public ProductoCalidad getLast() {
//        ProductoCalidad pp;
//	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//	Transaction tx = session.beginTransaction();
//        pp = (ProductoCalidad) session.createQuery("SELECT c from ProductoCalidad as c ORDER BY c.pcId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
//        tx.commit();
//        session.close();
//        return pp;
//        
//    }  
    
    
    public void actualizar(SaldoCajas p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setScsId(id);
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
            SaldoCajas p = (SaldoCajas)session.load(SaldoCajas.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public SaldoCajas buscaMCD(long id)
    {
        SaldoCajas p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (SaldoCajas)session.get(SaldoCajas.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
