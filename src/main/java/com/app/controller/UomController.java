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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator validator;

	@RequestMapping("/save")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertData(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		validator.validate(uom, errors);
		if (!errors.hasErrors()) {
			map.addAttribute("message", "Uom With id  '" + service.saveUom(uom) + "'  Inserted sucessfully");
			map.addAttribute("uom", new Uom());
		}
		return "UomRegister";
	}

	@RequestMapping("/all")
	public String showAllUom(ModelMap map) {
		map.addAttribute("uoms", service.getAllUoms());
		return "UomDatas";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteUom(id);
		map.addAttribute("message", "Uom of ID '" + id + "' Deleted Sucessfully");
		map.addAttribute("uoms", service.getAllUoms());
		return "UomDatas";
	}

	@RequestMapping("/edit")
	public String showUpdatePage(@RequestParam("id") Integer id, ModelMap map) {
		map.addAttribute("uom", service.getOneUomByID(id));
		return "UomUpdate";
	}

	@RequestMapping("/update")
	public String updateUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		validator.validate(uom, errors);
		if(!errors.hasErrors()) {
			service.updateUom(uom);
			map.addAttribute("message", "Uom of ID '" + uom.getId() + "' Updated Sucessfully");
			map.addAttribute("uoms", service.getAllUoms());
			return "UomDatas";			
		}
		return "UomUpdate";
	}

	@RequestMapping("/excel")
	public ModelAndView getExcelView() {
		return new ModelAndView(new UomExcelView(), new ModelMap().addAttribute("uoms", service.getAllUoms()));
	}

	@RequestMapping("/pdf")
	public ModelAndView getPDFView() {
		return new ModelAndView(new UomPdfView(), new ModelMap().addAttribute("uoms", service.getAllUoms()));
	}
}
