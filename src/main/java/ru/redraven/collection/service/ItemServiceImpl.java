package ru.redraven.collection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.redraven.collection.dao.ItemDao;
import ru.redraven.collection.model.Item;

@Service("employeeService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;
	
	public void saveItem(Item item) {
		dao.saveItem(item);
	}

	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	public void deleteItemById(int id) {
		dao.deleteItemById(id);
	}

}
