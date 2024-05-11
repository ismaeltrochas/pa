package com.fastlearn.course.application.coursecontent.usecase;

import com.fastlearn.course.domain.model.dto.CourseContentDTO;

public interface CreateCourseContentUseCase {

  CourseContentDTO createCourseContent(CourseContentDTO courseContentDTO);

}
