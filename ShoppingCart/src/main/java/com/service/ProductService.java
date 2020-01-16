/**
 * 
 */
package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.model.Product;

/**
 * @author SwapnadeepDutta
 *
 */

@Service(value = "productService")
public class ProductService implements ProductServiceImpl {

	@Autowired
	private ProductDAO productDAO;

	/*
	 * Getters and Setters
	 */

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public Product getProductsById(String productId) {
		return productDAO.getProductBy(productId);
	}

	public void deleteProduct(String productId) {
		productDAO.deleteProduct(productId);
	}

	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	public void editProduct(Product product) {
		productDAO.editProduct(product);
	}

}
