package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;

@Component
public class UomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom uom = (Uom) target;
		if ("".equals(uom.getType().trim()) || uom.getType() == null) {
			errors.rejectValue("type", null, "Please enter atleast one Type");
		}
		if (!Pattern.compile("[A-Z]{4,10}").matcher(uom.getModel()).matches()) {
			errors.rejectValue("model", null, "Please Enter a Valid Model Must be (4 to 10 Upper Case)");
		}
		if (!Pattern.compile("[A-Za-z\\.\\_\\s\\-]{10,200}").matcher(uom.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Plesae Enter a Valid (min 10 word) Description");
		}
	}

}
