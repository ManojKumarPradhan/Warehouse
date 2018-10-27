package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {

	public Integer saveWhUserType(WhUserType whUserType);

	public void deleteWhUserType(Integer id);

	public void updateWhUserType(WhUserType whUserType);

	public WhUserType getOneWhUserTypeById(Integer id);

	public List<WhUserType> getAllWhUserTypes();
}
