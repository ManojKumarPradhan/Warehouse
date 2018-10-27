package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {

	public Integer saveOrder(OrderMethod orderMethod);

	public void updateOrder(OrderMethod orderMethod);

	public void deleteOrder(Integer id);

	public OrderMethod getOneOrderMethodById(Integer id);

	public List<OrderMethod> getAllOrderMethods();
}
