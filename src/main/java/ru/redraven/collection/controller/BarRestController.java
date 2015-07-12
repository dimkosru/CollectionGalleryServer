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

    @RequestMapping(value = BarRestURIConstants.CREATE_BAR, method = RequestMethod.POST)
    public void createBar(Bar bar) {
        barDAO.create(bar);
        // HTTP status code 201 Created for a successful PUT of a new resource, with URIs and metadata of the new resource echoed in the response body
    }

    @RequestMapping(value = BarRestURIConstants.UPDATE_BAR, method = RequestMethod.PUT)
    public void updateBar(Bar bar) {
        barDAO.update(bar);
        // HTTP status code 200 OK for a successful PUT of an update to an existing resource. No response body needed.
    }

    @RequestMapping(value = BarRestURIConstants.DELETE_BAR, method = RequestMethod.DELETE)
    public void deleteBar(@PathVariable("id") int id) {
        barDAO.delete(id);
    }
}