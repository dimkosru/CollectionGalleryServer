package ru.redraven.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.redraven.collection.dao.BarDAO;
import ru.redraven.collection.model.Bar;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private BarDAO barDAO;

    /*
     * Список всех шоколадок
     */
    @RequestMapping(value = {BarWebURIConstants.GET_ALL_BAR, "/"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Bar> bars = barDAO.list();
        model.addAttribute("bars", bars);
        return "allbars";
    }


    /*
     * Редактирвоание шоколадки
     */
    @RequestMapping(value = {BarWebURIConstants.EDIT_BAR}, method = RequestMethod.GET)
    public String editBar(@PathVariable("id") int idBar, ModelMap model) {
        Bar bar = barDAO.get(idBar);
        model.addAttribute("bar", bar);
        return "edit";
    }



    /*
     * Сохранение шоколадки
     */
    @RequestMapping(value = {BarWebURIConstants.EDIT_BAR}, method = RequestMethod.POST)
    public String saveBar(@ModelAttribute("bar") @Valid Bar bar, BindingResult result, ModelMap model) {
        barDAO.saveOrUpdate(bar);
        model.addAttribute("success", "Шоколадка " + bar.getName() + " успешно сохранена");
        return "success";
    }


}