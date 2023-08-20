package com.skillsCraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.skillsCraft.entities.*;
import com.skillsCraft.services.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	StudentService sService;
	
	@Autowired
	UsersService uService;
	
	@GetMapping("/purchaseCourse")
	public String purchaseCourse(Model model) {
		List<Course> courseList = sService.fetchAllCourses();
		model.addAttribute("courseList" ,courseList);
		return "purchaseCourse";
	}
	
	@GetMapping("/myCourses")
	public String myCourses(Model model, HttpSession session) {
		Users loggedUser = (Users) session.getAttribute("loggedInUser");
		String email = loggedUser.getEmail();
		Users user = uService.findUserByEmail(email);
		
		List<Course> courseList = user.getCourseList();
		model.addAttribute("courseList", courseList);
		return "myCourses";
	}
	
	@GetMapping("/viewLesson")
	public String viewLesson(@RequestParam("lessonId") int lessonId, 
											Model model, 
											HttpSession session) {
		Lesson lesson = sService.getLesson(lessonId);
		
		String youtubeUrl = lesson.getLessonLink();
		
		String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);
		lesson.setLessonLink(videoId);
		
		model.addAttribute("lesson", lesson);
		
		return "myLesson";
	}
}
