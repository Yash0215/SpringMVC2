package com.user.winter2020.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.winter2020.dao.UserDao;
import com.user.winter2020.model.User;

@Controller
public class QueryController {
	
	@Autowired
	UserDao userDao;
	
	@ModelAttribute("user")
	public User queryForm() {
		return new User();
	}

	@GetMapping("/queryForm")
	public String login() {
	    return "query-form";
	}
	
	@PostMapping("/queryResult")
	public String result(HttpServletRequest request, Model model) {
		String gender = request.getParameter("gender");
		System.out.println("Getting gender: " + gender);
		List<User> users = userDao.findByGender(gender);
		model.addAttribute("users", users);
	    return "query-result";
	}

}
