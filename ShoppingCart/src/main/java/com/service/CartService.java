/**
 * 
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.model.Cart;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class CartService implements CartServiceImpl {

	@Autowired
	private CartDAO cartDAO;

	/*
	 * Getters and Setters
	 */

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public Cart getCartByCartId(String cartId) {

		return cartDAO.getCartByCartId(cartId);
	}

}
