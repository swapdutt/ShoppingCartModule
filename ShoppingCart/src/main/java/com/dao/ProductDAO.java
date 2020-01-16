/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Product;

/**
 * @author dell
 *
 */

@Repository
public class ProductDAO implements ProductDAOImpl {

	/*
	 * This class is wired with the session factory to do operations in the database
	 */

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Getters and Setters for CRUD operations in database
	 */

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> getAllProducts() {
		// Reading the records from the table
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("from products").list();
		System.out.println("------ List of Products ---------");
		System.out.println(products);

		// Session flush is used for clear cache in the session
		session.flush();

		// Closing the session
		session.close();
		return products;
	}

	public Product getProductBy(String productId) {
		// Reading the records from the table
		Session session = sessionFactory.openSession();

		Product product = session.get(Product.class, productId);
		session.close();
		return product;
	}

	public void deleteProduct(String productId) {
		// Reading the records from the table
		Session session = sessionFactory.openSession();

		Product product = session.get(Product.class, productId);
		session.delete(product);
		session.flush();
		session.close();
	}

	public void addProduct(Product product) {
		// Reading the records from the table
		Session session = sessionFactory.openSession();
		session.save(session);
		session.close();
	}

	public void editProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.update(product);
		session.flush();
		session.close();

	}

}
