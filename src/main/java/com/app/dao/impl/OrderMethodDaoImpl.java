package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveOrder(OrderMethod orderMethod) {
		return (Integer) hibernateTemplate.save(orderMethod);
	}

	@Override
	public void updateOrder(OrderMethod orderMethod) {
		hibernateTemplate.update(orderMethod);
	}

	@Override
	public void deleteOrder(Integer id) {
		hibernateTemplate.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOneOrderMethodById(Integer id) {
		return hibernateTemplate.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return hibernateTemplate.loadAll(OrderMethod.class);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		return (List<OrderMethod>) hibernateTemplate
				.findByCriteria(DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq("mode", mode)));
	}

}
