package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item) target;
		if (!Pattern.compile("[A-Z]{4,8}").matcher(item.getItemCode()).matches()) {
			errors.rejectValue("itemCode", null, "Please Enter a Valid Code Must be (4 to 8 Upper Case)");
		}
		if (item.getWidth() == null || item.getWidth() <= 0.0 || item.getHeight() == null || item.getHeight() <= 0.0
				|| item.getLength() == null || item.getLength() <= 0.0) {
			errors.rejectValue("width", null, "Please Enter a Positive Number");
		}
		if (item.getItemCost() == null || item.getItemCost() <= 0.0) {
			errors.rejectValue("itemCost", null, "Please Enter a valid cost");
		}
		if (item.getCurrency() == null || "".equals(item.getCurrency())) {
			errors.rejectValue("currency", null, "Please Select One Currency Type");
		}
		if (item.getUom() == null || item.getUom().getId() == null) {
			errors.rejectValue("uom", null, "Please Select One UOM type");
		}
		if (item.getSaleType() == null || item.getSaleType().getId() == null) {
			errors.rejectValue("saleType", null, "Please Select One Sale type");
		}
		if (item.getPurchaseType() == null || item.getPurchaseType().getId() == null) {
			errors.rejectValue("purchaseType", null, "Please Select One Purchase type");
		}
		if (item.getVenderType() == null || item.getVenderType().isEmpty()) {
			errors.rejectValue("venderType", null, "Please Select at least One Vender type");
		}
		if (item.getCustomerType() == null || item.getCustomerType().isEmpty()) {
			errors.rejectValue("customerType", null, "Please Select at least One Customer type");
		}
	}

}
