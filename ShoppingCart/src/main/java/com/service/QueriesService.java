/**
 * 
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QueriesDAO;
import com.model.Queries;

/**
 * @author SwapnadeepDutta
 *
 */

@Service
public class QueriesService implements QueriesServiceImpl {

	@Autowired
	private QueriesDAO queriesDAO;

	public void addQuery(Queries queries) {
		queriesDAO.addQuery(queries);
	}

}
