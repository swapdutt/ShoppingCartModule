/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Product;

/**
 * @author dell
 *
 */
public interface ProductDAOImpl {
	
	List<Product> getAllProducts();
	
	Product getProductBy(String productId);
	
	void deleteProduct(String productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);

}
