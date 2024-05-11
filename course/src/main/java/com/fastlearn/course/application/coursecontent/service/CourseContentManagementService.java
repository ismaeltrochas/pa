package com.fastlearn.course.application.coursecontent.service;

import com.fastlearn.course.application.coursecontent.mapper.CourseContentDTOMapper;
import com.fastlearn.course.application.coursecontent.usecase.CreateCourseContentUseCase;
import com.fastlearn.course.application.coursecontent.usecase.FindCourseContentUseCase;
import com.fastlearn.course.domain.model.dto.CourseContentDTO;
import com.fastlearn.course.domain.port.coursecontent.CreateCourseContentPort;
import com.fastlearn.course.domain.port.coursecontent.FindCourseContentPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseContentManagementService implements CreateCourseContentUseCase,
    FindCourseContentUseCase {

  private final CreateCourseContentPort createCourseContentPort;
  private final FindCourseContentPort findCourseContentPort;
  private final CourseContentDTOMapper courseContentDTOMapper;

  @Override
  public CourseContentDTO createCourseContent(CourseContentDTO courseContentDTO) {
    return courseContentDTOMapper.toDto(createCourseContentPort.createCourseContent(
        courseContentDTOMapper.toEntity(courseContentDTO)));
  }


  @Override
  public List<CourseContentDTO> courseContentEntities(Long id) {
    return courseContentDTOMapper.toDto(findCourseContentPort.courseContentEntities(id));
  }
}
