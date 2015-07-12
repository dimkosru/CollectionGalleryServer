package ru.redraven.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.redraven.collection.dao.BarDAO;
import ru.redraven.collection.model.Bar;

import java.util.List;

@RestController
public class BarRestController {
    @Autowired
    private BarDAO barDAO;

    @RequestMapping(value = BarRestURIConstants.GET_BAR, method = RequestMethod.GET)
    public Bar getBar(@PathVariable("id") int id) {
        return barDAO.get(id);
    }

    @RequestMapping(value = BarRestURIConstants.GET_ALL_BAR, method = RequestMethod.GET)
    public List<Bar> getBars() {
        return barDAO.list();
    }
}