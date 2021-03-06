package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	
	@Autowired
	private IShipmentTypeService service;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOrder(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		map.addAttribute("message", "Order Saved with id '" + service.saveShipmentType(shipmentType) + "' Sucessfully");
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping("/all")
	public String showAllOrder(ModelMap map) {
		map.addAttribute("shipmentTypes", service.getAllShipmentTypes());
		return "ShipmentTypeDatas";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteShipmentType(id);
		map.addAttribute("message", "Order ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("shipmentTypes", service.getAllShipmentTypes());
		return "ShipmentTypeDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("shipmentType", service.getOneShipmentTypeById(id));
		return "ShipmentTypeUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		service.updateShipmentType(shipmentType);
		map.addAttribute("message", "Order Id  '" + shipmentType.getId() + "'  Updated Sucessfully");
		map.addAttribute("shipmentTypes", service.getAllShipmentTypes());
		return "ShipmentTypeDatas";
	}
}
