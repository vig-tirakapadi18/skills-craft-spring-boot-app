package com.skillsCraft.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.razorpay.*;
import com.skillsCraft.entities.*;
import com.skillsCraft.services.*;

@Controller
public class OrderCreation {
	@Autowired
	UsersService uService;
	
	@Autowired
	StudentService sService;
	
	@Autowired
	TrainerService tService;
	
	@PostMapping("/takeOrder")
	@ResponseBody
	public String takeOrder(@RequestParam int amount, 
										@RequestParam String email, 
										@RequestParam int courseId) {
		mapCourseAndUser(email, courseId);
		
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_bC1XrLzr1W5HBP", "INipuGM22ATLq4JIs0UOLDNT");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			order = razorpay.orders.create(orderRequest);
		} catch (RazorpayException e) {
			// Handle Exception
			System.out.println(e.getMessage());
		}
		return order.toString();
	}
	
	public void mapCourseAndUser(String email, int courseId) {
		Users user = uService.findUserByEmail(email);
		Course course = sService.fetchCourse(courseId);
		
		user.getCourseList().add(course);
		course.getUserList().add(user);
		
		tService.saveCourse(course);
		uService.saveUsers(user);
	}
}
