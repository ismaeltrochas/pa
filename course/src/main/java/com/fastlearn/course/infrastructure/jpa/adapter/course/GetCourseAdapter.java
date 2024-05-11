package com.fastlearn.course.infrastructure.jpa.adapter.course;

import com.fastlearn.course.domain.model.Course;
import com.fastlearn.course.domain.port.course.GetCoursePort;
import com.fastlearn.course.infrastructure.jpa.mapper.CourseEntityMapper;
import com.fastlearn.course.infrastructure.jpa.repository.CourseRepository;
import com.fastlearn.course.shared.utils.MessageUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCourseAdapter implements GetCoursePort {

  private final CourseRepository courseRepository;
  private final CourseEntityMapper courseEntityMapper;
  private final MessageUtils messageUtils;

  @Override
  public Course findById(Long id) {
    return courseEntityMapper.toEntity(
        courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found")));
  }

  @Override
  public List<Course> findAllByOwner(String owner) {
    return courseEntityMapper.toEntity(courseRepository.findAllByOwner(owner));
  }

  @Override
  public List<Course> findByPriceIn(Double minPrice, Double maxPrice) {
    return courseEntityMapper.toEntity(courseRepository.findAllByPrice(minPrice, maxPrice));
  }


  @Override
  public List<Course> findAll() {
    return courseEntityMapper.toEntity(courseRepository.findAll());
  }
}
