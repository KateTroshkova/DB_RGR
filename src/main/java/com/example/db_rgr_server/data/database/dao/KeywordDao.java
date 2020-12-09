package com.example.db_rgr_server.data.database.dao;

import com.example.db_rgr_server.data.database.HibernateSessionFactoryUtil;
import com.example.db_rgr_server.domain.model.Good;
import com.example.db_rgr_server.domain.model.Keyword;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KeywordDao {

    public Keyword findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Keyword keyword = session.get(Keyword.class, id);
        tx1.commit();
        session.close();
        return keyword;
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Keyword> goods = session.createQuery("from Keyword", Keyword.class).list();
        tx1.commit();
        session.close();
        return goods;
    }
}