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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelVew;
import com.app.view.WhUserTypePfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute WhUserType whUserType, Errors errors, ModelMap map) {
		validator.validate(whUserType, errors);
		if (!errors.hasErrors()) {
			map.addAttribute("message", "User Saved with id '" + service.saveWhUserType(whUserType) + "' Sucessfully");
			map.addAttribute("whUserType", new WhUserType());
		}
		return "WhUserTypeRegister";
	}

	@RequestMapping("/all")
	public String showAllUser(ModelMap map) {
		map.addAttribute("whUserTypes", service.getAllWhUserTypes());
		return "WhUserTypeDatas";
	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteWhUserType(id);
		map.addAttribute("message", "User ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("whUserTypes", service.getAllWhUserTypes());
		return "WhUserTypeDatas";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("whUserType", service.getOneWhUserTypeById(id));
		return "WhUserTypeUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute WhUserType whUserType, Errors errors, ModelMap map) {
		validator.validate(whUserType, errors);
		if(!errors.hasErrors()) {
			service.updateWhUserType(whUserType);
			map.addAttribute("message", " User Id  '" + whUserType.getId() + "'  Updated Sucessfully");
			map.addAttribute("whUserTypes", service.getAllWhUserTypes());
			return "WhUserTypeDatas";			
		}
		return "WhUserTypeUpdate";
	}

	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new WhUserTypeExcelVew(),
				new ModelMap().addAttribute("users", service.getAllWhUserTypes()));
	}

	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new WhUserTypePfView(),
				new ModelMap().addAttribute("users", service.getAllWhUserTypes()));
	}
}
