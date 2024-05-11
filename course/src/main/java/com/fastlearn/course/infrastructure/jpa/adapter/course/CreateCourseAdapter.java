package com.fastlearn.course.infrastructure.jpa.adapter.course;

import com.fastlearn.course.domain.model.Course;
import com.fastlearn.course.domain.port.course.CreateCoursePort;
import com.fastlearn.course.infrastructure.jpa.mapper.CourseEntityMapper;
import com.fastlearn.course.infrastructure.jpa.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseAdapter implements CreateCoursePort {

  private final CourseRepository courseRepository;
  private final CourseEntityMapper courseEntityMapper;

  @Override
  public Course createCourse(Course entity) {
    return courseEntityMapper.toEntity(courseRepository.save(
        courseEntityMapper.toDto(entity)));
  }
}
