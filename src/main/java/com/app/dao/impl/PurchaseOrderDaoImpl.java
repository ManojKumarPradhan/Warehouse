package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return (Integer) hibernateTemplate.save(purchaseOrder);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		hibernateTemplate.update(purchaseOrder);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		hibernateTemplate.delete(new PurchaseOrder(id));
	}

	@Override
	public PurchaseOrder getOnePurchaseOrderById(Integer id) {
		return hibernateTemplate.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return hibernateTemplate.loadAll(PurchaseOrder.class);
	}

}
