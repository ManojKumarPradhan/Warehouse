package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipmentType(ShipmentType shipmentType);

	public void deleteShipmentType(Integer id);

	public void updateShipmentType(ShipmentType shipmentType);

	public ShipmentType getOneShipmentTypeById(Integer id);

	public List<ShipmentType> getAllShipmentTypes();
}
