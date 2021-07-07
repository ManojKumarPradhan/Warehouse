package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder);

	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	public void deletePurchaseOrder(Integer id);

	public PurchaseOrder getOnePurchaseOrderById(Integer id);

	public List<PurchaseOrder> getAllPurchaseOrders();
}
