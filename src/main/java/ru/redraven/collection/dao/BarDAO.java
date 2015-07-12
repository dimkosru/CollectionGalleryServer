package ru.redraven.collection.dao;

import ru.redraven.collection.model.Bar;

import java.util.List;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public interface BarDAO {

    public void saveOrUpdate(Bar bar);

    public void delete(int id);

    public Bar get(int id);

    public List<Bar> list();
}
