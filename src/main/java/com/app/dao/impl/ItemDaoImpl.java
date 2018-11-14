package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveItem(Item item) {
		return (Integer) hibernateTemplate.save(item);
	}

	@Override
	public void deleteItem(Integer id) {
		hibernateTemplate.delete(new Item(id));
	}

	@Override
	public void updateItem(Item item) {
		hibernateTemplate.update(item);
	}

	@Override
	public Item getOneItemById(Integer id) {
		return hibernateTemplate.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		return hibernateTemplate.loadAll(Item.class);
	}

}
