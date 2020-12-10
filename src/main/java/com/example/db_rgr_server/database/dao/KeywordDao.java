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

    public void save(Keyword keyword) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(keyword);
        tx1.commit();
        session.close();
    }

    public void update(Keyword keyword) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(keyword);
        tx1.commit();
        session.close();
    }

    public void delete(Keyword keyword) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for(Good good: keyword.getGoods()){
            good.removeKeyword(keyword);
            session.update(good);
        }
        session.delete(keyword);
        tx1.commit();
        session.close();
    }

    public List<Keyword> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Keyword> keywords = session.createQuery("from Keyword", Keyword.class).list();
        tx1.commit();
        session.close();
        return keywords;
    }
}