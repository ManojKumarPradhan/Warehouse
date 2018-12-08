package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@Autowired
	private OrderMethodValidator validator;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOrder(@ModelAttribute OrderMethod orderMethod, Errors errors, ModelMap map) {
		validator.validate(orderMethod, errors);
		if (!errors.hasErrors()) {
			map.addAttribute("message", "Order Saved with id '" + service.saveOrder(orderMethod) + "' Sucessfully");
			map.addAttribute("orderMethod", new OrderMethod());
		}
		return "OrderMethodRegister";
	}

	@RequestMapping("/all")
	public String showAllOrder(ModelMap map) {
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
	public String updateOrder(@ModelAttribute OrderMethod orderMethod, Errors errors, ModelMap map) {
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			service.updateOrder(orderMethod);
			map.addAttribute("message", "Order Id  '" + orderMethod.getId() + "'  Updated Sucessfully");
			map.addAttribute("orders", service.getAllOrderMethods());
			return "OrderMethodDatas";			
		}
		return "OrderUpdate";
	}

	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new OrderMethodExcelView(),
				new ModelMap().addAttribute("orders", service.getAllOrderMethods()));
	}

	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new OrderMethodPdfView(),
				new ModelMap().addAttribute("orders", service.getAllOrderMethods()));
	}
}
