package ru.redraven.collection.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ru.redraven.collection.model.Item;

@Repository("employeeDao")
public class ItemDaoImpl extends AbstractDao implements ItemDao {

	public void saveItem(Item item) {
		persist(item);
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return (List<Item>) criteria.list();
	}

	public void deleteItemById(int id) {
		Query query = getSession().createSQLQuery("delete from item where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
}
