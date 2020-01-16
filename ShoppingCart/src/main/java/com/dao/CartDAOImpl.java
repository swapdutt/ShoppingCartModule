/**
 * 
 */
package com.dao;

import java.io.IOException;

import com.model.Cart;

/**
 * @author dell
 *
 */
public interface CartDAOImpl {
	
	Cart getCartByCartId(String cartId);
	
	Cart validate(String cartId) throws IOException;
	
	void update(Cart cart);

}
