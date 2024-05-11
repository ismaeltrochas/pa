package com.fastlearn.course.application.course.service;

import com.fastlearn.course.application.course.mapper.CourseDTOMapper;
import com.fastlearn.course.application.course.usecase.CreateCourseUseCase;
import com.fastlearn.course.application.course.usecase.GetCourseUseCase;
import com.fastlearn.course.domain.model.dto.CourseDTO;
import com.fastlearn.course.domain.port.course.CreateCoursePort;
import com.fastlearn.course.domain.port.course.GetCoursePort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseManagementService implements CreateCourseUseCase, GetCourseUseCase {

  private final CreateCoursePort createCoursePort;
  private final CourseDTOMapper courseDTOMapper;
  private final GetCoursePort getCoursePort;

  @Override
  public CourseDTO createCourse(CourseDTO courseDTO) {
    return courseDTOMapper.toDto(createCoursePort.createCourse(
        courseDTOMapper.toEntity(courseDTO)));
  }

  @Override
  public CourseDTO findById(Long id) {
    return courseDTOMapper.toDto(getCoursePort.findById(id));
  }

  @Override
  public List<CourseDTO> findAllByOwner(String owner) {
    return courseDTOMapper.toDto(getCoursePort.findAllByOwner(owner));
  }

  @Override
  public List<CourseDTO> findByPriceIn(Double minPrice, Double maxPrice) {
    return courseDTOMapper.toDto(getCoursePort.findByPriceIn(minPrice, maxPrice));
  }

  @Override
  public List<CourseDTO> findAll() {
    return courseDTOMapper.toDto(getCoursePort.findAll());
  }
}
