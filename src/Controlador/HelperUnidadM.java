/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Umedidas;
import Persistencia.NewHibernateUtil;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author luisv
 */

public class HelperUnidadM {

     public DefaultTableModel obtenerTM(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Umedidas");
        List<Umedidas> lista = (List<Umedidas>) q.list();
        Iterator<Umedidas> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            Umedidas p = (Umedidas) iter.next();
            modelo.addRow(new Object[]{p.getUnidadmId(),p.getUnidadmDesc()});
        }
        session.close();
        return modelo; 
    }
     
    public void llenaCboTM(JComboBox combo) {
        try {

            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();

            Criteria crit = session.createCriteria(Umedidas.class);
            List<Umedidas> lista = (List<Umedidas>) crit.list();

            for (Umedidas p : lista) {
                combo.addItem(p.getUnidadmDesc());
            }
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(Umedidas p,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setUnidadmId(id);
            session.update(p);  
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public void eliminar(int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction();   
            Umedidas p = (Umedidas)session.load(Umedidas.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public Umedidas searchByD(String texto) {
        Umedidas pp;
	 SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
	Transaction tx = session.beginTransaction();
        pp = (Umedidas) session.createQuery("SELECT c from Umedidas as c where c.unidadmDesc like '%"+ texto +"%'").setFirstResult(0).setMaxResults(1).uniqueResult();
        tx.commit();
        session.close();
        return pp;
        
    }
    
    public Umedidas buscaUM(int id)
    {
        Umedidas p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (Umedidas)session.get(Umedidas.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
