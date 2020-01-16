/**
 * 
 */
package com.dao;

import java.util.List;


import com.model.User;

/**
 * @author SwapnadeepDutta
 *
 */
public interface UserDAOImpl {

	List<User> getAllUsers();

	void deleteUser(String userId);

	void addUser(User user);

	User getUserById(String userId);

}
