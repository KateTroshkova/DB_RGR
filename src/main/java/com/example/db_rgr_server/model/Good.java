package com.example.db_rgr_server.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name="goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "good_name")
    private String name;
    @Column(name = "price")
    private int price;

    public Good(){

    }

    public Good(long id, String name, int price, HashSet<String> keywords) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id && price == good.price && name.equals(good.name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.price;
        return hash;
    }
}
