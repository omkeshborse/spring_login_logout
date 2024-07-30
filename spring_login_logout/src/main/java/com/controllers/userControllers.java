package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dao.userDao;
import com.model.userModel;

@Controller
public class userControllers {
	
	@Autowired
	userDao ud ;
	
	@RequestMapping("/hello")
	public void get() {
		System.out.println("hello peter parker");
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "register" ;
	}
	 
	@RequestMapping("/saveUserInfo")
	public String saveUserInfo(@ModelAttribute("u1" ) userModel u1) {
		 String message;

		    System.out.println(u1.toString()); 

		    // Check if password and confirm password match
		    if (u1.getPassword().equals(u1.getConfirm_password())) {
		        List<userModel> existingUsers = ud.checkUserExists(u1);

		        if (existingUsers.isEmpty()) {
		            // Save user information if not already present
		            ud.saveInfo(u1);
		            message = "User registered successfully!";
		            System.out.println("User registered successfully.");
		        } else {
		            // User already exists
		            message = "User already exists , please login!";
		            System.out.println("User already exists with email '" + u1.getEmail() + "', please login!");
		        }
		    } else {
		        // Password and confirm password do not match
		        message = "Password and confirm password do not match.";
		        System.out.println("Password and confirm password do not match.");
		    }

		    return "redirect:/register?message=" + message;
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login" ;
	}
	
}
