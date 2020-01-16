/**
 * 
 */
package com.dao;

import com.model.Cart;
import com.model.CartItem;

/**
 * @author SwapnadeepDutta
 *
 */
public interface CartItemDAOImpl {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(String cartItemId);
	
	void removeAllCartItems(Cart cart);

}
