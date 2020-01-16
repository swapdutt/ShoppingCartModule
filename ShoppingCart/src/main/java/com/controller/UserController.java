/**
 * 
 */
package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.BillingAdress;
import com.model.Customer;
import com.model.ShippingAddress;
import com.model.User;
import com.service.CustomerService;

/**
 * @author SwapnadeepDutta
 *
 */

@Controller
public class UserController {

	@Autowired
	private CustomerService customerService;

	/*
	 * Getters and Setters
	 */

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/*
	 * Request Mapping
	 */

	@RequestMapping(value = "/customer/registration")
	public ModelAndView getRegistrationForm() {
		Customer customer = new Customer();
		User user = new User();
		BillingAdress ba = new BillingAdress();
		ShippingAddress sa = new ShippingAddress();

		customer.setBillingAddress(ba);
		customer.setShippingAddress(sa);
		customer.setUser(user);

		return new ModelAndView("register", "customer", customer);

	}

	// Inserting the data
	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, Model model,
			BindingResult br) {
		if (br.hasErrors()) {
			return "register";
		}

		customerService.addCustomer(customer);
		model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password.");
		return "login";

	}

}
