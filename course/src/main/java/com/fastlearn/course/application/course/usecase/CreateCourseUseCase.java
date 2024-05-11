package com.fastlearn.course.application.course.usecase;

import com.fastlearn.course.domain.model.dto.CourseDTO;

public interface CreateCourseUseCase {

  CourseDTO createCourse(CourseDTO courseDTO);

}
