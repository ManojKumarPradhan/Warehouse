package com.app.conveter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class UserIdToObjectConveter implements Converter<Object, WhUserType> {

	@Autowired
	private IWhUserTypeService whUserService;

	@Override
	public WhUserType convert(Object source) {
		return whUserService.getOneWhUserTypeById(Integer.parseInt((String) source));
	}

}
