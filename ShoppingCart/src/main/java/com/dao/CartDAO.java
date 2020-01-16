package com.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDAO implements CartDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public com.model.Cart getCartByCartId(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.model.Cart validate(String cartId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(com.model.Cart cart) {
		// TODO Auto-generated method stub
		
	}

	
}
