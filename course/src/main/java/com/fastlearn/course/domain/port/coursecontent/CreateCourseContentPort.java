package com.fastlearn.course.domain.port.coursecontent;

import com.fastlearn.course.domain.model.CourseContent;

public interface CreateCourseContentPort {

  CourseContent createCourseContent(CourseContent courseContent);

}
