package com.example.db_rgr_server.data.repository;

import com.example.db_rgr_server.data.database.dao.GoodDao;
import com.example.db_rgr_server.data.database.dao.KeywordDao;
import com.example.db_rgr_server.domain.model.Good;
import com.example.db_rgr_server.domain.model.Keyword;

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

    public Keyword loadBuId(int id){
        return keywordsDao.findById(id);
    }
}
