package ru.redraven.collection.service;

import java.util.List;

import ru.redraven.collection.model.Item;

public interface ItemService {

	void saveItem(Item item);
	
	List<Item> findAllItems();
	
	void deleteItemById(int id);
}
