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
		if (!Pattern.compile("[A_Z]{4,10}").matcher(item.getItemCode()).matches()) {
			errors.rejectValue("itemCode", null, "Please Enter a Valid Code Must be (3 to 7 Upper Case)");
		}
		if (item.getWidth() == null || item.getWidth() <= 0.0
				|| !Pattern.compile("[0-9]{1,4}[\\.][0-9]{1,4}").matcher(String.valueOf(item.getWidth())).matches()) {
			errors.rejectValue("width", null, "Please Enter a Positive Number like (0.2,89.90)");
		}
		if (item.getHeight() == null || item.getHeight() <= 0.0
				|| !Pattern.compile("[0-9]{1,4}[\\.][0-9]{1,4}").matcher(String.valueOf(item.getHeight())).matches()) {
			errors.rejectValue("height", null, "Please Enter a Positive Number like (0.2,89.90)");
		}
		if (item.getLength() == null || item.getLength() <= 0.0
				|| !Pattern.compile("[0-9]{1,4}[\\.][0-9]{1,4}").matcher(String.valueOf(item.getLength())).matches()) {
			errors.rejectValue("length", null, "Please Enter a Positive Number like (0.2,89.90)");
		}
		if (item.getItemCost() == null || item.getItemCost() <= 0.0 || !Pattern.compile("[0-9]{1,4}[\\.][0-9]{1,2}")
				.matcher(String.valueOf(item.getItemCost())).matches()) {
			errors.rejectValue("itemCost", null, "Please Enter a Positive Number like (0.2,89.90)");
		}
		if (item.getCurrency() == null || "".equals(item.getCurrency())) {
			errors.rejectValue("currency", null, "Please Select One Currency Type");
		}
		if (item.getUom().getId() == null) {
			errors.rejectValue("uom.id", null, "Please Select One UOM type");
		}
		if (item.getSaleType().getId() == null) {
			errors.rejectValue("saleType.id", null, "Please Select One Sale type");
		}
		if (item.getPurchaseType().getId() == null) {
			errors.rejectValue("purchaseType.id", null, "Please Select One Purchase type");
		}
		if (item.getVenderType() == null || item.getVenderType().isEmpty()) {
			errors.rejectValue("venderType", null, "Please Select at least One Vender type");
		}
		if (item.getCustomerType() == null || item.getCustomerType().isEmpty()) {
			errors.rejectValue("customerType", null, "Please Select at least One Customer type");
		}
	}

}
