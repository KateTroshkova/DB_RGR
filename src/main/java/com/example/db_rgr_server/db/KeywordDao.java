package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.model.Keyword;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KeywordDao {

    public Keyword findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Keyword.class, id);
    }

    public void save(Keyword user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Keyword good) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(good);
        tx1.commit();
        session.close();
    }

    public void delete(Keyword user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<Keyword> findAll() {
        List<Keyword> users = (List<Keyword>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From keywords").list();
        return users;
    }
}