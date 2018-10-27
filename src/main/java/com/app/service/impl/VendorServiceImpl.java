package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao dao;

	@Transactional
	public Integer saveVendor(Vendor vendor) {
		return dao.saveVendor(vendor);
	}

	@Transactional
	public void updateVendor(Vendor vendor) {
		dao.updateVendor(vendor);
	}

	@Transactional
	public void deleteVendor(Integer id) {
		dao.deleteVendor(id);
	}

	@Transactional
	public Vendor getOneVendorById(Integer id) {
		return dao.getOneVendorById(id);
	}

	@Transactional
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

}
