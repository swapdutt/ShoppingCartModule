/**
 * 
 */
package com.service;

import java.util.List;

import com.model.Product;

/**
 * @author SwapnadeepDutta
 *
 */
public interface ProductServiceImpl {

	public List<Product> getAllProducts();

	Product getProductsById(String productId);

	void deleteProduct(String productId);

	void addProduct(Product product);

	void editProduct(Product product);

}
