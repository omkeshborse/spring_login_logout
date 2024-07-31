package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	userDao ud;

	@RequestMapping("/hello")
	public void get() {
		System.out.println("hello peter parker");
	}

	@RequestMapping("/register")
	public String register(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "register";
	}

	@RequestMapping("/saveUserInfo")
	public String saveUserInfo(@ModelAttribute("u1") userModel u1) {
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
	public String login() {
		return "login";
	}

	@RequestMapping("/checkUser")
	public String checkCheredentials(@ModelAttribute("u1") userModel u1, HttpSession session) {
		String message ;
		System.out.println("checkUser");
		System.out.println("u1 email " + u1.getEmail());
		System.out.println("u1 password" + u1.getPassword());
		List<userModel> existingUsers = ud.checkUserExists(u1);
		if (existingUsers.isEmpty()) {
			message = "New here? Please register to create account";
			System.out.println("New here? Please register to create account");
			return "redirect:/register?message=" + message;
		} else {
			
			
			List<userModel> userWithCorrectCred = 	ud.checkCheredentials(u1) ;
			if (userWithCorrectCred.isEmpty()) {
				message = "User password is incorrect" ;
				System.out.println("User password is incorrect");
				return "redirect:/login?message=" + message;
 			}else {
				message  = "user Login successfully" ; 
				
				System.out.println();
				// Set the session attribute after successful login
	            session.setAttribute("user", u1.getEmail());
	            session.setMaxInactiveInterval(30 * 60) ;
	            return "redirect:/dashboard";
			}
		}
		

	}
	
	@RequestMapping("/dashboard")
	public String Dashboard(HttpSession session) {
		 // Retrieve the session attribute "user"
	    String user = (String) session.getAttribute("user");
	    
	    // Log the retrieved user name
	    System.out.println("User from session: " + user);
	    
		if (user == null ) {
			System.out.println(user);
			 System.out.println("No user in session, redirecting to login.");
			return "redirect:/login" ;
		}
		
		return "dashboard" ;
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate() ;
		return "redirect:/login" ;
	}
	
	@RequestMapping("/reset")
	public String reset() {
		return "resetPassword" ;
	}
	@RequestMapping("/resetPassword")
	public String resetPassword(@ModelAttribute("u1") userModel u1 )
	{	System.out.println(u1.getEmail());
		
		ud.updatePassword(u1) ;
		return "redirect:/login" ;
	}
	
}
