package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {

	public Integer saveShipmentType(ShipmentType shipmentType);

	public void deleteShipmentType(Integer id);

	public void updateShipmentType(ShipmentType shipmentType);

	public ShipmentType getOneShipmentTypeById(Integer id);

	public List<ShipmentType> getAllShipmentTypes();
}
