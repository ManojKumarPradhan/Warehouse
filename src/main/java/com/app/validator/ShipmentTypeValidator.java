package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType  shipmentType=(ShipmentType) target;
		if("".equals(shipmentType.getMode())||shipmentType.getMode()==null) {
			errors.rejectValue("mode", null, "Please Select One Value");
		}
		if(!Pattern.compile("[A-Z]{4,10}").matcher(shipmentType.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter a Valid Code Must be (4 to 10 Upper Case)");
		}
		if("".equals(shipmentType.getEnabled())||shipmentType.getEnabled()==null) {
			errors.rejectValue("enabled", null, "Please Select One Value");
		}
		if("".equals(shipmentType.getGrade())||shipmentType.getGrade()==null) {
			errors.rejectValue("grade", null, "Please Select One Grade");
		}
		if(!Pattern.compile("[A-Za-z\\.\\_\\s\\-]{10,200}").matcher(shipmentType.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Plesae Enter a Valid (min 10 word) Description");
		}
	}

}
