package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipmentTypeService;

	@Autowired
	private IWhUserTypeService whUserTypeService;

	@Autowired
	private PurchaseOrderValidator validator;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		map.addAttribute("shipmentTypes", shipmentTypeService.getAllEnabledShipment("Yes"));
		map.addAttribute("venders", whUserTypeService.getWhUserByType("Vender"));
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String savePurchaseOrderData(@ModelAttribute PurchaseOrder purchaseOrder, Errors errors, ModelMap map) {
		map.addAttribute("shipmentTypes", shipmentTypeService.getAllEnabledShipment("Yes"));
		map.addAttribute("venders", whUserTypeService.getWhUserByType("Vender"));
		validator.validate(purchaseOrder, errors);
		if (!errors.hasErrors()) {
			map.addAttribute("purchaseOrder", new PurchaseOrder());
			map.addAttribute("message", "Purchase Order Saved with id  " + service.savePurchaseOrder(purchaseOrder));
		}
		return "PurchaseOrderRegister";
	}

	@RequestMapping("/all")
	public String showAllData(ModelMap map) {
		map.addAttribute("purchaseOrders", service.getAllPurchaseOrders());
		return "PurchaseOrderDatas";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deletePurchaseOrder(id);
		map.addAttribute("message", "Purchase Order '" + id + "' Deleted Sucessfully");
		map.addAttribute("purchaseOrders", service.getAllPurchaseOrders());
		return "PurchaseOrderDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("shipmentTypes", shipmentTypeService.getAllEnabledShipment("Yes"));
		map.addAttribute("venders", whUserTypeService.getWhUserByType("Vender"));
		map.addAttribute("purchaseOrder", service.getOnePurchaseOrderById(id));
		return "PurchaseOrderUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute PurchaseOrder purchaseOrder, Errors errors, ModelMap map) {
		map.addAttribute("shipmentTypes", shipmentTypeService.getAllEnabledShipment("Yes"));
		map.addAttribute("venders", whUserTypeService.getWhUserByType("Vender"));
		validator.validate(purchaseOrder, errors);
		if (!errors.hasErrors()) {
			service.updatePurchaseOrder(purchaseOrder);
			map.addAttribute("purchaseOrders", service.getAllPurchaseOrders());
			map.addAttribute("message", "Purchase Order " + purchaseOrder.getId() + " Updated");
			return "PurchaseOrderDatas";
		}
		return "PurchaseOrderUpdate";
	}
}
