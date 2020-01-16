/**
 * 
 */
package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class UserService implements UserServiceImpl {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public void deleteUser(String userId) {
		userDAO.deleteUser(userId);
	}

	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public User getUserById(String userId) {
		return userDAO.getUserById(userId);
	}

}
