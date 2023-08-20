package com.skillsCraft.services;

import java.util.List;

import com.skillsCraft.entities.*;

public interface StudentService {
	List<Course> fetchAllCourses();
	Course fetchCourse(int courseId);
	Lesson getLesson(int lessonId);
}
