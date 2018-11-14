package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOrder(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		map.addAttribute("message", "Order Saved with id '" + service.saveOrder(orderMethod) + "' Sucessfully");
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping("/all")
	public String showAllOrder(ModelMap map) {
		//get All Methods Data and send through map
		map.addAttribute("orders", service.getAllOrderMethods());
		return "OrderMethodDatas";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteOrder(id);
		map.addAttribute("message", "Order ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("orders", service.getAllOrderMethods());
		return "OrderMethodDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("orderMethod", service.getOneOrderMethodById(id));
		return "OrderUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		service.updateOrder(orderMethod);
		map.addAttribute("message", "Order Id  '" + orderMethod.getId() + "'  Updated Sucessfully");
		map.addAttribute("orders", service.getAllOrderMethods());
		return "OrderMethodDatas";
	}
}
