package com.example.db_rgr_server.database.dao;

import com.example.db_rgr_server.database.HibernateSessionFactoryUtil;
import com.example.db_rgr_server.database.model.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class GoodDao {

    public Good findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Good good = session.get(Good.class, id);
        tx1.commit();
        session.close();
        return good;
    }

    public void save(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(good);
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

    public void delete(Good good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(good);
        tx1.commit();
        session.close();
    }

    public List<Good> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Good> goods = session.createQuery("from Good", Good.class).list();
        tx1.commit();
        session.close();
        return goods;
    }
}