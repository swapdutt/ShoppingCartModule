/**
 * 
 */
package com.service;

import com.model.Cart;
import com.model.CartItem;

/**
 * @author SwapnadeepDutta
 *
 */
public interface CartItemServiceImpl {
	
	void addCartItem(CartItem cartItem);
	
	void removerCartItem(String cartItemId);
	
	void removeAllCartItem(Cart cart);

}
