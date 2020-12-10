package com.example.db_rgr_server.database.dao;

import com.example.db_rgr_server.database.HibernateSessionFactoryUtil;
import com.example.db_rgr_server.database.model.Good;
import com.example.db_rgr_server.database.model.Keyword;
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
        for(Good good: user.getGoods()){
            good.removeKeyword(user);
            session.update(good);
        }
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