package ru.redraven.collection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.redraven.collection.model.Item;
import ru.redraven.collection.service.ItemService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	ItemService service;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listItems(ModelMap model) {

		List<Item> items = service.findAllItems();
		model.addAttribute("items", items);
		return "allitems";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newItem(ModelMap model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveItem(@Valid Item item, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.saveItem(item);

		model.addAttribute("success", "Item " + item.getName()
				+ " registered successfully");
		return "success";
	}

	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-item" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		service.deleteItemById(id);
		return "redirect:/list";
	}

}
