/**
 * 
 */
package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Cart;
import com.model.CartItem;

/**
 * @author SwapnadeepDutta
 *
 */

@Repository
@Transactional
public class CartItemDAO implements CartItemDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Getters and Setters
	 */

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCartItem(com.model.CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();

	}

	public void removeCartItem(String cartItemId) {
		Session session = sessionFactory.openSession();
		CartItem cartItem = session.get(CartItem.class, cartItemId);
		session.delete(cartItemId);
		Cart cart = cartItem.getCart();
		List<CartItem> cartItem1 = cart.getCartItem();
		cartItem1.remove(cartItemId);
		session.flush();
		session.close();

	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItem2 = cart.getCartItem();
		for (CartItem cartItem3 : cartItem2) {
			removeCartItem(cartItem3.getCartItemId());
		}

	}

}
