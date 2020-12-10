package com.example.db_rgr_server.repository;

import com.example.db_rgr_server.database.dao.GoodDao;
import com.example.db_rgr_server.database.dao.KeywordDao;
import com.example.db_rgr_server.database.model.Good;
import com.example.db_rgr_server.database.model.Keyword;

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
        Keyword keyword = keywordsDao.findById(id);
        keywordsDao.delete(keyword);
        return keyword.getId();
    }

    public List<Keyword> loadAllKeywords(){
        return keywordsDao.findAll();
    }

    public Keyword loadById(int id){
        return keywordsDao.findById(id);
    }
}
