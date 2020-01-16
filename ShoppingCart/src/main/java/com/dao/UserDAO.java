/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

/**
 * @author SwapnadeepDutta
 *
 */

@Repository
public class UserDAO implements UserDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		List<User> user = session.createQuery("from user").list();
		System.out.println(user);
		session.flush();
		session.close();
		return user;
	}

	public void deleteUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, userId);
		session.saveOrUpdate(user);
		session.flush();
		session.close();

	}

	public void addUser(com.model.User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();

	}

	public com.model.User getUserById(String userId) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, userId);
		session.close();
		return user;
	}

}
