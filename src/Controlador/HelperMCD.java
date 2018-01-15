/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MovimientosCajasd;
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

public class HelperMCD {

    Helper oper = new Helper();
    
     public DefaultTableModel obtenerMCD(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajasd p");
        List<MovimientosCajasd> lista = (List<MovimientosCajasd>) q.list();
        Iterator<MovimientosCajasd> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajasd p = (MovimientosCajasd) iter.next();
            modelo.addRow(new Object[]{p.getMcdId(),p.getMcdSerie(),p.getMcdFecha(),p.getMcdDesc(),p.getMcdImporte(),p.getMcdImportel(),oper.validarEstado(p.getMcdEstado())});
        }
        session.close();
        return modelo; 
    }
     
          public DefaultTableModel getMcdByUser(DefaultTableModel modelo,int ucod,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajasd p where p.mcdUsersol = "+ucod + " AND p.mcdEstado = "+estado);
        List<MovimientosCajasd> lista = (List<MovimientosCajasd>) q.list();
        Iterator<MovimientosCajasd> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajasd p = (MovimientosCajasd) iter.next();
            modelo.addRow(new Object[]{p.getMcdId(),p.getMcdSerie(),p.getMcdFecha(),p.getMcdDesc(),p.getMcdImporte(),p.getMcdImportel(),oper.validarEstado(p.getMcdEstado())});
        }
        session.close();
        return modelo; 
    }
          
          
    public DefaultTableModel getMcdByUserSerie(DefaultTableModel modelo, int ucod, String serie) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajasd p where p.mcdUsersol = " + ucod + " AND p.mcdSerie like '%" + serie + "%'");
        List<MovimientosCajasd> lista = (List<MovimientosCajasd>) q.list();
        Iterator<MovimientosCajasd> iter = lista.iterator();
        tx.commit();
        while (iter.hasNext()) {
            MovimientosCajasd p = (MovimientosCajasd) iter.next();
            modelo.addRow(new Object[]{p.getMcdId(), p.getMcdSerie(), p.getMcdFecha(), p.getMcdDesc(), p.getMcdImporte(), p.getMcdImportel(), oper.validarEstado(p.getMcdEstado())});
        }
        session.close();
        return modelo;
    }
          
              public DefaultTableModel getMcdByEstado(DefaultTableModel modelo,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from MovimientosCajasd p where p.mcdEstado = "+estado);
        List<MovimientosCajasd> lista = (List<MovimientosCajasd>) q.list();
        Iterator<MovimientosCajasd> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            MovimientosCajasd p = (MovimientosCajasd) iter.next();
            modelo.addRow(new Object[]{p.getMcdId(),p.getMcdSerie(),p.getMcdFecha(),p.getMcdDesc(),p.getMcdImporte(),p.getMcdImportel(),oper.validarEstado(p.getMcdEstado())});
        }
        session.close();
        return modelo; 
    }   
              
              
        public void setDR(long codMCD, double d, double r) {//DEVOULUCION & REINTEGRO
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajasd x set "
                    + "x.mcdDevolucion = :newMcdDevolucion, "
                    + "x.mcdReintegro = :newMcdReintegro "
                    + "where x.mcdId = :oldMCD";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcdDevolucion", d)
                    .setDouble("newMcdReintegro", r)
                    .setLong("oldMCD", codMCD)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }          
          
    public void aEstado(long codMCD, int estado) {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajasd x set "
                    + "x.mcdEstado = :newMcdEstado "
                    + "where x.mcdId = :oldMCS";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcdEstado", estado)
                    .setLong("oldMCS", codMCD)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }     
          
    public void aILiquidado(long codMCS, double iliq) {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update MovimientosCajasd c set "
                    + "c.mcdImportel =:newMcdImportel "
                    + "where c.mcdId = :oldMCD";

            session.createQuery(hqlUpdate)
                    .setDouble("newMcdImportel", iliq)
                    .setLong("oldMCD", codMCS)
                    .executeUpdate();
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }    
     
    public MovimientosCajasd getLast() {
        MovimientosCajasd pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (MovimientosCajasd) session.createQuery("SELECT c from MovimientosCajasd as c ORDER BY c.mcdId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
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
    
    
    public void actualizar(MovimientosCajasd p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setMcdId(id);
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
            MovimientosCajasd p = (MovimientosCajasd)session.load(MovimientosCajasd.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public MovimientosCajasd buscaMCD(long id)
    {
        MovimientosCajasd p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (MovimientosCajasd)session.get(MovimientosCajasd.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
