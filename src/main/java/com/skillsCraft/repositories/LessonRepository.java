package com.skillsCraft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsCraft.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
	Lesson findByLessonId(int lessonId);
}
