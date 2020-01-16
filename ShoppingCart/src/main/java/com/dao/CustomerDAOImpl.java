/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Customer;

/**
 * @author SwapnadeepDutta
 *
 */

public interface CustomerDAOImpl {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByEmailId(String emailId);
}
