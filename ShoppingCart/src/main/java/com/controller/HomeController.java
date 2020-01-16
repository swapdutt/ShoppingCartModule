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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Queries;
import com.service.QueriesService;

/**
 * @author SwapnadeepDutta
 *
 */

@Controller
public class HomeController {

	@RequestMapping({ "/index", "/index1" })
	public String sayIndex() {
		return "index1";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello", "hello", "Hello Mr. Dutta");
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
		}
		if (logout != null) {
			model.addAttribute("logout", "You have logged out successfully.");
		}
		return "login";

	}

	@RequestMapping("/aboutus")
	public String aboutUs() {
		return "aboutUs";
	}

	@Autowired
	private QueriesService queriesService;

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		Queries queries = new Queries();
		return new ModelAndView("contactus", "contact", queries);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") Queries queries, Model model, BindingResult br) {
		if (br.hasErrors()) {
			return "contactUs";
		}
		queriesService.addQuery(queries);
		model.addAttribute("querySuccess",
				"Thank you, Your Message stored in our Server we will contact through corresponding Mail");
		return "login";
	}

}
