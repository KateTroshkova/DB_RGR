package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;

import java.sql.*;

public class DBProtocol {

    private GoodDao usersDao = new GoodDao();

    public void saveGood(Good good){
        usersDao.save(good);
    }

    public void updateGood(Good good){
        usersDao.update(good);
    }

    public int deleteGood(int id){
        Good good = usersDao.findById(id);
        usersDao.delete(good);
        return good.getId();
    }
}
