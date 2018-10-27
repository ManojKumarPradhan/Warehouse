package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveUom(Uom uom) {
		return (Integer) hibernateTemplate.save(uom);
	}

	@Override
	public void deleteUom(Integer id) {
		hibernateTemplate.delete(new Uom(id));
	}

	@Override
	public void updateUom(Uom uom) {
		hibernateTemplate.update(uom);
	}

	@Override
	public Uom getOneUomByID(Integer id) {
		return hibernateTemplate.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUoms() {
		return hibernateTemplate.loadAll(Uom.class);
	}

}
