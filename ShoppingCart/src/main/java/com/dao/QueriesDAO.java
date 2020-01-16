/**
 * 
 */
package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author SwapnadeepDutta
 *
 */

@Repository
public class QueriesDAO implements QueriesDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public void addQuery(com.model.Queries queries) {
		Session session = sessionFactory.openSession();
		session.save(queries);
		session.close();

	}

}
