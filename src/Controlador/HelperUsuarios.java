/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuarios;
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

public class HelperUsuarios {

     public DefaultTableModel obtenerUsuarios(DefaultTableModel modelo)
    {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Proveedores p where p.proveedorEstado = 1");
        List<Usuarios> lista = (List<Usuarios>) q.list();
        Iterator<Usuarios> iter=lista.iterator();
        tx.commit();
        while(iter.hasNext())
        {
            Usuarios p = (Usuarios) iter.next();
            modelo.addRow(new Object[]{p.getUsuarioId(),p.getUsuarioUser(),p.getUsuarioNombres(),p.getUsuarioPassword()});
        }
        session.close();
        return modelo; 
    }
     
//    public DefaultTableModel buscaProveedores(String texto, DefaultTableModel modelo,int llave) {
//        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
//        Session session;
//        session = sesion.openSession();
//        Transaction tx = session.beginTransaction();
//        if (llave == 1) {
//            Query q = session.createQuery("select p.proveedorId,p.proveedorRuc,p.proveedorRs "
//                + "from Proveedores as p where p.proveedorRuc like '%"+ texto +"%'");
//            List<Object[]> lista = (List<Object[]>) q.list();
//            tx.commit();
//            for (Object[] p : lista) {
//                modelo.addRow(new Object[]{
//                    p[0], p[1],p[2]
//                });
//            }
//        } else {
//            if (llave == 2) {
//                Query q = session.createQuery("select p.proveedorId,p.proveedorRuc,p.proveedorRs "
//                + "from Proveedores as p where p.proveedorRs like '%"+ texto +"%'");
//                List<Object[]> lista = (List<Object[]>) q.list();
//                tx.commit();
//                for (Object[] p : lista) {
//                    modelo.addRow(new Object[]{
//                        p[0], p[1],p[2]
//                    });
//                }
//            } 
//        }
//        session.close();
//        return modelo;
//
//    } 
    
    public Usuarios getCUser(String texto) {
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuarios as p where p.usuarioUser like '%"+ texto +"%'");
        Usuarios p = (Usuarios) q.uniqueResult();
        
        

        session.close();
        return p;
    }
    
    public void actualizar(Usuarios p,int id){
        Transaction tx;
        try{
           SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            tx = session.beginTransaction(); 
            p.setUsuarioId(id);
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
            Usuarios p = (Usuarios)session.load(Usuarios.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }catch(HibernateException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    
    public Usuarios buscaUsuarios(int id)
    {
        Usuarios p;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        p = (Usuarios)session.get(Usuarios.class,id);
        tx.commit();
        session.close();
        return p;
    }
}
