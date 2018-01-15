/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SolicitudCaja;
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

public class HelperSCC {

    Helper oper = new Helper();
    
     public DefaultTableModel obtenerSCC(DefaultTableModel modelo,int bypass,int codU)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "";
        if(bypass == 2){
            hqlquery = "from SolicitudCaja p where p.scEstado = 1";
        }else if(bypass == 3){
            hqlquery = "from SolicitudCaja p where p.scEstado = 0";
        }else{
            hqlquery = "from SolicitudCaja p where p.usuarios.usuarioId = "+ codU +" order by field (p.scEstado,3,5,4,0,1,2) desc ";
        }
        Query q = session.createQuery(hqlquery);
        List<SolicitudCaja> lista = (List<SolicitudCaja>) q.list();
        Iterator<SolicitudCaja> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudCaja p = (SolicitudCaja) iter.next();
            String m = "";
            if(p.getSpTm()==1){
                m = "SOLES";
            }else{
                m = "DOLARES";
            }
            if(bypass==3 || bypass == 2){
                modelo.addRow(new Object[]{p.getScId(),p.getScSerie(),p.getSpFecha(),p.getScDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getScImporte(),m,oper.validarAprob(p.getScAprob1()),oper.validarAprob(p.getScAprob2()),oper.validarAprob(p.getScAprob3()),oper.validarESC(p.getScEstado())});
            }else{
                modelo.addRow(new Object[]{p.getScId(),p.getScSerie(),p.getSpFecha(),p.getScDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getScImporte(),m,oper.validarESC(p.getScEstado())});   
            }
            
        }
        session.close();
        return modelo; 
    }
     
     public DefaultTableModel obtenerSCEXT(DefaultTableModel modelo,int bypass,int codU)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudCaja p where p.usuarios.usuarioId = "+ codU +" order by field (p.scEstado,3,5,4,0,1,2) desc ";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudCaja> lista = (List<SolicitudCaja>) q.list();
        Iterator<SolicitudCaja> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudCaja p = (SolicitudCaja) iter.next();
            String m = "";
            if(p.getSpTm()==1){
                m = "SOLES";
            }else{
                m = "DOLARES";
            }
               modelo.addRow(new Object[]{p.getScId(),p.getScSerie(),p.getSpFecha(),p.getScDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getScImporte(),m,oper.validarESC(p.getScEstado())});   
        }
        session.close();
        return modelo; 
    } 
    
    public DefaultTableModel searchSCC(DefaultTableModel modelo,int estado,int codU)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudCaja p where p.usuarios.usuarioId = "+ codU +" and p.scEstado = "+estado+"order by p.spFecha desc ";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudCaja> lista = (List<SolicitudCaja>) q.list();
        Iterator<SolicitudCaja> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudCaja p = (SolicitudCaja) iter.next();
            String m = "";
            if(p.getSpTm()==1){
                m = "SOLES";
            }else{
                m = "DOLARES";
            }
               modelo.addRow(new Object[]{p.getScId(),p.getScSerie(),p.getSpFecha(),p.getScDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getScImporte(),m,oper.validarESC(p.getScEstado())});   
        }
        session.close();
        return modelo; 
    }
    
        public DefaultTableModel searchSCCBySerie(DefaultTableModel modelo,int codU,String cad)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        String hqlquery = "from SolicitudCaja p where p.usuarios.usuarioId = "+ codU +" and p.scSerie like '%"+ cad +"%'";
        
        Query q = session.createQuery(hqlquery);
        List<SolicitudCaja> lista = (List<SolicitudCaja>) q.list();
        Iterator<SolicitudCaja> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            SolicitudCaja p = (SolicitudCaja) iter.next();
            String m = "";
            if(p.getSpTm()==1){
                m = "SOLES";
            }else{
                m = "DOLARES";
            }
               modelo.addRow(new Object[]{p.getScId(),p.getScSerie(),p.getSpFecha(),p.getScDesc(),p.getUsuarios().getUsuarioNombres(),p.getUsuarios().getDepartamentos().getDptoDesc(),p.getScImporte(),m,oper.validarESC(p.getScEstado())});   
        }
        session.close();
        return modelo; 
    }
    
    
     
    public SolicitudCaja getLast() {
        SolicitudCaja pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (SolicitudCaja) session.createQuery("SELECT c from SolicitudCaja as c ORDER BY c.scId DESC").setFirstResult(0).setMaxResults(1).uniqueResult();
        tx.commit();
        session.close();
        return pp;
        
    }

    
    public void aodSCC(long codSCC,int valor,int llave,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String hqlUpdate = "";
        switch(llave){
            case 2:
            hqlUpdate = "update SolicitudCaja c set c.scAprob1 = :newAprobx,c.scEstado = :newScEstado where c.scId = :oldSCC";  
            break;
            case 3:
            hqlUpdate = "update SolicitudCaja c set c.scAprob2 = :newAprobx,c.scEstado = :newScEstado where c.scId = :oldSCC"; 
            break;
            case 14:
            hqlUpdate = "update SolicitudCaja c set c.scAprob3 = :newAprobx,c.scEstado = :newScEstado where c.scId = :oldSCC"; 
            break;   
        }
        session.createQuery( hqlUpdate )
                .setInteger("newAprobx", valor)
                .setInteger("newScEstado", estado)
                .setLong("oldSCC", codSCC).executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    }
    
    public void aESCC(long codSCC,int estado){
        try{
                 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        String hqlUpdate = "update SolicitudCaja c set c.scEstado = :newScEstado where c.scId = :oldSCC";
        session.createQuery( hqlUpdate )
                .setInteger("newScEstado", estado)
                .setLong("oldSCC", codSCC).executeUpdate();
        tx.commit();
        session.close(); 
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
       }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

    }
    
    public void actualizar(SolicitudCaja p,long id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setScId(id);
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
            SolicitudCaja p = (SolicitudCaja)session.load(SolicitudCaja.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public SolicitudCaja buscaSCC(long id)
    {
        SolicitudCaja p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (SolicitudCaja)session.get(SolicitudCaja.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
