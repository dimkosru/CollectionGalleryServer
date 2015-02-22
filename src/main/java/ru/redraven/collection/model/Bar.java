package ru.redraven.collection.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public class Bar implements Serializable {
    private int idBar;
    private String name;
    private Date date;
    private int weight;
    private String additional;
    private int idFactory;
    private int idStandart;

    public Bar() {
    }

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
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

    public int getIdFactory() {
        return idFactory;
    }

    public void setIdFactory(int idFactory) {
        this.idFactory = idFactory;
    }

    public int getIdStandart() {
        return idStandart;
    }

    public void setIdStandart(int idStandart) {
        this.idStandart = idStandart;
    }
}