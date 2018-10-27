package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveVendor(Vendor vendor) {
		return (Integer) hibernateTemplate.save(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		hibernateTemplate.update(vendor);
	}

	@Override
	public void deleteVendor(Integer id) {
		hibernateTemplate.delete(new Vendor(id));
	}

	@Override
	public Vendor getOneVendorById(Integer id) {
		return hibernateTemplate.get(Vendor.class, id);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return hibernateTemplate.loadAll(Vendor.class);
	}

}
