package com.fastlearn.course.infrastructure.jpa.adapter.coursecontent;

import com.fastlearn.course.domain.model.CourseContent;
import com.fastlearn.course.domain.port.coursecontent.CreateCourseContentPort;
import com.fastlearn.course.infrastructure.jpa.mapper.CourseContentEntityMapper;
import com.fastlearn.course.infrastructure.jpa.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseContentAdapter implements CreateCourseContentPort {

  private final CourseContentRepository courseContentRepository;
  private final CourseContentEntityMapper courseContentEntityMapper;

  @Override
  public CourseContent createCourseContent(CourseContent courseContent) {
    return courseContentEntityMapper.toEntity(
        courseContentRepository.save(courseContentEntityMapper.toDto(courseContent)));
  }
}
