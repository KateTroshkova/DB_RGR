package com.example.db_rgr_server.repository;

import com.example.db_rgr_server.database.model.Good;
import com.example.db_rgr_server.database.model.Keyword;

import java.util.List;

public class Repository {

    private static Repository instance;

    DBProtocol db;

    private Repository(){
        db = new DBProtocol();
    }

    public static Repository getInstance(){
        return instance;
    }

    public void createGood(Good good, int[] keywordIds){
        for (int keywordId:keywordIds){
            Keyword keyword = db.loadById(keywordId);
            good.addKeyword(keyword);
        }
        db.saveGood(good);
    }

    public void createKeyword(Keyword keyword){
        db.saveKeyword(keyword);
    }

    public List<Good> getGoods(){
        return db.loadAllGoods();
    }

    public List<Keyword> getKeywords(){
        return db.loadAllKeywords();
    }

    public void removeGood(int id){
        db.deleteGood(id);
    }

    public void removeKeyword(int id){
        db.deleteKeyword(id);
    }

    public void updateGood(Good good, int[] keywordIds){
        for (int keywordId:keywordIds){
            Keyword keyword = db.loadById(keywordId);
            good.addKeyword(keyword);
        }
        db.updateGood(good);
    }

    public void updateKeyword(Keyword keyword){
        db.updateKeyword(keyword);
    }
}
