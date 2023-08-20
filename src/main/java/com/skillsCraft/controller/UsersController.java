package com.skillsCraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.skillsCraft.entities.Users;
import com.skillsCraft.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService uService;
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user) {
		String email = user.getEmail();
		boolean isPresent = uService.checkEmail(email);
		if(!isPresent) {
			uService.addUser(user);			
		} else {
			System.out.println("Email already exists!");
		}
		return "login";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("email") String email, 
											@RequestParam("password") String password,
											HttpSession session) {
		Users user = uService.findUserByEmail(email);
		String role = user.getRole();

		if(role == null) {
			return "login";
		}
		
		if (password.equals(user.getPassword())) {
			session.setAttribute("loggedInUser", user);
			
			if(role.equals("student")) {
				return "studentHome";
			} else {
				return "trainerHome";
			}
		} else {
			return "login";
		}
	}

}
