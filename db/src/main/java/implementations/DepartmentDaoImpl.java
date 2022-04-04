package implementations;

import interfaces.IDepartmentDao;
import models.Departments;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

public class DepartmentDaoImpl implements IDepartmentDao {
    public Departments findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Departments departments = session.get(Departments.class, id);

        if(departments == null) {
            return null;
        }
        session.close();

        return departments;
    }

    public void save(Departments department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(department);
        transaction.commit();
        session.close();
    }

    public void update(Departments department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(department);
        transaction.commit();
        session.close();
    }

    public void delete(Departments department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        session.close();
    }
}
