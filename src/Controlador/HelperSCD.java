/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SaldoCajad;
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

public class HelperSCD {

     public DefaultTableModel obtenerSCAJAS(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from SaldoCajad p");
        List<SaldoCajad> lista = (List<SaldoCajad>) q.list();
        Iterator<SaldoCajad> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SaldoCajad p = (SaldoCajad) iter.next();
            String aprob="";
            if(p.getScdEstado()==1){
                aprob = "VALIDADO";
            }else if(p.getScdEstado()==2){
                aprob = "OBSERVADO";
            }
            modelo.addRow(new Object[]{p.getScdId(),p.getScdDebe(),p.getScdHaber(),p.getScdSaldo(),aprob});
        }
        session.close();
        return modelo; 
    }
     
    public SaldoCajad getLast() {
        SaldoCajad pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (SaldoCajad) session.createQuery("SELECT c from SaldoCajad as c ORDER BY c.scdId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
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
    
    
    public void actualizar(SaldoCajad p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setScdId(id);
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
            SaldoCajad p = (SaldoCajad)session.load(SaldoCajad.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public SaldoCajad buscaMCD(long id)
    {
        SaldoCajad p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (SaldoCajad)session.get(SaldoCajad.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
