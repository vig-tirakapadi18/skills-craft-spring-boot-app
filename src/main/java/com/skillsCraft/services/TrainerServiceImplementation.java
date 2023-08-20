package com.skillsCraft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.skillsCraft.entities.Course;
import com.skillsCraft.entities.Lesson;
import com.skillsCraft.repositories.CourseRepository;
import com.skillsCraft.repositories.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService {
	@Autowired
	CourseRepository cRepo;
	
	@Autowired
	LessonRepository lRepo;
	
	public String addCourse(Course course) {
		cRepo.save(course);
		return "Course Added Successfully!";
	}

	public List<Course> fetchAllCourses() {
		return cRepo.findAll();
	}
	
	public String addLesson(Lesson lesson) {
		lRepo.save(lesson);
		return "Lesson Added Successfully!";
	}
	
	public String saveCourse(Course course) {
		cRepo.save(course);
		return "Course Saved Successfully!";
	}
}
