package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class GoodDao {

    public Good findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Good.class, id);
    }

    public void save(Good user) {
        System.out.println(user.getId()+" "+user.getName()+" "+user.getPrice());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(good);
        tx1.commit();
        session.close();
    }

    public void delete(Good user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<Good> findAll() {
        List<Good> users = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from Good", Good.class)
                .list();
        return users;
    }
}