/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerOrderDAO;
import com.model.Cart;
import com.model.CartItem;
import com.model.CustomerOrder;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class CustomerOrderService implements CustomerOrderServiceImpl {

	@Autowired
	private CustomerOrderDAO customerOrderDAO;

	@Autowired
	private CartService cartService;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDAO.addCustomerOrder(customerOrder);

	}

	public double getCustomerOrderGrandTotal(String cartId) {
		double grandTotal = 0;

		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItem = cart.getCartItem();
		for (CartItem ci : cartItem) {
			grandTotal += ci.getPrice();
		}
		return grandTotal;
	}

}
