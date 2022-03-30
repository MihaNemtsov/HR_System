package dao;

import Models.Departmens;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

public class DepartmentDao {

    public Departmens findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Departmens departmens = session.get(Departmens.class, id);
        session.close();

        return departmens;
    }

    public void save(Departmens departmens) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(departmens);
        transaction.commit();
        session.close();
    }

    public void update(Departmens departmens) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(departmens);
        transaction.commit();
        session.close();
    }

    public void delete(Departmens departmens) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(departmens);
        transaction.commit();
        session.close();
    }
}
