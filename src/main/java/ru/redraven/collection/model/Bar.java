package ru.redraven.collection.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * Created by Дмитрий on 22.02.2015.
 */
public class Bar implements Serializable {
    private int id;
    private String name;
    private Date date;
    private int weight;
    private String additional;
    private Brand brand;

    public Bar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}