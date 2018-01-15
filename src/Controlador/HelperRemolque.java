/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Remolques;
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
public class HelperRemolque {
     public DefaultTableModel obtenerT(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Remolques e where e.REstado = 1");
        List<Remolques> lista = (List<Remolques>) q.list();
        Iterator<Remolques> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            Remolques e = (Remolques) iter.next();
            modelo.addRow(new Object[]{e.getRId(),e.getRPlaca(),e.getRModelo(),e.getRPesoutil()});
        }
        session.close();
        return modelo; 
    }
    
        public void llenaCboT(JComboBox combo) {
        try {

            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();

            Criteria crit = session.createCriteria(Remolques.class);
            List<Remolques> lista = (List<Remolques>) crit.list();


            for (Remolques e : lista) {
                combo.addItem(e.getRPlaca());
            }
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    public DefaultTableModel buscaRemolques(String texto, DefaultTableModel modelo, int llave) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        if (llave == 1) {
            Query q = session.createQuery("select e.RId,e.RPlaca,e.RModelo,e.RPesoutil "
                    + "from Remolques as e where e.RPlaca like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3]
                });
            }
        } else if (llave == 2) {
            Query q = session.createQuery("select e.RId,e.RPlaca,e.RModelo,e.RPesoutil "
                    + "from Remolques as e where e.RModelo like '%" + texto + "%'");
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
    
    public void actualizar(Remolques em,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            em.setRId(id);
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
            Remolques e = (Remolques)session.load(Remolques.class, id);
            session.delete(e);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public Remolques buscaR(int id)
    {
        Remolques e;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        e = (Remolques)session.get(Remolques.class,id);
        tx.commit();
        session.close();
        return e;
    }
}
