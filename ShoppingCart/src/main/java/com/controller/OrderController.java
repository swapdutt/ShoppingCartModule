/**
 * 
 */
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Cart;
import com.model.Customer;
import com.model.CustomerOrder;
import com.service.CartService;
import com.service.CustomerOrderService;

/**
 * @author SwapnadeepDutta
 *
 */

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerOrderService;

	/*
	 * Request Mapping
	 */

	@RequestMapping("/order/{cartId]")
	public String createOrder(@PathVariable(value = "cartId") String cartId) {

		CustomerOrder customerOrder = new CustomerOrder();

		Cart cart = cartService.getCartByCartId(cartId);

		// Update Cart id for customerOrder
		customerOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);

		customer.setShippingAddress(customer.getShippingAddress());
		customer.setBillingAddress(customer.getBillingAddress());
		customerOrderService.addCustomerOrder(customerOrder);

		return "redirect:/checkout?cartId" + cartId;

	}

}
