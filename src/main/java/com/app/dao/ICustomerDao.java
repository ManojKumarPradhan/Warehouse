package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {

	public Integer saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCuctomer(Integer id);

	public Customer getOneCustomerById(Integer id);

	public List<Customer> getAllCustomers();
}
