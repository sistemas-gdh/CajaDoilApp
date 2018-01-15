/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ServTransporte;
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
public class HelperST {
     public DefaultTableModel obtenerST(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from ServTransporte e where e.stEstado = 1");
        List<ServTransporte> lista = (List<ServTransporte>) q.list();
        Iterator<ServTransporte> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            ServTransporte e = (ServTransporte) iter.next();
            modelo.addRow(new Object[]{e.getStId(),e.getStOrigen(),e.getStDestino(),e.getStPcant(),e.getStPeajes()});
        }
        session.close();
        return modelo; 
    }
    
        public void llenaCboST(JComboBox combo) {
        try {

            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();

            Criteria crit = session.createCriteria(ServTransporte.class);
            List<ServTransporte> lista = (List<ServTransporte>) crit.list();


            for (ServTransporte e : lista) {
                combo.addItem(e.getStOrigen() +" - "+e.getStDestino()+" - "+e.getStPeajes());
            }
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    public DefaultTableModel buscaSTransp(String texto, DefaultTableModel modelo, int llave) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        if (llave == 1) {
            Query q = session.createQuery("select e.stId,e.stOrigen,e.stDestino,e.stPcant,e.stPeajes "
                    + "from ServTransporte as e where e.stOrigen like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3],p[4]
                });
            }
        } else if (llave == 2) {
            Query q = session.createQuery("select e.stId,e.stOrigen,e.stDestino,e.stPcant,e.stPeajes "
                    + "from ServTransporte as e where e.stDestino like '%" + texto + "%'");
            List<Object[]> lista = (List<Object[]>) q.list();
            tx.commit();
            for (Object[] p : lista) {
                modelo.addRow(new Object[]{
                    p[0], p[1], p[2],p[3],p[4]
                });
            }
        }
        session.close();
        return modelo;
    }
    
    public void actualizar(ServTransporte em,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            em.setStId(id);
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
            ServTransporte e = (ServTransporte)session.load(ServTransporte.class, id);
            session.delete(e);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public ServTransporte buscaST(int id)
    {
        ServTransporte e;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        e = (ServTransporte)session.get(ServTransporte.class,id);
        tx.commit();
        session.close();
        return e;
    }
}
