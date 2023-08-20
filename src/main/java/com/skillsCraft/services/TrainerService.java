package com.skillsCraft.services;

import java.util.List;

import com.skillsCraft.entities.Course;
import com.skillsCraft.entities.Lesson;

public interface TrainerService {
	String addCourse(Course course);
	List<Course> fetchAllCourses();
	String addLesson(Lesson lesson);
	String saveCourse(Course course);
}
