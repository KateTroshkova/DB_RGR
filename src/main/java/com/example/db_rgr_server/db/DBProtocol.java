package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.model.Keyword;

import java.sql.*;
import java.util.List;

public class DBProtocol {

    private GoodDao usersDao = new GoodDao();
    private KeywordDao keywordsDao = new KeywordDao();

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

    public List<Good> loadAllGoods(){
        return usersDao.findAll();
    }

    public void saveKeyword(Keyword keyword){
        keywordsDao.save(keyword);
    }

    public void updateKeyword(Keyword keyword){
        keywordsDao.update(keyword);
    }

    public int deleteKeyword(int id){
        Keyword good = keywordsDao.findById(id);
        keywordsDao.delete(good);
        return good.getId();
    }

    public List<Keyword> loadAllkeywords(){
        return keywordsDao.findAll();
    }
}
