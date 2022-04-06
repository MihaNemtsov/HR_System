package implementations;

import interfaces.IPostDao;
import models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class PostDaoImpl implements IPostDao {
    public Post findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Post post = session.get(Post.class, id);
        session.close();

        return post;
    }

    public void save(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        transaction.commit();
        session.close();
    }

    public void update(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(post);
        transaction.commit();
        session.close();
    }

    public void delete(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(post);
        transaction.commit();
        session.close();
    }

}