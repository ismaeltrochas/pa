package com.fastlearn.course.domain.port.course;

import com.fastlearn.course.domain.model.Course;

public interface CreateCoursePort {

  Course createCourse(Course entity);
}
