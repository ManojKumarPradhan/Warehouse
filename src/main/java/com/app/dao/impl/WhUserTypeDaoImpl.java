package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveWhUserType(WhUserType whUserType) {
		return (Integer) hibernateTemplate.save(whUserType);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		hibernateTemplate.delete(new WhUserType(id));
	}

	@Override
	public void updateWhUserType(WhUserType whUserType) {
		hibernateTemplate.update(whUserType);
	}

	@Override
	public WhUserType getOneWhUserTypeById(Integer id) {
		return hibernateTemplate.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return hibernateTemplate.loadAll(WhUserType.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<WhUserType> getWhUserByType(String type) {
		String hql_by_type = "from " + WhUserType.class.getName() + " where type=?";
		return (List<WhUserType>) hibernateTemplate.find(hql_by_type, type);
	}

}
