/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MovimientosCajas;
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

public class HelperMCS {
    
    Helper oper = new Helper();
    

     public DefaultTableModel obtenerMCS(DefaultTableModel modelo,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajas p");
        List<MovimientosCajas> lista = (List<MovimientosCajas>) q.list();
        Iterator<MovimientosCajas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajas p = (MovimientosCajas) iter.next();
            modelo.addRow(new Object[]{p.getMcsId(),p.getMcsSerie(),p.getMcsFecha(),p.getMcsDesc(),p.getMcsImporte(),p.getMcsImportel(),oper.validarEstado(p.getMcsEstado())});
        }
        session.close();
        return modelo; 
    }
     
    public DefaultTableModel getMcsByUser(DefaultTableModel modelo,int ucod,int estado,int tpin)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajas p where p.mcsUsersol = "+ucod + " AND p.mcsTpin = "+tpin+" AND p.mcsEstado = "+estado);
        List<MovimientosCajas> lista = (List<MovimientosCajas>) q.list();
        Iterator<MovimientosCajas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajas p = (MovimientosCajas) iter.next();
            modelo.addRow(new Object[]{p.getMcsId(),p.getMcsSerie(),p.getMcsFecha(),p.getMcsDesc(),p.getMcsImporte(),p.getMcsImportel(),oper.validarEstado(p.getMcsEstado())});
        }
        session.close();
        return modelo; 
    } 
    
        public DefaultTableModel getMcsByUserSerie(DefaultTableModel modelo,int ucod,String serie)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajas p where p.mcsUsersol = "+ucod + " AND p.mcsSerie like '%"+ serie +"%'");
        List<MovimientosCajas> lista = (List<MovimientosCajas>) q.list();
        Iterator<MovimientosCajas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajas p = (MovimientosCajas) iter.next();
            modelo.addRow(new Object[]{p.getMcsId(),p.getMcsSerie(),p.getMcsFecha(),p.getMcsDesc(),p.getMcsImporte(),p.getMcsImportel(),oper.validarEstado(p.getMcsEstado())});
        }
        session.close();
        return modelo; 
    } 
    
    public DefaultTableModel getMcsByEstado(DefaultTableModel modelo,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajas p where  p.mcsEstado = "+estado);
        List<MovimientosCajas> lista = (List<MovimientosCajas>) q.list();
        Iterator<MovimientosCajas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajas p = (MovimientosCajas) iter.next();
            modelo.addRow(new Object[]{p.getMcsId(),p.getMcsSerie(),p.getMcsFecha(),p.getMcsDesc(),p.getMcsImporte(),p.getMcsImportel(),oper.validarEstado(p.getMcsEstado())});
        }
        session.close();
        return modelo; 
    } 
    
    public void aILiquidado(long codMCS, double iliq) {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajas x set "
                    + "x.mcsImportel = :newMcsImportel "
                    + "where x.mcsId = :oldMCS";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcsImportel", iliq)
                    .setLong("oldMCS", codMCS)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    public void setDR(long codMCS, double d, double r) {//DEVOULUCION & REINTEGRO
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajas x set "
                    + "x.mcsDevolucion = :newMcsDevolucion, "
                    + "x.mcsReintegro = :newMcsReintegro "
                    + "where x.mcsId = :oldMCS";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcsDevolucion", d)
                    .setDouble("newMcsReintegro", r)
                    .setLong("oldMCS", codMCS)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    public void aEstado(long codMCS, int estado) {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajas x set "
                    + "x.mcsEstado = :newMcsEstado "
                    + "where x.mcsId = :oldMCS";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcsEstado", estado)
                    .setLong("oldMCS", codMCS)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
     
    public MovimientosCajas getLast() {
        MovimientosCajas pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (MovimientosCajas) session.createQuery("SELECT c from MovimientosCajas as c ORDER BY c.mcsId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
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
    
    
    public void actualizar(MovimientosCajas p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setMcsId(id);
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
            MovimientosCajas p = (MovimientosCajas)session.load(MovimientosCajas.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public MovimientosCajas buscaMCS(long id)
    {
        MovimientosCajas p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (MovimientosCajas)session.get(MovimientosCajas.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
