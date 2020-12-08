package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class GoodDao {

    public void save(Good user) {
        System.out.println(user.getId()+" "+user.getName()+" "+user.getPrice());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public List<Good> findAll() {
        List<Good> users = (List<Good>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From goods").list();
        return users;
    }
}