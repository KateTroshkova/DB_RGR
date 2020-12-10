package com.example.db_rgr_server.database.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="keywords")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id", updatable = false, nullable = false)
    private int id;
    @Column(name = "key")
    private String key;
    @Column(name = "value")
    private String value;

    @ManyToMany(
            mappedBy = "keywords",
            fetch = FetchType.EAGER
    )
    Set<Good> goods = new HashSet<>();

    public Keyword() {
    }

    public Keyword(String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Keyword(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    public void removeGood(Good good){
        goods.remove(good);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword that = (Keyword) o;
        return id == that.id && Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, value);
    }

    @Override
    public String toString() {
        return "KeywordRequest{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
