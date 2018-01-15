/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tractos;
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
public class HelperTractos {
     public DefaultTableModel obtenerT(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Tractos e where e.TEstado = 1");
        List<Tractos> lista = (List<Tractos>) q.list();
        Iterator<Tractos> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            Tractos e = (Tractos) iter.next();
            modelo.addRow(new Object[]{e.getTId(),e.getTPlaca(),e.getTMarca(),e.getTModelo()});
        }
        session.close();
        return modelo; 
    }
    
        public void llenaCboT(JComboBox combo) {
        try {

            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();

            Criteria crit = session.createCriteria(Tractos.class);
            List<Tractos> lista = (List<Tractos>) crit.list();


            for (Tractos e : lista) {
                combo.addItem(e.getTPlaca());
            }
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    public DefaultTableModel buscaTractos(String texto, DefaultTableModel modelo, int llave) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        if (llave == 1) {
            Query q = session.createQuery("select e.TId,e.TPlaca,e.TMarca,e.TModelo "
                    + "from Tractos as e where e.TPlaca like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3]
                });
            }
        } else if (llave == 2) {
            Query q = session.createQuery("select e.TId,e.TPlaca,e.TMarca,e.TModelo "
                    + "from Tractos as e where e.TMarca like '%" + texto + "%'");
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
    
    public void actualizar(Tractos em,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            em.setTId(id);
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
            Tractos e = (Tractos)session.load(Tractos.class, id);
            session.delete(e);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public Tractos buscaT(int id)
    {
        Tractos e;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        e = (Tractos)session.get(Tractos.class,id);
        tx.commit();
        session.close();
        return e;
    }
}
