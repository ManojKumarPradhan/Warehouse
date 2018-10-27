package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveShipmentType(ShipmentType shipmentType) {
		return (Integer) hibernateTemplate.save(shipmentType);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		hibernateTemplate.delete(new ShipmentType(id));
	}

	@Override
	public void updateShipmentType(ShipmentType shipmentType) {
		hibernateTemplate.update(shipmentType);
	}

	@Override
	public ShipmentType getOneShipmentTypeById(Integer id) {
		return hibernateTemplate.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return hibernateTemplate.loadAll(ShipmentType.class);
	}

}
