package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;

@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder purchaseOrder = (PurchaseOrder) target;
		if (!Pattern.compile("[A-Z]{4,10}").matcher(purchaseOrder.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter a Valid Code (minimun 4 and Maximun 10 Uppercase)");
		}
		if (purchaseOrder.getShipmentType().getId() == null) {
			errors.rejectValue("shipmentType.id", null, "Please Select One Shipment Type");
		}
		if (purchaseOrder.getWhUserType() == null) {
			errors.rejectValue("whUserType", null, "Please Select One Shipment Type");
		}
		if (!Pattern.compile("[A-Z0-9]{4}[\\-][A-Z0-9]{4}[\\-][A-Z0-9]{4}").matcher(purchaseOrder.getRefNum())
				.matches()) {
			errors.rejectValue("refNum", null, "Please Enter a Valid Reference Number like (XX99-XX99-XX99)");
		}
		if (purchaseOrder.getQualityCheck() == null || "".equals(purchaseOrder.getQualityCheck())) {
			errors.rejectValue("qualityCheck", null, "Please Click on One");
		}
		if (!Pattern.compile("[A-Za-z0-9\\.\\-\\_\\s]{10,200}").matcher(purchaseOrder.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Please Enter Description with minimum 10 characher");
		}
	}

}
