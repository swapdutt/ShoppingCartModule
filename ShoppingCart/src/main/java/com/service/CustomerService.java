/**
 * 
 */
package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.model.Customer;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class CustomerService implements CustomerServiceImpl {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	public Customer getCustomerByEmailId(String emailId) {
		return customerDAO.getCustomerByEmailId(emailId);
	}

}
