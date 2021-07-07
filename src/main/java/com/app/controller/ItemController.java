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

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderMethodService orderMethodService;

	@Autowired
	private IWhUserTypeService whUserService;

	@Autowired
	private ItemValidator validator;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("item", new Item());
		map.addAttribute("uoms", uomService.getAllUoms());
		map.addAttribute("sales", orderMethodService.getOrderMethodsByMode("Sale"));
		map.addAttribute("purchases", orderMethodService.getOrderMethodsByMode("Purchase"));
		map.addAttribute("vendors", whUserService.getWhUserByType("Vender"));
		map.addAttribute("customers", whUserService.getWhUserByType("Customer"));
		return "ItemRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertItem(@ModelAttribute Item item, Errors errors, ModelMap map) {
		map.addAttribute("uoms", uomService.getAllUoms());
		map.addAttribute("sales", orderMethodService.getOrderMethodsByMode("Sale"));
		map.addAttribute("purchases", orderMethodService.getOrderMethodsByMode("Purchase"));
		map.addAttribute("vendors", whUserService.getWhUserByType("Vender"));
		map.addAttribute("customers", whUserService.getWhUserByType("Customer"));
		validator.validate(item, errors);
		if (!errors.hasErrors()) {
			map.addAttribute("item", new Item());
			map.addAttribute("message", "Item Saved with id '" + service.saveItem(item) + "' Sucessfully");
		}
		return "ItemRegister";

	}

	@RequestMapping("/all")
	public String showAllItem(ModelMap map) {
		map.addAttribute("items", service.getAllItems());
		return "ItemsDatas";
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteItem(id);
		map.addAttribute("message", "Item '" + id + "' Deleted Sucessfully");
		map.addAttribute("items", service.getAllItems());
		return "ItemsDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("item", service.getOneItemById(id));
		map.addAttribute("uoms", uomService.getAllUoms());
		map.addAttribute("sales", orderMethodService.getOrderMethodsByMode("Sale"));
		map.addAttribute("purchases", orderMethodService.getOrderMethodsByMode("Purchase"));
		map.addAttribute("vendors", whUserService.getWhUserByType("Vender"));
		map.addAttribute("customers", whUserService.getWhUserByType("Customer"));
		return "ItemUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute Item item, Errors errors, ModelMap map) {
		validator.validate(item, errors);
		if (!errors.hasErrors()) {
			service.updateItem(item);
			map.addAttribute("message", "Item Id  '" + item.getId() + "'  Updated Sucessfully");
			map.addAttribute("items", service.getAllItems());
			return "ItemsDatas";
		}
		return "ItemUpdate";
	}

	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new ItemExcelView(), new ModelMap().addAttribute("items", service.getAllItems()));
	}

	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new ItemPdfView(), new ModelMap().addAttribute("items", service.getAllItems()));
	}
}