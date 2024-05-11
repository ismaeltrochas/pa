package com.fastlearn.course.application.course.usecase;

import com.fastlearn.course.domain.model.dto.CourseDTO;
import java.util.List;

public interface GetCourseUseCase {

  CourseDTO findById(Long id);
  List<CourseDTO> findAllByOwner(String owner);

  List<CourseDTO> findByPriceIn(Double minPrice, Double maxPrice);

  List<CourseDTO> findAll();

}
