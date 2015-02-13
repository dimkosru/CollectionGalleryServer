package ru.redraven.collection.dao;

import java.util.List;

import ru.redraven.collection.model.Item;

public interface ItemDao {

	void saveItem(Item item);
	
	List<Item> findAllItems();
	
	void deleteItemById(int id);
}
