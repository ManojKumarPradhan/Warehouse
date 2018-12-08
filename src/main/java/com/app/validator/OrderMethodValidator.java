package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orderMethod = (OrderMethod) target;
		if ("".equals(orderMethod.getMode()) || orderMethod.getMode() == null) {
			errors.rejectValue("mode", null, "Plesae click On one Value");
		}
		if (!Pattern.compile("[A-Z]{3,7}").matcher(orderMethod.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter a Valid Code Must be (3 to 7 Upper Case)");
		}
		if ("".equals(orderMethod.getMethod())) {
			errors.rejectValue("method", null, "Plesae Select one Value");
		}
		if (orderMethod.getAccept() == null || orderMethod.getAccept().isEmpty()) {
			errors.rejectValue("accept", null, "Plesae click on atleast one check box");
		}
		if (!Pattern.compile("[A-Za-z\\.\\_\\s\\-]{10,200}").matcher(orderMethod.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Plesae Enter a Valid (min 10 word) Description");
		}
	}

}
