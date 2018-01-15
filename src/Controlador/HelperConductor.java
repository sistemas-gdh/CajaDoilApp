/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Choferes;
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
public class HelperConductor {
     public DefaultTableModel obtenerCond(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Choferes e where e.chEstado = 1");
        List<Choferes> lista = (List<Choferes>) q.list();
        Iterator<Choferes> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            Choferes e = (Choferes) iter.next();
            modelo.addRow(new Object[]{e.getChId(),e.getChNombres(),e.getChDni(),e.getChBrevete(),e.getChTelefono(),e.getChTelefono2()});
        }
        session.close();
        return modelo; 
    }
    
        public void llenaCboEmp(JComboBox combo) {
        try {

            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();

            Criteria crit = session.createCriteria(Choferes.class);
            List<Choferes> lista = (List<Choferes>) crit.list();


            for (Choferes e : lista) {
                combo.addItem(e.getChNombres());
            }
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public DefaultTableModel buscaCond(String texto, DefaultTableModel modelo, int llave) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        if (llave == 1) {
            Query q = session.createQuery("select e.chId,e.chNombres,e.chBrevete,e.chTelefono "
                    + "from Choferes as e where e.chNombres like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3]
                });
            }
        } else if (llave == 2) {
            Query q = session.createQuery("select e.chId,e.chNombres,e.chBrevete,e.chTelefono "
                    + "from Choferes as e where e.chBrevete like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3]
                });
            }
        }
        session.close();
        return modelo;
    }
    
    public void actualizar(Choferes em,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            em.setChId(id);
            session.update(em);  
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
            Choferes e = (Choferes)session.load(Choferes.class, id);
            session.delete(e);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public Choferes buscaCd(int id)
    {
        Choferes e;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        e = (Choferes)session.get(Choferes.class,id);
        tx.commit();
        session.close();
        return e;
    }
}
