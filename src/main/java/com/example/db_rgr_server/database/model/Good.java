package com.example.db_rgr_server.database.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id", updatable = false, nullable = false)
    private int id;
    @Column(name = "good_name")
    private String name;
    @Column(name = "price")
    private float price;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "bond",
            joinColumns = { @JoinColumn(name = "good_id") },
            inverseJoinColumns = { @JoinColumn(name = "keyword_id") }
    )
    Set<Keyword> keywords = new HashSet<>();

    public Good(){

    }

    public Good(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Good(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void addKeyword(Keyword keyword){
        keywords.add(keyword);
    }

    public void removeKeyword(Keyword keyword){keywords.remove(keyword);}

    public Set<Keyword> getKeywords(){return keywords;}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
        hash = 97 * hash + Objects.hashCode(this.price);
        return hash;
    }
}
