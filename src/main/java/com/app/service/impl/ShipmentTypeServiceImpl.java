package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType shipmentType) {
		return dao.saveShipmentType(shipmentType);
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);
	}

	@Transactional
	public void updateShipmentType(ShipmentType shipmentType) {
		dao.updateShipmentType(shipmentType);
	}

	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentTypeById(Integer id) {
		return dao.getOneShipmentTypeById(id);
	}

	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentTypes() {
		return dao.getAllShipmentTypes();
	}

}
