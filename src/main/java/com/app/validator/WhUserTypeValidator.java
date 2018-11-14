package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType whUserType = (WhUserType) target;
		if (whUserType.getType() == null || "".equals(whUserType.getType())) {
			errors.rejectValue("type", null, "Please Click on one Value");
		}
		if (!Pattern.compile("[A-Z]{5,10}").matcher(whUserType.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter a Valid Code Must be (5 to 10 Upper Case)");
		}
		if (!Pattern.compile("[a-z]+[\\@][a-z]+[\\.][a-z]+").matcher(whUserType.getEmail()).matches()) {
			errors.rejectValue("email", null, "Please Enter one valid Email Id");
		}
		if (!Pattern.compile("[0-9]{10}").matcher(whUserType.getContact()).matches()) {
			errors.rejectValue("contact", null, "Please Enter 10 Digit valid Mobile Number");
		}
		if (whUserType.getIdType() == null || "".equals(whUserType.getIdType())) {
			errors.rejectValue("idType", null, "Please Select one Value");
			errors.rejectValue("idNum", null, "Please Enter Valid Id Type First");
		} else if (whUserType.getIdNum() == null || "".equals(whUserType.getIdNum())) {
			errors.rejectValue("idNum", null, "Please Enter Valid Id Number");
		} else if (whUserType.getIdType().equalsIgnoreCase("PanCard")) {
			if (!Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]").matcher(whUserType.getIdNum()).matches()) {
				errors.rejectValue("idNum", null, "Please Enter Pan Card Number");
			}
		} else if (whUserType.getIdType().equalsIgnoreCase("Aadhar")) {
			if (!Pattern.compile("[0-9]{4}[\\s][0-9]{4}[\\s][0-9]{4}").matcher(whUserType.getIdNum()).matches()) {
				errors.rejectValue("idNum", null, "Please Enter Valid Aadhar Number");
			}
		} else if (whUserType.getIdType().equalsIgnoreCase("VoterID")) {
			if (!Pattern.compile("[A-Z]{3}[0-9]{7}").matcher(whUserType.getIdNum()).matches()) {
				errors.rejectValue("idNum", null, "Please Enter Valid Voter ID Number");
			}
		}

		if ("".equals(whUserType.getIfOther())) {
			errors.rejectValue("ifOther", null, "Please Enter one Value");
		}
	}

}
