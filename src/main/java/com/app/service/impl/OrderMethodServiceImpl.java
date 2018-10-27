package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrder(OrderMethod orderMethod) {
		return dao.saveOrder(orderMethod);
	}

	@Transactional
	public void updateOrder(OrderMethod orderMethod) {
		dao.updateOrder(orderMethod);
	}

	@Transactional
	public void deleteOrder(Integer id) {
		dao.deleteOrder(id);
	}

	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethodById(Integer id) {
		return dao.getOneOrderMethodById(id);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

}
