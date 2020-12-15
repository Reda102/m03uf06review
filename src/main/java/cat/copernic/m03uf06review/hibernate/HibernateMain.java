/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import cat.copernic.m03uf06review.conexion.ControllerHibernateUtil;
import cat.copernic.m03uf06review.pojos.Alumnat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 * Cal usar la llibreria Hibernate.
 *
 *
 * @author pep
 */
public class HibernateMain {

    static HibernateMain HibeMain = new HibernateMain();
    static ControllerHibernateUtil HibeUtil = new ControllerHibernateUtil();
    static Alumnat a1;
    static Alumnat a2;
    static Alumnat a3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        a1 = new Alumnat(Integer.SIZE, "12345678A", "Pepe", "Lopez", 60.5, new Date(2000 - 03 - 25), TRUE);
        a2 = new Alumnat(Integer.SIZE, "12345679B", "Reda", "Anna", 60.5, new Date(2003 - 9 - 12), FALSE);
        a3 = new Alumnat(Integer.SIZE, "12345680C", "Luis", "Perez", 60.5, new Date(1998 - 01 - 9), TRUE);

        Integer ID1 = HibeMain.insertAlumnat(a1);
        Integer ID2 = HibeMain.insertAlumnat(a2);
        Integer ID3 = HibeMain.insertAlumnat(a3);

        HibeMain.updateAlumnat(ID1);

        HibeMain.deleteAlumnat(ID2);

        HibeMain.getListaDeAlumnat();

    }

    public Integer insertAlumnat(Alumnat alumnat) {

        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;
        Integer contador = 6;

        try {
            tx = session.beginTransaction();
            ID = (Integer) session.save(alumnat);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ID;
    }

    public void updateAlumnat(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Alumnat a = (Alumnat) session.get(Alumnat.class, ID);
            a.setNom("Mohamed");
            a.setCognoms("AL AKIL");
            session.update(a);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteAlumnat(Integer ID) {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Alumnat alumnat = (Alumnat) session.get(Alumnat.class, ID);
            session.delete(alumnat);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getListaDeAlumnat() {
        Session session = HibeUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List alumnat = session.createQuery("FROM Alumnat").list();
            for (Iterator iterator = alumnat.iterator(); iterator.hasNext();) {
                Alumnat alumnats = (Alumnat) iterator.next();
                System.out.println("ID "+alumnats.getId()+" DNI " + alumnats.getDni() + " Nom " + alumnats.getNom() + " Cognom " + alumnats.getCognoms() + " Matricula "
                        + alumnats.getMatricula() + " Data Naixament " + alumnats.getDataNaixement()
                        + " Mayor Edad " + alumnats.getMayorEdad());
            }

            tx.commit();
            System.out.println("Todo Correcto!!!");
            alumnat.clear();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
