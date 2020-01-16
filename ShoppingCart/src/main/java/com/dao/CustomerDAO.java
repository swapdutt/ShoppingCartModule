/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Authorities;
import com.model.Cart;
import com.model.Customer;
import com.model.User;

/**
 * @author SwapnadeepDutta
 *
 */

@Repository
public class CustomerDAO implements CustomerDAOImpl {

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

	public void addCustomer(Customer customer) {
		System.out.println("Adding customer in DAO");
		Session session = sessionFactory.openSession();
		customer.getUser().setEnabled(true);

		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USERS");
		authorities.setEmailId(customer.getUser().getEmailId());

		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		session.save(customer);
		session.save(authorities);
		session.flush();
		session.close();

	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<com.model.Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	public Customer getCustomerByEmailId(String emailId) {
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("from user where emailId=?");
		query.setString(0, emailId);

		User user = (User) query.uniqueResult();
		Customer customer = user.getCustomer();
		return customer;
	}

}
