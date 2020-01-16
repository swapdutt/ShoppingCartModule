/**
 * 
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartItemDAO;
import com.model.Cart;
import com.model.CartItem;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class CartItemService implements CartItemServiceImpl {

	@Autowired
	private CartItemDAO cartItemDAO;

	/*
	 * Getters and Setters
	 */

	public CartItemDAO getCartItemDAO() {
		return cartItemDAO;
	}

	public void setCartItemDAO(CartItemDAO cartItemDAO) {
		this.cartItemDAO = cartItemDAO;
	}

	/*
	 * Methods implemented in the interface java file
	 */

	public void addCartItem(CartItem cartItem) {
		cartItemDAO.addCartItem(cartItem);
	}

	public void removerCartItem(String cartItemId) {
		cartItemDAO.removeCartItem(cartItemId);

	}

	public void removeAllCartItem(Cart cart) {
		cartItemDAO.removeAllCartItems(cart);

	}

}
