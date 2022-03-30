package dao;

import Models.Mens;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

public class MenDao {
    public Mens findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Mens men = session.get(Mens.class, id);
        session.close();

        return men;
    }

    public void save(Mens men) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(men);
        transaction.commit();
        session.close();
    }

    public void update(Mens men) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(men);
        transaction.commit();
        session.close();
    }

    public void delete(Mens men) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(men);
        transaction.commit();
        session.close();
    }
}
