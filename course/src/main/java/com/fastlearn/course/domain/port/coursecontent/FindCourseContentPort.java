package com.fastlearn.course.domain.port.coursecontent;

import com.fastlearn.course.domain.model.CourseContent;
import java.util.List;

public interface FindCourseContentPort {

  List<CourseContent> courseContentEntities(Long id);

}
