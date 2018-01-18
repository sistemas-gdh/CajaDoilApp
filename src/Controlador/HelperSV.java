/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SolicitudViaticos;
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

public class HelperSV {

    Helper oper = new Helper();
    
     public DefaultTableModel obtenerSV(DefaultTableModel modelo,int bypass,int codU)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "";
        if(bypass == 2){
            hqlquery = "from SolicitudViaticos p where p.svEstado = 1";
        }else if(bypass == 3){
            hqlquery = "from SolicitudViaticos p where p.svEstado = 0";
        }else{
            hqlquery = "from SolicitudViaticos p where p.usuarios.usuarioId = "+ codU +" order by field (p.svEstado,3,5,4,0,1,2) desc ";
        }
        Query q = session.createQuery(hqlquery);
        List<SolicitudViaticos> lista = (List<SolicitudViaticos>) q.list();
        Iterator<SolicitudViaticos> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudViaticos p = (SolicitudViaticos) iter.next();
            if(bypass==3 || bypass == 2){
                modelo.addRow(new Object[]{p.getSvId(),p.getSvSerie(),p.getSvFechas(),p.getSvDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getSvImporte(),oper.validarAprob(p.getSvAprob1()),oper.validarAprob(p.getSpAprob2()),oper.validarAprob(p.getSpAprob3()),oper.validarESC(p.getSvEstado())});
            }else{
                modelo.addRow(new Object[]{p.getSvId(),p.getSvSerie(),p.getSvFechas(),p.getSvDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getSvImporte(),oper.validarESC(p.getSvEstado())});   
            }
            
        }
        session.close();
        return modelo; 
    }
     
     public DefaultTableModel obtenerSVEXT(DefaultTableModel modelo,int bypass,int codU)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudViaticos p where p.usuarios.usuarioId = "+ codU +" order by field (p.svEstado,3,5,4,0,1,2) desc ";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudViaticos> lista = (List<SolicitudViaticos>) q.list();
        Iterator<SolicitudViaticos> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudViaticos p = (SolicitudViaticos) iter.next();
               modelo.addRow(new Object[]{p.getSvId(),p.getSvSerie(),p.getSvFechas(),p.getSvDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getSvImporte(),oper.validarESC(p.getSvEstado())});   
        }
        session.close();
        return modelo; 
    } 
    
    public DefaultTableModel searchSV(DefaultTableModel modelo,int codU,int estado)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudViaticos p where p.usuarios.usuarioId = "+ codU +" and p.svEstado = "+estado+"order by p.svFechas desc ";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudViaticos> lista = (List<SolicitudViaticos>) q.list();
        Iterator<SolicitudViaticos> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudViaticos p = (SolicitudViaticos) iter.next();
           
            modelo.addRow(new Object[]{p.getSvId(),p.getSvSerie(),p.getSvFechas(),p.getSvDesc(),p.getSvImporte(),oper.validarESC(p.getSvEstado())});   
                    
               
        }
        session.close();
        return modelo; 
    }
    
        public DefaultTableModel searchSVBySerie(DefaultTableModel modelo,int codU,String cad)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudViaticos p where p.usuarios.usuarioId = "+ codU +" and p.svSerie like '%"+ cad +"%'";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudViaticos> lista = (List<SolicitudViaticos>) q.list();
        Iterator<SolicitudViaticos> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudViaticos p = (SolicitudViaticos) iter.next();
               modelo.addRow(new Object[]{p.getSvId(),p.getSvSerie(),p.getSvFechas(),p.getSvDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getSvImporte(),oper.validarESC(p.getSvEstado())});   
        }
        session.close();
        return modelo; 
    }
    
    
     
    public SolicitudViaticos getLast() {
        SolicitudViaticos pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (SolicitudViaticos) session.createQuery("SELECT c from SolicitudViaticos as c ORDER BY c.svId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
        tx.commit();
        session.close();
        return pp;
        
    }

    
    public void aodSCC(long codSV,int valor,int llave,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String hqlUpdate = "";
        switch(llave){
            case 2:
            hqlUpdate = "update SolicitudViaticos c set c.svAprob1 = :newAprobx,c.svEstado = :newSvEstado where c.svId = :oldSV";  
            break;
            case 3:
            hqlUpdate = "update SolicitudViaticos c set c.spAprob2 = :newAprobx,c.svEstado = :newSvEstado where c.svId = :oldSV"; 
            break;
            case 14:
            hqlUpdate = "update SolicitudViaticos c set c.spAprob3 = :newAprobx,c.svEstado = :newSvEstado where c.svId = :oldSV"; 
            break;   
        }
        session.createQuery( hqlUpdate )
                .setInteger("newAprobx", valor)
                .setInteger("newSvEstado", estado)
                .setLong("oldSV", codSV).executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    }
    
    public void aESCC(long codSV,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String hqlUpdate = "update SolicitudViaticos c set c.svEstado = :newSvEstado where c.svId = :oldSV";
        session.createQuery( hqlUpdate )
                .setInteger("newSvEstado", estado)
                .setLong("oldSV", codSV).executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    }
    
    public void actualizar(SolicitudViaticos p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setSvId(id);
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
            SolicitudViaticos p = (SolicitudViaticos)session.load(SolicitudViaticos.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public SolicitudViaticos buscaSCC(long id)
    {
        SolicitudViaticos p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (SolicitudViaticos)session.get(SolicitudViaticos.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
