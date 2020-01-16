/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.service.ProductService;

/**
 * @author SwapnadeepDutta
 *
 */

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/*
	 * Getters and Setters
	 */

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/*
	 * Configuration for MultiPartResolver MultiPart resolver is for uploading
	 * images and other media MaxUpload Size is for image size should not be maximum
	 * than 10240000
	 */

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}

	@RequestMapping("/getAllProducts")
	public ModelAndView getProductsById(@PathVariable(value = "productId") String productId) {
		Product product = productService.getProductsById(productId);
		return new ModelAndView("productPage", "productObj", product);
	}

	@RequestMapping("/admin/delete/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") String productId) {
		// Path to be provided to route to product JSP page

		Path path = Paths.get("");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		productService.deleteProduct(productId);
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String getProductForm(Model model) {
		Product product = new Product();
		product.setProductCategory("Android");
		model.addAttribute("productFormObj", product);
		return "addProduct";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(value = "productFormObj") Product product, BindingResult br) {
		if (br.hasErrors()) {
			return "addProducts";
		}
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();

		if (image != null && !image.isEmpty()) {
			Path path = Paths.get("");

			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}")
	public ModelAndView getEditForm(@ModelAttribute(value = "productId") String productId) {
		Product product = productService.getProductsById(productId);
		return new ModelAndView("editProduct", "editProductObj", product);
	}

	@RequestMapping("/getAllProductsList")
	public @ResponseBody List<Product> getProductsListInJson() {
		return productService.getAllProducts();
	}

	@RequestMapping("/productsListAngular")
	public String getAllProducts() {
		return "productListAngular";
	}

}
