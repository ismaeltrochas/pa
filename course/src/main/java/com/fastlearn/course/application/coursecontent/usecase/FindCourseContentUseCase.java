package com.fastlearn.course.application.coursecontent.usecase;

import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import java.util.List;

public interface FindCourseContentUseCase {

  List<CourseContentDTO> courseContentEntities(Long id);

}
