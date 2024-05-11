package com.fastlearn.course.application.configuration;

import com.fastlearn.course.application.course.mapper.CourseDTOMapper;
import com.fastlearn.course.application.course.service.CourseManagementService;
import com.fastlearn.course.application.coursecontent.mapper.CourseContentDTOMapper;
import com.fastlearn.course.application.coursecontent.service.CourseContentManagementService;
import com.fastlearn.course.domain.port.course.CreateCoursePort;
import com.fastlearn.course.domain.port.course.GetCoursePort;
import com.fastlearn.course.domain.port.coursecontent.CreateCourseContentPort;
import com.fastlearn.course.domain.port.coursecontent.FindCourseContentPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanApplicationConfiguration {

  @Bean
  public CourseManagementService courseManagementService(
      CreateCoursePort createCoursePort,
      CourseDTOMapper courseDTOMapper,
      GetCoursePort getCoursePort) {
    return new CourseManagementService(createCoursePort, courseDTOMapper, getCoursePort);
  }

  @Bean
  public CourseContentManagementService courseContentManagementService(
      CreateCourseContentPort createCourseContentPort,
      FindCourseContentPort findCourseContentPort,
      CourseContentDTOMapper courseContentDTOMapper
  ) {
    return new CourseContentManagementService(createCourseContentPort, findCourseContentPort,
        courseContentDTOMapper);
  }

}
