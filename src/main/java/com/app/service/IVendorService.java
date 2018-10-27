package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {

	public Integer saveVendor(Vendor vendor);

	public void updateVendor(Vendor vendor);

	public void deleteVendor(Integer id);

	public Vendor getOneVendorById(Integer id);

	public List<Vendor> getAllVendors();
}
