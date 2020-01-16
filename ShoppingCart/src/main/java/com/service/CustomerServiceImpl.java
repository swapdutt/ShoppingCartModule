/**
 * 
 */
package com.service;

import java.util.List;

import com.model.Customer;

/**
 * @author SwapnadeepDutta
 *
 */
public interface CustomerServiceImpl {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByEmailId(String emailId);

}
