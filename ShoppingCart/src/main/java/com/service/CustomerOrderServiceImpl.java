/**
 * 
 */
package com.service;

import com.model.CustomerOrder;

/**
 * @author SwapnadeepDutta
 *
 */
public interface CustomerOrderServiceImpl {

	void addCustomerOrder(CustomerOrder customerOrder);

	double getCustomerOrderGrandTotal(String cartId);

}
